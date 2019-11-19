/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.com.mindworks.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author abraham
 */
@Entity
@Table(name = "t_offering")
@NamedQueries({
    @NamedQuery(name = "TOffering.findAll", query = "SELECT t FROM TOffering t")})
public class TOffering implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
    @Column(name = "Id")
    private Integer id;
 
    @Column(name = "Name")
    private String name;
 
    @Column(name = "Code")
    private String code;
 
    @Column(name = "Description")
    private String description;
 
    @Column(name = "IsSaleable")
    private boolean isSaleable;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "offeringId", fetch = FetchType.EAGER)
    private List<TOfferingProperty> tOfferingPropertyList;
    
    @JoinColumn(name = "ProductTypeId", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TProductType productTypeId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "offeringId", fetch = FetchType.LAZY)
    private List<TOrderOffering> tOrderOfferingList;

    public TOffering() {
    }

    public TOffering(Integer id) {
        this.id = id;
    }

    public TOffering(Integer id, boolean isSaleable) {
        this.id = id;
        this.isSaleable = isSaleable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsSaleable() {
        return isSaleable;
    }

    public void setIsSaleable(boolean isSaleable) {
        this.isSaleable = isSaleable;
    }

    public List<TOfferingProperty> getTOfferingPropertyList() {
        return tOfferingPropertyList;
    }

    public void setTOfferingPropertyList(List<TOfferingProperty> tOfferingPropertyList) {
        this.tOfferingPropertyList = tOfferingPropertyList;
    }

    public TProductType getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(TProductType productTypeId) {
        this.productTypeId = productTypeId;
    }

    public List<TOrderOffering> getTOrderOfferingList() {
        return tOrderOfferingList;
    }

    public void setTOrderOfferingList(List<TOrderOffering> tOrderOfferingList) {
        this.tOrderOfferingList = tOrderOfferingList;
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
        if (!(object instanceof TOffering)) {
            return false;
        }
        TOffering other = (TOffering) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.com.mindworks.model.TOffering[ id=" + id + " ]";
    }
    
}
