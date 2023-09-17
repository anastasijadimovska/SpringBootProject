package mk.ukim.finki.labwp.web.controller;

import mk.ukim.finki.labwp.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/BalloonOrder.do")
public class BalloonOrderController {

    private final OrderService orderService;

    public BalloonOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getPage(Model model){
        model.addAttribute("bodyContent","deliveryInfo");
        return "master-template";
    }

    @PostMapping
    public String getDeliveryInfo(HttpServletRequest req, Model model){

        String color = (String) req.getSession().getAttribute("color");
        String size = (String) req.getSession().getAttribute("size");
        LocalDateTime dateCreated = LocalDateTime.parse(req.getParameter("dateCreated"));
        String ipAddress = (String) req.getRemoteAddr();
        String clientBrowser = (String) req.getHeader("User-Agent");
        model.addAttribute("clientName",req.getSession().getAttribute("username"));
        model.addAttribute("ipAddress",ipAddress);
        model.addAttribute("clientBrowser",clientBrowser);
        model.addAttribute("bodyContent","confirmationInfo");

        this.orderService.placeOrder(color,size,dateCreated);

        return "master-template";
    }
}
