
package ru.lab.hotdogs.product;

import ru.lab.hotdogs.component.HotDogComponent;

import java.util.List;

/**
 * Представляет хот-дог типа Berlinca.
 */
public class Berlinca extends HotDog {

    /**
     * Создает Berlinca с заданными компонентами.
     *
     * @param components список компонентов хот-дога
     */
    public Berlinca(List<HotDogComponent> components) {
        super("Berlinca", components);
    }
}
