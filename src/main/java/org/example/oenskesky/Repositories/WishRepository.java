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

    public void addWish(String url, String description, String comment, int price, String wishlistId){
        String query = "INSERT INTO wish (url, description, comment, price, wishlist_id) VALUES (?, ? ,?, ?, ?)";
        jdbcTemplate.update(query, url, description, comment, price, wishlistId);
    }

    public List<Wish> getAllWishes(String wishlistId){
        String query = "SELECT * FROM wish WHERE wishlist_id = ?";
        RowMapper<Wish> rowMapper = new BeanPropertyRowMapper<>(Wish.class);
        return jdbcTemplate.query(query, rowMapper, wishlistId);
    }

    public String getLatestWishIdFromWishListId(String id) {
        String query = "SELECT MAX(id) FROM wish WHERE wishlist_id = ?";
        try {
        return jdbcTemplate.queryForObject(query, String.class, id);}
        catch (Exception e){
            return "0";
        }
    }
    public void addEmailToWish(String email, int id){
        String query = "UPDATE wish SET email = ? WHERE id = ?";
        jdbcTemplate.update(query, email, id);
    }
    public String getwishListStringIdAndVerify(String wishListStringId, int wishIntegerId) {
        String query = "SELECT wishlist_id FROM wish WHERE wishlist_id = ? AND id = ?";
        return jdbcTemplate.queryForObject(query, String.class, wishListStringId, wishIntegerId);
    }
}
