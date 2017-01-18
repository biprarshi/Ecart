/**
 * 
 */
package com.niit.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Jo
 *
 */
@Entity
public class Product implements Serializable {
	@Id
	@GeneratedValue
int productId;
String productName;
String productDescription;
String productImage;
double productPrice;

@ManyToOne
@JoinColumn(name="catagoryId")
Catagory productCatagory;



/**
 * @return the productCatagory
 */
public Catagory getProductCatagory() {
	return productCatagory;
}
/**
 * @param productCatagory the productCatagory to set
 */
public void setProductCatagory(Catagory productCatagory) {
	this.productCatagory = productCatagory;
}
/**
 * @return the productId
 */
public int getProductId() {
	return productId;
}
/**
 * @param productId the productId to set
 */
public void setProductId(int productId) {
	this.productId = productId;
}
/**
 * @return the productName
 */
public String getProductName() {
	return productName;
}
/**
 * @param productName the productName to set
 */
public void setProductName(String productName) {
	this.productName = productName;
}
/**
 * @return the productDescription
 */
public String getProductDescription() {
	return productDescription;
}
/**
 * @param productDescription the productDescription to set
 */
public void setProductDescription(String productDescription) {
	this.productDescription = productDescription;
}
/**
 * @return the productImage
 */
public String getProductImage() {
	return productImage;
}
/**
 * @param productImage the productImage to set
 */
public void setProductImage(String productImage) {
	this.productImage = productImage;
}
/**
 * @return the productPrice
 */
public double getProductPrice() {
	return productPrice;
}
/**
 * @param productPrice the productPrice to set
 */
public void setProductPrice(double productPrice) {
	this.productPrice = productPrice;
}
}
