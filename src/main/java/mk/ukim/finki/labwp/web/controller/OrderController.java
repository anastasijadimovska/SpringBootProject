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
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getOrdersPage(Model model){
        model.addAttribute("orders",orderService.listAll());
        model.addAttribute("bodyContent","orders");
        return "master-template";
    }


    @PostMapping("/newOrder")
    public String createNewOrder(){
        return "redirect:/balloons";
    }

//    @PostMapping("/filter")
//    public String filteredOrders(HttpServletRequest req, Model model){
//        LocalDateTime from = (LocalDateTime) req.getAttribute("from");
//        LocalDateTime to = (LocalDateTime) req.getAttribute("to");
//        model.addAttribute("orders",orderService.findAllByDateCreatedBetween(from,to));
//        return "orders";
//    }
}
