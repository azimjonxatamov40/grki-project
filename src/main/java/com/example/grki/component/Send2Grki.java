package com.example.grki.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class Send2Grki {

    private final RestClient restClient;

    public Send2Grki(@Value("${grki.url}") String grkiUrl) {
        this.restClient = RestClient.builder()
                .baseUrl(grkiUrl)
                .build();
    }



    public String send(String method, String body) {
        return restClient.post()
                .uri("/{method}", method)
                .contentType(MediaType.APPLICATION_JSON)
                .body(body)
                .retrieve()
                .body(String.class);
    }
}
