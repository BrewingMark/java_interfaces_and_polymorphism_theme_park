package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor1, visitor2, visitor3;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor1 = new Visitor(18,140.00, 45.00);
        visitor2 = new Visitor(18,203.00, 45.00);
        visitor3 = new Visitor(11,157.00, 45.00);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void visitorUnderTwoHundredCmChargedDefault(){
        assertEquals(8.40, rollerCoaster.priceFor(visitor1), 0.01);
    }

    @Test
    public void visitorOverTwoHundredCmChargedDouble(){
        assertEquals(16.80, rollerCoaster.priceFor(visitor2), 0.01);
    }

    @Test
    public void visitorIsAllowedIFOverHeightAndAge(){
        assertEquals(true, rollerCoaster.isAllowedTo(visitor2));
    }

    @Test
    public void visitorIsNotAllowedIfUnderHeight(){
        assertEquals(false, rollerCoaster.isAllowedTo(visitor1));
    }

    @Test
    public void visitorIsNotAllowedIfUnderAge(){
        assertEquals(false, rollerCoaster.isAllowedTo(visitor3));
    }

}
