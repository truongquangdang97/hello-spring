package aptech.t2008m.hellospring.Family;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/familys")
public class FamilyApi {
    @Autowired
    FamilyRepository familyRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Family> getList(){
        return familyRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody Family obj){
        familyRepository.save(obj);
    }

}
