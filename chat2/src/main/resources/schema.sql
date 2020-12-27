CREATE TABLE IF NOT EXISTS user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(64),
    password VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS bbs (
    id INT PRIMARY KEY AUTO_INCREMENT,
    author VARCHAR(64),
    subject VARCHAR(255),
    body text,
    delete_flg int default 0
);