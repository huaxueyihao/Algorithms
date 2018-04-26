package com.algorithms.chapter01;

import java.util.Arrays;

public class MainClass {
	public static void main(String[] args) {
		
		int a = 1;
		transByValue(a);//��ֵ����
		System.out.println(a);
		
		String str = "A";
		trans(str);
		System.out.println(str);
		
		StringBuilder sb = new StringBuilder("a");
		transByQuote(sb);//�����ô��ݣ������ô��ݣ����ö���ķ��������Ըı�����ֵ
		System.out.println(sb.toString());
	
		Student student = new Student();
		student.setId(1);
		student.setName("����");
		
		transByQuote2(student);
		System.out.println(student.toString());
		
		int[] arrint = {1,2};//����Ҳ����������
		transByValue2(arrint);
		System.out.println(Arrays.toString(arrint));
		
		String[] arrstr = {"a","b"};
		transByQuote3(arrstr);
		System.out.println(Arrays.toString(arrstr));
		
	}

	public static void transByQuote3(String[] arrstr) {
		arrstr[1] = "c";
	}

	public static void transByValue2(int[] arrint) {
		arrint[1]= 4;
	}

	private static void transByQuote2(Student student) {
		
		student.setName("����");
		
	}

	public static void trans(String str) {
		str+="B";
		str.concat("B");
	}

	public static void transByQuote(StringBuilder sb) {
		sb.append("b");
	}

	public static void transByValue(int a) {
		a++;
	}
	
	
}
