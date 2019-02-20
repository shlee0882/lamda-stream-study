package lamdaTest;

import java.util.function.IntBinaryOperator;

public class OperatorTest {
	private static int[] valueList = { 10, 20, 30 };

	// IntBinaryOperator 사용
	public static int maxOrMin(IntBinaryOperator operator) {
		int result = valueList[0];
		for (int value : valueList) {
			result = operator.applyAsInt(result, value);
		}
		return result; }

	public static void main(String[] args) {
		// 최대값 얻기
		int maxValue = maxOrMin((n1,n2) ->{
			if(n1>=n2) return n1;
			else return n2;
		});
		System.out.println(maxValue);
		
		// 최소값 얻기
		int minValue = maxOrMin((n1,n2) ->{
			if(n1<=n2) return n1;
			else return n2;
		});
		System.out.println(minValue);
	}
}
