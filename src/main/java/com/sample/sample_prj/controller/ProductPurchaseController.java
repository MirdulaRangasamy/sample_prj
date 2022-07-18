package com.sample.sample_prj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.sample_prj.entity.Product;
import com.sample.sample_prj.service.ProductService;

@Controller
public class ProductPurchaseController {
	@Autowired
	ProductService prdsvc;
	@RequestMapping("home")
	public String home()
	{
		return "home.jsp";
	}
	
	@RequestMapping("addpd")
	@ResponseBody
	public String addPrd(Product p)
	{
		return prdsvc.addProduct(p);
	}
	
	@RequestMapping("viewpd")
	@ResponseBody
	public String viewPrd(int pid)
	{
		return prdsvc.viewProduct(pid);
	}
	
	@RequestMapping("updatepd")
	@ResponseBody
	public String updatePrd(Product p)
	{
		return prdsvc.updateProduct(p);
	}
	
	@RequestMapping("deletepd")
	@ResponseBody
	public String deletePrd(int pid)
	{
		return prdsvc.deleteProduct(pid);
	}
	
	@RequestMapping("purchasepd")
	@ResponseBody
	public String purchasePrd(int pid, int quantity)
	{
		return prdsvc.sellProduct(quantity,pid);
	}
}
