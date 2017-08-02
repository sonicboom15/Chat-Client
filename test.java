import java.util.Scanner;

public class test{
  public int fact(int a){
    if(a==1){
      return 1;
    }
    else{
      a--;
      return (a+1)*fact(a);
    }
  }
  
  public static void main(String args[]){
    test ab = new test();
    Scanner c = new Scanner(System.in);
    int a = c.nextInt();
    int b = ab.fact(a);
    System.out.println(b);
  }
}