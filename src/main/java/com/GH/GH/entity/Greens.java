package com.GH.GH.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="greens")
public class Greens {


    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 
    
    @Column(name="name")
    private String name;

    @Column(name="category")
    private String category;

    @Column(name="sunHours")
    private Double sunHours;

    @Column(name="germHours")
    private Integer germHours;

    @Column(name="harvestTime")
    private Integer harvestTime;

    @Column(name="waterTime")
    private Double waterTime;

    @Column(name="imageUrl")
    private String imageUrl;

    @ManyToMany(cascade = {
        CascadeType.ALL
    })
    @JoinTable(
        name="garden_greens", 
        joinColumns = {@JoinColumn(name= "greens_id", referencedColumnName="id")},
    inverseJoinColumns = {@JoinColumn(name = "garden_id", referencedColumnName="id")}
    ) 

private List<GardenGreens> gardenGreens;

public List<GardenGreens> getGardenGreens() {
    return gardenGreens;
}

public void addGardenGreen(GardenGreens gardenGreen) {
    gardenGreens.add(gardenGreen);
}

public Greens() {}

public Greens(Integer id, String name, String category, Double sunHours, Integer germHours, Integer harvestTime,
        Double waterTime, String imageUrl, List<GardenGreens> gardenGreens) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.sunHours = sunHours;
    this.germHours = germHours;
    this.harvestTime = harvestTime;
    this.waterTime = waterTime;
    this.imageUrl = imageUrl;
    this.gardenGreens = gardenGreens;
}

@Override
public String toString() {
    return "Greens [category=" + category + ", gardenGreens=" + gardenGreens + ", germHours=" + germHours
            + ", harvestTime=" + harvestTime + ", id=" + id + ", imageUrl=" + imageUrl + ", name=" + name
            + ", sunHours=" + sunHours + ", waterTime=" + waterTime + "]";
}

public Integer getId() {
    return id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getCategory() {
    return category;
}

public void setCategory(String category) {
    this.category = category;
}

public Double getSunHours() {
    return sunHours;
}

public void setSunHours(Double sunHours) {
    this.sunHours = sunHours;
}

public Integer getGermHours() {
    return germHours;
}

public void setGermHours(Integer germHours) {
    this.germHours = germHours;
}

public Integer getHarvestTime() {
    return harvestTime;
}

public void setHarvestTime(Integer harvestTime) {
    this.harvestTime = harvestTime;
}

public Double getWaterTime() {
    return waterTime;
}

public void setWaterTime(Double waterTime) {
    this.waterTime = waterTime;
}

public void setGardenGreens(List<GardenGreens> gardenGreens) {
    this.gardenGreens = gardenGreens;
}

public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
}

public String getImageUrl() {
    return imageUrl;
}

}
