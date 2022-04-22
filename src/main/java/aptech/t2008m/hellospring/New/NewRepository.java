package aptech.t2008m.hellospring.New;

import aptech.t2008m.hellospring.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewRepository extends JpaRepository<New,Integer> {
    @Query(value = "SELECT * FROM new a WHERE a.title LIKE %:title% and a.description LIKE %:description%",
            nativeQuery = true)
    List<New> search(
            @Param("title") String title , @Param("description") String description);
}
