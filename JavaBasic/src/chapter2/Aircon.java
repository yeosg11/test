package chapter2;

// 인터페이스 : 클래스가 구현해야하는 메서드들을 정의하는 것 (참조 타입)
// 사용측과 개발측의 분리를 위해 사요됨
// 모든 메서드가 추상메서드로 작성 되어 있음
// 모든 변수는 정적 상수로 작성이 되어 있음


public interface Aircon {
	// 전원
	public abstract void power();
	// 풍량 조절
	public abstract int airVolumeControl();
	// 풍향 조절
	public abstract String windDirectionControl();
	// 온도 조절
	public abstract int tempratureControl(); 
	// 모드 변경
	public abstract String modeChange();
	// 예약 기능
	public abstract void scheduleTermination();
	
	 
}
