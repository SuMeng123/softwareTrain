// default package
package com.tsgl.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UpBook entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "upBook", schema = "dbo", catalog = "tsgl")
public class UpBook implements java.io.Serializable {

	// Fields

	private Integer bookId;
	private String BName;
	private String BAu;
	private String BStatus;
	private Integer adminId;
	private String isNew;
	private String BNum;
	private Integer zlId;
	private Integer clid;
	private String clName;
	private String clNum;

	// Constructors

	/** default constructor */
	public UpBook() {
	}

	/** minimal constructor */
	public UpBook(Integer bookId, Integer zlId, Integer clid) {
		this.bookId = bookId;
		this.zlId = zlId;
		this.clid = clid;
	}

	/** full constructor */
	public UpBook(Integer bookId, String BName, String BAu, String BStatus,
			Integer adminId, String isNew, String BNum, Integer zlId,
			Integer clid, String clName, String clNum) {
		this.bookId = bookId;
		this.BName = BName;
		this.BAu = BAu;
		this.BStatus = BStatus;
		this.adminId = adminId;
		this.isNew = isNew;
		this.BNum = BNum;
		this.zlId = zlId;
		this.clid = clid;
		this.clName = clName;
		this.clNum = clNum;
	}

	// Property accessors
	@Id
	@Column(name = "BookID", nullable = false)
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

}