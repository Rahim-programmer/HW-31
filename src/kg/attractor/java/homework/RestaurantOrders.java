package kg.attractor.java.homework;

import com.google.gson.Gson;
import kg.attractor.java.homework.domain.Customer;
import kg.attractor.java.homework.domain.Item;
import kg.attractor.java.homework.domain.Order;

import javax.print.attribute.standard.OrientationRequested;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.flatMapping;

public class RestaurantOrders {
    // Этот блок кода менять нельзя! НАЧАЛО!
    private List<Order> orders;

    private RestaurantOrders(String fileName) {
        var filePath = Path.of("data", fileName);
        Gson gson = new Gson();
        try {
            orders = List.of(gson.fromJson(Files.readString(filePath), Order[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static RestaurantOrders read(String fileName) {
        var ro = new RestaurantOrders(fileName);
        ro.getOrders().forEach(Order::calculateTotal);
        return ro;
    }

    public List<Order> getOrders() {
        return orders;
    }
    // Этот блок кода менять нельзя! КОНЕЦ!

    //----------------------------------------------------------------------
    //------   Реализация ваших методов должна быть ниже этой линии   ------
    //----------------------------------------------------------------------

    // Наполните этот класс решением домашнего задания.
    // Вам необходимо создать все необходимые методы
    // для решения заданий из домашки:)
    // вы можете добавлять все необходимые imports
    //


    public void printOrder() {
        orders.forEach(Order::printOrder);
    }

    public List<Order> getNMaxOrders() {
        Scanner scanner = new Scanner(System.in);
        int maxN;
        while (true) {
            try {
                System.out.println("\nВведите число N, чтобы получить N количество заказов имеющих самую маленькую стоимость N: ");
                maxN = tryParse(scanner.nextLine());
            } catch (Exception ex) {
                System.out.println("Введите число:");
                continue;
            }
            break;


        }
        return orders.stream()
                .sorted(Comparator.comparingDouble(Order::getTotal).reversed())
                .limit(maxN)
                .collect(toList());
    }
    public List<Order> getNMinOrders() {
        Scanner sc = new Scanner(System.in);
        int minN;
        while (true) {
            try {
                System.out.print("Введите число N, чтобы увидеть N количество заказов имеющих наименьшую общую стоимость. N: ");
                minN = tryParse(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Введите число!");
                continue;
            }
            break;

        }
        return orders.stream()
                .sorted(comparingDouble(Order::getTotal))
                .limit(minN)
                .collect(toList());
    }




    public int tryParse(String nextLine) {
        return Integer.parseInt(nextLine);
    }


    public List<Order> getHomeOrders() {
        return orders.stream()
                .filter(Order::isHomeDelivery)
                .collect(toList());
    }

    public Order getMaxMinHomeOrders(boolean max) {
        if (max) {
            return getHomeOrders().stream()
                    .max(Comparator.comparingDouble(Order::getTotal))
                    .get();
        } else {
            return getHomeOrders().stream()
                    .min(Comparator.comparingDouble(Order::getTotal))
                    .get();
        }
    }

    public List<Order> getOrderBetweenMinAndMaxTotal(double minOrderTotal, double maxOrderTotal) {
        return orders.stream()
                .sorted(comparingDouble(Order::getTotal))
                .dropWhile(total -> total.getTotal() < minOrderTotal)
                .takeWhile(total -> total.getTotal() <= maxOrderTotal)
                .collect(toList());
    }

    public double getSumOfAllOrder() {
        return orders.stream()
                .mapToDouble(Order::getTotal)
                .sum();
    }

    public Collection<String> getUnidMails() {
        return orders.stream()
                .map(order -> order.getCustomer().getEmail())
                .collect(toCollection(TreeSet::new));
    }


    public Map<Customer, List<Item>> getUnudCustomer() {
        return orders.stream()
                .collect(groupingBy(Order::getCustomer, flatMapping(order -> order.getItems().stream(),
                        toList())));
    }

    public Map<Customer, Double> getUnidCostomAndTotalOrder() {
        return orders.stream()
                .collect(groupingBy(Order::getCustomer, summingDouble(Order::getTotal)));
    }

    public Customer getCustomMaxTotalOrders() {
        return getUnidCostomAndTotalOrder().entrySet().stream().max((expression1, expression2) -> expression1.getValue() > expression2.getValue() ? 1 : -1).get().getKey();
    }

    public Customer getCustomMinTotalOrders() {
        return getUnidCostomAndTotalOrder().entrySet().stream().min((expression1, expression2) -> expression1.getValue() > expression2.getValue() ? 1 : -1).get().getKey();
    }

    public Map<String, Long> getItemContOrder() {
        return orders.stream()
                .flatMap(e -> e.getItems().stream())
                .collect(groupingBy(Item::getName, counting()));
    }
}

















