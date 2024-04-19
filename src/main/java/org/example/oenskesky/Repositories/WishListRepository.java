package org.example.oenskesky.Repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WishListRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //
    public void createNewWishlist(String randomID, String randomPassword) {
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

    public String getWishListStringIdFromWishListPassword(String wishListPassword){
        String query = "SELECT id FROM wishlist WHERE password = ?";
        return jdbcTemplate.queryForObject(query, String.class, wishListPassword);
    }

    public String getIdAndVerify(String wishListStringId, int wishListIntegerId) {
        String query = "SELECT id FROM wishlist WHERE id = ? AND int_id = ?";
        return jdbcTemplate.queryForObject(query, String.class, wishListStringId, wishListIntegerId);
    }

    public void deleteWishList(String wishListStringId){
        String query = "DELETE FROM wishlist where id = ?";
        jdbcTemplate.update(query, wishListStringId);

    }
}
