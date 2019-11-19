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
@Table(name = "t_product_type")
@NamedQueries({
    @NamedQuery(name = "TProductType.findAll", query = "SELECT t FROM TProductType t")})
public class TProductType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
    @Column(name = "Id")
    private Integer id;
 
    @Column(name = "Name")
    private String name;
 
    @Column(name = "Code")
    private String code;
    @Column(name = "OrderBy")
    private Integer orderBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productTypeId", fetch = FetchType.LAZY)
    private List<TOffering> tOfferingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productTypeId", fetch = FetchType.LAZY)
    private List<TProductInstance> tProductInstanceList;

    public TProductType() {
    }

    public TProductType(Integer id) {
        this.id = id;
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

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    public List<TOffering> getTOfferingList() {
        return tOfferingList;
    }

    public void setTOfferingList(List<TOffering> tOfferingList) {
        this.tOfferingList = tOfferingList;
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
        if (!(object instanceof TProductType)) {
            return false;
        }
        TProductType other = (TProductType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.com.mindworks.model.TProductType[ id=" + id + " ]";
    }
    
}
