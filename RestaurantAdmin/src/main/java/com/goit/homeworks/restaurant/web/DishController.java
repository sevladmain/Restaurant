package com.goit.homeworks.restaurant.web;

import com.goit.homeworks.restaurant.model.Category;
import com.goit.homeworks.restaurant.model.Dish;
import com.goit.homeworks.restaurant.services.DishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SeVlad on 10.11.2016.
 */
@Controller
public class DishController {
    private final Logger LOGGER = LoggerFactory.getLogger(DishController.class);
    @Autowired
    private DishService dishService;

    public DishService getDishService() {
        return dishService;
    }

    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }

    @RequestMapping(value = "/dish/all", method = RequestMethod.GET)
    public String getAllDishes(Map<String, Object> model) {

        LOGGER.info("getAllDishes() is executed!");
        model.put("dishes", dishService.getAllDishes());
        return "app.dishes";
    }

    @RequestMapping(value = "/dish/{id}/delete", method = RequestMethod.POST)
    public String deleteDish(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

        LOGGER.debug("deleteDish() is executed!");
        Dish dish = dishService.getDishById(id);
        dishService.deleteDish(dish);
        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Страва " + dish.getName()
                + " видалена з бази даних");
        return "redirect:/dish/all";
    }

    @RequestMapping(value = "/dish/add", method = RequestMethod.GET)
    public String showCreateDishForm(Model model) {
        LOGGER.debug("showCreateDishForm() is executed!");
        Dish dish = new Dish();

        model.addAttribute("dishForm", dish);
        populateCategories(model);
        return "app.add-update-dish";
    }

    private void populateCategories(Model model) {
        List<Category> categories = dishService.getAllCategories();
        model.addAttribute("categoriesList", categories);
    }

    @RequestMapping(value = "dish/added", method = RequestMethod.POST)
    public String saveOrUpdateDish(@ModelAttribute("dishForm") Dish dish, final RedirectAttributes redirectAttributes) {
        LOGGER.debug("saveOrUpdateDish() is executed!");
        if (dish.isNew()) {
            dishService.addDish(dish);
            redirectAttributes.addFlashAttribute("msg", "Страва " + dish.getName()
                    + " додана до бази даних");
        } else {
            dishService.updateDish(dish);
            redirectAttributes.addFlashAttribute("msg", "Страва " + dish.getName()
                    + " оновлена у базі даних");

        }
        redirectAttributes.addFlashAttribute("css", "success");
        return "redirect:/";
    }

    @RequestMapping(value = "/dish/{id}/update", method = RequestMethod.GET)
    public String showUpdateDishForm(@PathVariable("id") int id, Model model) {

        LOGGER.debug("showUpdateDishForm() : {}", id);

        Dish dish = dishService.getDishById(id);
        model.addAttribute("dishForm", dish);
        populateCategories(model);
        return "app.add-update-dish";
    }

    @RequestMapping(value = "dish/find", method = RequestMethod.GET)
    public String showFindDishForm(Model model) {
        LOGGER.debug("showFindDishForm() is executed!");
        model.addAttribute("findWhat", "DISH");
        populateCategories(model);
        return "app.find";
    }

    @RequestMapping(value = "dish/finded", method = RequestMethod.POST)
    public String showFindedEmployeesForm(@ModelAttribute("findString") String findString, Map<String, Object> model) {
        LOGGER.debug("showFindedEmployeesForm() is executed!", findString);
        model.put("dishes", dishService.findDishByName(findString));
        return "app.dishes";
    }

}
