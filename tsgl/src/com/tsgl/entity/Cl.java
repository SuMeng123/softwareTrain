// default package

package com.tsgl.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Cl entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CL", schema = "dbo", catalog = "tsgl")
public class Cl implements java.io.Serializable {

	// Fields

	private Integer clid;
	private String clName;
	private String clNum;

	// Constructors

	/** default constructor */
	public Cl() {
	}

	/** minimal constructor */
	public Cl(Integer clid) {
		this.clid = clid;
	}

	/** full constructor */
	public Cl(Integer clid, String clName, String clNum) {
		this.clid = clid;
		this.clName = clName;
		this.clNum = clNum;
	}

	// Property accessors
	@Id
	@Column(name = "CLID", unique = true, nullable = false)
	public Integer getClid() {
		return this.clid;
	}

	public void setClid(Integer clid) {
		this.clid = clid;
	}

	@Column(name = "CL_Name")
	public String getClName() {
		return this.clName;
	}

	public void setClName(String clName) {
		this.clName = clName;
	}

	@Column(name = "CL_Num")
	public String getClNum() {
		return this.clNum;
	}

	public void setClNum(String clNum) {
		this.clNum = clNum;
	}

}