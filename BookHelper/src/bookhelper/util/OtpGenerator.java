package bookhelper.util;

public class OtpGenerator {

	public OtpGenerator() {
		
	}
  public static int generateOtp(){
	
	  Integer num=null;
	  double n=Math.random()*10000+999;
	  
	   num=(int)n;
	  return num;
	  
	  
	  
	  
  }
}
