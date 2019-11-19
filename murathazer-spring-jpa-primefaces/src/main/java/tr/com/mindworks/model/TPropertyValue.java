/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.com.mindworks.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author abraham
 */
@Entity
@Table(name = "t_property_value")
@NamedQueries({
    @NamedQuery(name = "TPropertyValue.findAll", query = "SELECT t FROM TPropertyValue t")})
public class TPropertyValue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
    @Column(name = "Id")
    private Integer id;
 
    @Column(name = "ValueText")
    private String valueText;
    @Column(name = "ValueNumber")
    private Integer valueNumber;
    @Column(name = "ValueDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date valueDate;
 
    @Column(name = "ValueFile")
    private String valueFile;
 
    @Column(name = "ValueColour")
    private String valueColour;
    @JoinColumn(name = "PropertyId", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TProperty propertyId;
    @JoinColumn(name = "PropertyLovId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private TPropertyLov propertyLovId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyValueId", fetch = FetchType.LAZY)
    private List<TOrderOfferingPropval> tOrderOfferingPropvalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyValueId", fetch = FetchType.LAZY)
    private List<TProductInstancePropval> tProductInstancePropvalList;

    public TPropertyValue() {
    }

    public TPropertyValue(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValueText() {
        return valueText;
    }

    public void setValueText(String valueText) {
        this.valueText = valueText;
    }

    public Integer getValueNumber() {
        return valueNumber;
    }

    public void setValueNumber(Integer valueNumber) {
        this.valueNumber = valueNumber;
    }

    public Date getValueDate() {
        return valueDate;
    }

    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    public String getValueFile() {
        return valueFile;
    }

    public void setValueFile(String valueFile) {
        this.valueFile = valueFile;
    }

    public String getValueColour() {
        return valueColour;
    }

    public void setValueColour(String valueColour) {
        this.valueColour = valueColour;
    }

    public TProperty getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(TProperty propertyId) {
        this.propertyId = propertyId;
    }

    public TPropertyLov getPropertyLovId() {
        return propertyLovId;
    }

    public void setPropertyLovId(TPropertyLov propertyLovId) {
        this.propertyLovId = propertyLovId;
    }

    public List<TOrderOfferingPropval> getTOrderOfferingPropvalList() {
        return tOrderOfferingPropvalList;
    }

    public void setTOrderOfferingPropvalList(List<TOrderOfferingPropval> tOrderOfferingPropvalList) {
        this.tOrderOfferingPropvalList = tOrderOfferingPropvalList;
    }

    public List<TProductInstancePropval> getTProductInstancePropvalList() {
        return tProductInstancePropvalList;
    }

    public void setTProductInstancePropvalList(List<TProductInstancePropval> tProductInstancePropvalList) {
        this.tProductInstancePropvalList = tProductInstancePropvalList;
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
        if (!(object instanceof TPropertyValue)) {
            return false;
        }
        TPropertyValue other = (TPropertyValue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.com.mindworks.model.TPropertyValue[ id=" + id + " ]";
    }
    
}
