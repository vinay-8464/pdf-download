package com.example.demo.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import ch.qos.logback.classic.Logger;

@Service
public class PdfService {
	
	private Logger logger= (Logger) LoggerFactory.getLogger(PdfService.class); 
	
	public ByteArrayInputStream createPdf() {
		logger.info("Create PDF Standard: ");
		
		ByteArrayOutputStream out= new ByteArrayOutputStream();
		Document document= new Document();
		PdfWriter.getInstance(document, out);
		
	//	Font fontBOLD = new Font(Font.FontFactory.T, 12,Font.BOLD);
		Font fontBOLD= FontFactory.getFont(FontFactory.HELVETICA,13,Font.BOLD);	
		
		document.open();
		Paragraph preface1 = new Paragraph();
       // addEmptyLine(preface1, 1);
        Paragraph heading =new Paragraph(); 
        heading = new Paragraph("ULB/UDA NAME");
        heading.setAlignment(1);
        document.add(heading);
        
        Chunk chunk1 = new Chunk("ENDORSEMENT", fontBOLD);
        chunk1.setUnderline(1.5F, -1.5F);
        heading = new Paragraph(chunk1);
        heading.setAlignment(1);
        document.add(heading);
        
        preface1.add(new Paragraph("Application No:                                    " +
         		"                                                           Date:DD/MM/YYYY"));
      //  addEmptyLine(preface1, 1);
        preface1.add(Chunk.NEWLINE);
        document.add(preface1);
        
        PdfPTable table = null;
        PdfPCell c1 = null;

        table = new PdfPTable(2);
        table.setWidths(new int[]{7, 90});

        c1 = new PdfPCell(new Phrase("Sub: "));
        c1.setBorder(0);
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("TDR  application    –    ULB/UDA  Name    –    Application  for   issue  of  Transferable  Development  Rights (TDR) – Site    affected/required   in  Sy.No.____ – Proposal REJECTED – Regarding"));
        c1.setBorder(0);
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Ref: "));
        c1.setBorder(0);
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("1. Andhra Pradesh Building Rules, 2017 and its amendments from time to time." +
                "                                                                                      " +
                "                      2. TDR application Number….Dt……..of Sri/Smt…."));
        c1.setBorder(0);
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);

        document.add(table);
		
        preface1 = new Paragraph();
        preface1.add(new Paragraph("                                                     ***     ", FontFactory.getFont(FontFactory.HELVETICA,13,Font.BOLD)));
        																							
        preface1.add(new Paragraph("        Your application submitted vide  reference 2nd cited,  has been  examined with reference to the A.P Building Rules, 2017 & its  amendments  from time to time and rejected for the following reasons."));

        //addEmptyLine(preface1, 1);
        preface1.add(Chunk.NEWLINE);

	      preface1.setAlignment(Element.ALIGN_JUSTIFIED);
	      preface1.setIndentationLeft(25);
	      preface1.setIndentationRight(25);
	      document.add(preface1);
	      
	      document.close();
		
		return new ByteArrayInputStream(out.toByteArray());
		 
	}
}
