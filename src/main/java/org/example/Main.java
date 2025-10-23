package java.org.example;

public class Main {


    public static void main(String[] args) {

        // --- Проверка Задания 1 (Animal) ---
        System.out.println("--- Задание 1: Animal ---");
        Animal myDog = new Dog("Buddy");
        Animal myCat = new Cat("Whiskers");
        System.out.println(myDog.getName() + " says: " + myDog.makeSound());
        System.out.println(myCat.getName() + " says: " + myCat.makeSound());

        // --- Проверка Задания 2 (Movable) ---
        System.out.println("\n--- Задание 2: Movable ---");
        Movable p = new Point(10, 20); // Создаем Point
        System.out.println("Начальная позиция: X=" + p.getX() + ", Y=" + p.getY());
        p.moveTo(50, 100); // Двигаем точку
        System.out.println("Конечная позиция: X=" + p.getX() + ", Y=" + p.getY());

        // --- Проверка Задания 3 (Smartphone) ---
        System.out.println("\n--- Задание 3: Smartphone ---");
        Smartphone myPhone = new Smartphone();
        myPhone.makeCall();
        myPhone.receiveCall();
        double[] coords = myPhone.getCoordinates();
        System.out.println("Coordinates: " + coords[0] + ", " + coords[1]);

        // --- Проверка Задания 4 (Car) ---
        System.out.println("\n--- Задание 4: Car ---");
        Car car1 = new Car(20000, 2018, 150);
        Car car2 = new Car(15000, 2020, 180);
        // car2 "больше" car1, т.к. дешевле (15000 < 20000) -> вернет > 0
        System.out.println("car2 vs car1: " + car2.compareTo(car1));

        // --- Проверка Задания 5 (Shape) ---
        System.out.println("\n--- Задание 5: Shape ---");
        // Создаем фигуры (это пример для Задания 5)
        Shape s1 = new Circle("Red", 10.0);
        Shape s2 = new Rectangle("Blue", 5, 10);
        s1.draw();
        System.out.println("Площадь круга: " + s1.getArea());
        s2.draw();
        System.out.println("Площадь прямоугольника: " + s2.getArea());
    }
}

// -------------------------------------------------------------------
// ЗАДАНИЕ 1 (БЕЗ 'public')
// -------------------------------------------------------------------
abstract class Animal {
    private String name;
    public Animal(String name) { this.name = name; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    abstract String makeSound();
}

class Dog extends Animal {
    public Dog(String name) { super(name); }
    @Override
    String makeSound() { return "Woof-woof!"; }
}

class Cat extends Animal {
    public Cat(String name) { super(name); }
    @Override
    String makeSound() { return "Meow!"; }
}

// -------------------------------------------------------------------
// ЗАДАНИЕ 2 (БЕЗ 'public')
// -------------------------------------------------------------------
interface Movable {
    void setX(double x);
    void setY(double y);
    double getX();
    double getY();
    void moveTo(double x, double y);
}

class Point implements Movable {
    private double x;
    private double y;
    public Point(double x, double y) { this.x = x; this.y = y; }
    @Override
    public void setX(double x) { this.x = x; }
    @Override
    public void setY(double y) { this.y = y; }
    @Override
    public double getX() { return x; }
    @Override
    public double getY() { return y; }
    @Override
    public void moveTo(double x, double y) { this.setX(x); this.setY(y); }
}

// -------------------------------------------------------------------
// ЗАДАНИЕ 3 (БЕЗ 'public')
// -------------------------------------------------------------------
interface GPS {
    double[] getCoordinates();
}

interface Cellular {
    void makeCall();
    void receiveCall();
}

class Smartphone implements GPS, Cellular {
    @Override
    public double[] getCoordinates() { return new double[]{46.4825, 30.7233}; }
    @Override
    public void makeCall() { System.out.println("Making a call..."); }
    @Override
    public void receiveCall() { System.out.println("Receiving an incoming call..."); }
}

// -------------------------------------------------------------------
// ЗАДАНИЕ 4 (БЕЗ 'public')
// -------------------------------------------------------------------
class Car implements Comparable {
    private int price;
    private int year;
    private int horsePower;
    public Car(int price, int year, int horsePower) {
        this.price = price;
        this.year = year;
        this.horsePower = horsePower;
    }
    @Override
    public int compareTo(Object o) {
        Car other = (Car) o;
        if (this.price != other.price) {
            return other.price - this.price; // Обратный порядок
        }
        if (this.year != other.year) {
            return this.year - other.year; // Прямой порядок
        }
        return this.horsePower - other.horsePower; // Прямой порядок
    }
    // Геттеры
    public int getPrice() { return price; }
    public int getYear() { return year; }
    public int getHorsePower() { return horsePower; }
}

// -------------------------------------------------------------------
// ЗАДАНИЕ 5 (БЕЗ 'public')
// -------------------------------------------------------------------
abstract class Shape {
    protected String color;
    public Shape(String color) { this.color = color; }
    abstract void draw();
    abstract double getArea();
}

// Пример реализации для Задания 5 (из твоей Лабы 4)
class Circle extends Shape {
    private double radius;
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    @Override
    void draw() { System.out.println("Drawing a " + color + " circle."); }
    @Override
    double getArea() { return Math.PI * radius * radius; }
}

class Rectangle extends Shape {
    private double width, height;
    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }
    @Override
    void draw() { System.out.println("Drawing a " + color + " rectangle."); }
    @Override
    double getArea() { return width * height; }
}