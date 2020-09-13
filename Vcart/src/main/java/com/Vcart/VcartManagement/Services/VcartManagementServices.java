package com.Vcart.VcartManagement.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Vcart.VcartManagement.Controller.Request.Category;
import com.Vcart.VcartManagement.Controller.Request.ItemResponse;
import com.Vcart.VcartManagement.Controller.Request.Items;
import com.Vcart.VcartManagement.Controller.Request.Product;
import com.Vcart.VcartManagement.Storage.CategoryRepository;
import com.Vcart.VcartManagement.Storage.ProductRepository;
import com.Vcart.VcartManagement.Storage.SubCatRespository;
import com.Vcart.VcartManagement.errorhandler.CategoryNotFoundException;
import com.Vcart.VcartManagement.errorhandler.IteamNotFoundException;

@Service
public class VcartManagementServices {

	@Autowired
	private ProductRepository pr;

	@Autowired
	private SubCatRespository sr;

	@Autowired
	private CategoryRepository cr;

	ItemResponse ir = new ItemResponse();

	public Optional<Product> getItem(int id) throws IteamNotFoundException {
		System.out.println("Product: " + pr.findById(id).isPresent());
		if (pr.findById(id).isPresent() == false) {
			throw new IteamNotFoundException("item not found " + id);
		}

		return pr.findById(id);
	}

	public List<Product> getAllItem() {
		return pr.findAll();

	}

	public int getQuantityByName(Product i) {
		return pr.getQuantityByName(i.getProductname());
	}

	public ItemResponse updateItem(Product i) throws IteamNotFoundException {
		Product p = null;

		if (pr.getProductByName(i.getProductname()) == null) {
			throw new IteamNotFoundException("item not found " + i.getProductname());
		} else {
			// updating SubCatQuantity

			System.out.println(pr.getSubCatIdByName(i.getProductname()) + "     "
					+ sr.getQuantitySubCat(pr.getSubCatIdByName(i.getProductname())));

			int i1 = sr.getQuantitySubCat(pr.getSubCatIdByName(i.getProductname())) + i.getQuantity();
			sr.setQuantitySubCat(i1, pr.getSubCatIdByName(i.getProductname()));

			// updating product quantity
			p = pr.getOne(pr.getIdByName(i.getProductname()));
			p.setQuantity(i.getQuantity() + pr.getQuantityByName(i.getProductname()));

			pr.save(p);

			// Response
			ir.setAmount(i.getMrp());
			ir.setProductname(i.getProductname());
			ir.setQuantity(pr.getQuantityByName(i.getProductname()));
			ir.setSubcategoryid(pr.getSubCatIdByName(i.getProductname()));
			ir.setSubcategoryname(sr.getSubCatNameById(pr.getSubCatIdByName(i.getProductname())));
			ir.setProductid(pr.getIdByName(i.getProductname()));
			ir.setCategoryname(cr.getCatNameByID(pr.getSubCatIdByName(i.getProductname())));
			ir.setCategoryid(cr.getCatIDByName(cr.getCatNameByID(pr.getSubCatIdByName(i.getProductname()))));

			return ir;
		}
	}

	public ItemResponse addItem(Category i) throws Exception {
		System.out.println(i);

		System.out.println(i.getType().getProduct().getProductname());
		// To verify the Category!!
		if (!cr.findAll().stream().collect(Collectors.toMap(Category::getCategoryid, Category::getCategory))
				.containsValue(i.getCategory())) {
			throw new CategoryNotFoundException("Category not found " + i.getCategory());
		}

		// To verify the SubCategory!!
		if (!sr.findAll().stream().collect(Collectors.toMap(Items::getSubcatid, Items::getSubcatname))
				.containsValue(i.getType().getSubcatname())) {
			throw new CategoryNotFoundException(
					"Category not found " + i.getCategory() + "." + i.getType().getSubcatname());
		}

		if (!pr.findAll().stream().collect(Collectors.toMap(Product::getProductid, Product::getProductname))
				.containsValue(i.getType().getProduct().getProductname())) {

			int subcatid = sr.getSubCatIdByName(i.getType().getSubcatname());
			i.getType().getProduct().setSubcatid(subcatid);
			sr.setQuantitySubCat(sr.getQuantitySubCat(subcatid) + i.getType().getProduct().getQuantity(), subcatid);
			pr.save(i.getType().getProduct());
			Product i1 = i.getType().getProduct();

			// Response
			ir.setAmount(i1.getMrp());
			ir.setProductname(i1.getProductname());
			ir.setQuantity(pr.getQuantityByName(i1.getProductname()));
			ir.setSubcategoryid(pr.getSubCatIdByName(i1.getProductname()));
			ir.setSubcategoryname(sr.getSubCatNameById(pr.getSubCatIdByName(i1.getProductname())));
			ir.setProductid(pr.getIdByName(i1.getProductname()));
			ir.setCategoryname(cr.getCatNameByID(pr.getSubCatIdByName(i1.getProductname())));
			ir.setCategoryid(cr.getCatIDByName(cr.getCatNameByID(pr.getSubCatIdByName(i1.getProductname()))));

			return ir;
		} else {

			return updateItem(i.getType().getProduct());
		}
	}

	public String deleteItem(String name) {

		sr.setQuantitySubCat(sr.getQuantitySubCat(pr.getSubCatIdByName(name)) - pr.getQuantityByName(name),
				pr.getSubCatIdByName(name));
		pr.deleteProductByName(name);

		return "Item " + name + " is deleted";
	}

}
