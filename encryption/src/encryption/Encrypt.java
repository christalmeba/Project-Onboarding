package encryption;

public class Encrypt {
	
	public static String encryptString(String st)
	{
		String alphabet="abcdefghijklmnopqrstuvwxyz";
		String newString="";
		for(int i=0;i<st.length();i++)
		{
			if(st.charAt(i)!=' ') 
			{
			int index=alphabet.indexOf((st.toLowerCase()).charAt(i));
			if(index<=12)
				index=index+13;
			else
				index=index-13;
			newString+=alphabet.charAt(index);
			}
			else
				newString+=' ';
			
		}
		
		return newString;
	}
	
	public static void main(String[] args) {
		
		String a="hello";
		System.out.println(a.indexOf('m'));
		System.out.println(encryptString(a));
	}

}
