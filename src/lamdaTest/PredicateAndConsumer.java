package lamdaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumer {

	public static void main(String... args) {

		// 청포도, 보라포도, 적포도
		List<Grape> inventory = 
				Arrays.asList(new Grape(70, "green"), 
							  new Grape(90, "purple"), 
							  new Grape(120, "red"));

		// 1. Predicate 인터페이스 사용
		System.out.println("----- 1. Predicate 인터페이스 사용 -----");
		filter(inventory, grape -> grape.getWeight() >=100)
		.forEach(System.out::println);
		// result : Grape{color='red', weight=120}
		
		// 2. Consumer 인터페이스 사용
		System.out.println("----- 2. Consumer 인터페이스 사용 -----");
		printGrapeInfo(inventory, grape -> System.out.println(grape));
		// result : All List print
		
	}

	public static void printGrapeInfo(List<Grape> inventory, Consumer<Grape> consumer) {
		for (Grape grape : inventory) {
			consumer.accept(grape);
		}
	}
	
	public static List<Grape> filter(List<Grape> inventory, Predicate<Grape> p) {
		List<Grape> result = new ArrayList<>();
		for (Grape grape : inventory) {
			if (p.test(grape)) {
				result.add(grape);
			}
		}
		return result;
	}

}
