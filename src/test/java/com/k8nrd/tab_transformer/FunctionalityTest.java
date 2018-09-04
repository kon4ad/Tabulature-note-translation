package com.k8nrd.tab_transformer;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.k8nrd.services.TabTransformer;
import com.k8nrd.services.TabTransformerImpl;



public class FunctionalityTest {
	
	private TabTransformer tabTransformer;
	
	@Before
	public void prepareMethod(){
		tabTransformer = new TabTransformerImpl();
	}

	@Test
	public void shouldReturnCorrectTransformedLine() {
		String line = 		"E|----3----4-2----5------12--4-1-3----4--";
		String toReturn = 	"E|----G----G#F#---A------E---G#F-G----G#-";
		//System.out.println(tabTransformer.tansformOnlyOneLineFromNumbersToNotes(line));
		assertEquals(toReturn, tabTransformer.tansformOnlyOneLineFromNumbersToNotes(line));
	}
	
	@Test
	public void shouldReturnCorrectTransformedFirstBeat(){
		String build = 	"E|------12----------12-----------12----------12-----------2-----------14--------|\n" +
                		"B|----13---13----13----13-----12----12----12----12-----15----15----15----15-----|\n" +
                		"G|-14---------14-----------12----------12-----------12----------12--------------|\n" +
                		"D|------------------------------------------------------------------------------|\n" +
                		"A|------------------------------------------------------------------------------|\n" +
                		"E|------------------------------------------------------------------------------|\n";
		
		String input = 	"E|------E-----------E------------E-----------E------------F#----------F#--------|\n" +
        				"B|----C----C-----C-----C------B-----B-----B-----B------D-----D-----D-----D------|\n" +
        				"G|-A----------A------------G-----------G------------G-----------G---------------|\n" +
        				"D|------------------------------------------------------------------------------|\n" +
        				"A|------------------------------------------------------------------------------|\n" +
        				"E|------------------------------------------------------------------------------|\n";
		assertEquals(input,tabTransformer.changeFretsNumbersToNoteNames(build));
		
	}
	
	@Test
	public void shouldReturnCorrectLineWithNumbersAndNotes(){
		 String input = 	"E|------5--------------2----|\n" +
		            		"B|--------------------------|\n" +
		            		"G|--12----------12----------|\n" +
		            		"D|------14--14------14--14--|\n" +
		            		"A|--------------------------|\n" +
		            		"E|--------------14----------|";
		 
		String input2 = "E|------5-------14----12---2----|\n";
		String outpt2 = "E|------A(5)-------F#(14)----E(12)---F#(2)----|\n";
	}

}
