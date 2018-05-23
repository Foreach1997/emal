package com.xiaoluo.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class downImage {
public static ResponseEntity<byte[]> getImage(HttpServletResponse res,HttpSession session,OutputStream out,String fileName) throws IOException{
			byte[] body=null;
			res.setCharacterEncoding("utf-8");
			ServletContext context=session.getServletContext();
			InputStream inputStream=context.getResourceAsStream("/image/"+fileName);
			body=new byte[inputStream.available()];
			inputStream.read(body);
			HttpHeaders Header=new HttpHeaders();
			 Header.add("Content-Disposition", "attachment;filename="+fileName);
			 HttpStatus status=HttpStatus.OK;
			 ResponseEntity<byte[]> response=new ResponseEntity<byte[]>(body,Header,status);
			 out.write(body);
			 return response;
			  
		  }
}
