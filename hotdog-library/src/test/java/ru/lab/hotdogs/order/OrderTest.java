
package ru.lab.hotdogs.order;

import org.junit.jupiter.api.Test;
import ru.lab.hotdogs.component.HotDogComponent;
import ru.lab.hotdogs.product.HunterDog;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private HotDogComponent bun() {
        return new HotDogComponent("Булочка", 2.0);
    }

    private HotDogComponent sausage() {
        return new HotDogComponent("Сосиска", 4.0);
    }

    private HunterDog createHotDog() {
        return new HunterDog(List.of(bun(), sausage()));
    }

    @Test
    void emptyOrderHasZeroTotal() {
        Order order = new Order();

        assertEquals(0.0, order.calculateTotal(), 0.001);
    }

    @Test
    void addHotDogIncreasesTotal() {
        Order order = new Order();
        order.addHotDog(createHotDog());

        assertEquals(6.0, order.calculateTotal(), 0.001);
    }

    @Test
    void addComponentIncreasesTotal() {
        Order order = new Order();
        order.addComponent(bun());

        assertEquals(2.0, order.calculateTotal(), 0.001);
    }

    @Test
    void calculateTotalIncludesHotDogsAndComponents() {
        Order order = new Order();
        order.addHotDog(createHotDog());
        order.addComponent(bun());

        assertEquals(8.0, order.calculateTotal(), 0.001);
    }

    @Test
    void getHotDogCountReturnsNumberOfHotDogs() {
        Order order = new Order();
        order.addHotDog(createHotDog());
        order.addHotDog(createHotDog());

        assertEquals(2, order.getHotDogCount());
    }

    @Test
    void getCompleteOrderCountReturnsNumberOfHotDogs() {
        Order order = new Order();
        order.addHotDog(createHotDog());
        order.addComponent(bun());

        assertEquals(1, order.getCompleteOrderCount());
    }

    @Test
    void getComponentCountReturnsSeparatelyPurchasedComponents() {
        Order order = new Order();
        order.addComponent(bun());
        order.addComponent(sausage());

        assertEquals(2, order.getComponentCount());
    }

    @Test
    void addHotDogRejectsNull() {
        Order order = new Order();

        assertThrows(
                IllegalArgumentException.class,
                () -> order.addHotDog(null)
        );
    }

    @Test
    void addComponentRejectsNull() {
        Order order = new Order();

        assertThrows(
                IllegalArgumentException.class,
                () -> order.addComponent(null)
        );
    }
}
