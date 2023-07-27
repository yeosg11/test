package chapter3;


import java.util.ArrayList;
import java.util.List;



class Result<Type> {
	int code;
	String message;
	String name;
	Type age;
	
	void print() {
		System.out.println("안녕");
	}
	
	<Parameter> void printer(Parameter parameter) {
		
	}
}


public class Generic {
	
	List<String> createList(int number, boolean flag) {
		if (flag) {
			List<Integer> list = new ArrayList<Integer>();
			for (int index =0; index < number; index++) {
				list.add(index);
			}
			return list;
			
		} else {
			List<String> list = new ArrayList<String>();
			for (int index =0; index <number; index++) {
				list.add(Integer.toString(index));
				
				
			}
		}
	}

	public static void main(String[] args) {
		Result<?> result = new Result<String>();

		
		
		

	}

}
