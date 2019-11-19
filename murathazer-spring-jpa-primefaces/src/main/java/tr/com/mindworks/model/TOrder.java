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
@Table(name = "t_order")
@NamedQueries({
    @NamedQuery(name = "TOrder.findAll", query = "SELECT t FROM TOrder t")})
public class TOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
    @Column(name = "Id")
    private Integer id;
 
    @Column(name = "OrderNo")
    private String orderNo;
    @Size(max = 400)
    @Column(name = "Description")
    private String description;
    @Column(name = "OrderDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Column(name = "ApproveDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date approveDate;
    @Column(name = "CommitmentDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date commitmentDate;
    @Column(name = "AppointmentDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date appointmentDate;
    @JoinColumn(name = "DeliveryAddressId", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TCustomerAddress deliveryAddressId;
    @JoinColumn(name = "OrderStatusId", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TOrderStatus orderStatusId;
    @JoinColumn(name = "CustomerContactId", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TCustomerContact customerContactId;
    @JoinColumn(name = "CustomerProjectId", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TCustomerProject customerProjectId;
    @JoinColumn(name = "CustomerId", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TCustomer customerId;
    @JoinColumn(name = "CreateUserId", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TUser createUserId;
    @JoinColumn(name = "UpdateUserId", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TUser updateUserId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId", fetch = FetchType.LAZY)
    private List<TOrderOffering> tOrderOfferingList;

    public TOrder() {
    }

    public TOrder(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public Date getCommitmentDate() {
        return commitmentDate;
    }

    public void setCommitmentDate(Date commitmentDate) {
        this.commitmentDate = commitmentDate;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public TCustomerAddress getDeliveryAddressId() {
        return deliveryAddressId;
    }

    public void setDeliveryAddressId(TCustomerAddress deliveryAddressId) {
        this.deliveryAddressId = deliveryAddressId;
    }

    public TOrderStatus getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(TOrderStatus orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public TCustomerContact getCustomerContactId() {
        return customerContactId;
    }

    public void setCustomerContactId(TCustomerContact customerContactId) {
        this.customerContactId = customerContactId;
    }

    public TCustomerProject getCustomerProjectId() {
        return customerProjectId;
    }

    public void setCustomerProjectId(TCustomerProject customerProjectId) {
        this.customerProjectId = customerProjectId;
    }

    public TCustomer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(TCustomer customerId) {
        this.customerId = customerId;
    }

    public TUser getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(TUser createUserId) {
        this.createUserId = createUserId;
    }

    public TUser getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(TUser updateUserId) {
        this.updateUserId = updateUserId;
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
        if (!(object instanceof TOrder)) {
            return false;
        }
        TOrder other = (TOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.com.mindworks.model.TOrder[ id=" + id + " ]";
    }
    
}
