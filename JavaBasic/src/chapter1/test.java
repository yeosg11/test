package chapter1;

public class test {

	public static void main(String[] args) {
		int day = 2;
		switch(day) {
		case 1:
			System.out.println("일요일");
		case 2:
			System.out.println("월요일");
		case 3:
			System.out.println("화요일");
		case 4:
			System.out.println("수요일");
			break;
		case 5:
			System.out.println("목요일");
		case 6:
			System.out.println("금요일");
		case 7:
			System.out.println("토요일");
		default:
			System.out.println("한주 끝!!");
		}
	}

}
