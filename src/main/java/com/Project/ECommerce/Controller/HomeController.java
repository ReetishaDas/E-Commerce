package com.Project.ECommerce.Controller;

import com.Project.ECommerce.Globals.GlobalData;
import com.Project.ECommerce.Service.CategoryService;
import com.Project.ECommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    @Autowired
    CategoryService CS;
    @Autowired
    ProductService PS;

    @GetMapping({"/","/home"})
    public String home(Model model){
        return "index";
    }

    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("categories",CS.getAllCategory());
        model.addAttribute("products",PS.getAllProduct());
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "shop";
    }

    @GetMapping("/shop/category/{id}")
    public String shopByCategory(Model model, @PathVariable int id){
        model.addAttribute("categories",CS.getAllCategory());
        model.addAttribute("products",PS.getAllProductsByCategoryId(id));
        model.addAttribute("cartCount", GlobalData.cart.size());

        return "shop";
    }

    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(Model model, @PathVariable int id){
        model.addAttribute("product", PS.getProductById(id).get());
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "viewProduct";
    }




}
