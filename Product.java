package Product;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double price;
	private LocalDate expiration_date;
	private int stock;

	public Product() {
		// default constructor
	}

	public Product(Long id, String name, double price, LocalDate expiration_date, int stock) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.expiration_date = expiration_date;
		this.stock = stock;
	}

	public Product(String name, double price, LocalDate expiration_date, int stock) {
		this.name = name;
		this.price = price;
		this.expiration_date = expiration_date;
		this.stock = stock;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(LocalDate expiration_date) {
		this.expiration_date = expiration_date;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", expiration_date=" + expiration_date
				+ ", stock=" + stock + "]";
	}

}
