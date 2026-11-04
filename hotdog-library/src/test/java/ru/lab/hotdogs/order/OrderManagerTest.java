
package ru.lab.hotdogs.order;

import org.junit.jupiter.api.Test;
import ru.lab.hotdogs.component.HotDogComponent;
import ru.lab.hotdogs.product.HunterDog;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderManagerTest {

    private HunterDog createHotDog() {
        return new HunterDog(
                List.of(
                        new HotDogComponent("Булочка", 2.0),
                        new HotDogComponent("Сосиска", 4.0)
                )
        );
    }

    private Order createOrder(double extraComponentPrice) {
        Order order = new Order();
        order.addHotDog(createHotDog());

        if (extraComponentPrice > 0) {
            order.addComponent(
                    new HotDogComponent(
                            "Дополнительный компонент",
                            extraComponentPrice
                    )
            );
        }

        return order;
    }

    @Test
    void emptyManagerHasZeroOrders() {
        OrderManager manager = new OrderManager();

        assertEquals(0, manager.getOrderCount());
    }

    @Test
    void emptyManagerHasZeroSales() {
        OrderManager manager = new OrderManager();

        assertEquals(0.0, manager.calculateTotalSales(), 0.001);
    }

    @Test
    void emptyManagerHasZeroAverageOrderCost() {
        OrderManager manager = new OrderManager();

        assertEquals(0.0, manager.calculateAverageOrderCost(), 0.001);
    }

    @Test
    void addOrderIncreasesOrderCount() {
        OrderManager manager = new OrderManager();
        manager.addOrder(createOrder(0.0));

        assertEquals(1, manager.getOrderCount());
    }

    @Test
    void calculateTotalSalesSumsAllOrders() {
        OrderManager manager = new OrderManager();
        manager.addOrder(createOrder(0.0)); // 6 рублей
        manager.addOrder(createOrder(2.0)); // 8 рублей

        assertEquals(14.0, manager.calculateTotalSales(), 0.001);
    }

    @Test
    void calculateCompleteOrderCountSumsHotDogs() {
        Order firstOrder = new Order();
        firstOrder.addHotDog(createHotDog());
        firstOrder.addHotDog(createHotDog());

        Order secondOrder = new Order();
        secondOrder.addHotDog(createHotDog());
        secondOrder.addComponent(
                new HotDogComponent("Кетчуп", 0.5)
        );

        OrderManager manager = new OrderManager();
        manager.addOrder(firstOrder);
        manager.addOrder(secondOrder);

        assertEquals(3, manager.calculateCompleteOrderCount());
    }

    @Test
    void calculateAverageOrderCostReturnsCorrectValue() {
        OrderManager manager = new OrderManager();
        manager.addOrder(createOrder(0.0)); // 6 рублей
        manager.addOrder(createOrder(2.0)); // 8 рублей

        assertEquals(7.0, manager.calculateAverageOrderCost(), 0.001);
    }

    @Test
    void addOrderRejectsNull() {
        OrderManager manager = new OrderManager();

        assertThrows(
                IllegalArgumentException.class,
                () -> manager.addOrder(null)
        );
    }
}
