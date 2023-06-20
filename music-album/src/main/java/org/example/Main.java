package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.example.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class Main implements CommandLineRunner {
    private final AlbumRepository albumRepository;
    @Autowired
    public Main(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Приложение успешно запущено!");
    }
}