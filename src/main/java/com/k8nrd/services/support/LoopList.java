package com.k8nrd.services.support;

public interface LoopList<Elem> {
	boolean setUpCurrentElement(Elem currentElement);
	Elem getCurrentElement();
	void nextElement();
	void addElement(Elem elemToAdd);
	int size();
	void setSize(int size);
}
