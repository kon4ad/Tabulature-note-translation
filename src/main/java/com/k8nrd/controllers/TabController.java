package com.k8nrd.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.k8nrd.entities.Tab;
import com.k8nrd.services.TabTransformer;

@RestController
public class TabController {

	private TabTransformer tabTransformer;
	
	@Autowired
	public TabController(TabTransformer tabTransformer){
		this.tabTransformer = tabTransformer;
	}
	
	
	
	@PostMapping("/api/transform")
	public ResponseEntity<Tab> transformTab(String inputTab, HttpServletRequest request){
		System.out.println(request.getRemoteAddr());
		Tab tab1 = new Tab();
		tab1.setInputTab(inputTab);
		tab1.setTransformedTab(tabTransformer.changeFretsNumbersToNoteNames(inputTab));
		return new ResponseEntity<Tab>(tab1, HttpStatus.OK);
	}
	
}
