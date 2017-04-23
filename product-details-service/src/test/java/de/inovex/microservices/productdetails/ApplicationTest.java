package de.inovex.microservices.productdetails;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import io.restassured.RestAssured;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ApplicationTest {

    @Value("${local.server.port}")
    private int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void shouldFetchProductDetails() {

        when()
                .get("/productdetails/{id}", 1)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("id", Matchers.is(1))
                .body("description", is("This is the description for product 1"));
    }

}
