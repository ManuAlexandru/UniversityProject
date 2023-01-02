package ro.UniversityProject.ProjectAPI.Controllers;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.UniversityProject.ProjectAPI.Common.Models.GenericResponse;
import ro.UniversityProject.ProjectAPI.Common.ViewModels.ProductViewModel;

@RestController

@RequestMapping(path="/api/Product")
public class ProductController {
public long  weekInMilliseconds=604800000;

@PostMapping("/CreateProduct")
public GenericResponse CreateProduct(@RequestBody ProductViewModel product){
    GenericResponse genericResponse=new GenericResponse();
System.out.println("The product name is "+product.title);
    genericResponse.message="It works";
    genericResponse.statusCode=200;

    return genericResponse;
}
}
