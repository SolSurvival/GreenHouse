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
@Table(name="garden")
public class Garden {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

    @Column(name="itemQuantity")
    private String itemQuantity;

    @Column(name="name")
    private String name;

    @ManyToMany(cascade = {
        CascadeType.ALL
    })
    @JoinTable(
        name="garden_greens", 
        joinColumns = {@JoinColumn(name= "garden_id", referencedColumnName="id")},
    inverseJoinColumns = {@JoinColumn(name = "greens_id", referencedColumnName="id")}
    )
    private List<GardenGreens> gardenGreens;

    public Garden() {
    }

    public Garden(Integer id, String itemQuantity, List<GardenGreens> gardenGreens) {
        this.id = id;
        this.itemQuantity = itemQuantity;
        this.gardenGreens = gardenGreens;
    }

    @Override
    public String toString() {
        return "Garden [gardenGreens=" + gardenGreens + ", id=" + id + ", itemQuantity=" + itemQuantity + "]";
    }

    public Integer getId() {
        return id;
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public List<GardenGreens> getGardenGreens() {
        return gardenGreens;
    }

    public void setGardenGreens(List<GardenGreens> gardenGreens) {
        this.gardenGreens = gardenGreens;
    }

    public void addGardenGreen(GardenGreens gardenGreen){
        this.gardenGreens.add(gardenGreen);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}