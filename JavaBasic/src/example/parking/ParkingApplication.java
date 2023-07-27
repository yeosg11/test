package example.parking;

import java.util.Scanner;

// 주차장 관리 프로그램
// 주차 등록
// 주차 확인
// 출차 

// 데이터
// 차량번호
// 차량번호, 차종, 주차공간, 층수, 입차 시간, 출차 시간, 요금, 차량수

// 층수 10층, 층당 30대, 경차: 1000, 중대형:1500, SUV:2000
// 장애인(임산부, 노약자, 유공), 차량높이, 장기주차, 전기차, 주차시간당 할인, 제휴할인 
public class ParkingApplication {

	
	public static void main(String[] args) {
		
		// 주차 공간 : 왜 boolean으로 시작? 
		
		// boolean [3][5] = {{t,t,f,f,t},{t,t,f,f,t},{t,t,f,f,t}}
		
//		### forEach 문
//
//		컬렉션(리스트, 배열 등)의 각 요소에 대해 코드를 실행하는 방법을 제공한다.
//
//		아래 예시는 ‘arr’배열의 모든 요소를 차례로 ‘num’ 변수에 할당하며, 각 반복마다 해당 요소를 출력하는 for-each 문이다.
  //		int[] arr = {1, 2, 3, 4, 5};
  //		for (int num : arr) {
  //		    System.out.println(num);
  //		}
		
		
		// false는 0, true=1
		// 초기값은 0으로 되어 있음. System.out.println(parkingSpaces[0][0]); ==> false
		boolean[][] parkingSpaces = new boolean [10][30];
		// 주차한 차량 번호
		String[][] registerNumberes = new String [10][30];
		// 입차 시간
		int [][] getInTimes = new int[10][30];
		// 차종
		String[][] types = new String[10][30];
		
		// 전체 여유 공간 
		//2차원 배열일때 for 조건문 2개
		int totalFreeSpaces = 0;
		for (boolean[] layer: parkingSpaces) { //foreach 구문
			for (boolean space: layer) {
				if(!space) totalFreeSpaces++;
			}
		}
		System.out.println("여유 공간 : " + totalFreeSpaces);
		
	// 층별 여유 공간
		int[] layerFreeSpaces = new int[10]; // 0으로 초기값
		for (int layer = 0; layer < parkingSpaces.length; layer++) {
			for (boolean space: parkingSpaces[layer]) { //foreach 구문
				if(!space) layerFreeSpaces[layer]++;
				
			}
		}
		

		for (int layer = 0; layer < parkingSpaces.length; layer++) {
			System.out.println(layer + 1 + "층 여유 공간 : " + layerFreeSpaces[layer]);
		}
	 
		Scanner scanner = new Scanner(System.in);
		// 입차
		System.out.println("차량 번호 : ");
		String registerNumber = scanner.nextLine();
		
		System.out.println("차종 : ");
		String type = scanner.nextLine();
		
		System.out.println("입차 시간 : ");
		int getInTime = scanner.nextInt();
		
		System.out.println("주차 층 (0 ~ 9) : ");
		int parkingLayer = scanner.nextInt();
		
		System.out.println("주차 층 (0 ~ 29) : ");
		int parkingSpace = scanner.nextInt();
		
		// 차량번호 검증 null 참조형
		if (registerNumber !=null && registerNumber.isBlank()) {
			System.out.println("차량번호를 반드시 입력하세요.");
			return;
				}
		
		// 차종 검증
		if (type !=null && type.equals("경차") && !type.equals("중대형") && !type.equals("SUV")) {
			System.out.println("경차, 중대형, SUV중에 하나를 입력하세요.");
			return;
		}
		
		// 입차시간 검증
		if (getInTime < 0 || getInTime > 24) {
			System.out.println("입차 시간은 0~ 24 사이어야 합니다.");
			return;
		}
		
		// 주차 층 검증
		if (parkingLayer < 0 || parkingLayer > 9) {
			System.out.println("주차 층은 0 ~ 9 사이어야 합니다.");
			return;
		}
		
		//주차 층 검증
		if (parkingSpace < 0 || parkingSpace > 29) {
			System.out.println("주차 층은 0 ~ 29 사이어야 합니다.");
			return;
		}
		// 해당 주차 공간이 비었는 검증
		if (parkingSpaces[parkingLayer][parkingSpace]) {
			System.out.println("이미 주차된 공간입니다.");
			return;			
		}
		
		// 주차
		parkingSpaces[parkingLayer][parkingSpace] = true;
		registerNumberes[parkingLayer][parkingSpace] = registerNumber;
		getInTimes[parkingLayer][parkingSpace] = getInTime;
		types[parkingLayer][parkingSpace] = type;
		
		// 주차 위치 확인
		System.out.print("확인할 차량 번호 : ");
		registerNumber = scanner.nextLine();
		
		if (registerNumber !=null && registerNumber.isBlank()) {
			System.out.println("차량번호를 반드시 입력하세요.");
			return;
				}
		
		boolean found = false;
		for(int layer = 0; layer < registerNumberes.length; layer++) {
			for (int space = 0; space < registerNumberes[layer].length; space++) {
			
				if (registerNumber.equals(registerNumberes[layer][space])) {
					System.out.println(layer + "층" + space + "번에 위치합니다.");
					found = true;
					break;
				}
				
				
				// 아래 구문처럼 하면 error 발생함.
//				if (registerNumberes[layer][space].equals(registerNumber)) {
//					System.out.println(layer + "층" + space + "번에 위치합니다.");
				}
				if (found) break;
			}
		    
		
	
	    if (!found) System.out.println("찾을 수 없는 차량 번호입니다.");
	    
	    
	    // 출차
	    scanner = new Scanner(System.in);
	    System.out.println("출차할 차량번호 : ");
	    registerNumber = scanner.nextLine();
	    
	    System.out.println("출차 시간 : ");
	    int leaveTime = scanner.nextInt();
	    
		if (registerNumber !=null && registerNumber.isBlank()) {
			System.out.println("차량번호를 반드시 입력하세요.");
			return;
				}
		if (leaveTime < 0 || leaveTime > 24) {
			System.out.println("입차 시간은 0~ 24 사이어야 합니다.");
			return;
		
	}
		found = false;
		int foundLayer = -1;
		int foundSpace = -1;
		for (int layer = 0; layer < registerNumberes.length; layer++) {
			for (int space =0; space < registerNumberes[layer].length; space++) {
				if (registerNumber.equals(registerNumberes[layer][space])) {
					foundLayer = layer;
					foundSpace = space;
					found = true;
					break;
					
				}
			}
			if (found) break;
		}
		
		if (!found) {
			System.out.println("찾을 수 없는 차량 번호입니다.");
			return;
		}
			
		
		if (leaveTime < getInTimes[foundLayer][foundSpace]) {
			System.out.println("출차 시간이 입차 시간보다 작을 수 없습니다.");
			return;
		}
		
		// (출차 시간 - 입차시간) * 차량별 금액
		int typeAmount =
				types[foundLayer][foundSpace].equals("경차") ? 1000 :
				types[foundLayer][foundSpace].equals("중대형") ? 1500 : 2000;
		
		int result = (leaveTime - getInTimes[foundLayer][foundSpace]);
		System.out.println("최종 금액은 " + result + "원 입니다.");
		
		parkingSpaces[foundLayer][foundSpace] = false;
		registerNumberes[foundLayer][foundSpace] = null;
		getInTimes[foundLayer][foundSpace] = 0;
		types[foundLayer][foundSpace] = null;
		
	}
	}
	