package aptech.t2008m.hellospring.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
//    @Query(value = "SELECT p FROM Product p WHERE p.name LIKE %:name%" , nativeQuery = true)
//    public List<Product> search(@Param("name") String name);

    @Query(value = "SELECT * FROM Product a WHERE a.name LIKE %:title%",
            nativeQuery = true)
    List<Product> search(
            @Param("title") String title);
}
