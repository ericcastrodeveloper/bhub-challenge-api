package com.example.bhubchallengeapi.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankDataDTO {
    @NotEmpty
    @Size(min = 4, message = "agencie should have at least 4 characters")
    private String agencie;
    @NotEmpty
    @Size(min = 6, message = "account should have at least 6 characters")
    private String account;
    @NotEmpty
    @Size(min = 3, message = "numberBank should have at least 3 characters")
    private String numberBank;
}
