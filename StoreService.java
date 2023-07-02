package Product;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

	private final ProductRepository productRepository;

	public StoreService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProductById(Long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Product ID does not exist"));
	}

	public void saveProduct(Product product) {
		Optional<Product> existingProduct = productRepository.findByName(product.getName());
		if (existingProduct.isPresent()) {
			Product updatedProduct = existingProduct.get();
			int newStock = updatedProduct.getStock() + product.getStock();
			updatedProduct.setStock(newStock);
			updatedProduct.setExpiration_date(product.getExpiration_date());
			updatedProduct.setPrice(product.getPrice());
			productRepository.save(updatedProduct);
		} else {
			productRepository.save(product);
		}
	}

	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

	public List<Product> findByPriceGreaterThan(double price) {
		return productRepository.findByPriceGreaterThan(price);
	}

}
