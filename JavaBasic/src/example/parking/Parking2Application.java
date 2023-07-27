package example.parking;

import java.util.Scanner;

//주차장 관리 프로그램

// 여유 공간 확인
//주차 등록
//주차 확인
//출차 

//데이터
//차량번호
//차량번호, 차종, 주차공간, 층수, 입차 시간, 출차 시간, 요금, 차량수

//층수 10층, 층 당 30대, 경차: 1000, 중대형:1500, SUV:2000
//장애인(임산부, 노약자, 유공), 차량높이, 장기주차, 전기차, 주차시간당 할인, 제휴할인 
class ParkingSpace {
	// boolean parkingStatus; static final Parking [][] 이하 선언으로 필요가 없이짐.
	String registerNumber;
	int getInTime;
	String type;
	
	ParkingSpace(String registerNumber, int getInTime, String type) {
		this.registerNumber = registerNumber ;
		this.getInTime = getInTime;
		this.type = type;
		
	}
	
}
class EnterCarDto { 

	String registerNumber ;
	String type ;
	int getInTime ;
	int layer ;
	int space ;
	
	EnterCarDto(String registerNumber, String type,int getInTime, int layer, int space) {
		this.registerNumber = registerNumber;
		this.type = type;
		this.getInTime = getInTime ;
		this.layer = layer;
		this.space = space;
		
	}
		
	static EnterCarDto getInstance() {
		
		EnterCarDto instance = null;
		try {
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("차량 번호 : ");
			String registerNumber = scanner.nextLine();
			
			System.out.println("차종 : ");
			String type = scanner.nextLine();
			
			
			System.out.println("입차시간(0~24) : ");
			int getInTime = scanner.nextInt();
			
			System.out.println("주차 층(0~9) : ");
			int layer = scanner.nextInt();
			
			System.out.println("주차 공간(0~29) : ");
			int space = scanner.nextInt();
			
			// todo : 사용자로부터 입력 (차량 번호, 차종, 입차시간, 주차층, 주차 공간)
			EnterCarDto dto = EnterCarDto.getInstance();
			if (dto == null) return null;
			
			// todo : 사용자 입력 검증
			// todo : 차량 번호 : 빈값인지 아닌지
			if (registerNumber == null || type == null) {
				System.out.println("입력 오류입니다.");
				return null;
			}
			if (registerNumber.isBlank()) {
				System.out.println("차량 번호를 반드시 입력하세요.");
				return null;
			}
			
			// todo : 차종 (경차, 중대형, SUV로 입력했는지)
			boolean validType = type.equals("경차") || type.equals("중대형") || type.equals("SUV");
			if (!validType) {
				System.out.println("경차, 중대형, SUV 중에 하나를 입력하세요");
				return null;
			}
			
			// todo : 입차 시간 (0~ 24 사이 인지)
			if (getInTime < 0 || getInTime > 24) {
				System.out.println("입차 시간은 0~ 24 사이어야 합니다");
				return null;
			}
			// todo : 주차 층 (0 ~ 9 사이 인지)
			if (layer < 0 || layer > 9) {
				System.out.println("주차 층은 0 ~ 9 사이어야 합니다");
				return null;
			}
			// todo : 주차 공간 ( 0 ~ 29 사이 인지)
			if (space < 0 || space > 29) {
				System.out.println("주차 공간은 0 ~ 29 사이어야 합니다");
				return null;
			}
			
			instance = new EnterCarDto(registerNumber, type, getInTime, layer, space);
		} catch (Exception exception) {
			System.out.println("입력오류입니다.");
		}
		return instance;
		
	}
}


class FindCarDto {
	int floor;
	int space;
	
	FindCarDto(int floor, int space) {
		this.floor = floor;
		this.space = space;
	}
	
}

public class Parking2Application {

	static final int LIGHT_FARE = 1000;
	static final int HEAVY_FARE = 1500;
	static final int SUV_FARE = 2000;
	
	// int[] array = new int[10] //  이것과 아래 내용 비교해서 개념 파악, 참조형 변수 
	
	static final ParkingSpace[][] PARKING_SPACES = new ParkingSpace[10][30];
	
	public static void main(String[] args) {
		
		
		// Scanner scanner = new Scanner(System.in); --> while 바깥에 있는거와 차이가 있음.
		while(true) {			
			
			// -1 : 잘못된 값 / 0~5 : 정상
			int selectedMethod = input();
			if (selectedMethod == -1) continue;
			if (selectedMethod == 0) {
				System.out.println("프로그램 종료");
				break;
			
			}

			if (selectedMethod == 1) getAllFreeSpace();
			if (selectedMethod == 2) getFloorFreeSpace();
			if (selectedMethod == 3) enterCar();
			if (selectedMethod == 4) checkParking();
			if (selectedMethod == 5) outCar();

		}

	}

	static int input () {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("작업을 선택하세요. (1.전체 주차공간 확인, 2. 층별 주차공간 확인, 3. 입차, 4. 차량확인, 5.출차, 0. 종료");
		
		int selectedMethod = -1; // 여기에 선언하는 이유는 try block 외부에 있는 selected 이하 변수 처리위해
		try {
			selectedMethod = scanner.nextInt(); 
		} catch (Exception exception) {
			System.out.println("잘못된 입력입니다.");
			return -1;
		}
		
		boolean validInput = selectedMethod < 0 || selectedMethod > 5;
		if (validInput) {
			System.out.println("잘못된 입력입니다.");
			return -1;
		}
		return selectedMethod;
	}
		
	static void getAllFreeSpace() {
		// todo : 전체 여유공간 출력
		int sum = 0;
		for (ParkingSpace[] floor: PARKING_SPACES) { // foreach 구문 이해할 것
			for (ParkingSpace space: floor) if(space == null) sum++;
		}
		System.out.println("전체 여유 공간 : " + sum);
		
	}
	
	static void getFloorFreeSpace() {
		// todo : 층별 여유공간 출력
		int[] freeSpaces = new int[10];
		
		for (int layer = 0; layer < PARKING_SPACES.length; layer++) {
			for (ParkingSpace space: PARKING_SPACES[layer]) {
				if (space == null) freeSpaces[layer]++;
			}
		}
		
		for (int layer = 0; layer < freeSpaces.length; layer++) {
			System.out.println(layer + 1 + "층의 여유 공간 : " + freeSpaces[layer]);
		}
	}
	
	static void enterCar() {
		
		EnterCarDto dto = EnterCarDto.getInstance();
		
		// todo : 해당 공간이 비어 있는지
		if (PARKING_SPACES[dto.layer][dto.space] !=null) {
			System.out.println("이미 주차된 공간입니다.");
			return;
         
		}
		// todo : 입차 처리
			
		PARKING_SPACES[dto.layer][dto.space] = new ParkingSpace(dto.registerNumber,dto.getInTime,dto.type);
		
	}
	
	static void checkParking() {
		Scanner scanner = new Scanner(System.in);
		System.out.println ("차량번호를 입력하세요.");
		String registerNumber = scanner.nextLine();
		
		if (registerNumber == null) {
			System.out.println("입력 오류입니다.");
			return;
		}
		
		if (registerNumber.isBlank()) {
			System.out.println("차량 번호를 반드시 입력해주세요.");
			return;
		}
		
		FindCarDto findCarDto = findCar(registerNumber);
	
		if (findCarDto ==null) {
			System.out.println("찾을 수 없는 차량 번호입니다.");
			 return;
		 } 
		System.out.println(findCarDto.floor + "층"+ findCarDto.space + "번에 위치합니다.");
	}
	
	static void outCar() {
		// todo : 출차 처리
		// 차량번호, 출차시간 입력 -> 입력검증 -> 주차공간 해당 차량 찾기 -> 입력한 출차시간이 입차시간보다 작은검증 -> 정산-> 주차공간에서 차량 제거
		String registerNumber = null;
		int outTime = -1;
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println ("차량번호 : ");
			registerNumber = scanner.nextLine();
			System.out.println("출차 시간 (0~24)");
			outTime = scanner.nextInt();
		} catch (Exception exception) {
		  System.out.println("입력 오류입니다."); 
		  return;
		}
	
		if (registerNumber == null) {}
		
		if (registerNumber.isBlank()) {
			System.out.println("차량 번호를 반드시 입력해주세요.");
			return;
		}
		if (outTime < 0 || outTime > 24) {
			System.out.println("출차시간은 0~ 24 사이어야 합니다. ");
			return;
			
		}
		
		FindCarDto findCarDto = findCar(registerNumber);
		if (findCarDto == null) {
			System.out.println("찾을 수 없는 차량번호입니다.");
			return;
		}
 	
		ParkingSpace parkingSpace = PARKING_SPACES[findCarDto.floor][findCarDto.space];
		if (parkingSpace.getInTime < outTime) {
			System.out.println("출차  시간이 입차 시간보다 작을 수 없습니다.");
			return;
		}
		
		int typePayment = parkingSpace.type.equals("경차") ? LIGHT_FARE:
						parkingSpace.type.equals("중대형") ? HEAVY_FARE : SUV_FARE;
		
		int payment = (outTime - parkingSpace.getInTime) * typePayment;
		System.out.println("최종금액은" + payment + "원 입니다.");
		
		PARKING_SPACES[findCarDto.floor][findCarDto.space] = null;
		

	}


	static FindCarDto findCar(String registerNumber) {
			
		FindCarDto dto = null;
		
		for (int floor = 0 ; floor < PARKING_SPACES.length; floor++) {
			for (int space = 0; space < PARKING_SPACES[floor].length; space++) {
				
				if (PARKING_SPACES[floor][space] == null) continue;
				
				if (registerNumber.equals(PARKING_SPACES[floor][space].registerNumber)) {
					dto = new FindCarDto(floor, space);
					break;
				}
	
			
			
			}
			if (dto != null) break;
		}
	
		return dto;
	}
}
