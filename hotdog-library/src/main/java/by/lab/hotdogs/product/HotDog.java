
package by.lab.hotdogs.product;

import java.util.ArrayList;
import java.util.List;

import by.lab.hotdogs.component.HotDogComponent;

/**
 * Абстрактный класс, описывающий общий принцип устройства хот-дога.
 * Конкретные виды хот-догов наследуются от этого класса.
 */
public abstract class HotDog {
    private final String name;
    private final List<HotDogComponent> components;

    /**
     * Создает хот-дог с заданным названием и набором компонентов.
     *
     * @param name название хот-дога
     * @param components список компонентов хот-дога
     */
    protected HotDog(String name, List<HotDogComponent> components) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название хот-дога не должно быть пустым.");
        }
        if (components == null || components.isEmpty()) {
            throw new IllegalArgumentException("Хот-дог должен содержать компоненты.");
        }

        this.name = name;
        this.components = new ArrayList<>(components);
    }

    /**
     * Возвращает название хот-дога.
     *
     * @return название хот-дога
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает компоненты хот-дога.
     *
     * @return неизменяемый список компонентов
     */
    public List<HotDogComponent> getComponents() {
        return List.copyOf(components);
    }

    /**
     * Вычисляет стоимость хот-дога как сумму стоимости его компонентов.
     *
     * @return общая стоимость хот-дога
     */
    public double calculatePrice() {
        return components.stream()
                .mapToDouble(HotDogComponent::getPrice)
                .sum();
    }
}
