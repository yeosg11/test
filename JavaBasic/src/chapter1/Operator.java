package chapter1;

public class Operator {

	public static void main(String[] args) {
	
		// 연산자
		// 산술연산자, 대입연산자, 비교연산자, 논리연산자, 삼항연산자
		
		//1.산술연산자 : 사칙연산과 관련된 연산자
		int result;
		int a=15;
		int b=9;
		
		//+ : 좌항에 우항을 더한 값을 반환
		result = 10+20; //result: 30
		result = a+b; //result: 24
		// - : 좌항에 우항을 뺀 값을 반환
		result = 10-20;
		result = a-b;
		System.out.println(result);
		System.out.println(16/5.0);
		result = 16%5;
		System.out.println(result);
		
		// ++, -- : 증감 연산자로 피연산자를 1 증가 혹은 감소
		//			증감 연산자가 피연사자의 앞에 오느냐 뒤에 오느냐에 따라
		//			연산되어지는 순서가 다름
		// 			증감 연산자는 피연산자가 반드시 일반 변수이어야 함.
		int c = 10;
		System.out.println(c);
		System.out.println(++c);
		System.out.println(c);
		System.out.println(c++);
		System.out.println(c); // c: 12 유심히 볼 것
		
		result = 10 + ++c; // result = 13 / c:13
		result = 20 - c++; // result = 7 / c:14
		result = 20 - c-- + 10 ; // result: 16 / c:13
		// result = ++10; 
		
		//2. 대입 연산자 : 변수에 값을 할당할 때 사용하는 연산자
		// 좌항은 우항의 결과를 대입
		// = : 좌항에 우항의 결과를 대입
		result = 5;
		// +=, -=, *=, /=, %= : 좌항에 우항과 좌항을 연산한 결과를 대입
		result += 3 ; // result : 8
		result -= 2; // 6
	
		
		// 10 += 3;
		
		// 3. 비교 연산자 : 두 값을 비교하여 논리값의 결과를 반환하는 연산자
		// a: 15, b: 9
		
		//		boolean compareResult;
		// == : 좌항이 우항과 같은지를 비교
		// compareResult =a == b;
		
		// char tem
		
	    // 4. 논리 연산자 : 논리값을 조합 혹은 반전할 때 사용하는 연산자
		
		final boolean TRUE = true;
		final boolean FALSE = false;
		boolean compareResult;
		
		// || : 좌황과 우항 중 하나라도 true면 true, 모두 false면 false 반환
		compareResult = TRUE || TRUE;
		
		System.out.println(compareResult);
		
		// 5. 삼항 연산자 : 논리 표현식의 결과에 따라 서로 다른 결과를 반환하는 연산자
		// 논리표현식 ? 참일때 결과(표현식) : 거짓일때 결과(표현식);
		a = 9;
		String message = a > b ? "a는 b보다 큽니다." 
			    : a < b ? "a는 b보다 작습니다."
			    : "a는 b와 같습니다.";
		System.out.println(message);
		
		
		
				
		
				
				
				
				
		
	}

}
