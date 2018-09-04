package com.k8nrd.services.support;

public class Element<Elem> {
	
	private Element next;
	private Elem value;
	private boolean isLast;
	
	
	public Element getNext() {
		return next;
	}
	public void setNext(Element next) {
		this.next = next;
	}
	public Elem getValue() {
		return value;
	}
	public void setValue(Elem value) {
		this.value = value;
	}
	public boolean isLast() {
		return isLast;
	}
	public void setLast(boolean isLast) {
		this.isLast = isLast;
	}
	
	
	
}
