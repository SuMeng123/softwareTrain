// default package
package com.tsgl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Book entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Book", schema = "dbo", catalog = "tsgl")
public class Book implements java.io.Serializable {

	// Fields

	private Integer bookId;
	private String BName;
	private String BAu;
	private String BStatus;
	private Integer adminId;
	private String isNew;
	private String BNum;
	private Integer BSl;

	// Constructors

	/** default constructor */
	public Book() {
	}

	/** minimal constructor */
	public Book(Integer bookId) {
		this.bookId = bookId;
	}

	/** full constructor */
	public Book(Integer bookId, String BName, String BAu, String BStatus,
			Integer adminId, String isNew, String BNum, Integer BSl) {
		this.bookId = bookId;
		this.BName = BName;
		this.BAu = BAu;
		this.BStatus = BStatus;
		this.adminId = adminId;
		this.isNew = isNew;
		this.BNum = BNum;
		this.BSl = BSl;
	}

	// Property accessors
	@Id
	@Column(name = "BookID", unique = true, nullable = false)
	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	@Column(name = "B_Name")
	public String getBName() {
		return this.BName;
	}

	public void setBName(String BName) {
		this.BName = BName;
	}

	@Column(name = "B_Au")
	public String getBAu() {
		return this.BAu;
	}

	public void setBAu(String BAu) {
		this.BAu = BAu;
	}

	@Column(name = "B_Status")
	public String getBStatus() {
		return this.BStatus;
	}

	public void setBStatus(String BStatus) {
		this.BStatus = BStatus;
	}

	@Column(name = "AdminID")
	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	@Column(name = "IS_New")
	public String getIsNew() {
		return this.isNew;
	}

	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}

	@Column(name = "B_Num")
	public String getBNum() {
		return this.BNum;
	}

	public void setBNum(String BNum) {
		this.BNum = BNum;
	}

	@Column(name = "B_SL")
	public Integer getBSl() {
		return this.BSl;
	}

	public void setBSl(Integer BSl) {
		this.BSl = BSl;
	}

}