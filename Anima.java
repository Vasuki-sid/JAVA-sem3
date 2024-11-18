abstract class Animal {
  abstract void makeSound();
}

class Dog extends Animal {
  @Override
  void makeSound() {
      System.out.println("Woof!");
  }
}

class Cat extends Animal {
  @Override
  void makeSound() {
      System.out.println("Meow!");
  }
}

public class Anima {
  public static void main(String[] args) {
      Animal[] animals = new Animal[2];
      animals[0] = new Dog();
      animals[1] = new Cat();

      for (Animal animal : animals) {
          animal.makeSound();
      }
  }
}