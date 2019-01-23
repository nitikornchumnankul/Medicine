package com.Team23.backend.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NonNull;
@Entity
@Data
public class Drug {
    @Id 
    @GeneratedValue(strategy= GenerationType.IDENTITY) //this isolate id 1 2 3
    private @NonNull Long drugId;
    private @NonNull String drugName;
    
    @ManyToOne()
    @JoinColumn(name="typesOfDrugsnameId")
    private TypesOfDrugs  typesOfDrugs;

    @ManyToOne()
    @JoinColumn(name=" drugRegistrationId")
    private DrugRegistration  drugRegistration;

    @ManyToOne()
    @JoinColumn(name="typesOfDosageFormsNameId")
    private TypesOfDosageForms  typesOfDosageForms;

    @ManyToOne()
    @JoinColumn(name="diseaseId")
    private Disease  disease;

    public Drug(){}
    //เพิ่ม ID
    public Long findById(long drugId){
        return this.drugId=drugId;
    }
    public String deleteByDrugName(String drugName){
        return this.drugName=drugName;
    }
 
}
