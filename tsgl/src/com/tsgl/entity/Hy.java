// default package

package com.tsgl.entity;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Hy entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "HY", schema = "dbo", catalog = "tsgl")
public class Hy implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String UName;
	private String UEmail;
	private String UPhone;
	private String USnum;
	private String UXnum;
	private String USex;
	private String UPsw;

	// Constructors

	/** default constructor */
	public Hy() {
	}

	/** minimal constructor */
	public Hy(Integer userId) {
		this.userId = userId;
	}

	/** full constructor */
	public Hy(Integer userId, String UName, String UEmail, String UPhone,
			String USnum, String UXnum, String USex, String UPsw) {
		this.userId = userId;
		this.UName = UName;
		this.UEmail = UEmail;
		this.UPhone = UPhone;
		this.USnum = USnum;
		this.UXnum = UXnum;
		this.USex = USex;
		this.UPsw = UPsw;
	}

	// Property accessors
	@Id
	@Column(name = "UserID", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "U_Name")
	public String getUName() {
		return this.UName;
	}

	public void setUName(String UName) {
		this.UName = UName;
	}

	@Column(name = "U_Email")
	public String getUEmail() {
		return this.UEmail;
	}

	public void setUEmail(String UEmail) {
		this.UEmail = UEmail;
	}

	@Column(name = "U_Phone")
	public String getUPhone() {
		return this.UPhone;
	}

	public void setUPhone(String UPhone) {
		this.UPhone = UPhone;
	}

	@Column(name = "U_Snum")
	public String getUSnum() {
		return this.USnum;
	}

	public void setUSnum(String USnum) {
		this.USnum = USnum;
	}

	@Column(name = "U_Xnum")
	public String getUXnum() {
		return this.UXnum;
	}

	public void setUXnum(String UXnum) {
		this.UXnum = UXnum;
	}

	@Column(name = "U_Sex")
	public String getUSex() {
		return this.USex;
	}

	public void setUSex(String USex) {
		this.USex = USex;
	}

	@Column(name = "U_Psw")
	public String getUPsw() {
		return this.UPsw;
	}

	public void setUPsw(String UPsw) {
		this.UPsw = UPsw;
	}

}