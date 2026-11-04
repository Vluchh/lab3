package ru.lab.hotdogs;

import ru.lab.hotdogs.component.*;
import ru.lab.hotdogs.order.*;
import ru.lab.hotdogs.product.*;

import java.util.List;

/**
 * Демонстрирует работу системы учета продаж хот-догов.
 */
public class App {

    /**
     * Точка входа в приложение.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        // Создание компонентов
        HotDogComponent bun = new HotDogComponent("Булочка", 2.00);
        HotDogComponent sausage = new HotDogComponent("Сосиска", 4.00);
        HotDogComponent ketchup = new HotDogComponent("Кетчуп", 0.50);
        HotDogComponent mustard = new HotDogComponent("Горчица", 0.50);
        HotDogComponent cheese = new HotDogComponent("Сыр", 1.50);
        HotDogComponent bacon = new HotDogComponent("Бекон", 2.00);

        // Создание хот-догов разных видов
        HotDog hunterDog = new HunterDog(List.of(bun, sausage, ketchup, mustard));
        HotDog masterDog = new MasterDog(List.of(bun, sausage, cheese, bacon));
        HotDog berlinca = new Berlinca(List.of(bun, sausage, ketchup, cheese));

        // Вывод информации о хот-догах
        System.out.println("=== МЕНЮ ===");
        printHotDog(hunterDog);
        printHotDog(masterDog);
        printHotDog(berlinca);

        // Создание и учет заказов
        OrderManager manager = new OrderManager();

        Order order1 = new Order();
        order1.addHotDog(hunterDog);
        order1.addHotDog(masterDog);
        order1.addComponent(cheese);
        manager.addOrder(order1);

        Order order2 = new Order();
        order2.addHotDog(berlinca);
        order2.addComponent(ketchup);
        order2.addComponent(mustard);
        manager.addOrder(order2);

        Order order3 = new Order();
        order3.addHotDog(hunterDog);
        manager.addOrder(order3);

        // Вывод информации о заказах
        System.out.println("\n=== ЗАКАЗЫ ===");
        printOrder(1, order1);
        printOrder(2, order2);
        printOrder(3, order3);

        // Вывод общей статистики
        System.out.println("\n=== СТАТИСТИКА ПРОДАЖ ===");
        System.out.printf("Количество заказов: %d%n", manager.getOrderCount());
        System.out.printf("Общая сумма продаж: %.2f руб.%n",
                manager.calculateTotalSales());
        System.out.printf("Количество полных заказов: %d%n",
                manager.calculateCompleteOrderCount());
        System.out.printf("Средняя стоимость заказа: %.2f руб.%n",
                manager.calculateAverageOrderCost());
    }

    /**
     * Выводит информацию о хот-доге.
     *
     * @param hotDog хот-дог
     */
    private static void printHotDog(HotDog hotDog) {
        System.out.printf("%s: %.2f руб.%n",
                hotDog.getName(), hotDog.calculatePrice());

        System.out.println("  Состав:");
        for (HotDogComponent component : hotDog.getComponents()) {
            System.out.printf("    %s - %.2f руб.%n",
                component.getName(), component.getPrice());
        }
    }

    /**
     * Выводит информацию о заказе.
     *
     * @param number номер заказа
     * @param order заказ
     */
    private static void printOrder(int number, Order order) {
        System.out.printf(
                "Заказ №%d: сумма %.2f руб., целых хот-догов: %d, "
                        + "отдельных компонентов: %d%n",
                number,
                order.calculateTotal(),
                order.getHotDogCount(),
                order.getComponentCount()
        );
    }
}
