package com.belajar.restapi.manager;

import org.springframework.http.HttpStatus;

import com.belajar.restapi.output.ErrorDetail;

public class ManagerImpl {
	private ErrorDetail info;
	private int totalRow;
	
	public ErrorDetail getInfo() {
		return info;
	}
	public void setInfo(ErrorDetail info) {
		this.info = info;
	}
	public int getTotalRow() {
		return totalRow;
	}
	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}
	public void setBadRequest(String msg) {
		ErrorDetail info = new ErrorDetail();
		info.setMessage("BAD REQUEST");
		info.setDetailmessage(msg);
		info.setStatus(HttpStatus.BAD_REQUEST.value());
		info.setDetailInfo(HttpStatus.BAD_REQUEST);
		this.setInfo(info);
	}
	
	public void setNoContent() {
		ErrorDetail info = new ErrorDetail();
		info.setStatus(HttpStatus.NO_CONTENT.value());
		info.setDetailInfo(HttpStatus.NO_CONTENT);
		this.setInfo(info);
	}
	
	public void setInternalError() {
		ErrorDetail info = new ErrorDetail();
		info.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		info.setDetailInfo(HttpStatus.INTERNAL_SERVER_ERROR);
		this.setInfo(info);
	}
	
	public void setOK(String msg) {
		ErrorDetail info = new ErrorDetail();
		info.setStatus(HttpStatus.OK.value());
		info.setMessage(msg);
		info.setDetailmessage(msg);
		info.setDetailInfo(HttpStatus.OK);
		this.setInfo(info);
	}
	
	public void setCreated(String msg) {
		ErrorDetail info = new ErrorDetail();
		info.setStatus(HttpStatus.CREATED.value());
		info.setMessage(HttpStatus.CREATED.name());
		info.setDetailInfo(HttpStatus.CREATED);
		info.setDetailmessage(msg);
		this.setInfo(info);
	}
	
	public void setConflict(String msg) {
		ErrorDetail info = new ErrorDetail();
		info.setStatus(HttpStatus.CONFLICT.value());
		info.setMessage(HttpStatus.CONFLICT.name());
		info.setDetailInfo(HttpStatus.CONFLICT);
		
		if(msg != null) {
			info.setDetailmessage(msg);
		}
		
		this.setInfo(info);
	}
	
	public void setNotFound(String msg) {
		ErrorDetail info = new ErrorDetail();
		info.setStatus(HttpStatus.NO_CONTENT.value());
		info.setMessage("NOT FOUND");
		info.setDetailmessage(msg);
		info.setDetailInfo(null);
		this.setInfo(info);
	}
	
	public void setExist(String detailMsg, String msg) {
		ErrorDetail info = new ErrorDetail();
		info.setStatus(HttpStatus.NO_CONTENT.value());
		info.setMessage(msg);
		info.setDetailmessage(detailMsg);
		info.setDetailInfo(null);
		this.setInfo(info);
	}
	
	public boolean setResponseSp(String respon) {
		String status = respon.substring(0,respon.lastIndexOf("||"));
		String msg = respon.substring(respon.lastIndexOf("||")+2);
		
		if(status.equals("01")) {
			setCreated(msg);
			return true;
		}
		
		if(status.equals("00")) {
			setOK(msg);
			return true;
		}
		else if(status.equals("01")) {
			setCreated(msg);
			return true;
		}
		else if(status.equals("10")) {
			setConflict(msg);
			return true;
		}
		else if(status.equals("11")) {
			setConflict(msg);
			return false;
		}
		
		return false;
	}
}
