package com.example.bhubchallengeapi.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    @NotEmpty
    private String companyName;
    @NotEmpty
    private String telephone;
    @NotEmpty
    @Email
    private String email;
    @NotNull
    @Valid
    private AddressDTO address;
    @NotEmpty
    private String declaredBilling;
    private LocalDate createdDate;
    private LocalDate updatedDate;
    @NotNull
    @Size(min = 1)
    @Valid
    private List<BankDataDTO> bankDataList;
}
