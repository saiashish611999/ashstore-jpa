CREATE TABLE `ashstore`.`wishlist` (
  `user_id` BIGINT NOT NULL,
  `product-id` BIGINT NOT NULL,
  PRIMARY KEY (`user_id`, `product-id`),
  INDEX `fk_wishlist_product_id_products_id_idx` (`product-id` ASC) VISIBLE,
  CONSTRAINT `fk_wishlist_user_id_users_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `ashstore`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_wishlist_product_id_products_id`
    FOREIGN KEY (`product-id`)
    REFERENCES `ashstore`.`products` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);