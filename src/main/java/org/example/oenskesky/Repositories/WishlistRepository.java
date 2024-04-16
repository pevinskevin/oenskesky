package org.example.oenskesky.Repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WishlistRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //
    public void createNewWishlistInDb(String randomID, String randomPassword) {
        String query = "INSERT INTO wishlist (id, password) VALUES (?, ?) ";
        jdbcTemplate.update(query, randomID, randomPassword);
    }

    public int getWishlistIntId() {
        String query = "SELECT MAX(int_id) FROM wishlist";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

    public String getWishlistId(int intId) {
        String query = "SELECT id FROM wishlist WHERE int_id = ?";
        return jdbcTemplate.queryForObject(query, String.class, intId);
    }

    public int getWishIntIdWhereIdEquqls(String id) {
        String query = "SELECT int_id FROM wishlist WHERE id = ?";
        return jdbcTemplate.queryForObject(query, Integer.class, id);
    }

    public String getWishlistPassword(String id) {
        String query = "SELECT password FROM wishlist WHERE id = ?";
        return jdbcTemplate.queryForObject(query, String.class, id);
    }

    public void updatePasswordViewed(String setToTrue, String id) {
        String query = "UPDATE wishlist SET password_viewed = ? WHERE id = ?";
        jdbcTemplate.update(query, setToTrue, id);
    }

    public String getPasswordViewed(String id) {
        String query = "SELECT password_viewed FROM wishlist WHERE id = ?";
        return jdbcTemplate.queryForObject(query, String.class, id);
    }

    public String causeErrorIfNoMatch(String id, int intId) {
        String query = "SELECT id FROM wishlist WHERE id = ? AND int_id = ?";
        return jdbcTemplate.queryForObject(query, String.class, id, intId);
    }

}
