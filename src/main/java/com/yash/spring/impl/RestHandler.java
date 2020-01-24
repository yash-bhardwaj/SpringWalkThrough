package com.yash.spring.impl;

import java.io.IOException;
import java.util.Collections;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yash.spring.controller.model.OutputCharCount;
import com.yash.spring.controller.model.OutputSentenceCount;
import com.yash.spring.controller.model.OutputVowelCount;
import com.yash.spring.controller.model.OutputWordCount;
import com.yash.spring.controller.model.TextModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * The type Rest handler.
 */
@Component
public class RestHandler {
    /**
     * The Http hunt base url.
     */
    @Value("${http.hunt.base.url}")
    String httpHuntBaseUrl;

    /**
     * The Input url.
     */
    private static final String INPUT_GET_URL = "/input";

    /**
     * The Input url.
     */
    private static final String INPUT_POST_URL = "/output";

    /**
     * The api template.
     */
    @Autowired
    private RestTemplate apiTemplate;

    /**
     * Process input.
     */
    public TextModel getInputBody() {
        final HttpHeaders headers = new HttpHeaders();
        headers.set("userId", "ISoY89hf");

        final HttpEntity<String> entity = new HttpEntity<>(headers);
//        final String url = "https://api.github.com/users/hadley/orgs";
        final String url = httpHuntBaseUrl + INPUT_GET_URL;
//        final URI uri = UriComponentsBuilder.fromHttpUrl(url).build(entity);
        final ResponseEntity<TextModel> responseEntity = apiTemplate.exchange(url, HttpMethod.GET, entity, TextModel.class);
        final HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println(responseEntity.getBody());
        if (statusCode.equals(HttpStatus.OK)) return responseEntity.getBody();
        else throw new RuntimeException("No Input Body Received!");
    }
    /**
     * Process input.
     * @param body
     */
    public String postInputBody(OutputVowelCount body) throws IOException {
        final HttpHeaders headers = new HttpHeaders();
        headers.set("userId", "ISoY89hf");
//        headers.setAccept("content-type", "application/json");
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("content-type", "application/json");
        final ObjectMapper mapper = new ObjectMapper();
        final String string = mapper.writeValueAsString(body);
        System.out.println(string);
        final HttpEntity<String> entity = new HttpEntity<>(string, headers);
        final String url = httpHuntBaseUrl + INPUT_POST_URL;
        final ResponseEntity<String> responseEntity = apiTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        final HttpStatus statusCode = responseEntity.getStatusCode();
        if (statusCode.equals(HttpStatus.OK)) return responseEntity.getBody();
        else throw new RuntimeException("No Input Body Received!");
    }
}
