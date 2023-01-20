package com.support;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.entities.Users;

public class ExcelPdfGenerator {

	public static String generateUSerExcel(List<Users> list) {


		String fileName = "USers_Excel" ;
		fileName = fileName.replace("-", "_");
		fileName = fileName.replace(":", "_");
		fileName = fileName.replace(" ", "_");
		fileName = fileName.trim();

		try {

			String excelFilePath = "D:\\yogi pratice\\excel_format.xlsx";

			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

			Workbook workbook = WorkbookFactory.create(inputStream);

			CellStyle center = workbook.createCellStyle();

			center.setAlignment(CellStyle.ALIGN_CENTER);

			// center.setBorderBottom(CellStyle.BORDER_THIN);

			center.setBorderLeft(CellStyle.BORDER_THIN);

			center.setBorderRight(CellStyle.BORDER_THIN);

			// center.setBorderTop(CellStyle.BORDER_THIN);

			Sheet sheet = workbook.getSheetAt(0);

			Cell cell;

			Row row;

			row = sheet.createRow(1);
			
			cell = row.createCell(0);
			cell.setCellValue("id");
			cell.setCellStyle(center);

			cell = row.createCell(1);
			cell.setCellValue("name");
			cell.setCellStyle(center);
			
			cell = row.createCell(2);
			cell.setCellValue("Password");
			cell.setCellStyle(center);
			
			cell = row.createCell(3);
			cell.setCellValue("email");
			cell.setCellStyle(center);

		    int tot = 0;

			for (int i = 0, r = 2; i < list.size(); i++, r++) {

				row = sheet.createRow(r);

				cell = row.createCell(0);
				cell.setCellValue(list.get(i).getUserid());
				cell.setCellStyle(center);

				cell = row.createCell(1);
				cell.setCellValue(list.get(i).getUsername());
				cell.setCellStyle(center);

				cell = row.createCell(2);
				cell.setCellValue(list.get(i).getUsername());
				cell.setCellStyle(center);

				cell = row.createCell(3);
				cell.setCellValue(list.get(i).getEmail());
				cell.setCellStyle(center);

				tot = tot + 1;
				
			}
			
			inputStream.close();

			FileOutputStream outputstream = new FileOutputStream(new File("D:/Download/Excels/" + fileName + ".xlsx"));

			workbook.write(outputstream);

			outputstream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return fileName;

	}
	
	public static String generateUSerPdf(List<Users> list) {

		String fileName = "UsersPdf";

		try {

			OutputStream file = new FileOutputStream(new File("D:/Download/PDF/" + fileName + ".pdf"));
			
			Document document = new Document(PageSize.A4.rotate());
			PdfWriter.getInstance(document, file);

			float[] hwidths = { 2, 5, 5, 5,};
			PdfPTable tableh = new PdfPTable(hwidths);
			tableh.setWidthPercentage(100);

			// Inserting Table in PDF
			PdfPCell cell;

			

			cell = new PdfPCell(new Paragraph("USers Data",
					new Font(FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLACK)));
			cell.setColspan(4);
			cell.setPaddingTop(10);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBorderColorTop(new BaseColor(239, 240, 242));
			tableh.addCell(cell);
	
			cell = new PdfPCell(new Paragraph("ID", new Font(FontFamily.HELVETICA, 9, Font.BOLD, BaseColor.BLACK)));
			cell.setColspan(1);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			tableh.addCell(cell);

			cell = new PdfPCell(
					new Paragraph("Name", new Font(FontFamily.HELVETICA, 9, Font.BOLD, BaseColor.BLACK)));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			tableh.addCell(cell);
			
			cell = new PdfPCell(new Paragraph("Password", new Font(FontFamily.HELVETICA, 9, Font.BOLD, BaseColor.BLACK)));
			cell.setColspan(1);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			tableh.addCell(cell);

			cell = new PdfPCell(
					new Paragraph("Email ID", new Font(FontFamily.HELVETICA, 9, Font.BOLD, BaseColor.BLACK)));
			cell.setColspan(1);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			tableh.addCell(cell);

			int tot = 0;
			
				for (int i = 0; i < list.size(); i++) {

					cell = new PdfPCell(new Paragraph(String.valueOf(list.get(i).getUserid()),
							new Font(FontFamily.HELVETICA, 9, Font.NORMAL, BaseColor.BLACK)));
					cell.setPadding(2);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBorderColorTop(new BaseColor(239, 240, 242));
					tableh.addCell(cell);

					cell = new PdfPCell(new Paragraph(list.get(i).getUsername(),
							new Font(FontFamily.HELVETICA, 9, Font.NORMAL, BaseColor.BLACK)));
					cell.setPadding(2);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBorderColorTop(new BaseColor(239, 240, 242));
					tableh.addCell(cell);

					cell = new PdfPCell(new Paragraph(list.get(i).getPassword(),
							new Font(FontFamily.HELVETICA, 9, Font.NORMAL, BaseColor.BLACK)));
					cell.setPadding(2);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBorderColorTop(new BaseColor(239, 240, 242));
					tableh.addCell(cell);
					
					cell = new PdfPCell(new Paragraph(list.get(i).getEmail(),
							new Font(FontFamily.HELVETICA, 9, Font.NORMAL, BaseColor.BLACK)));
					cell.setPadding(2);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBorderColorTop(new BaseColor(239, 240, 242));
					tableh.addCell(cell);
					
					tot = tot + 1;
					
				}

			document.open();// PDF document opened........

			document.add(new Paragraph("Document Generated On - " + new Date().toString()));
			document.add(new Paragraph(" "));

			tableh.setSpacingBefore(10f);
			document.add(tableh);
			document.close();
			file.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
	}
	
}
