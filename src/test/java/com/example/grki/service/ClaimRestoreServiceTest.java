package com.example.grki.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClaimRestoreServiceTest {

    @Test
    void buildsJsonAsInSpec() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ClaimRestoreService service = new ClaimRestoreService(mapper, null);

        String json = mapper.writeValueAsString(service.buildRequest("1", "00444", "123456789012345678", "CL-001"));
        System.out.println(json);

        JsonNode expected = mapper.readTree("""
                {
                  "save_mode": "1",
                  "creditor": { "type": "01", "code": "00444", "office": "00444" },
                  "claim": { "claim_guid": "123456789012345678", "claim_id": "CL-001" }
                }
                """);
        assertEquals(expected, mapper.readTree(json));
    }
}
