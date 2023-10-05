CREATE TABLE tb_products(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name Varchar(100) Not null unique,
    description Varchar(512),
    price decimal(8,2),
    stock BIGINT,
    category_id BIGINT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES tb_categories(id)
);