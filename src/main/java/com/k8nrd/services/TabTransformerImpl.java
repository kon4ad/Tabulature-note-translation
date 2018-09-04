package com.k8nrd.services;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.k8nrd.services.support.LoopList;
import com.k8nrd.services.support.LoopListImpl;

@Service
public class TabTransformerImpl implements TabTransformer {
	public static final int fretsNUmber = 24;
	public static final String exception1 = "Ups! This is too short! Sorry.";
	public static final String exception2 = "Ups! This note do not exist!";
	public static final String emptyLine = "";
	private LoopList<String> loopedNote;

	public TabTransformerImpl() {
		setupList();
	}

	private void setupList() {

		loopedNote = new LoopListImpl<>();

		loopedNote.addElement("G#");
		loopedNote.addElement("G");
		loopedNote.addElement("F#");
		loopedNote.addElement("F");
		loopedNote.addElement("E");
		loopedNote.addElement("D#");
		loopedNote.addElement("D");
		loopedNote.addElement("C#");
		loopedNote.addElement("C");
		loopedNote.addElement("B");
		loopedNote.addElement("A#");
		loopedNote.addElement("A");
		loopedNote.setSize(12);

	}

	public String changeFretsNumbersToNoteNames(String tabToChange) {
		String output = "";
		Scanner scanLines = new Scanner(tabToChange);
		int blocker = 0;
		while (scanLines.hasNextLine() && blocker < 9999) {
			String nl = scanLines.nextLine();
			output += tansformOnlyOneLineFromNumbersToNotes(nl) + "\n";
			blocker++;
		}
		return output;
	}

	@Override
	public String tansformOnlyOneLineFromNumbersToNotes(String line) {
		setupList();
		//System.out.println(line);
		String toTransform = StringUtils.trimAllWhitespace(line);
		//System.out.println(toTransform);
		if(toTransform.length()==0){
			return emptyLine;
		}
		if (toTransform.length() < 2) {
			return exception1;
		}
		String stringName = (toTransform.substring(0, 1)).toUpperCase();
		String getSharp = toTransform.substring(1, 2); 
		boolean checker = true;
		if(stringName.equals("H")){
			stringName = "B";
		}
		if (getSharp.equals("#")) {
			checker = loopedNote.setUpCurrentElement(stringName + getSharp);
		} else {
			checker = loopedNote.setUpCurrentElement(stringName);
		}
		if (!checker) {
			return exception2;
		}

		for (int x = TabTransformerImpl.fretsNUmber; x >= 0; x--) {
			String currElem = loopedNote.getCurrentElement();
			if (currElem.equals("A") || currElem.equals("B") || currElem.equals("C") || currElem.equals("D")
					|| currElem.equals("E") || currElem.equals("F") || currElem.equals("G")) {
				if (x >= 10) {
					toTransform = toTransform.replace(String.valueOf(x), currElem + "-");
				} else {
					toTransform = toTransform.replace(String.valueOf(x), currElem);
				}
			} else {
				if (x >= 10) {
					toTransform = toTransform.replace(String.valueOf(x), currElem);
				} else {
					toTransform = toTransform.replace("-" + String.valueOf(x) + "~", currElem + "~");
					toTransform = toTransform.replace("-" + String.valueOf(x) + "^", currElem + "^");
					toTransform = toTransform.replace(String.valueOf(x) + "-", currElem);
				}
			}
			loopedNote.nextElement();
		}
		return toTransform;
	}

	@Override
	public String tansformOnlyOneLineFromNumbersToNotesAndNumbers(String line) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * //do dokonczenia public String
	 * tansformOnlyOneLineFromNumbersToNotesAndNumbers(String line) { String
	 * toTransform = line; loopedNote.setUpCurrentElement(line.substring(0, 1));
	 * for(int x=24; x>TabTransformerImpl.fretsNUmber; x--){ String currElem =
	 * loopedNote.getCurrentElement(); System.out.println(currElem);
	 * if(currElem.equals("A") || currElem.equals("B") || currElem.equals("C")
	 * || currElem.equals("D") || currElem.equals("E") || currElem.equals("F")
	 * || currElem.equals("G")){ if(x > 10){ toTransform =
	 * toTransform.replace(String.valueOf(x), currElem+"("+x+")-"); }else {
	 * toTransform =
	 * toTransform.replace(String.valueOf(x),currElem+"("+x+")--"); } }else {
	 * if(x > 10){ toTransform = toTransform.replace(String.valueOf(x),
	 * currElem+"("+x+")"); }else { toTransform =
	 * toTransform.replace(String.valueOf(x)+"-", currElem+"("+x+")-"); } }
	 * loopedNote.nextElement(); } return toTransform; }
	 */

	/*
	 * String currElem = loopedNote.getCurrentElement(); if(currElem.equals("A")
	 * || currElem.equals("B") || currElem.equals("C") || currElem.equals("D")
	 * || currElem.equals("E") || currElem.equals("F") || currElem.equals("G")){
	 * if(x > 10){ //toTransform = toTransform.replace(new
	 * StringBuffer("|-"+String.valueOf(x)+"-"), new
	 * StringBuffer("|-"+loopedNote.getCurrentElement()+"-")); toTransform =
	 * toTransform.replace(new StringBuffer("-"+String.valueOf(x)+"-"), new
	 * StringBuffer("-"+loopedNote.getCurrentElement()+"--")); }else{
	 * toTransform = toTransform.replace(new
	 * StringBuffer("-"+String.valueOf(x)+"-"), new
	 * StringBuffer("-"+loopedNote.getCurrentElement()+"-")); } } else { if(x >
	 * 10){ toTransform = toTransform.replace(new
	 * StringBuffer("-"+String.valueOf(x)+"-"), new
	 * StringBuffer("-"+loopedNote.getCurrentElement()+"-")); }else{
	 * 
	 * 
	 * }
	 * 
	 * 
	 * }
	 */

}
