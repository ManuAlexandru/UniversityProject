package ro.UniversityProject.ProjectAPI.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import ro.UniversityProject.ProjectAPI.BLL.Abstraction.IProductService;
import ro.UniversityProject.ProjectAPI.BLL.UTILS.KafkaChat.Constants.KafkaConstants;
import ro.UniversityProject.ProjectAPI.BLL.UTILS.KafkaChat.Model.KafkaModel;
import ro.UniversityProject.ProjectAPI.BLL.ViewModels.ProductUpdateViewModel;
import ro.UniversityProject.ProjectAPI.BLL.ViewModels.ProductViewModel;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.ProductDTO;
import ro.UniversityProject.ProjectAPI.Common.Models.GenericResponse;

import java.util.List;

@RestController
@RequestMapping(path="/api/Product")
public class ProductController {

private IProductService _productService;
    @Autowired
    private KafkaTemplate<String, KafkaModel> kafkaTemplate;

public ProductController(IProductService productService){
    _productService=productService;
}

@PostMapping("/CreateProduct")
public GenericResponse CreateProduct(@RequestHeader("Authorization") String Header,@RequestBody ProductViewModel product){

    GenericResponse genericResponse=new GenericResponse();
System.out.println("The product name is "+product.title);

var result=_productService.AddProduct(product);
if(result){
    genericResponse.message="It works";
    genericResponse.statusCode=200;
    var model=new KafkaModel(product.userId, product.title);
kafkaTemplate.send(KafkaConstants.KAFKA_TOPIC,model);

    return genericResponse;
}
    genericResponse.message="It is not working";
    genericResponse.statusCode=500;
    return genericResponse;
}
    @GetMapping(path = "/GetYourProducts/{id}")
    public List<ProductDTO> GetProducts(@PathVariable("id") Long id){
System.out.println(id);
var listOfProduct= _productService.GetProductsByUserId(id);

        return _productService.GetProductsByUserId(id);

    }

    @DeleteMapping(path = "/DeleteProduct/{id}")
    public GenericResponse DeleteProduct(@PathVariable("id") Long id){
        GenericResponse genericResponse=new GenericResponse();


        var result=_productService.DeleteProduct(id);
        if(result){
            genericResponse.message="Product Deleted";
            genericResponse.statusCode=200;
            return genericResponse;
        }
        genericResponse.message="Something went wrong while deleting the product. Please try again later!";
        genericResponse.statusCode=500;
        return genericResponse;

    }
    @GetMapping(path = "/GetProduct/{id}")
    public ProductDTO GetProduct(@PathVariable("id") Long id){

    return _productService.GetProduct(id);
    }
    @PutMapping(path = "/UpdateProduct")
    public GenericResponse UpdateProduct(@RequestBody ProductUpdateViewModel product){
        GenericResponse genericResponse=new GenericResponse();
        System.out.println(product.getDescription());
 var result= _productService.UpdateProduct(product);
        if(result){
            genericResponse.message="Product Updated";
            genericResponse.statusCode=200;
        return genericResponse;
        }
        genericResponse.message="Something went wrong while updating the product. Please try again later!";
        genericResponse.statusCode=500;
        return genericResponse;
}

    @PutMapping(path = "/UpdateProductPrice")
    public GenericResponse UpdateProductPrice(@RequestBody ProductUpdateViewModel product){
        GenericResponse genericResponse=new GenericResponse();
        System.out.println(product.getDescription());
        var result= _productService.UpdatePrice(product.getActualPrice(), product.getId());
        if(result){
            genericResponse.message="Product price Updated";
            genericResponse.statusCode=200;
            return genericResponse;
        }
        genericResponse.message="Something went wrong while updating the price product. Please try again later!";
        genericResponse.statusCode=500;
        return genericResponse;
    }
    }
