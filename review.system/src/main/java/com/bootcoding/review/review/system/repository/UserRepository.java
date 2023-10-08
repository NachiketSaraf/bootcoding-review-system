package com.bootcoding.review.review.system.repository;

import com.bootcoding.review.review.system.model.User;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class UserRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public UserRepository(DataSource dataSource, JdbcTemplate jdbcTemplate){
        this.jdbcTemplate =jdbcTemplate;
        this.dataSource = dataSource;
    }
    public void save(User user){
        try {
            String query = "INSERT into review_user(name, email_id, number)" + " values ('" + user.getName() + "','" +
                    user.getEmailId() + "'," + user.getNumber() + ")";
                    jdbcTemplate.update(query);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
