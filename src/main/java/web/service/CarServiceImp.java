package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImp implements CarService {

    private final List<Car> makeCars = List.of(new Car(), new Car(), new Car(), new Car(), new Car());

    @Override
    public List<Car> listCar(Integer number) {
        number = number > 5 ? 5 : number;
        return makeCars.subList(0, number);
    }


}
