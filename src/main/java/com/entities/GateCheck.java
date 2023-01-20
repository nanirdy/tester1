package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gatecheck")
public class GateCheck {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
    private String discussionPoint;
    private String commentsOfIMPOF;
    private String scope;
    private String status;
    private String uniqueId;
    private String savingDate;
    private String dateTime;
    private String raisedBy;
    private String raisedMobileno;
    private String raisedDateTime;
    private String reviewBy;
    private String reviewDateTime;
    private String reviewStatus;
    private String approvedBy;
    private String approvedDateTime;
    private String approvedStatus;
    private String momStatus;
    private String remarks;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDiscussionPoint() {
		return discussionPoint;
	}
	public void setDiscussionPoint(String discussionPoint) {
		this.discussionPoint = discussionPoint;
	}
	public String getCommentsOfIMPOF() {
		return commentsOfIMPOF;
	}
	public void setCommentsOfIMPOF(String commentsOfIMPOF) {
		this.commentsOfIMPOF = commentsOfIMPOF;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public String getSavingDate() {
		return savingDate;
	}
	public void setSavingDate(String savingDate) {
		this.savingDate = savingDate;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getRaisedBy() {
		return raisedBy;
	}
	public void setRaisedBy(String raisedBy) {
		this.raisedBy = raisedBy;
	}
	public String getRaisedMobileno() {
		return raisedMobileno;
	}
	public void setRaisedMobileno(String raisedMobileno) {
		this.raisedMobileno = raisedMobileno;
	}
	public String getRaisedDateTime() {
		return raisedDateTime;
	}
	public void setRaisedDateTime(String raisedDateTime) {
		this.raisedDateTime = raisedDateTime;
	}
	public String getReviewBy() {
		return reviewBy;
	}
	public void setReviewBy(String reviewBy) {
		this.reviewBy = reviewBy;
	}
	public String getReviewDateTime() {
		return reviewDateTime;
	}
	public void setReviewDateTime(String reviewDateTime) {
		this.reviewDateTime = reviewDateTime;
	}
	public String getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	public String getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}
	public String getApprovedDateTime() {
		return approvedDateTime;
	}
	public void setApprovedDateTime(String approvedDateTime) {
		this.approvedDateTime = approvedDateTime;
	}
	public String getApprovedStatus() {
		return approvedStatus;
	}
	public void setApprovedStatus(String approvedStatus) {
		this.approvedStatus = approvedStatus;
	}
	public String getMomStatus() {
		return momStatus;
	}
	public void setMomStatus(String momStatus) {
		this.momStatus = momStatus;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "GateCheck [id=" + id + ", discussionPoint=" + discussionPoint + ", commentsOfIMPOF=" + commentsOfIMPOF
				+ ", scope=" + scope + ", status=" + status + ", uniqueId=" + uniqueId + ", savingDate=" + savingDate
				+ ", dateTime=" + dateTime + ", raisedBy=" + raisedBy + ", raisedMobileno=" + raisedMobileno
				+ ", raisedDateTime=" + raisedDateTime + ", reviewBy=" + reviewBy + ", reviewDateTime=" + reviewDateTime
				+ ", reviewStatus=" + reviewStatus + ", approvedBy=" + approvedBy + ", approvedDateTime="
				+ approvedDateTime + ", approvedStatus=" + approvedStatus + ", momStatus=" + momStatus + ", remarks="
				+ remarks + "]";
	}
	public GateCheck() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
