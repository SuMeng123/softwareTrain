// default package
package com.tsgl.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Hs entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "hs", schema = "dbo", catalog = "tsgl")
public class Hs implements java.io.Serializable {

	// Fields

	private Integer bookId;
	private Integer userId;
	private String JDate;
	private String HDate;
	private String BName;
	private String BAu;
	private String BStatus;
	private String isNew;
	private String UName;
	private String UEmail;
	private String USnum;
	private String jg;
	private String BNum;

	// Constructors

	/** default constructor */
	public Hs() {
	}

	/** minimal constructor */
	public Hs(Integer bookId) {
		this.bookId = bookId;
	}

	/** full constructor */
	public Hs(Integer bookId, Integer userId, String JDate, String HDate,
			String BName, String BAu, String BStatus, String isNew,
			String UName, String UEmail, String USnum, String jg, String BNum) {
		this.bookId = bookId;
		this.userId = userId;
		this.JDate = JDate;
		this.HDate = HDate;
		this.BName = BName;
		this.BAu = BAu;
		this.BStatus = BStatus;
		this.isNew = isNew;
		this.UName = UName;
		this.UEmail = UEmail;
		this.USnum = USnum;
		this.jg = jg;
		this.BNum = BNum;
	}

	// Property accessors
	@Id
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

	@Column(name = "IS_New")
	public String getIsNew() {
		return this.isNew;
	}

	public void setIsNew(String isNew) {
		this.isNew = isNew;
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

	@Column(name = "U_Snum")
	public String getUSnum() {
		return this.USnum;
	}

	public void setUSnum(String USnum) {
		this.USnum = USnum;
	}

	@Column(name = "JG", length = 2000)
	public String getJg() {
		return this.jg;
	}

	public void setJg(String jg) {
		this.jg = jg;
	}

	@Column(name = "B_Num")
	public String getBNum() {
		return this.BNum;
	}

	public void setBNum(String BNum) {
		this.BNum = BNum;
	}

}