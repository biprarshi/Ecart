/**

 * 
 */
package com.niit.shoppingcart.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 * @author Jo
 *
 */
@Entity
public class Catagory implements Serializable{
	@Id
	@GeneratedValue
	
	private int catagoryId;
	private String catagoryName;
	private String catagoryDescription;
	
	/**
	 * @return the catagoryId
	 */
	public int getCatagoryId() {
		return catagoryId;
	}

	/**
	 * @param catagoryId the catagoryId to set
	 */
	public void setCatagoryId(int catagoryId) {
		this.catagoryId = catagoryId;
	}

	/**
	 * @return the catagoryName
	 */
	public String getCatagoryName() {
		return catagoryName;
	}

	/**
	 * @param catagoryName the catagoryName to set
	 */
	public void setCatagoryName(String catagoryName) {
		this.catagoryName = catagoryName;
	}

	/**
	 * @return the catagoryDescription
	 */
	public String getCatagoryDescription() {
		return catagoryDescription;
	}

	/**
	 * @param catagoryDescription the catagoryDescription to set
	 */
	public void setCatagoryDescription(String catagoryDescription) {
		this.catagoryDescription = catagoryDescription;
	}

	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@OneToMany (mappedBy="productCatagory",fetch=FetchType.EAGER)
	List<Product> products;

}
