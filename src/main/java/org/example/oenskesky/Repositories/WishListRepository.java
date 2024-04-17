package org.example.oenskesky.Repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WishListRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //
    public void createNewWishlistInDb(String randomID, String randomPassword) {
        String query = "INSERT INTO wishlist (id, password) VALUES (?, ?) ";
        jdbcTemplate.update(query, randomID, randomPassword);
    }

    public int getLatestIntegerId() {
        String query = "SELECT MAX(int_id) FROM wishlist";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

    public String getStringIdWhereIntegerId(int wishListIntegerId) {
        String query = "SELECT id FROM wishlist WHERE int_id = ?";
        return jdbcTemplate.queryForObject(query, String.class, wishListIntegerId);
    }

    public int getIntegerIdWhereStringId(String wishListStringId) {
        String query = "SELECT int_id FROM wishlist WHERE id = ?";
        return jdbcTemplate.queryForObject(query, Integer.class, wishListStringId);
    }

    public String getWishListPasswordFromStringId(String wishListStringId) {
        String query = "SELECT password FROM wishlist WHERE id = ?";
        return jdbcTemplate.queryForObject(query, String.class, wishListStringId);
    }

    public String getPasswordViewedStatus(String wishListStringId) {
        String query = "SELECT password_viewed FROM wishlist WHERE id = ?";
        return jdbcTemplate.queryForObject(query, String.class, wishListStringId);
    }

    public String getIdAndVerify(String wishListStringId, int wishListIntegerId) {
        String query = "SELECT id FROM wishlist WHERE id = ? AND int_id = ?";
        return jdbcTemplate.queryForObject(query, String.class, wishListStringId, wishListIntegerId);
    }

    public void setPasswordViewed(String setToTrue, String wishListStringId) {
        String query = "UPDATE wishlist SET password_viewed = ? WHERE id = ?";
        jdbcTemplate.update(query, setToTrue, wishListStringId);
    }

}
