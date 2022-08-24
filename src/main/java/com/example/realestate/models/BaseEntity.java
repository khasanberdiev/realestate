package com.example.realestate.models;

import com.example.realestate.models.enums.Status;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;





@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;
    
    @Column(name = "created_on", insertable = true, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdOn;
 
    @Column(name = "created_by", insertable = true, updatable = false)
    private String createdBy;
 
    @Column(name = "updated_on")
    @UpdateTimestamp
    private LocalDateTime updatedOn;
 
    @Column(name = "updated_by")
    private String updatedBy;

    public BaseEntity(){
        
    }

    public BaseEntity(Long id, Status status, LocalDateTime createdOn, String createdBy, LocalDateTime updatedOn,
            String updatedBy) {
        this.id = id;
        this.status = status;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.updatedOn = updatedOn;
        this.updatedBy = updatedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    




 
    
}
