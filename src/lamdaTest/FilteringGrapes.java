package lamdaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilteringGrapes {

	public static void main(String... args) {

		// 청포도, 보라포도, 적포도
		List<Grape> inventory = 
				Arrays.asList(new Grape(70, "green"), 
							  new Grape(90, "purple"), 
							  new Grape(120, "red"));

		
		//filter method 호출
		// 1. 익명클래스 
		filter(inventory,new GrapePredicate() {
			@Override
			public boolean test(Grape a) {
				return a.getColor().equals("green");
			}
		}).forEach((abc) -> System.out.println(abc));
		// result : Grape{color='green', weight=70}
		
		// 2. 람다식
		filter(inventory, abc -> abc.getColor().equals("purple"))
		.forEach(System.out::println);
		// result : Grape{color='purple', weight=90}
		
		// 3. Predicate API 사용
		filter2(inventory, grape -> grape.getWeight() >=100)
		.forEach(System.out::println);
		// result : Grape{color='red', weight=120}
		
		// Consumer type을 람다식으로 호출
		System.out.println("---------------------------------");
		printGrapeInfo(inventory, grape -> System.out.println(grape));
		printGrapeInfo(inventory, System.out::println);
		// result : All List print
		

		// 4. 람다식 사용한 필터링 
		List<Grape> greenGrapes = filter(inventory, (Grape a) -> "green".equals(a.getColor()));
		System.out.println(greenGrapes);

		// 5. 람다식 사용 비교
		Comparator<Grape> c = (Grape a1, Grape a2) -> a1.getWeight().compareTo(a2.getWeight());
		inventory.sort(c);
		System.out.println(inventory);
		
		
	}

	public static void printGrapeInfo(List<Grape> inventory, Consumer<Grape> consumer) {
		for (Grape grape : inventory) {
			consumer.accept(grape);
		}
	}
	
	public static List<Grape> filterGreenGrapes(List<Grape> inventory) {
		List<Grape> result = new ArrayList<>();
		for (Grape grape : inventory) {
			if ("green".equals(grape.getColor())) {
				result.add(grape);
			}
		}
		return result;
	}

	public static List<Grape> filterGrapesByColor(List<Grape> inventory, String color) {
		List<Grape> result = new ArrayList<>();
		for (Grape grape : inventory) {
			if (grape.getColor().equals(color)) {
				result.add(grape);
			}
		}
		return result;
	}

	public static List<Grape> filterGrapesByWeight(List<Grape> inventory, int weight) {
		List<Grape> result = new ArrayList<>();
		for (Grape grape : inventory) {
			if (grape.getWeight() > weight) {
				result.add(grape);
			}
		}
		return result;
	}

	public static List<Grape> filter(List<Grape> inventory, GrapePredicate p) {
		List<Grape> result = new ArrayList<>();
		for (Grape grape : inventory) {
			if (p.test(grape)) {
				result.add(grape);
			}
		}
		return result;
	}

	public static List<Grape> filter2(List<Grape> inventory, Predicate<Grape> p) {
		List<Grape> result = new ArrayList<>();
		for (Grape grape : inventory) {
			if (p.test(grape)) {
				result.add(grape);
			}
		}
		return result;
	}

	@FunctionalInterface
	interface GrapePredicate {
		public boolean test(Grape a);
	}

	static class GrapeWeightPredicate implements GrapePredicate {
		public boolean test(Grape grape) {
			return grape.getWeight() > 150;
		}
	}

	static class GrapeColorPredicate implements GrapePredicate {
		public boolean test(Grape grape) {
			return "green".equals(grape.getColor());
		}
	}

	static class GrapeRedAndHeavyPredicate implements GrapePredicate {
		public boolean test(Grape grape) {
			return "red".equals(grape.getColor()) && grape.getWeight() > 150;
		}
	}
}
