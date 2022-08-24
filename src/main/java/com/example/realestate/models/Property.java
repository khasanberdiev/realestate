package com.example.realestate.models;

import com.example.realestate.models.enums.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="property")
public class Property extends BaseEntity{
    @NotNull
    @Size(min = 3, max = 200, message= "Title must be between 3 and 200 characters")
    private String title;

    @NotNull
    @Positive
    @Min(value = 5, message = "Size should not be less than 5")
    private Integer size;

    @NotNull
    @Positive
    private Double price;

    @Positive
    private int bedroom;

    @Positive
    private int bathroom;

    @NotNull
    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate available_from;

    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate available_until;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Purpose purpose;
    
    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    @JoinColumn(name="property_id", nullable = false)
    private Category category;


    private int year_built;

    @Enumerated(EnumType.STRING)
    private Availability garage;

    @NotNull
    @Positive
    private int floor;

    @NotNull
    @Positive
    private int total_floor;

    // @Enumerated(EnumType.STRING)
    // private Status internet;

    private String description;
    private String feature;

    @Enumerated(EnumType.STRING)
    private Policy pet_policy;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Featured featured;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

     @OneToMany(mappedBy="property")
     private List<Picture> picture;

   public Property(){

   }




    public Property(Long id, Status status, LocalDateTime createdOn, String createdBy, LocalDateTime updatedOn,
                    String updatedBy,
                    @NotNull @Size(min = 3, max = 200, message = "Title must be between 3 and 200 characters") String title,
                    @NotNull @Positive @Min(value = 5, message = "Size should not be less than 5") Integer size,
                    @NotNull @Positive Double price, @Positive int bedroom, @Positive int bathroom,
                    @NotNull @FutureOrPresent LocalDate available_from, @Future LocalDate available_until, @NotNull Status status2,
                    @NotNull Purpose purpose, Category category, int year_built, Availability garage, @NotNull @Positive int floor,
                    @NotNull @Positive int total_floor, String description, String feature, Policy pet_policy,
                    @NotNull Featured featured, Address address, List<Picture> picture) {
    super(id, status, createdOn, createdBy, updatedOn, updatedBy);
    this.title = title;
    this.size = size;
    this.price = price;
    this.bedroom = bedroom;
    this.bathroom = bathroom;
    this.available_from = available_from;
    this.available_until = available_until;
    status = status2;
    this.purpose = purpose;
    this.category = category;
    this.year_built = year_built;
    this.garage = garage;
    this.floor = floor;
    this.total_floor = total_floor;
    this.description = description;
    this.feature = feature;
    this.pet_policy = pet_policy;
    this.featured = featured;
    this.address = address;
    this.picture=picture;
}




public Property(@NotNull @Size(min = 3, max = 200, message = "Title must be between 3 and 200 characters") String title,
        @NotNull @Positive @Min(value = 5, message = "Size should not be less than 5") Integer size,
        @NotNull @Positive Double price, @Positive int bedroom, @Positive int bathroom,
        @NotNull @FutureOrPresent LocalDate available_from, @Future LocalDate available_until, @NotNull Status status,
        @NotNull Purpose purpose, Category category, int year_built, Availability garage, @NotNull @Positive int floor,
        @NotNull @Positive int total_floor, String description, String feature, Policy pet_policy,
        @NotNull Featured featured, Address address, List<Picture> picture) {
    this.title = title;
    this.size = size;
    this.price = price;
    this.bedroom = bedroom;
    this.bathroom = bathroom;
    this.available_from = available_from;
    this.available_until = available_until;
    this.status = status;
    this.purpose = purpose;
    this.category = category;
    this.year_built = year_built;
    this.garage = garage;
    this.floor = floor;
    this.total_floor = total_floor;
    this.description = description;
    this.feature = feature;
    this.pet_policy = pet_policy;
    this.featured = featured;
    this.address = address;
    this.picture=picture;
}


public List<Picture> getPicture() {
    return picture;
}

public void setPicture(List<Picture> picture) {
    this.picture = picture;
}

public String getTitle() {
    return title;
}

public void setTitle(String title) {
    this.title = title;
}

public Integer getSize() {
    return size;
}

public void setSize(Integer size) {
    this.size = size;
}

public Double getPrice() {
    return price;
}

public void setPrice(Double price) {
    this.price = price;
}

public int getBedroom() {
    return bedroom;
}

public void setBedroom(int bedroom) {
    this.bedroom = bedroom;
}

public int getBathroom() {
    return bathroom;
}

public void setBathroom(int bathroom) {
    this.bathroom = bathroom;
}

public LocalDate getAvailable_from() {
    return available_from;
}

public void setAvailable_from(LocalDate available_from) {
    this.available_from = available_from;
}

public LocalDate getAvailable_until() {
    return available_until;
}

public void setAvailable_until(LocalDate available_until) {
    this.available_until = available_until;
}

public int getYear_built() {
    return year_built;
}

public void setYear_built(int year_built) {
    this.year_built = year_built;
}

public int getFloor() {
    return floor;
}

public void setFloor(int floor) {
    this.floor = floor;
}

public int getTotal_floor() {
    return total_floor;
}

public void setTotal_floor(int total_floor) {
    this.total_floor = total_floor;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

public String getFeature() {
    return feature;
}

public void setFeature(String feature) {
    this.feature = feature;
}

public Status getStatus() {
    return status;
}

public void setStatus(Status status) {
    this.status = status;
}

public Purpose getPurpose() {
    return purpose;
}

public void setPurpose(Purpose purpose) {
    this.purpose = purpose;
}

public Category getCategory() {
    return category;
}

public void setCategory(Category category) {
    this.category = category;
}

public Availability getGarage() {
    return garage;
}

public void setGarage(Availability garage) {
    this.garage = garage;
}

public Policy getPet_policy() {
    return pet_policy;
}

public void setPet_policy(Policy pet_policy) {
    this.pet_policy = pet_policy;
}

public Featured getFeatured() {
    return featured;
}

public void setFeatured(Featured featured) {
    this.featured = featured;
}

public Address getAddress() {
    return address;
}

public void setAddress(Address address) {
    this.address = address;
}




@Override
public String toString() {
    return "Property [address=" + address + ", available_from=" + available_from + ", available_until="
            + available_until + ", bathroom=" + bathroom + ", bedroom=" + bedroom + ", category=" + category
            + ", description=" + description + ", feature=" + feature + ", featured=" + featured + ", floor=" + floor
            + ", garage=" + garage + ", pet_policy=" + pet_policy + ", price=" + price + ", purpose=" + purpose
            + ", size=" + size + ", status=" + status + ", title=" + title + ", total_floor=" + total_floor
            + ", year_built=" + year_built + "]";
}

    

   

    
}
