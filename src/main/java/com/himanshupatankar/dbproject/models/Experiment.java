package com.himanshupatankar.dbproject.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "experiments")
public class Experiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String treatmentType;
    private Date datePerformed;
    private String notes;
    private Integer scientist_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(String treatmentType) {
        this.treatmentType = treatmentType;
    }

    public Date getDatePerformed() {
        return datePerformed;
    }

    public void setDatePerformed(Date datePerformed) {
        this.datePerformed = datePerformed;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getScientist_id() {
        return scientist_id;
    }

    public void setScientist_id(Integer scientist_id) {
        this.scientist_id = scientist_id;
    }

    public Experiment(String title, String treatmentType, Date datePerformed, String notes, Integer scientist_id) {
        this.title = title;
        this.treatmentType = treatmentType;
        this.datePerformed = datePerformed;
        this.notes = notes;
        this.scientist_id = scientist_id;
    }

    public Experiment() {

    }
}
