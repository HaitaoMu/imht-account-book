package com.mht.service.vo;

public class BillDetailVO {

	private String billDetailId;
	
	private Integer currentYear;
	
	private Integer currentMonth;

	private Double preMonthPrincipal;

	private Double currentMonthPrincipal;

	private Double currentMonthInput;

	private Double currentMonthIncome;
	
	private String billId;
	
	/**
	 * @return the billId
	 */
	public String getBillId() {
		return billId;
	}

	/**
	 * @param billId the billId to set
	 */
	public void setBillId(String billId) {
		this.billId = billId;
	}

	/**
	 * @return the currentYear
	 */
	public Integer getCurrentYear() {
		return currentYear;
	}

	/**
	 * @param currentYear the currentYear to set
	 */
	public void setCurrentYear(Integer currentYear) {
		this.currentYear = currentYear;
	}

	/**
	 * @return the currentMonth
	 */
	public Integer getCurrentMonth() {
		return currentMonth;
	}

	/**
	 * @param currentMonth the currentMonth to set
	 */
	public void setCurrentMonth(Integer currentMonth) {
		this.currentMonth = currentMonth;
	}

	/**
	 * @return the currentMonthIncome
	 */
	public Double getCurrentMonthIncome() {
		return currentMonthIncome;
	}

	/**
	 * @param currentMonthIncome the currentMonthIncome to set
	 */
	public void setCurrentMonthIncome(Double currentMonthIncome) {
		this.currentMonthIncome = currentMonthIncome;
	}

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

}