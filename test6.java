package test2;

public class test6 {

	public static void main(String[] args) {
		int i;
		int a[]=new int [1000];
		for(i=0;i<1000;i++)
		{
			a[i]=(int) (Math.random()*100);
		}
		int b[]=new int[101];
		for(i=0;i<100;++i)
		{
			b[i]=0;
		}
		for(i=0;i<1000;++i)
		{
			b[a[i]]++;
		}
		for(i=1;i<=100;++i)
		{
			System.out.println(i+"出现了:"+b[i]+" 次");
		}



	}

}
