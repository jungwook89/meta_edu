/*

 * 작성일 : 2019. 2. 20.

 * 작성자 : meta

 *

 * 설명   : 로그 데이터를 담을 데이터 객체

 */


package logFileAnalysis;

public class LogData {
	private String loggingTime;
	private String state;
	private String targetObject;
	private String detail;
	
	public String getLoggingTime() {
		return loggingTime;
	}
	public void setLoggingTime(String loggingTime) {
		this.loggingTime = loggingTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTargetObject() {
		return targetObject;
	}
	public void setTargetObject(String targetObject) {
		this.targetObject = targetObject;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}

}


