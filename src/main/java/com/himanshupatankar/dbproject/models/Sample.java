package com.himanshupatankar.dbproject.models;

import javax.persistence.*;

@Entity
@Table(name = "samples")
public class Sample {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private String organism;
  private String tissueOrigin;
  private String dnaSequence;
  private String disease;
  private String vendor;
  private String notes;
  private Integer experiment_id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getOrganism() {
    return organism;
  }

  public void setOrganism(String organism) {
    this.organism = organism;
  }

  public String getTissueOrigin() {
    return tissueOrigin;
  }

  public void setTissueOrigin(String tissueOrigin) {
    this.tissueOrigin = tissueOrigin;
  }

  public String getDnaSequence() {
    return dnaSequence;
  }

  public void setDnaSequence(String dnaSequence) {
    this.dnaSequence = dnaSequence;
  }

  public String getDisease() {
    return disease;
  }

  public void setDisease(String disease) {
    this.disease = disease;
  }

  public String getVendor() {
    return vendor;
  }

  public void setVendor(String vendor) {
    this.vendor = vendor;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public Integer getExperiment_id() {
    return experiment_id;
  }

  public void setExperiment_id(Integer experiment_id) {
    this.experiment_id = experiment_id;
  }




  public Sample(String name, String organism, String tissueOrigin, String dnaSequence, String disease,
      String vendor, String notes, Integer experiment_id) {
    this.name = name;
    this.organism = organism;
    this.tissueOrigin = tissueOrigin;
    this.dnaSequence = dnaSequence;
    this.disease = disease;
    this.vendor = vendor;
    this.notes = notes;
    this.experiment_id = experiment_id;
  }

  public Sample() {

  }
}