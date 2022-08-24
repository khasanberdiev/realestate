package com.example.realestate.models;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

public class FileModel extends BaseEntity {
    @Column(name = "name")
    String fileName;
    @Lob
    @Column(name = "content")
    String content;
    @Column(name = "filetype")
    private String fileType;

    @ManyToOne
    @JoinColumn(name="property_id", nullable=false)
    private Property property;

    public FileModel(){

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

    
}
