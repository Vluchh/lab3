
package ru.lab.hotdogs.component;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotDogComponentTest {

    @Test
    void constructorSetsNameAndPrice() {
        HotDogComponent component =
                new HotDogComponent("Сосиска", 4.0);

        assertEquals("Сосиска", component.getName());
        assertEquals(4.0, component.getPrice(), 0.001);
    }

    @Test
    void constructorRejectsEmptyName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new HotDogComponent(" ", 4.0)
        );
    }

    @Test
    void constructorRejectsNegativePrice() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new HotDogComponent("Сосиска", -1.0)
        );
    }

    @Test
    void constructorRejectsNullName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new HotDogComponent(null, 4.0)
        );
    }

    @Test
    void constructorRejectsInfinitePrice() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new HotDogComponent(
                        "Сосиска",
                        Double.POSITIVE_INFINITY
                )
        );
    }
}
