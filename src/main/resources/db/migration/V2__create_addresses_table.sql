CREATE TABLE `ashstore`.`addresses` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(255) NOT NULL,
  `city` VARCHAR(255) NOT NULL,
  `zip` VARCHAR(255) NOT NULL,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_addresses_user_id_users_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_addresses_user_id_users_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `ashstore`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
