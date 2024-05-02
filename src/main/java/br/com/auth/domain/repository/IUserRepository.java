package br.com.auth.domain.repository;

import br.com.auth.domain.model.user.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserRepository {

    public UserDetails findByEmail(String email);

    public User findById(Long id);

    public void insert(User user);

    public User update(User user);

    public void delete(Long id);
}
