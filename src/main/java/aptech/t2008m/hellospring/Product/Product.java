package aptech.t2008m.hellospring.Product;


//import aptech.t2008m.hellospring.entity.Student;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@RestController
@RequestMapping(path = "api/v1/products")

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private  String name;
    private String  information;
    private double price;
    private int status;
}
