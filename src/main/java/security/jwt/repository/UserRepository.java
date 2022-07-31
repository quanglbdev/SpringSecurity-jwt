package security.jwt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import security.jwt.model.AppUser;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<AppUser, Integer> {

  boolean existsByUsername(String username);

  AppUser findByUsername(String username);

  @Transactional
  void deleteByUsername(String username);

}
