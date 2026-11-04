
package ru.lab.hotdogs.order;

import ru.lab.hotdogs.component.HotDogComponent;
import ru.lab.hotdogs.product.HotDog;

import java.util.ArrayList;
import java.util.List;

/**
 * Представляет заказ, содержащий целые хот-доги
 * и отдельно приобретенные компоненты.
 */
public class Order {
    private final List<HotDog> hotDogs;
    private final List<HotDogComponent> components;

    /**
     * Создает пустой заказ.
     */
    public Order() {
        hotDogs = new ArrayList<>();
        components = new ArrayList<>();
    }

    /**
     * Добавляет целый хот-дог в заказ.
     *
     * @param hotDog хот-дог
     */
    public void addHotDog(HotDog hotDog) {
        if (hotDog == null) {
            throw new IllegalArgumentException("Хот-дог не должен быть null.");
        }

        hotDogs.add(hotDog);
    }

    /**
     * Добавляет отдельно приобретаемый компонент в заказ.
     *
     * @param component компонент хот-дога
     */
    public void addComponent(HotDogComponent component) {
        if (component == null) {
            throw new IllegalArgumentException("Компонент не должен быть null.");
        }

        components.add(component);
    }

    /**
     * Рассчитывает общую стоимость заказа.
     *
     * @return общая стоимость всех товаров в заказе
     */
    public double calculateTotal() {
        double total = components.stream()
                .mapToDouble(HotDogComponent::getPrice)
                .sum();

        total += hotDogs.stream()
                .mapToDouble(HotDog::calculatePrice)
                .sum();

        return total;
    }

    /**
     * Возвращает количество целых хот-догов в заказе.
     *
     * @return количество полных заказов согласно принятому правилу
     */
    public int getCompleteOrderCount() {
        return hotDogs.size();
    }

    /**
     * Возвращает количество целых хот-догов в заказе.
     *
     * @return количество хот-догов
     */
    public int getHotDogCount() {
        return hotDogs.size();
    }

    /**
     * Возвращает количество отдельно приобретенных компонентов.
     *
     * @return количество компонентов
     */
    public int getComponentCount() {
        return components.size();
    }
}
