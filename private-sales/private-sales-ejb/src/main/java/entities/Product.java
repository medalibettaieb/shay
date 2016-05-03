package entities;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: product
 *
 */
@Entity

public class Product extends User implements Serializable {

	private String product_category;
	private int size;
	private int nb_points;
	private String color;
	private static final long serialVersionUID = 1L;

	public Product() {
		super();
	}

	public String getProduct_category() {
		return this.product_category;
	}

	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}

	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getNb_points() {
		return this.nb_points;
	}

	public void setNb_points(int nb_points) {
		this.nb_points = nb_points;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
