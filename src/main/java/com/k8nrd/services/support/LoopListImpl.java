package com.k8nrd.services.support;

public class LoopListImpl<Elem> implements LoopList<Elem> {
	
	private Element<Elem> current;
	private Element<Elem> first;
	private int size;
	
	public boolean setUpCurrentElement(Elem currentElement) {
			int counter = 0;
			while(!current.getValue().equals(currentElement) && counter <= size+1 ){
				this.nextElement();
				counter++;
			}
			if(counter > size){
				return false;
			}else{
				return true;
			}
		
	}
	
	public void loooper(){
		while(first != null){
			System.out.println(first.getValue());
			first = first.getNext();
		}
	}

	public Elem getCurrentElement() {
		if(current != null){
		return current.getValue();
		}else
		{
			return first.getValue();
		}
	}


	public void nextElement() {
			if(current.getNext() == null){
				current = first;
			}else
			{
				current = current.getNext();
			}
		
	}

	public void addElement(Elem elemToAdd) {
		if(first == null){
			first = new Element<>();
			first.setValue(elemToAdd);
		}else
		{
			if(current == null){
				current = new Element<>();
				current.setValue(elemToAdd);
				first.setNext(current);
			}else
			{
				Element<Elem> before = null;
				while(current != null){
					before = current;
					current = current.getNext();
				}
				current = new Element<Elem>();
				current.setValue(elemToAdd);
				before.setNext(current);
			}
		}
		
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void setSize(int size) {
		this.size = size;
	}

}
