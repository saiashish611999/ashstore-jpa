CREATE TABLE `ashstore`.`products` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  `category_id` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_products_category_id_categories_id_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `fk_products_category_id_categories_id`
    FOREIGN KEY (`category_id`)
    REFERENCES `ashstore`.`categories` (`id`)
    ON DELETE RESTRICT
    ON UPDATE NO ACTION);
