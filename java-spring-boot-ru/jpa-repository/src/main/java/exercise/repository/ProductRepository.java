package exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import exercise.model.Product;

import org.springframework.data.domain.Sort;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // BEGIN
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice, Sort price);
    List<Product> findByPriceGreaterThanEqual(Double minPrice, Sort sort);
    List<Product> findByPriceLessThanEqual(Double maxPrice, Sort sort);
    // END
}
