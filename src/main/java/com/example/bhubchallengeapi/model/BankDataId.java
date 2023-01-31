package com.example.bhubchallengeapi.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BankDataId implements Serializable {
    private String agencie;
    private String account;
    private String numberBank;
}
