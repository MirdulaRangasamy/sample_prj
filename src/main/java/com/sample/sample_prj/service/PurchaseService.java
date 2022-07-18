package com.sample.sample_prj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.sample_prj.dao.PurchaseRepo;
import com.sample.sample_prj.entity.Purchase;
@Service
public class PurchaseService {
	@Autowired
	private PurchaseRepo purrepo;
	
	public void purchase(Purchase p)
	{
		purrepo.save(p);
		System.out.println("Purchase Successfull..");
	}
	
	public String getReceipt(int billno)
	{
		Purchase p = purrepo.findById(billno).orElse(null);
		if(p!=null)
		{
			return p.toString();
		}
		else
		{
			return "Invalid Bill number";
		}
	}
}
