/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.com.mindworks.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author abraham
 */
@Entity
@Table(name = "t_offering_property")
@NamedQueries({
    @NamedQuery(name = "TOfferingProperty.findAll", query = "SELECT t FROM TOfferingProperty t")})
public class TOfferingProperty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
 
    @Column(name = "OrderBy")
    private int orderBy;
 
    @Column(name = "IsMondatory")
    private boolean isMondatory;
 
    @Column(name = "ShowOnReport")
    private boolean showOnReport;
    
    @JoinColumn(name = "OfferingId", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TOffering offeringId;
    
    @JoinColumn(name = "PropertyId", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TProperty propertyId;

    public TOfferingProperty() {
    }

    public TOfferingProperty(Integer id) {
        this.id = id;
    }

    public TOfferingProperty(Integer id, int orderBy, boolean isMondatory, boolean showOnReport) {
        this.id = id;
        this.orderBy = orderBy;
        this.isMondatory = isMondatory;
        this.showOnReport = showOnReport;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(int orderBy) {
        this.orderBy = orderBy;
    }

    public boolean getIsMondatory() {
        return isMondatory;
    }

    public void setIsMondatory(boolean isMondatory) {
        this.isMondatory = isMondatory;
    }

    public boolean getShowOnReport() {
        return showOnReport;
    }

    public void setShowOnReport(boolean showOnReport) {
        this.showOnReport = showOnReport;
    }

    public TOffering getOfferingId() {
        return offeringId;
    }

    public void setOfferingId(TOffering offeringId) {
        this.offeringId = offeringId;
    }

    public TProperty getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(TProperty propertyId) {
        this.propertyId = propertyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TOfferingProperty)) {
            return false;
        }
        TOfferingProperty other = (TOfferingProperty) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.com.mindworks.model.TOfferingProperty[ id=" + id + " ]";
    }
    
}
