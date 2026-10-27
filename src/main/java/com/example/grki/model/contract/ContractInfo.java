package com.example.grki.model.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractInfo {
    @JsonProperty("contract_guid")
    private String contractGuid;
    @JsonProperty("contract_id")
    private String contractId;
}
