package com.k8nrd.entities;

import java.sql.Timestamp;



//@Entity
//@Table
public class Tab {
	//@Id
	//@Column
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	//@Column(columnDefinition="MEDIUMBLOB")
	private String inputTab;
	//@Transient
	private String transformedTab;
	//@Column
	private long timeStamp;

	public Tab() {
		this.timeStamp = System.currentTimeMillis();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInputTab() {
		return inputTab;
	}

	public void setInputTab(String inputTab) {
		this.inputTab = inputTab;
	}

	public String getTransformedTab() {
		return transformedTab;
	}

	public void setTransformedTab(String transformedTab) {
		this.transformedTab = transformedTab;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inputTab == null) ? 0 : inputTab.hashCode());
		result = prime * result + (int) (timeStamp ^ (timeStamp >>> 32));
		result = prime * result + ((transformedTab == null) ? 0 : transformedTab.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tab other = (Tab) obj;
		if (inputTab == null) {
			if (other.inputTab != null)
				return false;
		} else if (!inputTab.equals(other.inputTab))
			return false;
		if (timeStamp != other.timeStamp)
			return false;
		if (transformedTab == null) {
			if (other.transformedTab != null)
				return false;
		} else if (!transformedTab.equals(other.transformedTab))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tab [inputTab=" + inputTab + ", transformedTab=" + transformedTab + ", timeStamp=" + timeStamp + "]";
	}

}
