// default package
package com.tsgl.entity;// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JhBook entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jhBook", schema = "dbo", catalog = "tsgl")
public class JhBook implements java.io.Serializable {

	// Fields

	private Integer inid;
	private Integer bookId;
	private Integer zlId;
	private Integer clid;
	private String clName;
	private String clNum;
	private String BName;
	private String BAu;
	private String BStatus;
	private Integer userId;
	private String HDate;
	private String JDate;
	private Integer adminId;

	// Constructors

	/** default constructor */
	public JhBook() {
	}

	/** minimal constructor */
	public JhBook(Integer inid, Integer bookId, Integer zlId, Integer clid) {
		this.inid = inid;
		this.bookId = bookId;
		this.zlId = zlId;
		this.clid = clid;
	}

	/** full constructor */
	public JhBook(Integer inid, Integer bookId, Integer zlId, Integer clid,
			String clName, String clNum, String BName, String BAu,
			String BStatus, Integer userId, String HDate, String JDate,
			Integer adminId) {
		this.inid = inid;
		this.bookId = bookId;
		this.zlId = zlId;
		this.clid = clid;
		this.clName = clName;
		this.clNum = clNum;
		this.BName = BName;
		this.BAu = BAu;
		this.BStatus = BStatus;
		this.userId = userId;
		this.HDate = HDate;
		this.JDate = JDate;
		this.adminId = adminId;
	}

	// Property accessors
	@Id
	@Column(name = "INID", nullable = false)
	public Integer getInid() {
		return this.inid;
	}

	public void setInid(Integer inid) {
		this.inid = inid;
	}

	@Column(name = "BookID", nullable = false)
	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	@Column(name = "ZL_ID", nullable = false)
	public Integer getZlId() {
		return this.zlId;
	}

	public void setZlId(Integer zlId) {
		this.zlId = zlId;
	}

	@Column(name = "CLID", nullable = false)
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

	@Column(name = "UserID")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "H_Date")
	public String getHDate() {
		return this.HDate;
	}

	public void setHDate(String HDate) {
		this.HDate = HDate;
	}

	@Column(name = "J_Date")
	public String getJDate() {
		return this.JDate;
	}

	public void setJDate(String JDate) {
		this.JDate = JDate;
	}

	@Column(name = "AdminID")
	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

}