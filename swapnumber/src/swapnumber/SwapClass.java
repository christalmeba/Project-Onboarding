package swapnumber;

public class SwapClass {
	public static void main(String[] args) {
		int x=5, y=11;
		x+=y;
		y=x-y;
		x=x-y;
		System.out.print(x+" "+y);
	}

}
