
package ru.lab.hotdogs.product;

import ru.lab.hotdogs.component.HotDogComponent;

import java.util.List;

/**
 * Представляет хот-дог типа MasterDog.
 */
public class MasterDog extends HotDog {

    /**
     * Создает MasterDog с заданными компонентами.
     *
     * @param components список компонентов хот-дога
     */
    public MasterDog(List<HotDogComponent> components) {
        super("MasterDog", components);
    }
}
