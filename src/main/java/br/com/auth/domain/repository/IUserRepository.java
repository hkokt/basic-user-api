package br.com.auth.domain.repository;

import br.com.auth.domain.entity.user.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserRepository {

    UserDetails findByEmail(String email);

    User findById(Long id);

    void insert(User user);

    User update(User user);

    void delete(Long id);
}
