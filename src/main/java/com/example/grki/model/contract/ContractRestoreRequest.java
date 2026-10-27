package com.example.grki.model.contract;

import com.example.grki.model.claim.CreditorInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractRestoreRequest {
    @JsonProperty("save_mode")
    private String saveMode;
    private CreditorInfo creditor;
    private ContractInfo contract;
}
