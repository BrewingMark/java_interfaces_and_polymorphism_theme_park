package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class RollerCoaster  extends Attraction implements ITicketed, ISecurity {

    public RollerCoaster(String name, int rating) {
        super(name, rating);
    }

    public double defaultPrice(){
        return 8.40;
    }

    public double priceFor(Visitor visitor){
        if (visitor.getHeight() > 200.00){
            return defaultPrice() * 2;
        } else
            return defaultPrice();
    }

    public boolean isAllowedTo(Visitor visitor){
        if (visitor.getHeight() > 145.00 & visitor.getAge() > 12){
            return true;
        } return false;
    }
}
