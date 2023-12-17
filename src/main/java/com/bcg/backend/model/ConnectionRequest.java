package com.bcg.backend.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String applicantName;
    private String gender;
    private String district;
    private String state;
    private Integer pincode;
    private String ownership;
    private String govtIdType;
    private Long idNumber;
    private String category;
    private Integer loadApplied;
    private String dateOfApplication;
    private Double dateOfApproval;
    private String modifiedDate;
    private String status;
    private Integer reviewerId;
    private String reviewerName;
    private String reviewerComments;

}
