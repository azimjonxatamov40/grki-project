package com.example.grki.model.claim;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditorInfo {
    private String type;
    @JsonProperty("code")
    private String branch;
    private String office;
}
