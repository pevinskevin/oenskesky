package org.example.oenskesky.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WishRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


}
