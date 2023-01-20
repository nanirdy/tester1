package com.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;



@Entity
@Table(name="chats")
public class chats 
{
 
	
	@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
		@Column(name="messageid")
		private Integer messageid;
 @Column(name="message")
 private String message;
 @Column(name="senderid")
 private Integer senderid;
 @Column(name="receiverid")
 private Integer receiverid;
 private String mesid;
public String getMesid() {
	return mesid;
}
public void setMesid(String mesid) {
	this.mesid = mesid;
}
public Integer getMessageid() {
	return messageid;
}
public void setMessageid(Integer messageid) {
	this.messageid = messageid;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Integer getSenderid() {
	return senderid;
}
public void setSenderid(Integer senderid) {
	this.senderid = senderid;
}
public Integer getReceiverid() {
	return receiverid;
}
public void setReceiverid(Integer receiverid) {
	this.receiverid = receiverid;
}
@Override
public String toString() {
	return "chats [messageid=" + messageid + ", message=" + message + ", senderid=" + senderid + ", receiverid="
			+ receiverid + "]";
}
public int Message() {
	// TODO Auto-generated method stub
	return 0;
}



	 	
 
}
