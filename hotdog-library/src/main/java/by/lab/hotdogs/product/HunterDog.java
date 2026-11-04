
package ru.lab.hotdogs.product;

import ru.lab.hotdogs.component.HotDogComponent;

import java.util.List;

/**
 * Представляет хот-дог типа HunterDog.
 */
public class HunterDog extends HotDog {

    /**
     * Создает HunterDog с заданными компонентами.
     *
     * @param components список компонентов хот-дога
     */
    public HunterDog(List<HotDogComponent> components) {
        super("HunterDog", components);
    }
}
