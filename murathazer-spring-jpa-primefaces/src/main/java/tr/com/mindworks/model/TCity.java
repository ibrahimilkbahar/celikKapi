/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.com.mindworks.model;

import java.io.Serializable;
import java.util.List;

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

/**
 *
 * @author abraham
 */
@Entity
@Table(name = "t_city")
@NamedQueries({@NamedQuery(name = "TCity.findAll", query = "SELECT t FROM TCity t")})
public class TCity implements Serializable {

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
    
    @JoinColumn(name = "CountryId", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TCountry countryId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityId", fetch = FetchType.LAZY)
    private List<TDistrict> tDistrictList;

    public TCity() {
    }

    public TCity(Integer id) {
        this.id = id;
    }    
}
