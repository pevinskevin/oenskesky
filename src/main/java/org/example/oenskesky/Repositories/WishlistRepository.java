package org.example.oenskesky.Repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WishlistRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //
    public void createNewWishlistInDb(String randomPassword) {
        String query = "INSERT INTO wishlist (password) VALUES (?) ";
        jdbcTemplate.update(query, randomPassword);
    }

    //
    public int getWishlistId() {
        String query = "SELECT MAX(id) FROM wishlist";
        return jdbcTemplate.queryForObject(query, Integer.class);

    }
    public String getWishlistPassword(int id) {
        String query = "SELECT password FROM wishlist WHERE id = ?";
        return jdbcTemplate.queryForObject(query, String.class, id);
    }

    public void updatePasswordViewed(String setToTrue, int id) {
        String query = "UPDATE wishlist SET password_viewed = ? WHERE id = ?";
        jdbcTemplate.update(query, setToTrue, id);
    }

    public String getPasswordViewed(int id) {
        String query = "SELECT password_viewed FROM wishlist WHERE id = ?";
        return jdbcTemplate.queryForObject(query, String.class, id);
    }
}
