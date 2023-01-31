package com.example.bhubchallengeapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_bank_data")
@IdClass(BankDataId.class)
public class BankData implements Serializable {
    @Id
    private String agencie;
    @Id
    private String account;
    @Id
    @Column(name = "number_bank")
    private String numberBank;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
