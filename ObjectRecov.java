package test2;
import java.io.*;

public class ObjectRecov implements Serializable {

	public static void main(String[] args) {
		Student stu=null;
		try{
			FileInputStream fi=new FileInputStream("data.ser");
			ObjectInputStream si=new ObjectInputStream(fi);
			stu = (Student)si.readObject();
			si.close();
		}catch(Exception e){
			System.out.println(e);
		}
		System.out.println("ID: "+stu.id+"name:"+stu.name+"age: "+stu.age+"dept.:"+stu.department);
		
		

	}

}
