# j2ee-todolist
A To Do list built in J2EE.

# SQL query to create table

CREATE TABLE `jee_database`.`todo_elements` (
`id` INT NOT NULL AUTO_INCREMENT,
`title` VARCHAR(150) NULL,
`done` VARCHAR(45) NULL,
`created` DATETIME NULL,
PRIMARY KEY (`id`));

ALTER TABLE `jee_database`.`todo_elements`
CHANGE COLUMN `done` `done` BIT(1) NULL DEFAULT NULL ; 
