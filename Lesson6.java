package java_1.lesson_6;

public class Lesson6 {

    public static void main(String[] args) {

        Cat cat = new Cat("Барсик");
        cat.run(150.0);
        cat.jump(1.5);
        cat.swim(3.0);

        Dog dog = new Dog("Черныш");
        dog.run(400.0);
        dog.jump(0.3);
        dog.swim(8.0);

        stringRepl(" Предложение один    Теперь предложение два     Предложение три");



    }

    // доп задание
    static void stringRepl(String s) {
        System.out.println(s);

        String str2 = s.replaceAll(" +", " ");
        System.out.println(str2);

        StringBuilder stringBuilder = new StringBuilder(str2);

        for(int i = 1; i < str2.length(); i++) {
            if(str2.charAt(i) >= 'A' && str2.charAt(i) <= 'Я') {
                stringBuilder.setCharAt(i-1, '.');
            }
        }

        System.out.println(stringBuilder.toString());



    }
}


abstract class Animal {

    public abstract void run(double len);
    public abstract void jump(double height);
    public abstract  void swim(double len);

}

class Cat extends Animal {

    final double lenRun = 200.0;
    final double heightJump = 2.0;
    private String name;

    Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }



    @Override
    public void run(double len) {
        if (len > lenRun) {
            System.out.println(getName() + " run:false");
        } else {
            System.out.println(getName() + " run:true");
        }
    }

    @Override
    public void jump(double height) {
        if(height > heightJump) {
            System.out.println(getName() + " jump:false");
        } else {
            System.out.println(getName() + " jump:true");
        }

    }

    @Override
    public void swim (double len) {
        System.out.println(getName() +" swim:false");
    }

}

class Dog extends Animal {

    final double lenRun = 500.0;
    final double heightJump = 0.5;
    final double lenSwim = 10.0;

    private String name;

    Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public void run(double len) {
        if (len > lenRun) {
            System.out.println(getName() + " run:false");
        } else {
            System.out.println(getName() +" run:true");
        }
    }

    @Override
    public void jump(double height) {
        if(height > heightJump) {
            System.out.println(getName() + " jump:false");
        } else {
            System.out.println(getName() + " jump:true");
        }

    }

    @Override
    public void swim (double len) {
        if (len > lenSwim) {
        System.out.println(getName() +" swim:false");
        } else {
            System.out.println(getName() + " swim: true");
        }
    }

}



