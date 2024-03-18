package web.services;

import org.springframework.stereotype.Service;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Override
    public List<Car> getCars(int showItems) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Lada", "Priora", 4));
        cars.add(new Car("Lada", "Granta", 4));
        cars.add(new Car("Lada", "Vesta", 4));
        cars.add(new Car("Honda", "Civik", 4));
        cars.add(new Car("Kia", "Rio", 4));
        return cars.subList(0, Math.min(showItems, cars.size()));
    }
}
