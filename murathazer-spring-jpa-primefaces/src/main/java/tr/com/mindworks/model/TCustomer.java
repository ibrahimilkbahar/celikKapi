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
@Table(name = "t_customer")
@NamedQueries({
    @NamedQuery(name = "TCustomer.findAll", query = "SELECT t FROM TCustomer t")})
public class TCustomer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
    @Column(name = "Id")
    private Integer id;
 
    @Column(name = "Fullname")
    private String fullname;
 
 
    @Column(name = "IsCorporate")
    private boolean isCorporate;
 
    @Column(name = "Description")
    private String description;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
 
 
 
    @Column(name = "Phone")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
 
    @Column(name = "Email")
    private String email;
 
    @Column(name = "WebUrl")
    private String webUrl;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId", fetch = FetchType.LAZY)
    private List<TOrder> tOrderList;
    @JoinColumn(name = "DefaultAddressId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private TCustomerAddress defaultAddressId;
    @JoinColumn(name = "DefaultContactId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private TCustomerContact defaultContactId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId", fetch = FetchType.LAZY)
    private List<TCustomerAddress> tCustomerAddressList;
    @OneToMany(mappedBy = "customerId", fetch = FetchType.LAZY)
    private List<TCustomerProject> tCustomerProjectList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId", fetch = FetchType.LAZY)
    private List<TCustomerContact> tCustomerContactList;

    public TCustomer() {
    }

    public TCustomer(Integer id) {
        this.id = id;
    }

    public TCustomer(Integer id, boolean isCorporate, String phone) {
        this.id = id;
        this.isCorporate = isCorporate;
        this.phone = phone;
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

    public boolean getIsCorporate() {
        return isCorporate;
    }

    public void setIsCorporate(boolean isCorporate) {
        this.isCorporate = isCorporate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public List<TOrder> getTOrderList() {
        return tOrderList;
    }

    public void setTOrderList(List<TOrder> tOrderList) {
        this.tOrderList = tOrderList;
    }

    public TCustomerAddress getDefaultAddressId() {
        return defaultAddressId;
    }

    public void setDefaultAddressId(TCustomerAddress defaultAddressId) {
        this.defaultAddressId = defaultAddressId;
    }

    public TCustomerContact getDefaultContactId() {
        return defaultContactId;
    }

    public void setDefaultContactId(TCustomerContact defaultContactId) {
        this.defaultContactId = defaultContactId;
    }

    public List<TCustomerAddress> getTCustomerAddressList() {
        return tCustomerAddressList;
    }

    public void setTCustomerAddressList(List<TCustomerAddress> tCustomerAddressList) {
        this.tCustomerAddressList = tCustomerAddressList;
    }

    public List<TCustomerProject> getTCustomerProjectList() {
        return tCustomerProjectList;
    }

    public void setTCustomerProjectList(List<TCustomerProject> tCustomerProjectList) {
        this.tCustomerProjectList = tCustomerProjectList;
    }

    public List<TCustomerContact> getTCustomerContactList() {
        return tCustomerContactList;
    }

    public void setTCustomerContactList(List<TCustomerContact> tCustomerContactList) {
        this.tCustomerContactList = tCustomerContactList;
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
        if (!(object instanceof TCustomer)) {
            return false;
        }
        TCustomer other = (TCustomer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.com.mindworks.model.TCustomer[ id=" + id + " ]";
    }
    
}
