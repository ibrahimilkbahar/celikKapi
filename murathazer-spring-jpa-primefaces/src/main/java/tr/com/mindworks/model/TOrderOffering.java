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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author abraham
 */
@Entity
@Table(name = "t_order_offering")
@NamedQueries({
    @NamedQuery(name = "TOrderOffering.findAll", query = "SELECT t FROM TOrderOffering t")})
public class TOrderOffering implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
    @Column(name = "Id")
    private Integer id;
 
    @Column(name = "Description")
    private String description;
 
 
    @Column(name = "CommitmentDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date commitmentDate;
 
 
    @Column(name = "Quantity")
    private int quantity;
 
 
    @Column(name = "InstanceAmount")
    private long instanceAmount;
 
 
    @Column(name = "TotalAmount")
    private long totalAmount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderOfferingId", fetch = FetchType.LAZY)
    private List<TOrderOfferingPropval> tOrderOfferingPropvalList;
    @JoinColumn(name = "OrderId", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TOrder orderId;
    @JoinColumn(name = "OfferingId", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TOffering offeringId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderOfferingId", fetch = FetchType.LAZY)
    private List<TProductInstance> tProductInstanceList;

    public TOrderOffering() {
    }

    public TOrderOffering(Integer id) {
        this.id = id;
    }

    public TOrderOffering(Integer id, Date commitmentDate, int quantity, long instanceAmount, long totalAmount) {
        this.id = id;
        this.commitmentDate = commitmentDate;
        this.quantity = quantity;
        this.instanceAmount = instanceAmount;
        this.totalAmount = totalAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCommitmentDate() {
        return commitmentDate;
    }

    public void setCommitmentDate(Date commitmentDate) {
        this.commitmentDate = commitmentDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getInstanceAmount() {
        return instanceAmount;
    }

    public void setInstanceAmount(long instanceAmount) {
        this.instanceAmount = instanceAmount;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<TOrderOfferingPropval> getTOrderOfferingPropvalList() {
        return tOrderOfferingPropvalList;
    }

    public void setTOrderOfferingPropvalList(List<TOrderOfferingPropval> tOrderOfferingPropvalList) {
        this.tOrderOfferingPropvalList = tOrderOfferingPropvalList;
    }

    public TOrder getOrderId() {
        return orderId;
    }

    public void setOrderId(TOrder orderId) {
        this.orderId = orderId;
    }

    public TOffering getOfferingId() {
        return offeringId;
    }

    public void setOfferingId(TOffering offeringId) {
        this.offeringId = offeringId;
    }

    public List<TProductInstance> getTProductInstanceList() {
        return tProductInstanceList;
    }

    public void setTProductInstanceList(List<TProductInstance> tProductInstanceList) {
        this.tProductInstanceList = tProductInstanceList;
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
        if (!(object instanceof TOrderOffering)) {
            return false;
        }
        TOrderOffering other = (TOrderOffering) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.com.mindworks.model.TOrderOffering[ id=" + id + " ]";
    }
    
}
