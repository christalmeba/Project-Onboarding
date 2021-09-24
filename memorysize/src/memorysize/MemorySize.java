package memorysize;

import java.text.DecimalFormat;

public class MemorySize {
	
	public static String getActualMemorySize(String m) {
		int ms=Integer.parseInt(m.substring(0,m.length()-2));
		String label=m.substring(m.length()-2);
		
		DecimalFormat df = new DecimalFormat("#.##");
		double actualmemory=ms-ms*0.07;
		if(actualmemory>=1)
			return df.format(actualmemory)+label;
		else {
			actualmemory*=1024;
			return df.format(actualmemory)+"MB";}
		

	}
	
	public static void main(String[] args) {
		String m="1GB";
		
		System.out.println(getActualMemorySize(m));
	}

}
