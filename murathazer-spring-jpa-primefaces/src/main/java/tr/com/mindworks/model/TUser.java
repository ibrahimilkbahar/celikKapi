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
@Table(name = "t_user")
@NamedQueries({
    @NamedQuery(name = "TUser.findAll", query = "SELECT t FROM TUser t")})
public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
    @Column(name = "Id")
    private Integer id;
 
 
 
    @Column(name = "LoginName")
    private String loginName;
 
 
 
    @Column(name = "Password")
    private String password;
 
 
    @Column(name = "IsActive")
    private boolean isActive;
    @Column(name = "LastLogin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createUserId", fetch = FetchType.LAZY)
    private List<TOrder> tOrderList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "updateUserId", fetch = FetchType.LAZY)
    private List<TOrder> tOrderList1;

    public TUser() {
    }

    public TUser(Integer id) {
        this.id = id;
    }

    public TUser(Integer id, String loginName, String password, boolean isActive) {
        this.id = id;
        this.loginName = loginName;
        this.password = password;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public List<TOrder> getTOrderList() {
        return tOrderList;
    }

    public void setTOrderList(List<TOrder> tOrderList) {
        this.tOrderList = tOrderList;
    }

    public List<TOrder> getTOrderList1() {
        return tOrderList1;
    }

    public void setTOrderList1(List<TOrder> tOrderList1) {
        this.tOrderList1 = tOrderList1;
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
        if (!(object instanceof TUser)) {
            return false;
        }
        TUser other = (TUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.com.mindworks.model.TUser[ id=" + id + " ]";
    }
    
}
