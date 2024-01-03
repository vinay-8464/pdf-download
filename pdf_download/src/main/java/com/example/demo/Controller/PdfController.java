package com.example.demo.Controller;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.PdfService;


@RestController
public class PdfController {
	
	@Autowired
	private PdfService pdfService;
	
	@GetMapping("/createPdf")
	public ResponseEntity<InputStreamResource> createPdf() {
		
		ByteArrayInputStream pdf= pdfService.createPdf();
		
		HttpHeaders httpHeaders= new HttpHeaders();
		httpHeaders.add("Content-Disposition", "inline;file=lcwd.pdf");
		return ResponseEntity
					.ok()
					.headers(httpHeaders)
					.contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(pdf));
	}
}
