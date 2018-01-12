// default package

package com.tsgl.entity;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Infor entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Infor", schema = "dbo", catalog = "tsgl")
public class Infor implements java.io.Serializable {

	// Fields

	private Integer inid;
	private Integer bookId;
	private Integer userId;
	private Integer adminId;
	private String JDate;
	private String HDate;
	private String isPs;
	private String isDs;
	private String jg;

	// Constructors

	/** default constructor */
	public Infor() {
	}

	/** minimal constructor */
	public Infor(Integer inid) {
		this.inid = inid;
	}

	/** full constructor */
	public Infor(Integer inid, Integer bookId, Integer userId, Integer adminId,
			String JDate, String HDate, String isPs, String isDs, String jg) {
		this.inid = inid;
		this.bookId = bookId;
		this.userId = userId;
		this.adminId = adminId;
		this.JDate = JDate;
		this.HDate = HDate;
		this.isPs = isPs;
		this.isDs = isDs;
		this.jg = jg;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "INID", unique = true, nullable = false)
	public Integer getInid() {
		return this.inid;
	}

	public void setInid(Integer inid) {
		this.inid = inid;
	}

	@Column(name = "BookID")
	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	@Column(name = "UserID")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "AdminID")
	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	@Column(name = "J_Date")
	public String getJDate() {
		return this.JDate;
	}

	public void setJDate(String JDate) {
		this.JDate = JDate;
	}

	@Column(name = "H_Date")
	public String getHDate() {
		return this.HDate;
	}

	public void setHDate(String HDate) {
		this.HDate = HDate;
	}

	@Column(name = "IS_PS")
	public String getIsPs() {
		return this.isPs;
	}

	public void setIsPs(String isPs) {
		this.isPs = isPs;
	}

	@Column(name = "IS_DS")
	public String getIsDs() {
		return this.isDs;
	}

	public void setIsDs(String isDs) {
		this.isDs = isDs;
	}

	@Column(name = "JG", length = 2000)
	public String getJg() {
		return this.jg;
	}

	public void setJg(String jg) {
		this.jg = jg;
	}

}