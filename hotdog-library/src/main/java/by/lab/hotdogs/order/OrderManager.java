
package ru.lab.hotdogs.order;

import java.util.ArrayList;
import java.util.List;

/**
 * Управляет заказами и рассчитывает статистику продаж.
 */
public class OrderManager {
    private final List<Order> orders;

    /**
     * Создает менеджер с пустым списком заказов.
     */
    public OrderManager() {
        orders = new ArrayList<>();
    }

    /**
     * Добавляет заказ в систему учета.
     *
     * @param order заказ для добавления
     */
    public void addOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Заказ не должен быть null.");
        }

        orders.add(order);
    }

    /**
     * Рассчитывает общую сумму всех заказов.
     *
     * @return общая выручка
     */
    public double calculateTotalSales() {
        return orders.stream()
                .mapToDouble(Order::calculateTotal)
                .sum();
    }

    /**
     * Подсчитывает количество целых хот-догов во всех заказах.
     *
     * @return общее количество полных заказов
     */
    public int calculateCompleteOrderCount() {
        return orders.stream()
                .mapToInt(Order::getCompleteOrderCount)
                .sum();
    }

    /**
     * Рассчитывает среднюю стоимость одного заказа.
     *
     * @return средняя стоимость заказа или 0, если заказов нет
     */
    public double calculateAverageOrderCost() {
        if (orders.isEmpty()) {
            return 0.0;
        }

        return calculateTotalSales() / orders.size();
    }

    /**
     * Возвращает количество зарегистрированных заказов.
     *
     * @return количество заказов
     */
    public int getOrderCount() {
        return orders.size();
    }
}
