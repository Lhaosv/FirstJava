package test2;
import java.util.Scanner;
public class test2 {

	public static void main(String[] args) {
		Scanner w=new Scanner(System.in);
		float a=w.nextFloat();
		float b=w.nextFloat();
		float c=w.nextFloat();
		float q;
		double s;
		q=(a+b+c)/2;
		s=(float)Math.sqrt(q*(q-a)*(q-b)*(q-c));
		System.out.println(s);
		
		
		
		
		

	}

}
