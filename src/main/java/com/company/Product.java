/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Locale;
import java.util.Set;


/**
 *
 * @author leandros
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements Serializable, Comparable {



    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private float price;

    private String description;

    private String imagePath;

    private Category category;

    private Set<Recension> recensions;

    private boolean active;


    public Product() {
    }

    public Product(String name, float price, String description, String imgPath, Category category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.imagePath = imgPath;
        this.category = category;
        this.active = true;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Recension> getRecensions() {
        return recensions;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    @Override
    public int compareTo(Object o) {
        return Long.compare(((Product) o).getId(), this.id);
    }


    // Convenience methods

    public int ratingCount() {
        return recensions.size();
    }

    public float averageRating() {
        // avoid division by 0
        if (ratingCount() == 0) {
            return 0;
        }
        int sum = 0;
        for (Recension r : recensions) {
            sum += r.getRating();
        }
        return sum/ratingCount();

    }


}
