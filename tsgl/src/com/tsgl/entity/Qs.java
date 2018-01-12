// default package
package com.tsgl.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Qs entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "QS", schema = "dbo", catalog = "tsgl")
public class Qs implements java.io.Serializable {

	// Fields

	private Integer qsId;
	private String status;
	private String name;
	private String au;
	private Integer sl;
	private Integer bookId;

	// Constructors

	/** default constructor */
	public Qs() {
	}

	/** minimal constructor */
	public Qs(Integer qsId) {
		this.qsId = qsId;
	}

	/** full constructor */
	public Qs(Integer qsId, String status, String name, String au, Integer sl,
			Integer bookId) {
		this.qsId = qsId;
		this.status = status;
		this.name = name;
		this.au = au;
		this.sl = sl;
		this.bookId = bookId;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "QS_ID", unique = true, nullable = false)
	public Integer getQsId() {
		return this.qsId;
	}

	public void setQsId(Integer qsId) {
		this.qsId = qsId;
	}

	@Column(name = "Status", length = 255)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "Name", length = 255)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Au", length = 255)
	public String getAu() {
		return this.au;
	}

	public void setAu(String au) {
		this.au = au;
	}

	@Column(name = "SL")
	public Integer getSl() {
		return this.sl;
	}

	public void setSl(Integer sl) {
		this.sl = sl;
	}

	@Column(name = "BookID")
	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

}