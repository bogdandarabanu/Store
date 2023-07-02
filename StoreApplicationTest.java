package Product;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StoreApplicationTest {
	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(StoreApplicationTest.class, args);

		StoreService storeService = context.getBean(StoreService.class);

		Product product1 = new Product("sugar", 4.99, LocalDate.of(2023, 8, 21), 2);
		Product product2 = new Product("salt", 2.99, LocalDate.of(2023, 8, 21), 10);
		Product product3 = new Product("oil", 7.99, LocalDate.of(2023, 8, 21), 5);
		Product product4 = new Product("candy", 10.99, LocalDate.of(2023, 8, 21), 7);
		storeService.saveProduct(product1);
		storeService.saveProduct(product4);
		storeService.saveProduct(product3);
		storeService.saveProduct(product2);

		Product producta = new Product("sugar", 4.99, LocalDate.of(2023, 8, 21), 2);
		Product productb = new Product("salt", 2.99, LocalDate.of(2023, 8, 21), 10);
		Product productc = new Product("oil", 7.99, LocalDate.of(2023, 8, 21), 5);
		Product productd = new Product("candy", 10.99, LocalDate.of(2023, 8, 21), 7);
		storeService.saveProduct(producta);
		storeService.saveProduct(productb);
		storeService.saveProduct(productc);
		storeService.saveProduct(productd);

		List<Product> products = storeService.findByPriceGreaterThan(3);
		for (Product product : products) {
			System.out.println(product.toString());
		}
		

	}
}
