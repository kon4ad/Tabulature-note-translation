package com.k8nrd.services;

public interface TabTransformer {
	public String changeFretsNumbersToNoteNames(String tabToChange); 
	public String tansformOnlyOneLineFromNumbersToNotes(String line);
	public String tansformOnlyOneLineFromNumbersToNotesAndNumbers(String line);
}
