package com.example.realestate.models;


import com.example.realestate.models.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="picture")
public class Picture extends BaseEntity{


    @Column(name = "name")
    String fileName;

    @Column(name = "content")
    String content;
    @Column(name = "filetype")
    private String fileType;

    @ManyToOne
    @JoinColumn(name="property_id", nullable=false)
    private Property property;

    public Picture(){

    }

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    

    public Picture(String fileName, String content, String fileType, Property property, Status status) {
        this.fileName = fileName;
        this.content = content;
        this.fileType = fileType;
        this.property = property;
        this.status= status;

    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public void setStatus(Status status) {
        this.status = Status.active;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "fileName='" + fileName + '\'' +
                ", content='" + content + '\'' +
                ", fileType='" + fileType + '\'' +
                ", property=" + property +
                '}';
    }
}
