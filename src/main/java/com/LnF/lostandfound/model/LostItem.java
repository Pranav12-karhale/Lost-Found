package com.LnF.lostandfound.model;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "lost_items")
@AttributeOverrides({
        @AttributeOverride(name = "date", column = @Column(name = "lost_date"))
})
public class LostItem extends Item {
    // Methods mapping to old properties - for backward compatibility in TableView.
    // In DashboardController, it uses 'lostDate'.

    public Date getLostDate() {
        return super.getDate();
    }

    public void setLostDate(Date lostDate) {
        super.setDate(lostDate);
    }
}