package de.inovex.microservices.productdetails;

import de.inovex.microservices.productdetails.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackageClasses = Application.class)
@ComponentScan(basePackages = { "de.inovex.microservices" })
@RestController
public class Application {

    @RequestMapping(value = "/productdetails/{id}", method = RequestMethod.GET)
    public ProductDetails fetchProductDetails(@PathVariable final long id) {
        return new ProductDetails(id, "This is the description for product " + id);
    }

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }
}