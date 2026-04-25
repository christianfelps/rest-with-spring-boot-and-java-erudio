CREATE TABLE IF NOT EXISTS `erudio`.`person` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(80) NOT NULL,
    `last_name` VARCHAR(80) NOT NULL,
    `address` VARCHAR(100) NOT NULL,
    `gender` VARCHAR(6) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 13
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


INSERT INTO person (first_name, last_name, address, gender) VALUES
                                                                ('João', 'Silva', 'Rua A, 123 - São Paulo', 'Male'),
                                                                ('Maria', 'Souza', 'Av. Central, 456 - Rio de Janeiro', 'Female'),
                                                                ('Carlos', 'Oliveira', 'Rua B, 789 - Belo Horizonte', 'Male'),
                                                                ('Ana', 'Pereira', 'Rua das Flores, 101 - Curitiba', 'Female'),
                                                                ('Lucas', 'Santos', 'Av. Brasil, 202 - Porto Alegre', 'Male'),
                                                                ('Fernanda', 'Costa', 'Rua Verde, 303 - Salvador', 'Female'),
                                                                ('Bruno', 'Almeida', 'Rua Azul, 404 - Recife', 'Male'),
                                                                ('Juliana', 'Rocha', 'Av. Paulista, 505 - São Paulo', 'Female'),
                                                                ('Rafael', 'Gomes', 'Rua do Sol, 606 - Fortaleza', 'Male'),
                                                                ('Camila', 'Barbosa', 'Rua da Paz, 707 - Brasília', 'Female');