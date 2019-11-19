/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.com.mindworks.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Inheritance
@MappedSuperclass
@Data 
public class BaseAuditModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "CreateUserTime")
	private Date createUserTime;

	@Column(name = "UpdateUserTime")
	private Date updateUserTime;

	@Column(name = "CreateUserId")
	private Integer createUserId;

	@Column(name = "UpdateUserId")
	private Integer updateUserId;

	@Column(name = "IsActive")
	private Integer isActive = 1;
}
