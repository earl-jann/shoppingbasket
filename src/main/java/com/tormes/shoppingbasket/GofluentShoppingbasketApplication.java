package com.tormes.shoppingbasket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.tormes.shoppingbasket.models.Customer;
import com.tormes.shoppingbasket.models.Product;
import com.tormes.shoppingbasket.repository.CustomerRepository;
import com.tormes.shoppingbasket.repository.ProductRepository;

@SpringBootApplication
public class GofluentShoppingbasketApplication extends SpringBootServletInitializer implements CommandLineRunner {
	
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CustomerRepository customerRepository; 
	
	public static void main(String[] args) {
		SpringApplication.run(GofluentShoppingbasketApplication.class, args);
	}


    @Override
    public void run(String... strings) throws Exception {
    	// does nothing actually, we just want a customer :D
    	Customer earl = new Customer();
    	earl.setName("Earl");
    	
    	customerRepository.save(earl);

        Product english = new Product();
        english.setName("English");
        english.setPrice(2.99);

        Product german = new Product();
        german.setName("German");
        german.setPrice(4.99);
        
        Product nihonggo = new Product();
        nihonggo.setName("Nihonggo");
        nihonggo.setPrice(8.99);
        
        Product tagalog = new Product();
        tagalog.setName("Tagalog");
        tagalog.setPrice(1.00);

        productRepository.save(english);
        productRepository.save(german);
        productRepository.save(nihonggo);
        productRepository.save(tagalog);
    }
}