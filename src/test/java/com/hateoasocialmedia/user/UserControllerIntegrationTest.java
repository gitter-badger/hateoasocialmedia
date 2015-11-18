package com.hateoasocialmedia.user;

import com.hateoasocialmedia.SocialMediaApplication;
import com.jayway.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SocialMediaApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class UserControllerIntegrationTest {

    @Value("${local.server.port}")
    int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void it_returns_a_user() throws Exception {
        String handle = "@Jean-Luc";
        when()
                .get("/user/{handle}", handle)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("handle", Matchers.is(handle));
    }

    @Test
    public void it_returns_a_link_to_the_users_feed() throws Exception {
        String handle = "@Jean-Luc";
        when()
                .get("/user/{handle}", handle)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("links.rel", Matchers.contains("self", "statuses"));
    }
}