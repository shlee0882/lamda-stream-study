package lamdaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionTest {

	// Function 인터페이스
	public static List<String> getColorList(List<Grape> inventory, Function<Grape, String> function) {
		List<String> colorList = new ArrayList<String>();
		for (Grape grape : inventory) {
			colorList.add(function.apply(grape));
		}
		return colorList;
	}

	public static void main(String[] args) {
		List<Grape> grapeList = new ArrayList<>();
		grapeList.add(new Grape(150, "green"));
		grapeList.add(new Grape(200, "purple"));
		grapeList.add(new Grape(200, "red"));
		grapeList.add(new Grape(150, "red"));

		// 1. 익명 클래스 사용
		System.out.println("----- 1. 익명 클래스 사용 -----");
		getColorList(grapeList, new Function<Grape, String>() {
			@Override
			public String apply(Grape grape) {
				// TODO Auto-generated method stub
				return grape.getColor();
			}
		}).forEach(System.out::println);
		

		// 2. 람다식 사용
		System.out.println("----- 2. 람다식 사용 -----");
		getColorList(grapeList, grape -> grape.getColor()).forEach(System.out::println);

		// 3. 메소드 레퍼런스 사용
		System.out.println("----- 3. 메소드 레퍼런스 사용 -----");
		getColorList(grapeList, Grape::getColor).forEach(System.out::println);

	}

	public static class Grape {
		private Integer weight = 0;
		private String color = "";

		public Grape(Integer weight, String color) {
			this.weight = weight;
			this.color = color;
		}

		public Integer getWeight() {
			return weight;
		}

		public void setWeight(Integer weight) {
			this.weight = weight;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String toString() {
			return "Grape{" + "color='" + color + '\'' + ", weight=" + weight + '}';
		}
	}
}
