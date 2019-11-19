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
import javax.validation.constraints.Size;

/**
 *
 * @author abraham
 */
@Entity
@Table(name = "t_customer_contact")
@NamedQueries({
    @NamedQuery(name = "TCustomerContact.findAll", query = "SELECT t FROM TCustomerContact t")})
public class TCustomerContact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
    @Column(name = "Id")
    private Integer id;
 
    @Column(name = "Fullname")
    private String fullname;
 
    @Column(name = "MobilePhone")
    private String mobilePhone;
 
    @Column(name = "OfficePhone")
    private String officePhone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
 
    @Column(name = "Email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerContactId", fetch = FetchType.LAZY)
    private List<TOrder> tOrderList;
    @OneToMany(mappedBy = "defaultContactId", fetch = FetchType.LAZY)
    private List<TCustomer> tCustomerList;
    @JoinColumn(name = "CustomerId", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TCustomer customerId;

    public TCustomerContact() {
    }

    public TCustomerContact(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TCustomerContact)) {
            return false;
        }
        TCustomerContact other = (TCustomerContact) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.com.mindworks.model.TCustomerContact[ id=" + id + " ]";
    }
    
}
