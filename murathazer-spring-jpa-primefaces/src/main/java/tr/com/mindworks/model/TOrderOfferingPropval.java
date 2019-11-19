/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.com.mindworks.model;

import java.io.Serializable;
import javax.persistence.Basic;
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
@Table(name = "t_order_offering_propval")
@NamedQueries({
    @NamedQuery(name = "TOrderOfferingPropval.findAll", query = "SELECT t FROM TOrderOfferingPropval t")})
public class TOrderOfferingPropval implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
    @Column(name = "Id")
    private Integer id;
    @JoinColumn(name = "OrderOfferingId", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TOrderOffering orderOfferingId;
    @JoinColumn(name = "PropertyValueId", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TPropertyValue propertyValueId;

    public TOrderOfferingPropval() {
    }

    public TOrderOfferingPropval(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TOrderOffering getOrderOfferingId() {
        return orderOfferingId;
    }

    public void setOrderOfferingId(TOrderOffering orderOfferingId) {
        this.orderOfferingId = orderOfferingId;
    }

    public TPropertyValue getPropertyValueId() {
        return propertyValueId;
    }

    public void setPropertyValueId(TPropertyValue propertyValueId) {
        this.propertyValueId = propertyValueId;
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
        if (!(object instanceof TOrderOfferingPropval)) {
            return false;
        }
        TOrderOfferingPropval other = (TOrderOfferingPropval) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.com.mindworks.model.TOrderOfferingPropval[ id=" + id + " ]";
    }
    
}
