// default package

package com.tsgl.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Zl entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ZL", schema = "dbo", catalog = "tsgl")
public class Zl implements java.io.Serializable {

	// Fields

	private Integer zlId;
	private Integer bookId;
	private Integer clid;

	// Constructors

	/** default constructor */
	public Zl() {
	}

	/** minimal constructor */
	public Zl(Integer zlId) {
		this.zlId = zlId;
	}

	/** full constructor */
	public Zl(Integer zlId, Integer bookId, Integer clid) {
		this.zlId = zlId;
		this.bookId = bookId;
		this.clid = clid;
	}

	// Property accessors
	@Id
	@Column(name = "ZL_ID", unique = true, nullable = false)
	public Integer getZlId() {
		return this.zlId;
	}

	public void setZlId(Integer zlId) {
		this.zlId = zlId;
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

}