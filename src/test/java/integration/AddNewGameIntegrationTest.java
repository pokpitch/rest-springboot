package integration;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import game.door.boot.api.rest.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class AddNewGameIntegrationTest {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private RestTemplate restTemplate = new TestRestTemplate();
  
    @Test
    public void get_game_by_id_should_be_not_null() throws JsonProcessingException {
    	
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
 
        @SuppressWarnings("unchecked")
		Map<String, Object> apiResponse =
                restTemplate.getForObject("http://localhost:8080/api/games/1", Map.class);

        //Assert
        assertNotNull(apiResponse);
        assertNotNull(apiResponse.get("id"));
        assertEquals("test 1", apiResponse.get("name"));
        assertEquals("test game 1", apiResponse.get("description"));
        
    }
}
