DROP DATABASE IF EXISTS oenskesky;

CREATE DATABASE IF NOT EXISTS oenskesky;

USE oenskesky;

CREATE TABLE wishlist (
                          `id` VARCHAR(255) UNIQUE,
                          `int_id` INT AUTO_INCREMENT PRIMARY KEY,
                          `password` VARCHAR(255) NOT NULL,
                          `password_viewed` ENUM ('false', 'true') DEFAULT 'false'
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


