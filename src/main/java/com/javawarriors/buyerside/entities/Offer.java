package com.javawarriors.buyerside.entities;

import java.util.Date;

import com.javawarriors.buyerside.entities.compositeKeys.*;
import javax.persistence.*;

@Entity
@Table(name = "offer")
@IdClass(OfferPK.class)
public class Offer {
    @ManyToOne
    @JoinColumn(name = "uid")
    @Column(name="buyer_id", nullable = false, unique = true, length = 45)
    @Id
    private User buyer;
    
    @ManyToOne
    @JoinColumn(name = "ifs_id")
    @Column(name = "ifs_id", nullable = false, unique = true, length = 45)
    @Id
    private ItemForSaleListing ifsListing;

    private Double offeredPrice;

    private Date dateOfOffer;

    private String desc;

    private Character status;

    /** getters and setters for the variables of the Offer */

    public User getBuyer() {
		return this.buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

    public ItemForSaleListing getIfsListing() {
		return this.ifsListing;
	}

	public void setIfsListing(ItemForSaleListing ifsListing) {
		this.ifsListing = ifsListing;
	}

	public Double getOfferedPrice() {
		return this.offeredPrice;
	}

	public void setOfferedPrice(Double offeredPrice) {
		this.offeredPrice = offeredPrice;
	}

    public Date getDateOfOffer() {
        return this.dateOfOffer;
    }

    public void setDateOfOffer(Date dateOfOffer) {
        this.dateOfOffer = dateOfOffer;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Character getStatus() {
        return this.status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }
}
