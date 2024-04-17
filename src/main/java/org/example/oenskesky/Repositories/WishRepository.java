package org.example.oenskesky.Repositories;

import org.example.oenskesky.Models.Wish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WishRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addWish(String url, String description, String comment, int price, String wishListStringId){
        String query = "INSERT INTO wish (url, description, comment, price, wishlist_id) VALUES (?, ? ,?, ?, ?)";
        jdbcTemplate.update(query, url, description, comment, price, wishListStringId);
    }

    /* How? Do I just past wish as argument?
    public void addWishObject(Wish wish){
        String query = "INSERT INTO wish (url, description, comment, price, wishlist_id, email) VALUES (?, ? ,?, ?, ?, ?)";
        jdbcTemplate.update(query, wish.getUrl(), wish.getDescription(), wish.getComment(), wish.getPrice(), wish.getWishlistID(), wish.getEmail());
    }*/

    public void updateWish(String url, String description, String comment, int price, int wishIntegerId) {
        String query = "UPDATE wish SET url = ?, description = ?, comment = ?, price = ? WHERE id = ?";
        jdbcTemplate.update(query, url, description, comment, price, wishIntegerId);
    }

    public List<Wish> getAllWishes(String wishListStringId){
        String query = "SELECT * FROM wish WHERE wishlist_id = ?";
        RowMapper<Wish> rowMapper = new BeanPropertyRowMapper<>(Wish.class);
        return jdbcTemplate.query(query, rowMapper, wishListStringId);
    }
    public String getLatestWishIdFromWishListId(String wishListStringId) {
        String query = "SELECT MAX(id) FROM wish WHERE wishlist_id = ?";
        try {
        return jdbcTemplate.queryForObject(query, String.class, wishListStringId);}
        catch (Exception e){
            return "0";
        }
    }

    public Wish getWish(int wishIntegerId){
        String query = "SELECT * FROM wish WHERE id = ?";
        RowMapper<Wish> rowMapper = new BeanPropertyRowMapper<>(Wish.class);
        return jdbcTemplate.queryForObject(query, rowMapper, wishIntegerId);
    }

    public String getwishListStringIdAndVerify(String wishListStringId, int wishIntegerId) {
        String query = "SELECT wishlist_id FROM wish WHERE wishlist_id = ? AND id = ?";
        return jdbcTemplate.queryForObject(query, String.class, wishListStringId, wishIntegerId);
    }

    public String validateWishId(int WishIntegerId){
        String query = "SELECT id FROM wishlist WHERE id = ?";
        return jdbcTemplate.queryForObject(query, String.class, WishIntegerId);
    }

    public void addEmailToWish(String userEmail, int wishIntegerID){
        String query = "UPDATE wish SET email = ? WHERE id = ?";
        jdbcTemplate.update(query, userEmail, wishIntegerID);
    }

    public void deleteWish(int wishIntegerId){
        String query = "DELETE FROM wish WHERE id = ?";
        jdbcTemplate.update(query, wishIntegerId);
    }
}
