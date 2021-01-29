package payload;

import java.io.File;


import java.io.FileNotFoundException;
import java.util.Scanner;

import com.informatica.mdm.cs.server.rest.Credentials;
import com.siperian.sif.client.CertificateHelper;

public class PayloadGenerator {
	public static void main(String[] args) throws FileNotFoundException {
		
			    Scanner sc = new Scanner(System.in); 
			    
			    System.out.println("enter the request name");
			    String req = sc.nextLine();
			    System.out.println("enter the path for hub server");
			    String path = sc.nextLine();
			    System.out.println("enter the orsid");
			    String orsid = sc.nextLine();

			    System.out.println(path +" " + req);
			    try{
			    	CertificateHelper cc = new CertificateHelper("C:\\infamdm\\hub\\server");
			    	//CertificateHelper cc = new CertificateHelper(path);
			    	//CertificateHelper cc = CertificateHelper.getInstance();
					  String payload = cc.getEncryptedSecurityPayloadForRest("",
					  orsid, req, "hub", "admin");
					  System.out.println("payload =" + payload); 
					  payload = cc.getSecurityPayloadForRestAsHttpHeader("",
							  orsid, req, "hub", "admin");
							  System.out.println("payload =" + payload); 
					  
			    
			    } catch(Exception e) {
					  e.printStackTrace(); }


	}

}

