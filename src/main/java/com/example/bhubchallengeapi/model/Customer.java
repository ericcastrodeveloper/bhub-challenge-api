package com.example.bhubchallengeapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_customer")
@EntityListeners(AuditingEntityListener.class)
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private Long id;
    @Column(name = "company_name")
    private String companyName;
    private String telephone;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;
    @Column(name = "declared_billing")
    private String declaredBilling;
    @CreatedDate
    @Column(name = "created_date")
    private LocalDate createdDate;
    @LastModifiedDate
    @Column(name = "updated_date")
    private LocalDate updatedDate;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<BankData> bankDataList;

}
