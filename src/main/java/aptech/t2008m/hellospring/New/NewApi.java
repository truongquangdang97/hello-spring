package aptech.t2008m.hellospring.New;

import aptech.t2008m.hellospring.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/news")
public class NewApi {
    @Autowired
    NewRepository newRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<New> getList(@RequestParam(defaultValue = "") String title , @RequestParam(defaultValue = "") String description){
        return newRepository.search(title,description);
    }



    @RequestMapping(method = RequestMethod.POST)
    public New save(@RequestBody New obj){
        return newRepository.save(obj);
    }

    @RequestMapping(method = RequestMethod.GET,path = "/{id}")
    public New findById(@PathVariable int id){
        return newRepository.findById(id).get();
    }
    @RequestMapping(method = RequestMethod.PUT,path = "/{id}")
    public New update(@PathVariable int id,@RequestBody New updateNew){
        New existing = newRepository.findById(id).get();

        existing.setTitle(updateNew.getTitle());
        existing.setImage(updateNew.getImage());
        existing.setDescription(updateNew.getDescription());
        existing.setCategory(updateNew.getCategory());
        existing.setCreateDate(updateNew.getCreateDate());
        existing.setUpdateDate(updateNew.getUpdateDate());
        newRepository.save(existing);
        return updateNew;
    }


    @RequestMapping(method = RequestMethod.DELETE,path = "/{id}")
    public String delete(@PathVariable int id){
        newRepository.deleteById(id);
        return "ok delete";
    }





}
