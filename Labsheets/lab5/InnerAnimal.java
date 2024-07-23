interface Animal {
    void eat();

    void makeSound();
}

interface Swim {
    default void swim() {
        System.out.println("Swimming...");
    }
}

interface Fly {
    default void fly() {
        System.out.println("Flying...");
    }
}

class Fish implements Animal, Swim {
    public void eat() {
        System.out.println("Eating...");
    }

    public void makeSound() {
        System.out.println("Making sound...");
    }

    public void breathe() {
        System.out.println("Breathing underwater...");
    }
}

class Bird implements Animal, Fly {
    public void eat() {
        System.out.println("Eating...");
    }

    public void makeSound() {
        System.out.println("Making sound...");
    }

    public void lay() {
        System.out.println("Laying eggs...");
    }

}

public class InnerAnimal {
    public static void main(String[] args) {
        Fish fish = new Fish();
        System.out.println("Fish");
        fish.eat();
        fish.makeSound();
        fish.swim();
        fish.breathe();

        Bird bird = new Bird();
        System.out.println("Bird");
        bird.eat();
        bird.makeSound();
        bird.fly();
        bird.lay();
    }
}