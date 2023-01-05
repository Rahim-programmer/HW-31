package kg.attractor.java;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

// используя статические imports
// мы импортируем *всё* из Collectors и Comparator.
// теперь нам доступны такие операции как
// toList(), toSet() и прочие, без указания уточняющего слова Collectors. или Comparator.
// вот так было до импорта Collectors.toList(), теперь стало просто toList()


import kg.attractor.java.homework.RestaurantOrders;
import kg.attractor.java.homework.domain.Item;
import kg.attractor.java.homework.domain.Order;

import java.util.MissingFormatArgumentException;

public class Main {

    public static void main(String[] args) {

        // это для домашки
        // выберите любое количество заказов, какое вам нравится.
        //var orders = RestaurantOrders.read("orders_1000.json").getOrders();
        // протестировать ваши методы вы можете как раз в этом файле (или в любом другом, в котором вам будет удобно)


//      Данный метод нужен для вывода всего Json файла.
        var restaurant = RestaurantOrders.read("orders_10_000.json");
        restaurant.printOrder();

//      Данный метод нужен для вывода количества заказчиков, (Пользователь сам ввод сколько заказчиков он хочет видеть).
//        var maxNOrders = restaurant.getNMaxOrders();
//        maxNOrders.forEach(Order::printOrder);

//      заказ на дом" наиболее малые.
//        var maxTotalHomeOrder = restaurant.getMaxMinHomeOrders(true);
//        maxTotalHomeOrder.printOrder();

//      метод возвращающий список из N заказов, имеющих наименьшую общую стоимость.
//        var minNOrders = restaurant.getNMinOrders();
//        minNOrders.forEach(Order::printOrder);

//      метод, который будет возвращать все заказы которые были оформлены с выдачей "на дом"
//        var homeOrders = restaurant.getHomeOrders();
//        homeOrders.forEach(Order::printOrder);

//      метод, который выбирать все заказы с общей суммой больше minOrderTotal = 45, и меньше maxOrderTotal = 80.
//        var ordersBetweenMinAndMaxTotal = restaurant.getOrderBetweenMinAndMaxTotal(45, 80);
//        ordersBetweenMinAndMaxTotal.forEach(Order::printOrder);

//      метод возвращающий общую стоимость всех заказов.
//        var totalSum = restaurant.getSumOfAllOrder();
//        System.out.println(totalSum);

//        отсортированный список уникальных адресов электронной почты для всех клиентов
//        var uniqueMails = restaurant.getUnidMails();
//        uniqueMails.forEach(System.out::println);

//        метод возвращающий список заказов, сгруппированных по имени заказчика.
//        var uniqueCustomers = restaurant.getUnudCustomer();
//        uniqueCustomers.forEach((k,v) -> {
//            k.buyerInformation();
//            v.forEach(Item::printItem);
//        });

        //      список уникальных заказчиков и общую сумму заказов для каждого из них
//        var uniqueCustomerAndTotalOrder = restaurant.getUnidCostomAndTotalOrder();
//        uniqueCustomerAndTotalOrder.forEach((k,v) -> {
//            k.buyerInformation();
//            System.out.printf("Общая сумма заказов: %s %2f\n",k, v);
//        });


//      заказ на дом" наиболее прибыльный
//        var minTotalHomeOrder = restaurant.getMaxMinHomeOrders(false);
//         minTotalHomeOrder.printOrder();

//        метод, который группирует "товары" по их общему количеству заказов.
//        var itemWithCountOrder = restaurant.getItemContOrder();
//        itemWithCountOrder.forEach((k, v) -> {
//            System.out.printf("Товар: %s, количество заказов этого товара: %s\n", k, v);
//        });

//        клиент с минимальной суммой всех его заказов
//        System.out.printf("Покупатель с минимальной общей стоимостью заказов: %s\n", restaurant.getCustomMinTotalOrders().getFullName());

//        клиент с максимальной суммой всех его заказов
//        System.out.printf("Покупатель с максимальной общей стоимостью заказов: %s\n", restaurant.getCustomMaxTotalOrders().getFullName());
    }

}
