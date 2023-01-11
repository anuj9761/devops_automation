package com.codewithanuj.spring.pdfgenerator.controller;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithanuj.spring.pdfgenerator.service.PdfGenerationService;

@RestController
@RequestMapping("/pdf")
public class PdfGenerationController {
	
	@Autowired
	private PdfGenerationService pdfGenerationService;
	
	@GetMapping("/createPdf")
	public ResponseEntity<InputStreamResource> createPdf() {
		
		ByteArrayInputStream pdf = pdfGenerationService.createPdf();
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("Content-Disposition","inline;file=anuj.pdf");
		return ResponseEntity
				.ok()
				.headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(pdf));
	}
}
