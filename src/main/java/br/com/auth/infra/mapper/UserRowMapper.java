package br.com.auth.infra.mapper;

import br.com.auth.domain.model.user.User;
import br.com.auth.domain.model.user.UserRole;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        User user = new User();
        user.setId(rs.getLong("user_id"));
        user.setName(rs.getString("user_name"));
        user.setEmail(rs.getString("user_email"));
        user.setPassword(rs.getString("user_password"));
        String roleStr = rs.getString("user_role");
        Arrays.stream(UserRole.values())
                .filter(role ->
                        role.name().equals(roleStr))
                .findFirst()
                .ifPresent(user::setRole);
        return user;
    }
}
