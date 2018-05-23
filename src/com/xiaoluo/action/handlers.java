package com.xiaoluo.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.xiaoluo.dao.userDao;
import com.xiaoluo.dao.wxcodeDao;
import com.xiaoluo.dao.goodsDao;
import com.xiaoluo.dao.orderDao;
import com.xiaoluo.entity.goods;
import com.xiaoluo.entity.order;
import com.xiaoluo.entity.user;


@RequestMapping("wx")
@Controller
public class handlers {
	@Autowired
	private userDao  userdao;
	@Autowired
	private goodsDao goodsDao ;
	@Autowired
	private wxcodeDao wxcodeDao;
	@Autowired
	private orderDao  orderDao;
  @RequestMapping(value="/count")
  @ResponseBody
  public Integer count(@RequestParam("username") String username,@RequestParam("password") String password) throws IOException{
	  System.out.println(username+password);
	  int count1=0;
	  int count=1;
	 count1=userdao.count(username,password);
	 if(count1>0){
		 return count;
	 }else{
		 return 0;
	 }
  }
  @RequestMapping(value="/user",method=RequestMethod.GET)
  @ResponseBody
  public user getuser() throws IOException{
	  return  userdao.getuesrandposs();
  }
  @RequestMapping(value="/getAllAndgoods",method=RequestMethod.GET)
  @ResponseBody
  public List<goods> getAllAndgoods() throws IOException{
	  return goodsDao.getAllGoods();  
  }
  @RequestMapping(value="/setGoodsAndPrice",method=RequestMethod.GET)
  public void setGoodsAndPrice(@RequestParam("goodsName") String goodsName,@RequestParam("price") Integer price,@RequestParam("id") Integer id) throws IOException{
	  
	  goodsDao.setGoodsAndPrice(goodsName, price, id);
  }
//  @RequestMapping(value="/setGoods",method=RequestMethod.GET)
//  public void setGoods(@RequestParam("goodsName") String goodsName,@RequestParam("price") Integer price,@RequestParam("id") Integer id) throws IOException{
//		goodsDao.setGoods(goodsName,price,id);
//	}
  @RequestMapping(value="/setGoods")
  @ResponseBody
   public Integer setGood(@RequestParam("id") Integer id,@RequestParam("goodsName")String goodsName ,@RequestParam("price") Integer price,@RequestParam("photo") String photo) throws IOException{
	  System.out.println(goodsName+" "+price+" "+photo+" "+id);
	  goodsDao.setGoods(goodsName,price,photo,id);
	  return 1;
	}
  @RequestMapping(value="/setCode",method=RequestMethod.GET)
  public void setCode(@RequestParam("code") String code) throws IOException{
	  System.out.println(code);
	    wxcodeDao.setcode(code);
  }
  @RequestMapping(value="/getCountCode",method=RequestMethod.GET)
  @ResponseBody
  public Integer getCountCode(@RequestParam("code") String code) throws IOException{
	  int count1=0;
	  int count=1;
	 count1=wxcodeDao.getCountCode(code);
	 if(count1>0){
		 return count;
	 }else{
		 return 0;
	 }
  }
  @RequestMapping(value="/setOrder",method=RequestMethod.GET)
  public void setOrder(@RequestParam("code") String code,@RequestParam("goodstime") String goodstime,@RequestParam("goodsName") String goodsName,@RequestParam("price") String price) throws IOException{
	 order order=new order(code, goodstime, goodsName, price);
	 orderDao.setOrder(order);
  }
  
  @RequestMapping(value="/getOrder",method=RequestMethod.GET)
  @ResponseBody
  public List<order> setOrder(@RequestParam("code") String code) throws IOException{
	 return orderDao.getOrder(code);
  }
  @RequestMapping(value="/getImage")
  public ResponseEntity<byte[]> getImage(HttpServletResponse res,HttpSession session,OutputStream out) throws IOException{
	byte[] body=null;
	res.setCharacterEncoding("utf-8");
	ServletContext context=session.getServletContext();
	InputStream inputStream=context.getResourceAsStream("/WEB-INF/image/大盘鸡.png");
	body=new byte[inputStream.available()];
	inputStream.read(body);
	HttpHeaders Header=new HttpHeaders();
	 Header.add("Content-Disposition", "attachment;filename=大盘鸡.png");
	 HttpStatus status=HttpStatus.OK;
	 ResponseEntity<byte[]> response=new ResponseEntity<byte[]>(body,Header,status);
	 out.write(body);
	 return response;
  }
  @RequestMapping(value="/getKl")
  public ResponseEntity<byte[]> getKl(HttpServletResponse res,HttpSession session,OutputStream out) throws IOException{
	byte[] body=null;
	res.setCharacterEncoding("utf-8");
	ServletContext context=session.getServletContext();
	InputStream inputStream=context.getResourceAsStream("/WEB-INF/image/可乐.png");
	body=new byte[inputStream.available()];
	inputStream.read(body);
	HttpHeaders Header=new HttpHeaders();
	 Header.add("Content-Disposition", "attachment;filename=可乐.png");
	 HttpStatus status=HttpStatus.OK;
	 ResponseEntity<byte[]> response=new ResponseEntity<byte[]>(body,Header,status);
	 out.write(body);
	 return response;
  }
  @RequestMapping(value="/getmf")
  public ResponseEntity<byte[]> getmf(HttpServletResponse res,HttpSession session,OutputStream out) throws IOException{
	byte[] body=null;
	res.setCharacterEncoding("utf-8");
	ServletContext context=session.getServletContext();
	InputStream inputStream=context.getResourceAsStream("/WEB-INF/image/米饭.png");
	body=new byte[inputStream.available()];
	inputStream.read(body);
	HttpHeaders Header=new HttpHeaders();
	 Header.add("Content-Disposition", "attachment;filename=米饭.png");
	 HttpStatus status=HttpStatus.OK;
	 ResponseEntity<byte[]> response=new ResponseEntity<byte[]>(body,Header,status);
	 out.write(body);
	 return response;
  }
  @RequestMapping(value="/testfileName")
  public void getfile(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest  request) throws IOException{
//	  System.out.println(file.getOriginalFilename().substring(4));
	  String str=file.getOriginalFilename();
	  String filePath="你"+str.substring(str.length()-4);
//	  String filePath="123.txt";
	  System.out.println(filePath);
	  String path=request.getServletContext().getRealPath("WEB-INF/file/");
//	  String filePath=file.getOriginalFilename();
	  File f=new File(path,filePath);
	  if(!file.isEmpty()){
	     FileOutputStream out=new FileOutputStream(f);
		InputStream in = file.getInputStream();  
        int b = 0;  
        while ((b = in.read()) != -1) {  
            out.write(b);  
        }  
        out.close();  
        in.close();
	  }
 }
  //  public String count() throws IOException{
////	  int count=0;
////	 count=userdao.count();
////	 System.out.println(count);
//	  System.out.println(123);
//	  return  "success";
//  }
  @RequestMapping(value="/getGoods")
  @ResponseBody
  public goods getGoods(@RequestParam("edit_id") Integer id) throws IOException{
	  return goodsDao.getGoods(id); 
  }
  @RequestMapping(value="/delGoods")
  @ResponseBody
  public String delGoods(@RequestParam("del_id") Integer id) throws IOException{
	   goodsDao.delGoods(id);
	   return "删除成功";
  }
  @RequestMapping(value="/addGoods")
  @ResponseBody
  public String addGoods(goods good) throws IOException{
	  goodsDao.addGoods(good);
	  return "添加成功";
  }
  @RequestMapping(value="getAllOrder")
  @ResponseBody
  public List<order> getAllOrder() throws IOException{
	  return orderDao.getAllOrder();
  }
}
