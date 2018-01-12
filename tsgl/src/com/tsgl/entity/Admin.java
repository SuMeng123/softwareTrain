// default package
package com.tsgl.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Admin", schema = "dbo", catalog = "tsgl")
public class Admin implements java.io.Serializable {

	// Fields

	private Integer adminId;
	private String ANum;
	private String AName;
	private String APsw;

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** minimal constructor */
	public Admin(Integer adminId) {
		this.adminId = adminId;
	}

	/** full constructor */
	public Admin(Integer adminId, String ANum, String AName, String APsw) {
		this.adminId = adminId;
		this.ANum = ANum;
		this.AName = AName;
		this.APsw = APsw;
	}

	// Property accessors
	@Id
	@Column(name = "Admin_ID", unique = true, nullable = false)
	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	@Column(name = "A_Num")
	public String getANum() {
		return this.ANum;
	}

	public void setANum(String ANum) {
		this.ANum = ANum;
	}

	@Column(name = "A_Name")
	public String getAName() {
		return this.AName;
	}

	public void setAName(String AName) {
		this.AName = AName;
	}

	@Column(name = "A_Psw")
	public String getAPsw() {
		return this.APsw;
	}

	public void setAPsw(String APsw) {
		this.APsw = APsw;
	}

}