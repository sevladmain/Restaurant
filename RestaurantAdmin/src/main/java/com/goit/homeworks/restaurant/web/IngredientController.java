package com.goit.homeworks.restaurant.web;

import com.goit.homeworks.restaurant.model.Ingredient;
import com.goit.homeworks.restaurant.services.IngredientService;
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

/**
 * Created by SeVlad on 19.11.2016.
 */
@Controller
public class IngredientController {
    private final Logger LOGGER = LoggerFactory.getLogger(IngredientController.class);

    @Autowired
    IngredientService ingredientService;

    public void setIngredientService(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @RequestMapping(value = "/ingredient/all", method = RequestMethod.GET)
    public String getAllIngredients(Model model) {
        LOGGER.debug("getAllIngredients()");

        model.addAttribute("ingredients", ingredientService.getAllIngredients());
        return "app.ingredients";
    }

    @RequestMapping(value = "/ingredient/{id}/delete", method = RequestMethod.POST)
    public String deleteIngredient(@PathVariable("id") int id,
                                   final RedirectAttributes redirectAttributes) {
        LOGGER.debug("deleteIngredient()");
        Ingredient ingredient = ingredientService.getIngredientById(id);
        ingredientService.deleteIngredient(ingredient);
        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Складова " + ingredient.getName() +
                " успішно видалена");

        return "redirect:/ingredient/all";
    }

    @RequestMapping(value = "ingredient/find", method = RequestMethod.GET)
    public String findIngredients(Model model){
        LOGGER.debug("findIngredients()");

        model.addAttribute("findWhat", "INGREDIENT");
        return "app.find";
    }

    @RequestMapping(value = "ingredient/finded", method = RequestMethod.POST)
    public String findedIngredients(@ModelAttribute("findString") String findString,
                                    Model model){
        LOGGER.debug("findedIngredients()");

        model.addAttribute("ingredients", ingredientService.findIngredientByName(findString));
        return "app.ingredients";
    }

    @RequestMapping(value = "ingredient/min", method = RequestMethod.GET)
    public String minIngredients(Model model){
        LOGGER.debug("minIngredients()");

        model.addAttribute("ingredients", ingredientService.getAllEndIngredients(20));
        return "app.ingredients";
    }

    @RequestMapping(value = "ingredient/add", method = RequestMethod.GET)
    public String addIngredientForm(Model model){
        LOGGER.debug("addIngredientForm()");

        model.addAttribute("ingredient", new Ingredient());
        return "app.add-update-ingredient";
    }

    @RequestMapping(value = "ingredient/{id}/update", method = RequestMethod.GET)
    public String updateIngredientForm(@PathVariable("id") int id, Model model){
        LOGGER.debug("updateIngredientForm()");

        model.addAttribute("ingredient", ingredientService.getIngredientById(id));
        return "app.add-update-ingredient";
    }

    @RequestMapping(value = "ingredient/added", method = RequestMethod.POST)
    public String saveOrUpdateIngredient(@ModelAttribute("ingredient") Ingredient ingredient,
                                       final RedirectAttributes redirectAttributes) {
        LOGGER.debug("saveOrUpdateIngredient() is executed!");
        if (ingredient.isNew()) {
            ingredientService.addIngredient(ingredient);
            redirectAttributes.addFlashAttribute("msg", "Складова " + ingredient.getName()
                    + " додана до бази даних");
        } else {
            ingredientService.updateIngredient(ingredient);
            redirectAttributes.addFlashAttribute("msg", "Складова " + ingredient.getName()
                    + " оновлена у базі даних");

        }
        redirectAttributes.addFlashAttribute("css", "success");
        return "redirect:/";
    }


}
