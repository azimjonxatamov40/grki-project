package com.example.grki.model.information;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IdentityInfo {
    @JsonProperty("identity_type")
    private String identityType;
    @JsonProperty("identity_id")
    private String identityId;
}
