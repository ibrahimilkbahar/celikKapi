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
import javax.persistence.Lob;
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
@Table(name = "t_customer_address")
@NamedQueries({
    @NamedQuery(name = "TCustomerAddress.findAll", query = "SELECT t FROM TCustomerAddress t")})
public class TCustomerAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
    @Column(name = "Id")
    private Integer id;
 
 
    @Column(name = "IsDefaultCommAddress")
    private boolean isDefaultCommAddress;
 
 
    @Column(name = "IsDefaultDeliveryAddress")
    private boolean isDefaultDeliveryAddress;
 
 
 
    @Column(name = "AddressName")
    private String addressName;
 
 
    @Column(name = "AddressText")
    private String addressText;
 
 
    @Column(name = "Description")
    private String description;
    
 
 
    @Column(name = "PostCode")
    private int postCode;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveryAddressId", fetch = FetchType.LAZY)
    private List<TOrder> tOrderList;
    
    @OneToMany(mappedBy = "defaultAddressId", fetch = FetchType.LAZY)
    private List<TCustomer> tCustomerList;
    
    @JoinColumn(name = "CustomerId", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TCustomer customerId;
    
    @JoinColumn(name = "DistrictId", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TDistrict districtId;

    public TCustomerAddress() {
    }

    public TCustomerAddress(Integer id) {
        this.id = id;
    }

    public TCustomerAddress(Integer id, boolean isDefaultCommAddress, boolean isDefaultDeliveryAddress, String addressName, String addressText, String description, int postCode) {
        this.id = id;
        this.isDefaultCommAddress = isDefaultCommAddress;
        this.isDefaultDeliveryAddress = isDefaultDeliveryAddress;
        this.addressName = addressName;
        this.addressText = addressText;
        this.description = description;
        this.postCode = postCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getIsDefaultCommAddress() {
        return isDefaultCommAddress;
    }

    public void setIsDefaultCommAddress(boolean isDefaultCommAddress) {
        this.isDefaultCommAddress = isDefaultCommAddress;
    }

    public boolean getIsDefaultDeliveryAddress() {
        return isDefaultDeliveryAddress;
    }

    public void setIsDefaultDeliveryAddress(boolean isDefaultDeliveryAddress) {
        this.isDefaultDeliveryAddress = isDefaultDeliveryAddress;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddressText() {
        return addressText;
    }

    public void setAddressText(String addressText) {
        this.addressText = addressText;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public List<TOrder> getTOrderList() {
        return tOrderList;
    }

    public void setTOrderList(List<TOrder> tOrderList) {
        this.tOrderList = tOrderList;
    }

    public List<TCustomer> getTCustomerList() {
        return tCustomerList;
    }

    public void setTCustomerList(List<TCustomer> tCustomerList) {
        this.tCustomerList = tCustomerList;
    }

    public TCustomer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(TCustomer customerId) {
        this.customerId = customerId;
    }

    public TDistrict getDistrictId() {
        return districtId;
    }

    public void setDistrictId(TDistrict districtId) {
        this.districtId = districtId;
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
        if (!(object instanceof TCustomerAddress)) {
            return false;
        }
        TCustomerAddress other = (TCustomerAddress) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.com.mindworks.model.TCustomerAddress[ id=" + id + " ]";
    }
    
}
