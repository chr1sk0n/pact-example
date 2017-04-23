package de.inovex.microservices.product.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import de.inovex.microservices.product.consumer.adapter.*;
import de.inovex.microservices.product.consumer.model.*;
import java.net.URI;

@SpringBootApplication(scanBasePackageClasses = Application.class)
//@ComponentScan(basePackages = {"de.inovex.microservices"})
@RestController
public class Application {

    @Autowired
    private ProductDetailsFetcher detailsFetcher;

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public Product fetchProductPrice(@PathVariable final long id) {
        URI productDetailsUri = URI.create("http://localhost:10100/productdetails/1");
        return new Product(id, "Foo Product", detailsFetcher.fetchDetails(productDetailsUri));

    }

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
