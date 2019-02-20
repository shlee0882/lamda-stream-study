package lamdaTest;

import java.util.function.IntBinaryOperator;

public class OperatorTest {
	private static int[] valueList = { 10, 20, 30 };

	// IntBinaryOperator ���
	public static int maxOrMin(IntBinaryOperator operator) {
		int result = valueList[0];
		for (int value : valueList) {
			result = operator.applyAsInt(result, value);
		}
		return result; }

	public static void main(String[] args) {
		// �ִ밪 ���
		int maxValue = maxOrMin((n1,n2) ->{
			if(n1>=n2) return n1;
			else return n2;
		});
		System.out.println(maxValue);
		
		// �ּҰ� ���
		int minValue = maxOrMin((n1,n2) ->{
			if(n1<=n2) return n1;
			else return n2;
		});
		System.out.println(minValue);
	}
}
