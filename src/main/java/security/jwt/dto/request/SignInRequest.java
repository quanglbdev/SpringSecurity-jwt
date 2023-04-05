package security.jwt.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import security.jwt.exception.ApiErrorCode;
import security.jwt.exception.ApiException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInRequest {
    private String username;

    private String password;
    public void validSignIn() {
        if (username == null) throw new ApiException(ApiErrorCode.USERNAME_NOT_EMPTY);
        if (password == null) throw new ApiException(ApiErrorCode.PASSWORD_NOT_EMPTY);
    }
}
