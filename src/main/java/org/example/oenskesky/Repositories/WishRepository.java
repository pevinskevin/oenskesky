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

    public String getwishListStringIdAndVerify(String wishListStringId, int wishIntegerId) {
        String query = "SELECT wishlist_id FROM wish WHERE wishlist_id = ? AND id = ?";
        return jdbcTemplate.queryForObject(query, String.class, wishListStringId, wishIntegerId);
    }

    public void addEmailToWish(String userEmail, int wishIntegerID){
        String query = "UPDATE wish SET email = ? WHERE id = ?";
        jdbcTemplate.update(query, userEmail, wishIntegerID);
    }
}
