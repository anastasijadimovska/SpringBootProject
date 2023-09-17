package mk.ukim.finki.labwp.data;


import lombok.Data;
import mk.ukim.finki.labwp.model.Balloon;
import mk.ukim.finki.labwp.model.Manufacturer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Balloon> balloons = new ArrayList<>();
    public static List<Manufacturer> manufacturers = new ArrayList<>();
    @PostConstruct
    public void init(){


        Manufacturer m1 = new Manufacturer("Apple","USA","California Road");
        Manufacturer m2 = new Manufacturer("Samsung","Japan","Japan Road");
        Manufacturer m3 = new Manufacturer("Huawei","China","Chinese Road");
        Manufacturer m4 = new Manufacturer("Xiaomi","China","China Road");
        Manufacturer m5 = new Manufacturer("Acer","Australia","Australian Road");
        this.manufacturers.add(m1);
        this.manufacturers.add(m2);
        this.manufacturers.add(m3);
        this.manufacturers.add(m4);
        this.manufacturers.add(m5);
        this.balloons.add(new Balloon("Black","Black balloon",m1));
        this.balloons.add(new Balloon("White","White balloon",m1));
        this.balloons.add(new Balloon("Red","Red balloon",m2));
        this.balloons.add(new Balloon("Green","Green balloon",m2));
        this.balloons.add(new Balloon("Yellow","Yellow balloon",m3));
        this.balloons.add(new Balloon("Blue","Blue balloon",m3));
        this.balloons.add(new Balloon("Pink","Pink balloon",m4));
        this.balloons.add(new Balloon("Gray","Gray balloon",m4));
        this.balloons.add(new Balloon("Brown","Brown balloon",m5));
        this.balloons.add(new Balloon("Orange ","Orange balloon",m5));
    }

}
