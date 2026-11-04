package ru.lab.hotdogs.component;

/**
 * Представляет отдельный компонент хот-дога, который можно продавать отдельно.
 */
public class HotDogComponent {
    private final String name;
    private final double price;

    /**
     * Создает компонент хот-дога.
     *
     * @param name название компонента
     * @param price цена компонента
     */
    public HotDogComponent(String name, double price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название компонента не должно быть пустым.");
        }
        if (price < 0 || !Double.isFinite(price)) {
            throw new IllegalArgumentException("Цена должна быть конечным неотрицательным числом.");
        }

        this.name = name;
        this.price = price;
    }

    /**
     * Возвращает название компонента.
     *
     * @return название компонента
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает цену компонента.
     *
     * @return цена компонента
     */
    public double getPrice() {
        return price;
    }
}
