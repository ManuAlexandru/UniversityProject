package ro.UniversityProject.ProjectAPI.Controllers;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ro.UniversityProject.ProjectAPI.Common.Models.GenericResponse;
import ro.UniversityProject.ProjectAPI.Common.ViewModels.ProductViewModel;

@RestController
@PreAuthorize("hasRole('User')")
@RequestMapping(path="/api/Product")
public class ProductController {


@PostMapping("/CreateProduct")
public GenericResponse CreateProduct(@RequestHeader("Authorization") String Header,@RequestBody ProductViewModel product){

    GenericResponse genericResponse=new GenericResponse();
System.out.println("The product name is "+product.title);
    genericResponse.message="It works";
    genericResponse.statusCode=200;

    return genericResponse;
}
}
