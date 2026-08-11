package com.LnF.lostandfound.model;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "found_items")
@AttributeOverrides({
    @AttributeOverride(name = "date", column = @Column(name = "found_date")),
    @AttributeOverride(name = "location", column = @Column(name = "location_found"))
})
public class FoundItem extends Item {
    
    public String getLocationFound() {
        return super.getLocation();
    }

    public void setLocationFound(String locationFound) {
        super.setLocation(locationFound);
    }

    public Date getFoundDate() {
        return super.getDate();
    }

    public void setFoundDate(Date foundDate) {
        super.setDate(foundDate);
    }
}