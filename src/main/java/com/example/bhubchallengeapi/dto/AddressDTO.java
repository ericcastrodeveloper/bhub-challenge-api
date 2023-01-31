package com.example.bhubchallengeapi.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    @NotEmpty
    private String postalCode;
    @NotEmpty
    private String street;
    @NotEmpty
    private String number;
    @NotEmpty
    private String country;
    @NotEmpty
    private String city;
}
