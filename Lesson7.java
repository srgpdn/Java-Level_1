package java_1.lesson_7;

public class Lesson7 {

    public static void main(String[] args) {
        String yes = "да";
        String no = "нет";

        //5
        Cat[] cat = {new Cat("Barsik", 5),
                     new Cat("Semen", 12),
                     new Cat("Whiter", 80),
                     new Cat("Dina", 15)};
        Plate plate = new Plate(100);
        plate.info();
        for (Cat c : cat) {
            c.eat(plate);

            System.out.println(c.getName() + " сыт? " + (c.getIsFull() == true ? yes : no));
        }
        plate.info();
        plate.addFood(20);
        plate.info();

    }
}

class Plate {

    private int food;

    public Plate(int food) {

        this.food = food;
    }

    public void decreaseFood(int n) {
        food -= n;
    }

    public void info() {
        System.out.println("plate: " + food);
    }


    int getFood() { // 2 задание
        return food;
    }


    void addFood(int addFood) { // 6 задание
        food += addFood;
    }

}

class Cat {

    private String name;

    private int appetite;

    private boolean isFull; //3

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        isFull = false;
    }

    public void eat(Plate p) { // 2 задание

        //4.
        if (p.getFood() >= appetite) {
            p.decreaseFood(appetite);
            isFull = true;
        } else {
            System.out.println(name + " есть не стал не хватает еды");
            isFull = false;
        }
    }

    boolean getIsFull() {
        return isFull;
    }

    String getName() {
        return name;
    }
}

