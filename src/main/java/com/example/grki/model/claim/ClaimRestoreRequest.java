package com.example.grki.model.claim;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClaimRestoreRequest {
    @JsonProperty("save_mode")
    private String saveMode;
    private CreditorInfo creditor;
    private ClaimInfo claim;
}
