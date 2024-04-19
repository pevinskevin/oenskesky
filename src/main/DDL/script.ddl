DROP DATABASE IF EXISTS oenskesky;

CREATE DATABASE IF NOT EXISTS oenskesky;

USE oenskesky;

CREATE TABLE wishlist (
                          `int_id` INT AUTO_INCREMENT PRIMARY KEY,
                          `id` VARCHAR(255) UNIQUE,
                          `password` VARCHAR(255) NOT NULL
                      );
CREATE TABLE wish (
                      `id` INT AUTO_INCREMENT PRIMARY KEY,
                      `url` VARCHAR(255) NOT NULL,
                      `description` VARCHAR(255) NOT NULL,
                      `comment` VARCHAR(255),
                      `price` INT NOT NULL,
                      `email` VARCHAR(255),
                      `wishlist_id` VARCHAR(255) NOT NULL,
                      FOREIGN KEY (`wishlist_id`) REFERENCES `wishlist`(`id`)
                          ON DELETE CASCADE
);


