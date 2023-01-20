package com.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.entities.Users;
import com.servicesapi.UsersService;
import com.support.ExcelPdfGenerator;

@RestController
@RequestMapping("users")
public class UsersController {

	@Autowired
	UsersService userServices;
	SessionFactory session;

	@RequestMapping(value ="/page", method = RequestMethod.GET)
	public ModelAndView getPage() {
		ModelAndView view = new ModelAndView("users");
		return view;
	}
	

	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getSaved(Users users) {
		Map<String, Object> map = new HashMap<String, Object>();

		if (userServices.saveOrUpdate(users)) {
			map.put("status", "200");
			map.put("message", "Your record have been saved successfully");
		}

		return map;
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getAll(Users users) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Users> list = userServices.list();

		if (list != null) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", list);
		} else {
			map.put("status", "404");
			map.put("message", "Data not found");

		}

		return map;
	}

	//@RequestMapping(value = "/delete/{userid}", method = RequestMethod.POST)
     @RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> delete(Users users) {
		Map<String, Object> map = new HashMap<String, Object>();

		if (userServices.delete(users)) {
			map.put("status", "200");
			map.put("message", "Your record have been deleted successfully");
		}

		return map;
	}

	@RequestMapping(value = "/downloadsUserPDF", method = RequestMethod.GET)
	public void downloadpdfVisitorReports(HttpServletRequest requset, HttpServletResponse response) throws IOException {

		try {

			new File("D:/Download/PDF").mkdirs();

			String fileName = "";

			List<Users> list = userServices.list();

			fileName = ExcelPdfGenerator.generateUSerPdf(list);

			InputStream is = new FileInputStream(new File("D:/Download/PDF/" + fileName + ".pdf"));
			IOUtils.copy(is, response.getOutputStream());
			response.flushBuffer();

		} catch (IOException ex) {
			throw new RuntimeException("IOError writing file to output stream");
		}

	}

	@RequestMapping(value = "/downloadUSerExcel", method = RequestMethod.GET)
	public void downloadExcelFormat(HttpServletRequest request, HttpServletResponse response) throws IOException {

		try {
			new File("D:/Download/Excels").mkdirs();

			String fileName = "";

			List<Users> list = userServices.list();

			fileName = ExcelPdfGenerator.generateUSerExcel(list);

			InputStream is = new FileInputStream(new File("D:/Download/Excels/" + fileName + ".xlsx"));

			IOUtils.copy(is, response.getOutputStream());

			response.flushBuffer();

		} catch (IOException ex) {

			throw new RuntimeException("IOError writing file to output stream");
		}

	}


	@RequestMapping(value = "/uploadUSerExcel", method = RequestMethod.POST)
	public void uploadExcelFormat(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException
	{
		System.out.println("start controller");  
				
				
				 File file=new File("D:\\yogi pratice\\new.xlsx");
				 FileInputStream fis=new FileInputStream(file);
				 
				 System.out.println("read file");
				 
				 XSSFWorkbook WorkBook = new XSSFWorkbook(fis);
				 
				 System.out.println("create work book");
				 
				 XSSFSheet sheet = WorkBook.getSheetAt(0);
				 
				 System.out.println("create sheet");
				 
				 Iterator<Row> rowIterator = sheet.iterator();
					Row row;
				  
				 System.out.println(sheet.getLastRowNum());
				  
				 for(int i=1; i<=sheet.getLastRowNum(); i++)
				
				   {
					
					 System.out.println("loop"+i);
				        
					 
					 	String userid =  sheet.getRow(i).getCell(0).getRawValue();
					 	
					 	System.out.println(userid);
					 	
				        String username = sheet.getRow(i).getCell(1).getStringCellValue();
				        String password = sheet.getRow(i).getCell(2).getStringCellValue();
				        String email = sheet.getRow(i).getCell(3).getStringCellValue();
				       
				        System.out.println("Import rows "+i);
				        
				        System.out.println(userid + "-"+ username+"-"+password+"-"+email);
				   
				        Users user = new Users();
				        
				        user.setUserid(userid);
				        user.setUsername(username);
				        user.setPassword(password);
				        user.setEmail(email);
				        
				        System.out.println(user.getPassword());
				        
				        userServices.save(user);
				        
				   }
				   
				    System.out.println("Success import excel to mysql table");
	}
	 
}