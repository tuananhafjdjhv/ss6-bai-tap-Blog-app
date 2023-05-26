package ra.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.model.Blog;
import ra.repository.blog.IBlogRepository;
import ra.service.BlogService;
import ra.service.IBlogService;

import java.util.List;

@Controller
@RequestMapping({"/","/homeController"})
public class HomeController {

    @Autowired
    private IBlogService blogService;

    @GetMapping({"/","/home"})
    public String getAll(Model model){
        List<Blog> list = blogService.findAll();
        model.addAttribute("list",list);
        return "index";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        blogService.remove(id);
        return "redirect:/";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        return "redirect:/";
    }
    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("add","blogList",new Blog());
    }

    @GetMapping("/edit/{id}")
    public ModelAndView add(@PathVariable("id")int id){
        return new ModelAndView("edit","blog",blogService.findById(id));
    }

    @PostMapping("/update")
    public  String update(@ModelAttribute("blog") Blog c){
        blogService.save(c);
        return "redirect:/";
    }
}
