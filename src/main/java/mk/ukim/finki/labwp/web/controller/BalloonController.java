package mk.ukim.finki.labwp.web.controller;

import mk.ukim.finki.labwp.model.Balloon;
import mk.ukim.finki.labwp.model.Manufacturer;
import mk.ukim.finki.labwp.service.BalloonService;
import mk.ukim.finki.labwp.service.ManufacturerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/balloons")
public class BalloonController {
    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;

    public BalloonController(BalloonService balloonService, ManufacturerService manufacturerService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public String getBalloonsPage(@RequestParam (required = false) String error, Model model){
        if(error!=null && !error.isEmpty()){
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }
        model.addAttribute("balloons",this.balloonService.listAll());
        model.addAttribute("bodyContent","listBalloons");

        return "master-template";
    }

    @PostMapping
    public String BalloonsPage(HttpServletRequest request, @RequestParam String color, Model model){
        request.getSession().setAttribute("color",color);
        model.addAttribute("bodyContent","selectBalloonSize");
        return "master-template";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/add")
    public String getAddPage(Model model){
        List<Manufacturer> manufacturers = manufacturerService.findAll();
        model.addAttribute("manufacturers",manufacturers);
        model.addAttribute("bodyContent","add-balloon");
        return "master-template";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public String deleteBalloon(@PathVariable Long id){
        this.balloonService.delete(id);
        return "redirect:/balloons";
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String saveBalloon(@RequestParam(required = false) Long id,
                              @RequestParam String name,
                              @RequestParam String description,
                              @RequestParam Long manufacturerId){
        this.balloonService.save(id,name,description,manufacturerId);
        return "redirect:/balloons";
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/edit-form/{id}")
    public String getEditBalloonPage(@PathVariable Long id, Model model){
        if(this.balloonService.findById(id).isPresent()) {
            Balloon balloon = balloonService.findById(id).get();
            List<Manufacturer> manufacturers = manufacturerService.findAll();
            model.addAttribute("balloon",balloon);
            model.addAttribute("manufacturers",manufacturers);
            model.addAttribute("bodyContent","add-balloon");
            return "master-template";
        }
        return "redirect:/balloons";
    }

}
