CREATE TABLE IF NOT EXISTS album (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    artists VARCHAR(150) NOT NULL,
    genre VARCHAR(50) NOT NULL,
    release_year YEAR NOT NULL,
    songs_count INT NOT NULL
);

CREATE TABLE IF NOT EXISTS song (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    lyrics TEXT NOT NULL,
    artists VARCHAR(150) NOT NULL,
    duration TIME NOT NULL,
    album_id INT,
    FOREIGN KEY (album_id) REFERENCES album(id)
);