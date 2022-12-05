package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import web.model.Car;
import web.service.CarServiceImp;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarServiceImp carService;

    @GetMapping(value = "/cars/{number}")
    public String listCar(@PathVariable int number, ModelMap model) {
        System.out.println("Требуется показать машин " + number);
        List<Car> listCar = carService.listCar(number);
        System.out.println("В cars контроллер пришло машин " + listCar.size());
        model.addAttribute("listCar",listCar);
        return "cars";
    }

    @GetMapping(value = "/all")
    public String allListCar(ModelMap model) {
        List<Car> listCar = carService.listCar(5);
        System.out.println("В all контроллер пришло машин " + listCar.size());

        model.addAttribute("listCar",listCar);
        return "cars";
    }
}
