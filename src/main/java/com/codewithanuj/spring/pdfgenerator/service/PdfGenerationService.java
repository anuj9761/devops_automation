package com.codewithanuj.spring.pdfgenerator.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class PdfGenerationService {

	private Logger logger = LoggerFactory.getLogger(PdfGenerationService.class);

	public ByteArrayInputStream createPdf() {

		logger.info("Create PDF Started : ");

		String title = "Welcome To The World Of SpringBoot";
		String content = "SpringBoot is the most Fastest Backend Development Framework";

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		Document document = new Document();
		PdfWriter.getInstance(document, out);
		
		HeaderFooter header = new HeaderFooter(new Phrase("This is a header."), false);
		 HeaderFooter footer = new HeaderFooter(new Phrase("This is page "), new Phrase("."));
		 document.setHeader(header);
		 document.setFooter(footer);

		document.open();

		Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 25);
		Paragraph titlePara = new Paragraph(title, titleFont);
		titlePara.setAlignment(Element.ALIGN_CENTER);
		document.add(titlePara);

		Font paraFont = FontFactory.getFont(FontFactory.HELVETICA, 18);

		Paragraph paragraph = new Paragraph(content);
		paragraph.add(new Chunk("Wow this font is added after creating paragraph "));
		document.add(paragraph);

		document.close();

		return new ByteArrayInputStream(out.toByteArray());
	}
}
