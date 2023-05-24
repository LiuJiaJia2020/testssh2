import java.util.*;

public class ElevatorController {
    private List<Elevator> elevators;
    private List<Floor> floors;

    public ElevatorController() {
        // 初始化3部电梯和30层楼层
        elevators = new ArrayList<Elevator>();
        elevators.add(new Elevator(1, 3));
        elevators.add(new Elevator(16, 16));
        elevators.add(new Elevator(9, 9));
        floors = new ArrayList<Floor>();
        for (int i = 1; i <= 30; i++) {
            floors.add(new Floor(i));
        }
    }

    public void run() {
        // 每秒钟更新一次电梯和楼层的状态
        while (true) {
            for (Elevator elevator : elevators) {
                elevator.updateStatus();
            }
            for (Floor floor : floors) {
                floor.updateStatus();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void addRequest(int floorNumber, Direction direction) {
        // 处理电梯外部的请求
        Floor floor = floors.get(floorNumber - 1);
        floor.addRequest(direction);
        System.out.println("Add request from floor " + floorNumber + ", direction: " + direction);
    }

    public synchronized void addPassenger(int elevatorNumber, Passenger passenger) {
        // 处理电梯内部的请求
        Elevator elevator = elevators.get(elevatorNumber - 1);
        elevator.addPassenger(passenger);
        System.out.println("Add passenger to elevator " + elevatorNumber + ": " + passenger);
    }

    public synchronized void removePassenger(int elevatorNumber, Passenger passenger) {
        // 处理电梯内部的请求
        Elevator elevator = elevators.get(elevatorNumber - 1);
        elevator.removePassenger(passenger);
        System.out.println("Remove passenger from elevator " + elevatorNumber + ": " + passenger);
    }

    public static void main(String[] args) {
        // 启动电梯控制器
        ElevatorController controller = new ElevatorController();
        Thread thread = new Thread(controller::run);
        thread.start();
    }
}

class Elevator {
    private int current
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeliverySystem {
    private Map<String, User> users;
    private Map<String, Order> orders;
    private Map<String, Courier> couriers;

    public DeliverySystem() {
        users = new HashMap<>();
        orders = new HashMap<>();
        couriers = new HashMap<>();
    }

    public void addUser(String name, String address, String phone) {
        User user = new User(name, address, phone);
        users.put(phone, user);
    }

    public void addOrder(String userPhone, String destination, double weight) {
        User user = users.get(userPhone);
        if (user == null) {
            throw new IllegalArgumentException("Invalid user phone number");
        }
        Order order = new Order(user, destination, weight);
        orders.put(order.getId(), order);
    }

    public void assignOrder(String courierPhone, String orderId) {
        Courier courier = couriers.get(courierPhone);
        if (courier == null) {
            throw new IllegalArgumentException("Invalid courier phone number");
        }
        Order order = orders.get(orderId);
        if (order == null) {
            throw new IllegalArgumentException("Invalid order ID");
        }
        courier.addOrder(order);
    }

    public List<Order> listOrders(String courierPhone) {
        Courier courier = couriers.get(courierPhone);
        if (courier == null) {
            throw new IllegalArgumentException("Invalid courier phone number");
        }
        return courier.getOrders();
    }

    public void addCourier(String name, String phone) {
        Courier courier = new Courier(name, phone);
        couriers.put(phone, courier);
    }

    public static void main(String[] args) {
        DeliverySystem deliverySystem = new DeliverySystem();
        deliverySystem.addUser("Alice", "123 Main St", "555-1234");
        deliverySystem.addUser("Bob", "456 Second St", "555-5678");
        deliverySystem.addOrder("555-1234", "789 Third St", 10.0);
        deliverySystem.addOrder("555-5678", "234 Fourth St", 5.0);
        deliverySystem.addCourier("Charlie", "555-9999");
        deliverySystem.assignOrder("555-9999", "1");
        System.out.println(deliverySystem.listOrders("555-9999"));
    }
}

class User {
    private String name;
    private String address;
    private String phone;

    public User(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}

class Order {
    private static int count = 1;
    private int id;
    private User user;
    private String destination;
    private double weight;

    public Order(User user, String destination, double weight) {
        this.id = count++;
        this.user = user;
        this.destination
