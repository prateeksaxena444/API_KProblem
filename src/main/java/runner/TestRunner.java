package runner;

import APIs.API_Details;
import Utility.Utility_Class;

public class TestRunner {

	public static void main(String args[])
	{
		API_Details apd = new API_Details();
		Utility_Class uc = new Utility_Class();
		
		System.out.println(System.getProperty("user.dir"));
		
		if(uc.checkFor200(apd.To_be_checked) && uc.validateSchema(apd.API))
				{
			  System.out.println(uc.getBody(apd.API));
				}
	}
}
