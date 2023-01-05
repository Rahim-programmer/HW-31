package kg.attractor.java.homework;

import com.google.gson.Gson;
import kg.attractor.java.homework.domain.Order;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

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
                System.out.println("Введите число N, чтобы получить N количество заказов имеющих самую маленькую стоимость N: ");
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

    public int tryParse(String nextLine) {
        return Integer.parseInt(nextLine);
    }
}
