# J2EE To Do List

This is a To Do list built in J2EE. Currently, this is a work in progress.

# SQL query to create table

    CREATE TABLE `jee_database`.`todo_elements` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(150) NULL,
    `done` VARCHAR(45) NULL,
    `created` DATETIME NULL,
    PRIMARY KEY (`id`));
    
    ALTER TABLE `jee_database`.`todo_elements`
    CHANGE COLUMN `done` `done` BIT(1) NULL DEFAULT NULL ; 

# Environment Variables

Before launching the project, please set the following environment variables. Replace with your MySQL username and 
password.

## UNIX
    export J2EE_DB_USER=root
    export J2EE_DB_PASSWORD=root

## Windows
    set J2EE_DB_USER=root
    get J2EE_DB_USER=root

> You may add these command to your .bash_profile to make sure the environment variables are set every time.
