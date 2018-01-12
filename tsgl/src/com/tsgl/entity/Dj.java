// default package

package com.tsgl.entity;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Dj entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "DJ", schema = "dbo", catalog = "tsgl")
public class Dj implements java.io.Serializable {

	// Fields

	private Integer djid;
	private String djStatus;
	private String djName;
	private String djAu;
	private Integer userId;
	private Integer bookId;

	// Constructors

	/** default constructor */
	public Dj() {
	}

	/** minimal constructor */
	public Dj(Integer djid) {
		this.djid = djid;
	}

	/** full constructor */
	public Dj(Integer djid, String djStatus, String djName, String djAu,
			Integer userId,Integer bookId) {
		this.djid = djid;
		this.djStatus = djStatus;
		this.djName = djName;
		this.djAu = djAu;
		this.userId = userId;
		this.bookId = bookId;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "DJID", unique = true, nullable = false)
	public Integer getDjid() {
		return this.djid;
	}

	public void setDjid(Integer djid) {
		this.djid = djid;
	}

	@Column(name = "DJ_Status")
	public String getDjStatus() {
		return this.djStatus;
	}

	public void setDjStatus(String djStatus) {
		this.djStatus = djStatus;
	}

	@Column(name = "DJ_Name")
	public String getDjName() {
		return this.djName;
	}

	public void setDjName(String djName) {
		this.djName = djName;
	}

	@Column(name = "DJ_AU")
	public String getDjAu() {
		return this.djAu;
	}

	public void setDjAu(String djAu) {
		this.djAu = djAu;
	}

	@Column(name = "UserID")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Column(name = "BookID")
	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

}