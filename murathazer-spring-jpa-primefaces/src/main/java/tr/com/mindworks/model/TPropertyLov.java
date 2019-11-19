/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.com.mindworks.model;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author abraham
 */
@Entity
@Table(name = "t_property_lov")
@NamedQueries({ @NamedQuery(name = "TPropertyLov.findAll", query = "SELECT t FROM TPropertyLov t")})
public class TPropertyLov implements Serializable {

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
    
	@Column(name = "Price")
    private long price;
    
    @OneToMany(mappedBy = "propertyLovId", fetch = FetchType.LAZY)
    private List<TPropertyValue> tPropertyValueList;
    
    @JoinColumn(name = "PropertyLovDefId", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TPropertyLovDef propertyLovDefId;

    public TPropertyLov() {
    }

    public TPropertyLov(Integer id) {
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
    public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
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

    public List<TPropertyValue> getTPropertyValueList() {
        return tPropertyValueList;
    }

    public void setTPropertyValueList(List<TPropertyValue> tPropertyValueList) {
        this.tPropertyValueList = tPropertyValueList;
    }

    public TPropertyLovDef getPropertyLovDefId() {
        return propertyLovDefId;
    }

    public void setPropertyLovDefId(TPropertyLovDef propertyLovDefId) {
        this.propertyLovDefId = propertyLovDefId;
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
        if (!(object instanceof TPropertyLov)) {
            return false;
        }
        TPropertyLov other = (TPropertyLov) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.com.mindworks.model.TPropertyLov[ id=" + id + " ]";
    }
    
}
