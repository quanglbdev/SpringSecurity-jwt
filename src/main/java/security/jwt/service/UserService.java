package security.jwt.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import security.jwt.dto.request.SignInRequest;
import security.jwt.exception.ApiErrorCode;
import security.jwt.exception.ApiException;
import security.jwt.exception.CustomException;
import security.jwt.model.AppUser;
import security.jwt.repository.UserRepository;
import security.jwt.security.JwtTokenProvider;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private  UserRepository userRepository;
    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Autowired
    private  JwtTokenProvider jwtTokenProvider;
    @Autowired
    private  AuthenticationManager authenticationManager;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String signin(SignInRequest signInRequest) {
        signInRequest.validSignIn();
        var user = userRepository.findByUsername(signInRequest.getUsername());
        if (user == null) throw new ApiException(ApiErrorCode.LOGIN_FAILED);
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword()));
            return jwtTokenProvider.createToken(signInRequest.getUsername(), user.getAppUserRoles());
        } catch (AuthenticationException  e) {
            e.printStackTrace();
            throw new ApiException(ApiErrorCode.UNAUTHORIZED);
        }
    }

    public String signup(AppUser appUser) {
        if (!userRepository.existsByUsername(appUser.getUsername())) {
            appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
            userRepository.save(appUser);
            return jwtTokenProvider.createToken(appUser.getUsername(), appUser.getAppUserRoles());
        } else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public void delete(String username) {
        userRepository.deleteByUsername(username);
    }

    public AppUser search(String username) {
        AppUser appUser = userRepository.findByUsername(username);
        if (appUser == null) {
            throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
        }
        return appUser;
    }

    public List<AppUser> getAll() {
        return userRepository.findAll();
    }

}
