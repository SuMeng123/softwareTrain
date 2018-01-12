// default package
package com.tsgl.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tuijian entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tuijian", schema = "dbo", catalog = "tsgl")
public class Tuijian implements java.io.Serializable {

	// Fields

	private String clNum;
	private String clName;
	private String BName;
	private Integer bookId;
	private Integer clid;
	private String BAu;
	private String BStatus;
	private Integer adminId;
	private String isNew;
	private String BNum;
	private Integer BSl;

	// Constructors

	/** default constructor */
	public Tuijian() {
	}

	/** minimal constructor */
	public Tuijian(String clNum) {
		this.clNum = clNum;
	}

	/** full constructor */
	public Tuijian(String clNum, String clName, String BName, Integer bookId,
			Integer clid, String BAu, String BStatus, Integer adminId,
			String isNew, String BNum, Integer BSl) {
		this.clNum = clNum;
		this.clName = clName;
		this.BName = BName;
		this.bookId = bookId;
		this.clid = clid;
		this.BAu = BAu;
		this.BStatus = BStatus;
		this.adminId = adminId;
		this.isNew = isNew;
		this.BNum = BNum;
		this.BSl = BSl;
	}

	// Property accessors
	@Id
	@Column(name = "CL_Num")
	public String getClNum() {
		return this.clNum;
	}

	public void setClNum(String clNum) {
		this.clNum = clNum;
	}

	@Column(name = "CL_Name")
	public String getClName() {
		return this.clName;
	}

	public void setClName(String clName) {
		this.clName = clName;
	}

	@Column(name = "B_Name")
	public String getBName() {
		return this.BName;
	}

	public void setBName(String BName) {
		this.BName = BName;
	}

	@Column(name = "BookID")
	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	@Column(name = "CLID")
	public Integer getClid() {
		return this.clid;
	}

	public void setClid(Integer clid) {
		this.clid = clid;
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