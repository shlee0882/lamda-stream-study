package lamdaTest;

import java.util.function.Supplier;

class Animal {
	public void eat() {
		System.out.println("Eating something");
	}
}

class Cat extends Animal {
	@Override
	public void eat() {
		System.out.println("Eating fish");
	}
}

public class SupplierTest {
	static void eatSomething(Supplier<? extends Animal> supplier) {
		Animal animal = supplier.get();
		animal.eat();
	}

	public static void main(String[] args) {
		// Using Lambda expression
		eatSomething(() -> new Animal());
		eatSomething(() -> new Cat());
		
		// Using Method Reference
		eatSomething(Animal::new);
		eatSomething(Cat::new);
	}
}