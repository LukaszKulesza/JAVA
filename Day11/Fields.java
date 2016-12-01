package Day11;

import java.util.Scanner;

public class Fields {

	private int row;
	private int column;
	
	

	
	public int getRow() {
		return row;
	}
	public int setRow(int row) {
		return this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public int setColumn(int column) {
		return this.column = column;
	}
	
	public int inputrow(){	
	
	Fields r=new Fields();
	System.out.println("wpisz ilosc wierszy");
	@SuppressWarnings("resource")
	Scanner scan=new Scanner (System.in);
	int inputrow=scan.nextInt();
	System.out.println("wpisana ilosc wierszy to "+ inputrow);
//	r.setRow(scan.nextInt());
	row=r.setRow(inputrow);
	System.out.println(r.getRow()+"    to co dalej");
	return r.getRow();
	}
	
	public int inputcolumn(){
//		
//		System.out.println("wpisz ilosc kolumn");
//		Scanner scan2=new Scanner(System.in);
//		int inputcolumn=scan2.nextInt();
//	
//		System.out.println("wpisana ilosc wierszy to "+ inputcolumn);
//		r1.setColumn(scan2.nextInt());
//	}
	Fields c=new Fields();
	System.out.println("wpisz ilosc kolumn");
	@SuppressWarnings("resource")
	Scanner scan=new Scanner (System.in);
	int inputcolumn=scan.nextInt();
	System.out.println("wpisana ilosc kolumn to "+ inputcolumn);
//	r.setRow(scan.nextInt());
	column=c.setColumn(inputcolumn);
	System.out.println(c.getColumn()+"    to co dalej");
	return c.getColumn();
	}
	
	
}
