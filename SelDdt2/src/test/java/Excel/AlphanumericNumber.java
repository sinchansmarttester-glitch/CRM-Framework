package Excel;

public class AlphanumericNumber {

	public static void main(String[] args) {
		int n=10;
		String AlphaNumricString="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder sb=new StringBuilder(n);
		for(int i=0;i<n;i++)
		{
			int index=(int)(AlphaNumricString.length()*Math.random());
			sb.append(AlphaNumricString.charAt(index));
		}
		System.out.println(sb);
	}

}
