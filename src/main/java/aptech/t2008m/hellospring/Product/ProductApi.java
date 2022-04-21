package aptech.t2008m.hellospring.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/products")
public class ProductApi {
    @Autowired
    ProductRepository productRepository;

    private  static List<Product> productList;


    @RequestMapping (method = RequestMethod.GET)
    public List<Product> getList(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit){
        return  productRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void  save(@RequestBody Product obj){
        productRepository.save(obj);
    }

    @RequestMapping(method = RequestMethod.GET,path = "/{id}")
    public Product getDetail(@PathVariable int id){
       return productRepository.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.PUT,path = "/{id}")
    public Product update(@PathVariable int id,@RequestBody Product updateProduct){
      Product existing =  productRepository.findById(id).get();
      existing.setName(updateProduct.getName());
      productRepository.save(existing);
      return updateProduct;
    }

    @RequestMapping(method = RequestMethod.DELETE,path = "/{id}")
    public String delete(@PathVariable int id){
        productRepository.deleteById(id);
        return "ok";
    }
}
