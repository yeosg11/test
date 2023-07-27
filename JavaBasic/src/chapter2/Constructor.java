package chapter2;

// 생성자
// 클래스로 인스턴스를 생성할 때 호출하는 메서드
// 생성자의 이름은 클래스의 이름과 동일하고 반환 타입을 지정하지 않음

class Dog {
	String breed;
	String name;
	int age;
	
	 Dog() {
		 breed = "진돗개";
		 name = "누렁이";
		 age = 1;
		 
		 System.out.println("Dog 인스턴스 생성!");
	 }
	 
	 // this : 현재 인스턴스를 지칭하는 키워드	 
	 Dog(String breed, String name, int age) {
		 this.breed = breed;
		 this.name = name;
		 this.age = age;
	 }	 
		 
	 
	 
	 Dog (Dog dog){
		 breed = dog.breed;
		name = dog.name;
		age = dog.age;
	 }
		
	 
}
	 
public class Constructor {

	public static void main(String[] args) {
		Dog dog1 = new Dog();
		Dog dog2 = new Dog();
		Dog dog3 = new Dog("포메라니안", "봄",8);
		
		System.out.println(dog1.breed);
		System.out.println(dog1.name);
		System.out.println(dog1.age);
		
		System.out.println(dog3.breed);
		System.out.println(dog3.name);
		System.out.println(dog3.age);
		
		Dog dog = new Dog();
		dog.breed = dog3.breed;
		dog.name = dog3.name;
		dog.age = dog3.age;
		
		System.out.println(dog3);
		System.out.println(dog);
		
//		dog = dog3;
//		dog.name = "여름";
		
		dog.breed = dog3.breed;
		dog.name = dog3.name;
		dog.age = dog3.age;
		
		//dog.name = "여름"
	}


}
