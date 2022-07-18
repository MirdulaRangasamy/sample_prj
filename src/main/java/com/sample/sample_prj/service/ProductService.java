package com.sample.sample_prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.sample_prj.dao.ProductRepo;
import com.sample.sample_prj.entity.Product;
import com.sample.sample_prj.entity.Purchase;
import com.sample.sample_prj.exception.InvalidProductException;
import com.sample.sample_prj.exception.ProductNotFoundException;

@Service
public class ProductService {
	@Autowired
	private ProductRepo prdrepo;
	@Autowired
	private PurchaseService psvc;

	public String addProduct(Product p) {
		prdrepo.save(p);
		return "Added..";
	}

	public List<Product> getAll() {
		return prdrepo.findAll();
	}

	public String viewProduct(int pid) {
		try {
			Product p = prdrepo.findById(pid).orElse(null);
			if (p != null) {
				return p.toString();
			} else {
				throw new ProductNotFoundException();
			}
		} catch (ProductNotFoundException e) {
			return e.toString();
		}
	}

	public String updateProduct(Product p1) {
		Product p = prdrepo.findById(p1.getPid()).orElse(null);
		if (p != null) {
			prdrepo.delete(p);
		}
		prdrepo.save(p1);
		return "Updated..";
	}

	public String deleteProduct(int pid) {
		try {
			Product p = prdrepo.findById(pid).orElse(null);
			if (p != null) {
				prdrepo.delete(p);
				return "Product Deleted Successfully...";
			} else {
				throw new ProductNotFoundException();
			}
		} catch (ProductNotFoundException e) {
			return e.toString();
		}
	}

	public String sellProduct(int quantity, int pid) {
		try {
			Product p = prdrepo.findById(pid).orElse(null);
			if (p != null) {
				if (p.getAvailable() >= quantity) {
					p.setAvailable(p.getAvailable() - quantity);
					psvc.purchase(new Purchase(pid, quantity, (quantity * p.getPcost())));
					return (quantity + " product sold");
				} else {
					addStock(pid, quantity);
					return "Stock unavailable...";
				}
			} else {
				throw new InvalidProductException();
			}
		} catch (InvalidProductException e) {
			return e.toString();
		}
	}

	public void addStock(int pid, int pqty) {
		try {
			Product p = prdrepo.findById(pid).orElse(null);
			if (p != null) {
				System.out.println("Inside Sell");
				System.out.println(p.getAvailable());
				p.setAvailable(p.getAvailable() + pqty);
				System.out.println(p.getAvailable());
				updateProduct(p);
			} else {
				throw new InvalidProductException();
			}
		} catch (InvalidProductException e) {
			System.out.println(e);
		}
	}
}
