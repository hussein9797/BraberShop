package com.Basil.BraberShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

@SpringBootApplication
public class BraberShopApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(BraberShopApplication.class, args);
	}

}
