package com.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
//import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.entities.Project;
import com.servicesapi.UsersService;

@RestController
@RequestMapping("project")
public class ProjectController {

	@Autowired
	UsersService usersService;
	
	 @RequestMapping(value="/page", method = RequestMethod.GET )
		public ModelAndView getLogin(){
			ModelAndView view =new ModelAndView("project2");
			return view;
		}
		/* 
		@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
		public @ResponseBody Map<String, Object> getSaved(Project project) {
			Map<String, Object> map = new HashMap<String, Object>();
		
			if (usersService.saveOrUpdate(project)) {
				map.put("status", "200");
				map.put("message", "Your record have been saved successfully");
			}
		
			return map;
		}
		
		@RequestMapping(value = "/list2", method = RequestMethod.POST)
		public @ResponseBody Map<String, Object> getAll(Project project) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Project> list2 = usersService.list2();
		
			if (list2 != null) {
				map.put("status", "200");
				map.put("message", "Data found");
				map.put("data", list2);
			} else {
				map.put("status", "404");
				map.put("message", "Data not found");
		
			}
		
			return map;
		}*/

	@RequestMapping(value = "/uploadDocuments", method = RequestMethod.POST)
	public ResponseEntity<Object> ProjectUpload(@RequestParam("asstdocument1") MultipartFile file,
			@RequestParam("asstdocument2") MultipartFile file1,
			@RequestParam("asstdocument3") MultipartFile file2,
			@RequestParam("asstdocument4") MultipartFile file3,
			@RequestParam("asstdocument5") MultipartFile file4, 
			MultipartHttpServletRequest mrequest) throws IOException {

		String file1name = file.getOriginalFilename().trim();
		String file2name = file1.getOriginalFilename().trim();
		String file3name = file2.getOriginalFilename().trim();
		String file4name = file3.getOriginalFilename().trim();
		String file5name = file4.getOriginalFilename().trim();
		
		boolean msgReturn = false;

		String path = "D:/Documents/DocumentsUpload";

		new File(path).mkdirs();

		// Save file on system
		if (!file.getOriginalFilename().isEmpty()) {
			BufferedOutputStream outputStream = new BufferedOutputStream(
					new FileOutputStream(new File(path, file1name)));
			outputStream.write(file.getBytes());
			outputStream.flush();
			outputStream.close();
		} 
			
		if (!file1.getOriginalFilename().isEmpty()) {
			BufferedOutputStream outputStream = new BufferedOutputStream(
					new FileOutputStream(new File(path, file2name)));
			outputStream.write(file1.getBytes());
			outputStream.flush();
			outputStream.close();
		} 
		
		if (!file2.getOriginalFilename().isEmpty()) {
			BufferedOutputStream outputStream = new BufferedOutputStream(
					new FileOutputStream(new File(path, file3name)));
			outputStream.write(file2.getBytes());
			outputStream.flush();
			outputStream.close();
		} 
		
		if (!file3.getOriginalFilename().isEmpty()) {
			BufferedOutputStream outputStream = new BufferedOutputStream(
					new FileOutputStream(new File(path, file4name)));
			outputStream.write(file3.getBytes());
			outputStream.flush();
			outputStream.close();
		} 
		
		if (!file4.getOriginalFilename().isEmpty()) {
			BufferedOutputStream outputStream = new BufferedOutputStream(
					new FileOutputStream(new File(path, file5name)));
			outputStream.write(file4.getBytes());
			outputStream.flush();
			outputStream.close();
		} 
		
		Project proj = new Project();
		
		proj.setDetails(mrequest.getParameter("details")+' '+mrequest.getParameter("details1")+' '+mrequest.getParameter("details2")+' '+mrequest.getParameter("details3")+' '+mrequest.getParameter("details4")+' '+mrequest.getParameter("details5"));	
		proj.setHighlights(mrequest.getParameter("highlights1")+' '+mrequest.getParameter("highlights3"));
		proj.setHighlights1(mrequest.getParameter("highlights2")+' '+mrequest.getParameter("highlights4"));
		
		//asst.setUniqueId(unqid);
		
		proj.setAsstdocument1name(mrequest.getParameter("asstdocument1name"));
		proj.setAsstdocument2name(mrequest.getParameter("asstdocument2name"));
		proj.setAsstdocument3name(mrequest.getParameter("asstdocument3name"));
		proj.setAsstdocument4name(mrequest.getParameter("asstdocument4name"));
		proj.setAsstdocument5name(mrequest.getParameter("asstdocument5name"));
		

		
		if (!file.getOriginalFilename().isEmpty()) {
			proj.setAsstdocument1(file1name);
			
		}else {
			proj.setAsstdocument1("none");
			
		}
		
		if (!file1.getOriginalFilename().isEmpty()) {
			proj.setAsstdocument2(file2name);
			
		}else {
			proj.setAsstdocument2("none");
			
		}
		
		if (!file2.getOriginalFilename().isEmpty()) {
			proj.setAsstdocument3(file3name);
			
		}else {
			proj.setAsstdocument3("none");
			
		}
		
		if (!file3.getOriginalFilename().isEmpty()) {
			proj.setAsstdocument4(file4name);
			
		}else {
			proj.setAsstdocument4("none");
			;
		}
		
		if (!file4.getOriginalFilename().isEmpty()) {
			proj.setAsstdocument5(file5name);
			
		}else {
			proj.setAsstdocument5("none");
			
		}
			
		msgReturn = usersService.saveOrUpdate(proj);
			
		
		if (msgReturn) {
			return new ResponseEntity<>("File Uploaded Successfully.", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(msgReturn, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	
	
	@RequestMapping(value = "/listdocuments", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getAllAssetDocuments(@RequestBody Project project) {
		Map<String, Object> map = new HashMap<String, Object>();

		
		String path = "D:/project/DocumentsUpload";

		new File(path).mkdirs();
		
		File source = new File("D:/Documents/DocumentsUpload");
		File dest = new File("D:/project/DocumentsUpload");
		try {
			FileUtils.copyDirectory(source, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<Project> list = usersService.list2();

		if (list.size() >= 1) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", list);
		} else {
			map.put("status", "404");
			map.put("message", "Data not found");

		}

		return map;
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> delete(Project project) {
		Map<String, Object> map = new HashMap<String, Object>();

		if (usersService.delete(project)) {
			map.put("status", "200");
			map.put("message", "Your record have been deleted successfully");
		}

		return map;
	}
	
	
}
