package com.mht.service.vo;

import java.util.Date;

public class BillVO {

	private String billId;

	private String billName;

	private String billDesc;

	private Date createTime;

	private Date updateTime;

	private Date deleteTime;

	private String createUser;

	private String updateUser;

	private String deleteUser;

	private String billDetailId;

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId == null ? null : billId.trim();
	}

	public String getBillName() {
		return billName;
	}

	public void setBillName(String billName) {
		this.billName = billName == null ? null : billName.trim();
	}

	public String getBillDesc() {
		return billDesc;
	}

	public void setBillDesc(String billDesc) {
		this.billDesc = billDesc == null ? null : billDesc.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser == null ? null : updateUser.trim();
	}

	public String getDeleteUser() {
		return deleteUser;
	}

	public void setDeleteUser(String deleteUser) {
		this.deleteUser = deleteUser == null ? null : deleteUser.trim();
	}

	public String getBillDetailId() {
		return billDetailId;
	}

	public void setBillDetailId(String billDetailId) {
		this.billDetailId = billDetailId == null ? null : billDetailId.trim();
	}
}