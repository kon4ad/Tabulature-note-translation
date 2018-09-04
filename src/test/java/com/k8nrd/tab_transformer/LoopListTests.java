package com.k8nrd.tab_transformer;

import static org.junit.Assert.*;

import org.junit.Test;

import com.k8nrd.services.support.LoopList;
import com.k8nrd.services.support.LoopListImpl;


public class LoopListTests {

	@Test
	public void test() {
		LoopList<Integer> loopL = new LoopListImpl<>();
		loopL.addElement(1);
		loopL.addElement(2);
		loopL.addElement(3);
		loopL.setUpCurrentElement(1);
		assertEquals(Integer.valueOf(1), loopL.getCurrentElement());
		loopL.nextElement();
		assertEquals(Integer.valueOf(2), loopL.getCurrentElement());
		loopL.nextElement();
		assertEquals(Integer.valueOf(3), loopL.getCurrentElement());
		loopL.nextElement();
		assertEquals(Integer.valueOf(1), loopL.getCurrentElement());
	}

}
