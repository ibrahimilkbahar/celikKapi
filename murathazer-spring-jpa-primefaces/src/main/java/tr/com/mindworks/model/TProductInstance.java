/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.com.mindworks.model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author abraham
 */
@Entity
@Table(name = "t_product_instance")
@NamedQueries({
    @NamedQuery(name = "TProductInstance.findAll", query = "SELECT t FROM TProductInstance t")})
public class TProductInstance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
    @Column(name = "Id")
    private Integer id;
 
 
 
    @Column(name = "ProductCode")
    private String productCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productInstanceId", fetch = FetchType.LAZY)
    private List<TProductInstancePropval> tProductInstancePropvalList;
    @JoinColumn(name = "ProductTypeId", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TProductType productTypeId;
    @JoinColumn(name = "OrderOfferingId", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TOrderOffering orderOfferingId;
    @JoinColumn(name = "ProductInstanceStatusId", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TProductInstanceStatus productInstanceStatusId;

    public TProductInstance() {
    }

    public TProductInstance(Integer id) {
        this.id = id;
    }

    public TProductInstance(Integer id, String productCode) {
        this.id = id;
        this.productCode = productCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public List<TProductInstancePropval> getTProductInstancePropvalList() {
        return tProductInstancePropvalList;
    }

    public void setTProductInstancePropvalList(List<TProductInstancePropval> tProductInstancePropvalList) {
        this.tProductInstancePropvalList = tProductInstancePropvalList;
    }

    public TProductType getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(TProductType productTypeId) {
        this.productTypeId = productTypeId;
    }

    public TOrderOffering getOrderOfferingId() {
        return orderOfferingId;
    }

    public void setOrderOfferingId(TOrderOffering orderOfferingId) {
        this.orderOfferingId = orderOfferingId;
    }

    public TProductInstanceStatus getProductInstanceStatusId() {
        return productInstanceStatusId;
    }

    public void setProductInstanceStatusId(TProductInstanceStatus productInstanceStatusId) {
        this.productInstanceStatusId = productInstanceStatusId;
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
        if (!(object instanceof TProductInstance)) {
            return false;
        }
        TProductInstance other = (TProductInstance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.com.mindworks.model.TProductInstance[ id=" + id + " ]";
    }
    
}
