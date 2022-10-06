package spring.model;

import java.util.Date;

/**
 * model 类
 * 
 * @author jangle
 * @email jangle@jangle.xyz
 * @time 2022年10月6日 下午2:12:35
 * 
 */
public class Account {
	
	private long id;
	private String ownerName;
	private double balance;
	private Date accessTime;
	private boolean locked;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getAccessTime() {
		return accessTime;
	}
	public void setAccessTime(Date accessTime) {
		this.accessTime = accessTime;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}	
	
	
	

}
