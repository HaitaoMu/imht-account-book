package com.mht.service.vo;

public class BillDetailVO {
	private String billDetailId;

	private Double preMonthPrincipal;

	private Double currentMonthPrincipal;

	private Double currentMonthInput;

	private Double currentmonthincome;

	public String getBillDetailId() {
		return billDetailId;
	}

	public void setBillDetailId(String billDetailId) {
		this.billDetailId = billDetailId == null ? null : billDetailId.trim();
	}

	public Double getPreMonthPrincipal() {
		return preMonthPrincipal;
	}

	public void setPreMonthPrincipal(Double preMonthPrincipal) {
		this.preMonthPrincipal = preMonthPrincipal;
	}

	public Double getCurrentMonthPrincipal() {
		return currentMonthPrincipal;
	}

	public void setCurrentMonthPrincipal(Double currentMonthPrincipal) {
		this.currentMonthPrincipal = currentMonthPrincipal;
	}

	public Double getCurrentMonthInput() {
		return currentMonthInput;
	}

	public void setCurrentMonthInput(Double currentMonthInput) {
		this.currentMonthInput = currentMonthInput;
	}

	public Double getCurrentmonthincome() {
		return currentmonthincome;
	}

	public void setCurrentmonthincome(Double currentmonthincome) {
		this.currentmonthincome = currentmonthincome;
	}
}