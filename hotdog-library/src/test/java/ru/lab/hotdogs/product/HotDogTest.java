
package ru.lab.hotdogs.product;

import org.junit.jupiter.api.Test;

import by.lab.hotdogs.component.HotDogComponent;
import by.lab.hotdogs.product.HotDog;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HotDogTest {

    private HotDogComponent bun() {
        return new HotDogComponent("Булочка", 2.0);
    }

    private HotDogComponent sausage() {
        return new HotDogComponent("Сосиска", 4.0);
    }

    private HotDog createHotDog(List<HotDogComponent> components) {
        return new HotDog("Тестовый хот-дог", components) {};
    }

    @Test
    void constructorSetsNameCorrectly() {
        HotDog hotDog = createHotDog(List.of(bun(), sausage()));

        assertEquals("Тестовый хот-дог", hotDog.getName());
    }

    @Test
    void calculatePriceReturnsSumOfComponents() {
        HotDog hotDog = createHotDog(List.of(bun(), sausage()));

        assertEquals(6.0, hotDog.calculatePrice(), 0.001);
    }

    @Test
    void getComponentsReturnsAllComponents() {
        HotDog hotDog = createHotDog(List.of(bun(), sausage()));

        assertEquals(2, hotDog.getComponents().size());
    }

    @Test
    void getComponentsReturnsUnmodifiableList() {
        HotDog hotDog = createHotDog(List.of(bun(), sausage()));

        assertThrows(
                UnsupportedOperationException.class,
                () -> hotDog.getComponents().add(
                        new HotDogComponent("Кетчуп", 0.5)
                )
        );
    }

    @Test
    void constructorRejectsEmptyComponentList() {
        assertThrows(
                IllegalArgumentException.class,
                () -> createHotDog(List.of())
        );
    }

    @Test
    void constructorRejectsNullName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new HotDog(null, List.of(bun())) {}
        );
    }

    @Test
    void constructorRejectsNullComponentList() {
        assertThrows(
                IllegalArgumentException.class,
                () -> createHotDog(null)
        );
    }
}
