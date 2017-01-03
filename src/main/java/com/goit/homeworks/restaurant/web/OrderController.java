package com.goit.homeworks.restaurant.web;

import com.goit.homeworks.restaurant.model.Menu;
import com.goit.homeworks.restaurant.model.Order;
import com.goit.homeworks.restaurant.model.PreparedDish;
import com.goit.homeworks.restaurant.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by SeVlad on 13.11.2016.
 */
@Controller
public class OrderController {
    private final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/order/allOpen", method = RequestMethod.GET)
    public String getAllOpenOrders(Model model) {
        LOGGER.debug("getAllOpenOrders() is executed!");
        model.addAttribute("orders", orderService.getAllOpenOrders());
        model.addAttribute("isClosed", "OPEN");

        return "app.orders";
    }

    @RequestMapping(value = "/order/allClosed", method = RequestMethod.GET)
    public String getAllClosedOrders(Model model) {
        LOGGER.debug("getAllClosedOrders() is executed!");
        model.addAttribute("orders", orderService.getAllClosedOrders());
        model.addAttribute("isClosed", "CLOSED");

        return "app.orders";
    }

    @RequestMapping(value = "/order/{id}/delete", method = RequestMethod.POST)
    public String deleteOrder(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
        LOGGER.debug("deleteOrder() is executed!");
        Order order = orderService.getOrderById(id);
        orderService.deleteOrder(order);
        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Замовлення #" + order.getId() + " успішно видалено");
        String redirect = order.isOpen() ? "allOpen" : "allClosed";
        return "redirect:/order/" + redirect;
    }

    @RequestMapping(value = "/order/add", method = RequestMethod.GET)
    public String showCreateOrderForm(Model model){
        LOGGER.debug("showCreateOrderForm() is executed!");
        Order order = new Order();
        model.addAttribute("orderForm", order);
        model.addAttribute("employees", orderService.getAllEmployee());
        return "app.add-update-order";
    }

    @RequestMapping(value = "/order/added", method = RequestMethod.POST)
    public String addOrUpdateOrder(@ModelAttribute("orderForm") Order order, final RedirectAttributes redirectAttributes){
        LOGGER.debug("addOrUpdateOrder() is executed!");
        if (order.isNew()) {
            orderService.addOrder(order);
            redirectAttributes.addFlashAttribute("msg", "Замовлення №" + order.getId()
                    + " додане до бази даних");
        } else {
            orderService.updateOrder(order);
            redirectAttributes.addFlashAttribute("msg", "Замовлення №" + order.getId()
                    + " оновлене у базі даних");
        }
        redirectAttributes.addFlashAttribute("css", "success");
        return "redirect:/";
    }

    @RequestMapping(value = "/order/{id}/update", method = RequestMethod.GET)
    public String updateOrder(@PathVariable("id") int id, Model model){
        LOGGER.debug("addOrUpdateOrder() is executed!");
        Order order = orderService.getOrderById(id);
        if(order.isOpen()) {
            model.addAttribute("orderForm", order);
            model.addAttribute("employees", orderService.getAllEmployee());
            return "app.add-update-order";
        } else{
            model.addAttribute("css", "warning");
            model.addAttribute("msg", "Закрите замовлення не можна редагувати");
            return "app.homepage";
        }
    }

    @RequestMapping(value = "/order/{id}/details", method = RequestMethod.GET)
    public String showOrderDetails(@PathVariable("id") int orderId, Model model){
        LOGGER.debug("showOrderDetails() is executed!");
        Order order = orderService.getOrderById(orderId);

        model.addAttribute("order", order);
        model.addAttribute("dishes", orderService.getDishesFromOrder(orderId));
        model.addAttribute("newDish", new PreparedDish());
        model.addAttribute("allDishes", orderService.getAllDishes());

        return "app.order-details";
    }
    @RequestMapping(value = "/order/{orderid}/dish/{dishid}/delete", method = RequestMethod.POST)
    public String deleteDishFromOrder(@PathVariable("orderid") int orderid,
                                      @PathVariable("dishid") int dishid,
                                      final RedirectAttributes redirectAttributes){
        LOGGER.debug("deleteDishFromOrder() is executed!");
        PreparedDish dish = orderService.getPreparedDishById(dishid);
        orderService.removePreparedDish(dish);
        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Страву видалено");

        return "redirect:/order/" + orderid + "/details";
    }

    @RequestMapping(value = "/order/{orderid}/dish/add", method = RequestMethod.POST)
    public String addDishToOrder(@PathVariable("orderid") int orderid,
                                 @ModelAttribute("newDish") PreparedDish newDish,
                                 final RedirectAttributes redirectAttributes){
        LOGGER.debug("addDishToOrder() is executed!");
        newDish.setOrderId(orderid);
        orderService.addPreparedDish(newDish);
        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Страву додано");

        return "redirect:/order/" + orderid + "/details";
    }

    @RequestMapping(value = "/order/{orderid}/dish/{dishkeyid}/update", method = RequestMethod.GET)
    public String updatePreparedDishForm(@PathVariable("orderid") int orderid,
                                     @PathVariable("dishkeyid") int dishid,
                                     Model model){
        LOGGER.debug("updatePreparedDish() is executed!");
        model.addAttribute("orderid", orderid);
        PreparedDish preparedDish = orderService.getPreparedDishById(dishid);
        model.addAttribute("preparedDish", preparedDish);
        model.addAttribute("dish", preparedDish.getDish());
        model.addAttribute("employees", orderService.getAllEmployee());

        return "app.prepared-dish";
    }

    @RequestMapping(value = "/order/prepareddish/update", method = RequestMethod.POST)
    public String updatePreparedDish(@ModelAttribute("preparedDish") PreparedDish preparedDish,
                                     final RedirectAttributes redirectAttributes){
        LOGGER.debug("updatePreparedDish() is executed!");

        orderService.updatePreparedDish(preparedDish);
        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Страву оновлено");

        return "redirect:/order/" + preparedDish.getOrderId() + "/details";
    }

    @RequestMapping(value = "/order/{orderid}/dish/{dishid}/prepared", method = RequestMethod.POST)
    public String setPreparedToPreparedDish(@PathVariable("orderid") int orderid,
                                            @PathVariable("dishid") int dishid,
                                            final RedirectAttributes redirectAttributes){
        LOGGER.debug("updatePreparedDish() is executed!");
        PreparedDish preparedDish = orderService.getPreparedDishById(dishid);
        orderService.setPreparedToDish(preparedDish);
        orderService.reduceIngredientsAmountFromPreparedDish(dishid);
        return "redirect:/order/" + orderid + "/details";
    }
    @RequestMapping(value = "/rest/order/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Order> getAllOrders(Model model){
        return orderService.getAllOrders();
    }

    @RequestMapping(value = "/rest/order/open", method = RequestMethod.GET)
    @ResponseBody
    public List<Order> getRestAllOpenOrders(Model model){
        return orderService.getAllOpenOrders();
    }

    @RequestMapping(value = "/rest/order/closed", method = RequestMethod.GET)
    @ResponseBody
    public List<Order> getRestAllClosedOrders(Model model){
        return orderService.getAllClosedOrders();
    }

    @RequestMapping(value = "/rest/order/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Order getRestOrderById(@PathVariable("id") int id, Model model){
        return orderService.getOrderById(id);
    }

}
