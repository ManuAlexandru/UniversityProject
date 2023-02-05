package ro.UniversityProject.ProjectAPI.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.UniversityProject.ProjectAPI.BLL.Abstraction.IProductService;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.ProductDTO;

import java.util.List;

@Controller
@RequestMapping(path="/api/Home")
public class HomeController {
private IProductService _productService;

public HomeController(IProductService productService){
    _productService=productService;
}
    @GetMapping(path = "/GetAllProducts")
    public List<ProductDTO> GetProducts(){
_productService.CheckIfProductIsExpired();
return _productService.GetProducts();

    }
    @GetMapping(path = "/index")
    public String thymeLeafMethod(){
    return "index";
    }
}
