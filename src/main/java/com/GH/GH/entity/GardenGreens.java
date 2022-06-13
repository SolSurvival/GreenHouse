package com.GH.GH.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="garden_greens")
public class GardenGreens {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

    @Column(name="quantityOfProduct")
    private Integer quantityOfProduct;

    @Column(name="garden_id")
    private Integer garden_id;

    @Column(name="greens_id")
    private Integer greens_id;
    
    public GardenGreens() {
    }

    public GardenGreens(Integer id, Integer quantityOfProduct, Integer garden_id, Integer greens_id) {
        this.id = id;
        this.quantityOfProduct = quantityOfProduct;
        this.garden_id = garden_id;
        this.greens_id = greens_id;
    }

    @Override
    public String toString() {
        return "GardenGreens [id=" + id + ", quantityOfProduct=" + quantityOfProduct + "]";
    }

    public Integer getId() {
        return id;
    }



    public Integer getQuantityOfProduct() {
        return quantityOfProduct;
    }



    public void setQuantityOfProduct(Integer quantityOfProduct) {
        this.quantityOfProduct = quantityOfProduct;
    }



    public Integer getGarden_id() {
        return garden_id;
    }



    public Integer getGreens_id() {
        return greens_id;
    }

   

}