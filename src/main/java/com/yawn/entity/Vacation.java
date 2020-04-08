package com.yawn.entity;

import java.util.Date;

/**
 * @author Created by yawn on 2018-01-08 16:44
 */
public class Vacation {

	/**
	 * 申请人
	 */
	private String applyUser;// 申请人
	private int days;// 申请的假期时间
	private String reason;// 申请的原因
	private Date applyTime;// 申请的时间
	private String applyStatus;// 申请状态 正在申请或者申请结束

	/**
	 * 审核人
	 */
	private String auditor;// 审核人
	private String result;// 审核结果 审核拒绝或者审核通过
	private Date auditTime;// 审核的时间
	private String auditorremark;// 评论

	public String getAuditorremark() {
		return auditorremark;
	}

	public void setAuditorremark(String auditorremark) {
		this.auditorremark = auditorremark;
	}

	public String getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}

	public String getApplyUser() {
		return applyUser;
	}

	public void setApplyUser(String applyUser) {
		this.applyUser = applyUser;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
}
