package com.example.grki.model.information;

import com.example.grki.model.claim.CreditorInfo;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InformationRequest {
    private CreditorInfo creditor;
    private IdentityInfo identity;
}
