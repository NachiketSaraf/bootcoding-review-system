package com.bootcoding.review.review.system.repository;

import com.bootcoding.review.review.system.model.User;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class UserRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public UserRepository(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(List<User> user) {
        for (User u : user) {
            try {
                String query = "INSERT into app_user(username, email, phone)" + " values ('" + u.getUsername() + "','" +
                        u.getEmailId() + "'," + u.getPhone() + ")";
                jdbcTemplate.update(query);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public List<User> getAllUsers() {
        try {
            String query = "Select from app_user ";
            return jdbcTemplate.query(query, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user = new User();
                    user.setUsername(rs.getString("username"));
                    user.setEmailId(rs.getString("email"));
                    user.setPhone(rs.getLong("phone"));
                    return user;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public User getUser(int userId) {
        try {
            String sql = "Select * from app_user where id ="+ userId+"";
            return jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user = new User();
                    user.setUsername(rs.getString("username"));
                    user.setEmailId(rs.getString("email"));
                    user.setPhone(rs.getLong("phone"));
                    return user;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
