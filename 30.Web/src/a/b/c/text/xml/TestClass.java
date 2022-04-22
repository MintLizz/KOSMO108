package a.b.c.test.xml;

import java.util.ArrayList;

public class TestClass {
	
	public void test() {
		
		System.out.println("	a.b.c.text.xml.TestClass 클래스에 있는 test() 메소드 입니다.");
		System.out.println("	HELLO	>>>>>>>>>> ");
		
		ArrayList<String> aList = new ArrayList<String>();
		aList.add("박성훈");
		aList.add("손준성");
		aList.add("윤요섭");
		aList.add("박주형");
		aList.add("전건희");
		aList.add("송정흔");
		
		for (int i = 0; i < aList.size(); i++) {
		
			System.out.println("	>>> : " + aList.get(i));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 여기서 TestClass 클래스의 tc 참조변수를 인스턴스 한다.
		TestClass tc = new TestClass();
		
		// 그 다음 TestClass에서 참조변수로 선언한 다음 인스턴스 한 tc 참조변수의 text() 메소드를 가져온다.
		tc.test();

	}

}
