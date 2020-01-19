import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transformation transfo = new Transformation();
		ArrayList<ArrayList<String>> t01 = transfo.makeTransformation(0, 1);
		ArrayList<ArrayList<String>> t12 = transfo.makeTransformation(1, 2);
		ArrayList<ArrayList<String>> t23 = transfo.makeTransformation(2, 3);
		ArrayList<ArrayList<String>> t34 = transfo.makeTransformation(3, 4);
		ArrayList<ArrayList<String>> t45 = transfo.makeTransformation(4, 5);
		ArrayList<ArrayList<String>> t56 = transfo.makeTransformation(5, 6);

		ArrayList<ArrayList<String>> t02 = transfo.mult(t01, t12);
		ArrayList<ArrayList<String>> t03 = transfo.mult(t02, t23);
		ArrayList<ArrayList<String>> t04 = transfo.mult(t03, t34);
		ArrayList<ArrayList<String>> t05 = transfo.mult(t04, t45);
		ArrayList<ArrayList<String>> t06 = transfo.mult(t05, t56);

		System.out.println("Matrices de transformation\n");
		System.out.println("0T1 :");
		transfo.print(t01);
		System.out.println("\n1T2 :");
		transfo.print(t12);
		System.out.println("\n2T3 :");
		transfo.print(t23);
		System.out.println("\n3T4 :");
		transfo.print(t34);
		System.out.println("\n4T5 :");
		transfo.print(t45);
		System.out.println("\n5T6 :");
		transfo.print(t56);
		System.out.println("\n\n");
		System.out.println("0T1*1T2=0T2 :");
		transfo.print(t02);
		System.out.println("\n0T2*2T3=0T3 :");
		transfo.print(t03);
		System.out.println("\n0T3*3T4=0T4 :");
		transfo.print(t04);
		System.out.println("\n0T4*4T5=0T5 :");
		transfo.print(t05);
		System.out.println("\n0T5*5T6=0T6 :");
		transfo.print(t06);
	}

}
