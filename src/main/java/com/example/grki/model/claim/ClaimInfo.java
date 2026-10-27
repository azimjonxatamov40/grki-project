package com.example.grki.model.claim;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClaimInfo {
    @JsonProperty("claim_guid")
    private String claimGuid;
    @JsonProperty("claim_id")
    private String claimId;
}
