-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ezstay
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ezstay
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ezstay` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `ezstay` ;

-- -----------------------------------------------------
-- Table `ezstay`.`bookings`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ezstay`.`bookings` ;

CREATE TABLE IF NOT EXISTS `ezstay`.`bookings` (
  `booking_id` INT NOT NULL,
  `customer_id` INT NOT NULL,
  `check_in` DATE NOT NULL,
  `check_out` DATE NOT NULL,
  `room_no` INT NOT NULL,
  `stay_period` INT NOT NULL,
  `total_amount` DOUBLE NOT NULL,
  PRIMARY KEY (`booking_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ezstay`.`customers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ezstay`.`customers` ;

CREATE TABLE IF NOT EXISTS `ezstay`.`customers` (
  `customer_id` INT NOT NULL,
  `customer_name` VARCHAR(45) NOT NULL,
  `mobile_number` BIGINT UNSIGNED NOT NULL,
  `nationality` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(45) NOT NULL,
  `email` VARCHAR(90) NOT NULL,
  `id_proof` VARCHAR(45) NOT NULL,
  `id_number` VARCHAR(45) NOT NULL,
  `address` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `mobile_number_UNIQUE` (`mobile_number` ASC) VISIBLE,
  UNIQUE INDEX `id_number_UNIQUE` (`id_number` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ezstay`.`rooms`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ezstay`.`rooms` ;

CREATE TABLE IF NOT EXISTS `ezstay`.`rooms` (
  `room_no` INT UNSIGNED NOT NULL,
  `room_type` VARCHAR(45) NOT NULL,
  `sharing` VARCHAR(45) NOT NULL,
  `price` DOUBLE NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`room_no`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ezstay`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ezstay`.`users` ;

CREATE TABLE IF NOT EXISTS `ezstay`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(20) NOT NULL,
  `last_name` VARCHAR(20) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `mobile` INT NOT NULL,
  `address` VARCHAR(90) NOT NULL,
  `is_admin` TINYINT NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `mobile_UNIQUE` (`mobile` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
