package net.richlum.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

import net.richlum.demo.controller.Stock;
import net.richlum.demo.controller.StockDetail;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext context;

	public static void main(String[] args) {
		System.out.println("Starting...");
		populatedb();
		SpringApplication.run(DemoApplication.class, args);

	}

	private static void populatedb() {
		StockDetail padinidetail = new StockDetail("Padini Holding Company");
		Stock padinistock = new Stock("7052", "PADINI");
		padinidetail.setStock(padinistock);
		padinistock.setStockDetail(padinidetail);
	}

	@Override
	public void run(String... args) throws Exception {
		Arrays.asList(context.getBeanDefinitionNames()).stream().forEach(System.out::println);

	}

}
