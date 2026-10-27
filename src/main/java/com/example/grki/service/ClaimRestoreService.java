package com.example.grki.service;

import com.example.grki.component.Send2Grki;
import com.example.grki.model.claim.CreditorInfo;
import com.example.grki.model.claim.ClaimInfo;
import com.example.grki.model.claim.ClaimRestoreRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class ClaimRestoreService {

    private final ObjectMapper objectMapper;

    private final Send2Grki send2Grki;

    public ClaimRestoreRequest buildRequest(String saveMode, String branch, String claimGuid, String claimId) {
        return ClaimRestoreRequest.builder()
                .saveMode(saveMode)
                .creditor(CreditorInfo.builder()
                        .type("01")
                        .branch(branch)
                        .office(branch)
                        .build())
                .claim(ClaimInfo.builder()
                        .claimGuid(claimGuid)
                        .claimId(claimId)
                        .build())
                .build();
    }

    public String restore(String saveMode, String branch, String claimGuid, String claimId) throws JsonProcessingException {
        String request = objectMapper.writeValueAsString(buildRequest(saveMode, branch, claimGuid, claimId));
        log.info("restoreClaim request: {}", request);

        String response = send2Grki.send("restoreClaim", request);
        log.info("restoreClaim response: {}", response);

        return response;
    }
}
