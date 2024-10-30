// Определение базового класса Building
class Building {
    private double height;
    private double baseLength;  //длина основания
    private double baseWidth;  //ширина основания

    // Конструктор по умолчанию
    public Building() {
    }


    public Building(double baseLength, double baseWidth) {
        this.baseLength = baseLength;
        this.baseWidth = baseWidth;
    }

    // Конструктор, принимающий параметры для всех полей.
    public Building(double height, double baseLength, double baseWidth) {
        // Вызов конструктора с двумя параметрами.
        this (height, baseLength);
        this.baseWidth = baseWidth;
    }



    public double getHeight() {
        return height;
    }

    public double getBaseLength() {
        return baseLength;
    }

    public double getBaseWidth() {
        return baseWidth;
    }

    public double calculateVolume() {
        return this.baseLength * this.baseWidth * this.height;
    }

    // Метод вычисляет площадь поверхности здания.
    public double calculateSurfaceArea() {
        return 2 * (this.baseLength * this.baseWidth + this.baseLength * this.height + this.baseWidth * this.height);
    }
}

class Room extends Building {
    private boolean hasWindows;
    private int numberOfDoors;

    // Конструктор, принимающий параметры для всех полей
    public Room(double height, double baseLength, double baseWidth, boolean hasWindows, int numberOfDoors) {
        super(height, baseLength, baseWidth); // Вызываем конструктор базового класса с параметрами
        this.hasWindows = hasWindows;
        this.numberOfDoors = numberOfDoors;
    }

    public Room(double height, double baseLength, double baseWidth, boolean hasWindows) {
        super(height, baseLength, baseWidth);
        this.hasWindows = hasWindows;
    }

    public double calculateSurfaceAreaAB() {
        return super.calculateSurfaceArea(); // Используем super для вызова метода родительского класса
    }

    public double calculatePerimeter() {
        return 2 * (super.getBaseLength() + super.getBaseWidth()); // Используем super для обращения к полям родительского класса
    }

    public void displayRoomInfo() {
        System.out.println("Room dimensions: " + super.getBaseLength() + "x" + super.getBaseWidth() + "x" + super.getHeight()); // Используем super для обращения к полям родительского класса
        System.out.println("Has windows: " + this.hasWindows);
        System.out.println("Number of doors: " + this.numberOfDoors);
    }
}

public class Main {
    public static void main(String[] args) {
        // а)Создание объекта Building с использованием конструктора с параметрами
        Building building = new Building(275.0, 300.0, 120.0);

        // Вызов методов объекта Building
        double volume = building.calculateVolume();
        double surfaceArea = building.calculateSurfaceArea();
        System.out.println();

        System.out.println(">>Building dimensions:<<");
        System.out.println("--------->>>Height: " + building.getHeight());
        System.out.println("--------->>>Base Length: " + building.getBaseLength());
        System.out.println("--------->>>Base Width: " + building.getBaseWidth());
        System.out.println("Volume: " + volume);
        System.out.println("Surface Area: " + surfaceArea);
        System.out.println();


        // с)Создание объекта Room с использованием конструктора производного класса Room
        Room room1 = new Room(3.0, 5.0, 4.0, true, 1);

        // Вызов методов объекта Room
        double volume2 = room1.calculateVolume();
        double surfaceArea2 = room1.calculateSurfaceArea();

        System.out.println("Room dimensions:");
        System.out.println("--------->>>Height: " + room1.getHeight());
        System.out.println("--------->>>Base Length: " + room1.getBaseLength());
        System.out.println("--------->>>Base Width: " + room1.getBaseWidth());
        System.out.println("Volume: " + volume2);
        System.out.println("Surface Area: " + surfaceArea2);
        room1.displayRoomInfo();
        System.out.println();

        //б)Объект производного класса, используя конструктор базового класса;
        Building building2 = new Room(4.0, 5.0, 5.0, true, 2); // Создание объекта производного класса Room и присвоение его переменной базового класса Building
        Room room2 = (Room) building2; // Приведение типа объекта building2 к типу Room

        // Вызов методов объекта Room
        double volume3 = room2.calculateVolume();
        double surfaceArea1 = room2.calculateSurfaceArea();
        double surfaceAreaAB = room2.calculateSurfaceAreaAB();
        double perimeter = room2.calculatePerimeter();

        // Вывод результатов
        System.out.println("Room dimensions:");
        System.out.println("--------->>>Height: " + room2.getHeight());
        System.out.println("--------->>>Base Length: " + room2.getBaseLength());
        System.out.println("--------->>>Base Width: " + room2.getBaseWidth());
        System.out.println("Volume: " + volume3);
        System.out.println("Surface Area: " + surfaceArea1);
        System.out.println("Surface Area AB: " + surfaceAreaAB);
        System.out.println("Perimeter: " + perimeter);
        room2.displayRoomInfo();
        System.out.println();

        //д) Создание объекта базового класса Building с использованием конструктора производного класса Room
        Room room3 = new Room(3.0, 5.0, 4.0, true, 3);
        Building building1 = room3; // Приведение типа

        double volume4 = building1.calculateVolume();
        double surfaceArea4 = building1.calculateSurfaceArea();

        // Вывод информации о созданном объекте Building
        System.out.println("Building dimensions:");
        System.out.println("--------->>>Height: " + building1.getHeight());
        System.out.println("--------->>>Base Length: " + building1.getBaseLength());
        System.out.println("--------->>>Base Width: " + building1.getBaseWidth());
        System.out.println("Volume: " + volume4);
        System.out.println("Surface Area: " + surfaceArea4);
    }
}
