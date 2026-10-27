package com.example.grki.service;

import com.example.grki.component.Send2Grki;
import com.example.grki.model.claim.CreditorInfo;
import com.example.grki.model.contract.ContractInfo;
import com.example.grki.model.contract.ContractRestoreRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class ContractRestoreService {

    private final ObjectMapper objectMapper;

    private final Send2Grki send2Grki;

    public ContractRestoreRequest buildRequest(String saveMode, String branch, String contractGuid, String contractId) {
        return ContractRestoreRequest.builder()
                .saveMode(saveMode)
                .creditor(CreditorInfo.builder()
                        .type("01")
                        .branch(branch)
                        .office(branch)
                        .build())
                .contract(ContractInfo.builder()
                        .contractGuid(contractGuid)
                        .contractId(contractId)
                        .build())
                .build();
    }

    public String restore(String saveMode, String branch, String contractGuid, String contractId) throws JsonProcessingException {
        String request = objectMapper.writeValueAsString(buildRequest(saveMode, branch, contractGuid, contractId));
        log.info("saveContractRestore request: {}", request);

        String response = send2Grki.send("saveContractRestore", request);
        log.info("saveContractRestore response: {}", response);

        return response;
    }
}
