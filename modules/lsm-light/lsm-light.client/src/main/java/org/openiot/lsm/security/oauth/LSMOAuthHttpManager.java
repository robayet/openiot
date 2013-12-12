package org.openiot.lsm.security.oauth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.jasig.cas.services.RegisteredService;
import org.openiot.lsm.security.oauth.mgmt.Permission;
import org.openiot.lsm.security.oauth.mgmt.Role;
import org.openiot.lsm.security.oauth.mgmt.User;
import org.openiot.lsm.server.LSMTripleStore;

import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.sparql.engine.http.QueryEngineHTTP;
/**
 * 
 * @author Hoan Nguyen Mau Quoc
 * 
 */
public class LSMOAuthHttpManager {
	String LSMOauthURL;
	private String LSMOauthGraphURL;
	final static String OAUTH_PER = "Permission";
	final static String OAUTH_ROLE = "Role";
	final static String OAUTH_USER = "OAuthUser";
	final static String OAUTH_SERVICE = "RegisteredService";
	final static String OAUTH_TICKET = "ServiceTicket";
	final static String OAUTH_TICKET_GRANTING = "TicketGranting";
	
	Properties prop = new Properties();
    
    public LSMOAuthHttpManager(){
    	InputStream in = LSMTripleStore.class.getResourceAsStream("/lsm-client.properties");
    	try {
			prop.load(in);
			String server = prop.getProperty("connection.serverhost"); 
			LSMOauthURL = server + "oauth";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
    }
    
	public LSMOAuthHttpManager(String OAuthGraphURL){
		this.LSMOauthGraphURL = OAuthGraphURL;
		InputStream in = LSMTripleStore.class.getResourceAsStream("/lsm-client.properties");
    	try {
			prop.load(in);
			String server = prop.getProperty("connection.serverhost"); 
			LSMOauthURL = server + "oauth";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getLSMOauthGraphURL() {
		return LSMOauthGraphURL;
	}


	public void setLSMOauthGraphURL(String lSMOauthGraphURL) {
		LSMOauthGraphURL = lSMOauthGraphURL;
	}


	public Permission getPermission(String perId) {
		// TODO Auto-generated method stub
		HttpURLConnection conn = null;  
        ObjectOutputStream dos = null;  
        int responseCode = 0;
        Permission permission = null;
        try{  
             URL url = new URL(LSMOauthURL);  
             String name=OAUTH_PER;             
	      // Open a HTTP connection to the URL  
	
	         conn = (HttpURLConnection) url.openConnection();  
	         conn.setDoInput(true);  
	         conn.setDoOutput(true);  
	         conn.setUseCaches(false);  
	
	         // Use a post method.  
	         conn.setRequestMethod("POST");  
	         conn.setRequestProperty("objectType",name);
	         conn.setRequestProperty("OAuthGraphURL",LSMOauthGraphURL);
		     conn.setRequestProperty("project", "openiot");
		     conn.setRequestProperty("operator", "load");
	         conn.setRequestProperty("Connection", "Keep-Alive");  
	         conn.setRequestProperty("Content-Type", "text/html"); 
	         
	         dos = new ObjectOutputStream( conn.getOutputStream() );  
	         dos.writeObject(perId);  
	         dos.flush();  
	         dos.close();   
	         
	      // always check HTTP response code from server
	        responseCode = conn.getResponseCode();
	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            // reads server's response
	        	ObjectInputStream objStream =new ObjectInputStream(conn.getInputStream());
	            permission = (Permission) objStream.readObject();        
	            System.out.println("Server's response: " + responseCode);
	        } else {
	            System.out.println("Server returned non-OK code: " + responseCode);
	        }	  		
        }catch (Exception ex) {  
        	ex.printStackTrace();
            System.out.println("cannot send data to server");     
        }
		return permission;
	}

	public void deletePermission(String perId) {
		// TODO Auto-generated method stub
		HttpURLConnection conn = null;  
        ObjectOutputStream dos = null;  
        int responseCode = 0;
        try{  
             URL url = new URL(LSMOauthURL);  
             String name=OAUTH_PER;             
	      // Open a HTTP connection to the URL  
	
	         conn = (HttpURLConnection) url.openConnection();  
	         conn.setDoInput(true);  
	         conn.setDoOutput(true);  
	         conn.setUseCaches(false);  
	
	         // Use a post method.  
	         conn.setRequestMethod("POST");  
	         conn.setRequestProperty("objectType",name);
	         conn.setRequestProperty("OAuthGraphURL",LSMOauthGraphURL);
		     conn.setRequestProperty("project", "openiot");
		     conn.setRequestProperty("operator", "delete");
	         conn.setRequestProperty("Connection", "Keep-Alive");  
	         conn.setRequestProperty("Content-Type", "text/html"); 
	         
	         dos = new ObjectOutputStream( conn.getOutputStream() );  
	         dos.writeObject(perId);  
	         dos.flush();  
	         dos.close();   
	         
	      // always check HTTP response code from server
	        responseCode = conn.getResponseCode();
	        if (responseCode == HttpURLConnection.HTTP_OK) {	    
	            System.out.println("Server's response: " + responseCode);
	        } else {
	            System.out.println("Server returned non-OK code: " + responseCode);
	        }	  		
        }catch (Exception ex) {  
        	ex.printStackTrace();
            System.out.println("cannot send data to server");     
        }
	}

	public void addPermission(Permission permission){
		// TODO Auto-generated method stub
		HttpURLConnection conn = null;  
        ObjectOutputStream dos = null;  
        int responseCode = 0;
        try{  
             URL url = new URL(LSMOauthURL);  
             String name=OAUTH_PER;             
	      // Open a HTTP connection to the URL  
	
	         conn = (HttpURLConnection) url.openConnection();  
	         conn.setDoInput(true);  
	         conn.setDoOutput(true);  
	         conn.setUseCaches(false);  
	
	         // Use a post method.  
	         conn.setRequestMethod("POST");  
	         conn.setRequestProperty("objectType",name);
	         conn.setRequestProperty("OAuthGraphURL",LSMOauthGraphURL);
	         conn.setRequestProperty("operator", "insert");
		     conn.setRequestProperty("project", "openiot");
	         conn.setRequestProperty("Connection", "Keep-Alive");  
	         conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");  
	        
	         dos = new ObjectOutputStream( conn.getOutputStream() );  
	         dos.writeObject(permission);  
	         dos.flush();  
	         dos.close();  
	         
	      // always check HTTP response code from server
	        responseCode = conn.getResponseCode();
	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            // reads server's response
	            BufferedReader reader = new BufferedReader(new InputStreamReader(
	                    conn.getInputStream()));
	            String response = reader.readLine();
	            System.out.println("Server's response: " + response);
	        } else {
	            System.out.println("Server returned non-OK code: " + responseCode);
	        }	  		
        }catch (Exception ex) {  
        	ex.printStackTrace();
            System.out.println("cannot send data to server");     
        }
	}
	
	public Role getRole(String roleId) {
		// TODO Auto-generated method stub
		HttpURLConnection conn = null;  
        ObjectOutputStream dos = null;  
        int responseCode = 0;
        Role role = null;
        try{  
             URL url = new URL(LSMOauthURL);  
             String name=OAUTH_ROLE;             
	      // Open a HTTP connection to the URL  
	
	         conn = (HttpURLConnection) url.openConnection();  
	         conn.setDoInput(true);  
	         conn.setDoOutput(true);  
	         conn.setUseCaches(false);  
	
	         // Use a post method.  
	         conn.setRequestMethod("POST");  
	         conn.setRequestProperty("objectType",name);
	         conn.setRequestProperty("OAuthGraphURL",LSMOauthGraphURL);
	         conn.setRequestProperty("operator", "load");
		     conn.setRequestProperty("project", "openiot");
	         conn.setRequestProperty("Connection", "Keep-Alive");  
	         conn.setRequestProperty("Content-Type", "text/html"); 
	         
	         dos = new ObjectOutputStream( conn.getOutputStream() );  
	         dos.writeObject(roleId);  
	         dos.flush();  
	         dos.close();   
	         
	      // always check HTTP response code from server
	        responseCode = conn.getResponseCode();
	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            // reads server's response
	        	ObjectInputStream objStream =new ObjectInputStream(conn.getInputStream());
	            role = (Role) objStream.readObject();        
	            System.out.println("Server's response: " + responseCode);
	        } else {
	            System.out.println("Server returned non-OK code: " + responseCode);
	        }	  		
        }catch (Exception ex) {  
        	ex.printStackTrace();
            System.out.println("cannot send data to server");     
        }
		return role;
	}

	public void deleteRole(String roleId) {
		// TODO Auto-generated method stub
		HttpURLConnection conn = null;  
        ObjectOutputStream dos = null;  
        int responseCode = 0;
        try{  
             URL url = new URL(LSMOauthURL);  
             String name=OAUTH_ROLE;             
	      // Open a HTTP connection to the URL  
	
	         conn = (HttpURLConnection) url.openConnection();  
	         conn.setDoInput(true);  
	         conn.setDoOutput(true);  
	         conn.setUseCaches(false);  
	
	         // Use a post method.  
	         conn.setRequestMethod("POST");  
	         conn.setRequestProperty("objectType",name);
	         conn.setRequestProperty("OAuthGraphURL",LSMOauthGraphURL);
	         conn.setRequestProperty("operator", "delete");
		     conn.setRequestProperty("project", "openiot");
	         conn.setRequestProperty("Connection", "Keep-Alive");  
	         conn.setRequestProperty("Content-Type", "text/html"); 
	         
	         dos = new ObjectOutputStream( conn.getOutputStream() );  
	         dos.writeObject(roleId);  
	         dos.flush();  
	         dos.close();   
	         
	      // always check HTTP response code from server
	        responseCode = conn.getResponseCode();
	        if (responseCode == HttpURLConnection.HTTP_OK) {	          
	            System.out.println("Server's response: " + responseCode);
	        } else {
	            System.out.println("Server returned non-OK code: " + responseCode);
	        }	  		
        }catch (Exception ex) {  
        	ex.printStackTrace();
            System.out.println("cannot send data to server");     
        }
	}
	
	public void addRole(Role role){		
		// TODO Auto-generated method stub
		HttpURLConnection conn = null;  
        ObjectOutputStream dos = null;  
        int responseCode = 0;
        try{  
             URL url = new URL(LSMOauthURL);  
             String name=OAUTH_ROLE;             
	      // Open a HTTP connection to the URL  
	
	         conn = (HttpURLConnection) url.openConnection();  
	         conn.setDoInput(true);  
	         conn.setDoOutput(true);  
	         conn.setUseCaches(false);  
	
	         // Use a post method.  
	         conn.setRequestMethod("POST");  
	         conn.setRequestProperty("objectType",name);
	         conn.setRequestProperty("OAuthGraphURL",LSMOauthGraphURL);
	         conn.setRequestProperty("operator", "insert");
		     conn.setRequestProperty("project", "openiot");
	         conn.setRequestProperty("Connection", "Keep-Alive");  
	         conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");  
	        
	         dos = new ObjectOutputStream( conn.getOutputStream() );  
	         dos.writeObject(role);  
	         dos.flush();  
	         dos.close();  
	         
	      // always check HTTP response code from server
	        responseCode = conn.getResponseCode();
	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            // reads server's response
	            BufferedReader reader = new BufferedReader(new InputStreamReader(
	                    conn.getInputStream()));
	            String response = reader.readLine();
	            System.out.println("Server's response: " + response);
	        } else {
	            System.out.println("Server returned non-OK code: " + responseCode);
	        }	  		
        }catch (Exception ex) {  
        	ex.printStackTrace();
            System.out.println("cannot send data to server");     
        }		
	}
	
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		HttpURLConnection conn = null;  
        ObjectOutputStream dos = null;  
        int responseCode = 0;
        User user = null;
        try{  
             URL url = new URL(LSMOauthURL);  
             String name=OAUTH_USER;             
	      // Open a HTTP connection to the URL  
	
	         conn = (HttpURLConnection) url.openConnection();  
	         conn.setDoInput(true);  
	         conn.setDoOutput(true);  
	         conn.setUseCaches(false);  
	
	         // Use a post method.  
	         conn.setRequestMethod("POST");  
	         conn.setRequestProperty("objectType",name);
	         conn.setRequestProperty("OAuthGraphURL",LSMOauthGraphURL);
	         conn.setRequestProperty("operator", "load");
		     conn.setRequestProperty("project", "openiot");
	         conn.setRequestProperty("Connection", "Keep-Alive");  
	         conn.setRequestProperty("Content-Type", "text/html"); 
	         
	         dos = new ObjectOutputStream( conn.getOutputStream() );  
	         dos.writeObject(userId);  
	         dos.flush();  
	         dos.close();   
	         
	      // always check HTTP response code from server
	        responseCode = conn.getResponseCode();
	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            // reads server's response
	        	ObjectInputStream objStream =new ObjectInputStream(conn.getInputStream());
	            user = (User) objStream.readObject();        
	            System.out.println("Server's response: " + responseCode);
	        } else {
	            System.out.println("Server returned non-OK code: " + responseCode);
	        }	  		
        }catch (Exception ex) {  
        	ex.printStackTrace();
            System.out.println("cannot send data to server");     
        }
		return user;
	}

	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		HttpURLConnection conn = null;  
        ObjectOutputStream dos = null;  
        int responseCode = 0;
        try{  
             URL url = new URL(LSMOauthURL);  
             String name=OAUTH_USER;             
	      // Open a HTTP connection to the URL  
	
	         conn = (HttpURLConnection) url.openConnection();  
	         conn.setDoInput(true);  
	         conn.setDoOutput(true);  
	         conn.setUseCaches(false);  
	
	         // Use a post method.  
	         conn.setRequestMethod("POST");  
	         conn.setRequestProperty("objectType",name);
	         conn.setRequestProperty("OAuthGraphURL",LSMOauthGraphURL);
	         conn.setRequestProperty("operator", "delete");
		     conn.setRequestProperty("project", "openiot");
	         conn.setRequestProperty("Connection", "Keep-Alive");  
	         conn.setRequestProperty("Content-Type", "text/html"); 
	         
	         dos = new ObjectOutputStream( conn.getOutputStream() );  
	         dos.writeObject(userId);  
	         dos.flush();  
	         dos.close();   
	         
	      // always check HTTP response code from server
	        responseCode = conn.getResponseCode();
	        if (responseCode == HttpURLConnection.HTTP_OK) {	        	
	            System.out.println("Server's response: " + responseCode);
	        } else {
	            System.out.println("Server returned non-OK code: " + responseCode);
	        }	  		
        }catch (Exception ex) {  
        	ex.printStackTrace();
            System.out.println("cannot send data to server");     
        }
	}
	
	public void addUser(User user){
		// TODO Auto-generated method stub
		HttpURLConnection conn = null;  
        ObjectOutputStream dos = null;  
        int responseCode = 0;
        try{  
             URL url = new URL(LSMOauthURL);  
             String name=OAUTH_USER;             
	      // Open a HTTP connection to the URL  
	
	         conn = (HttpURLConnection) url.openConnection();  
	         conn.setDoInput(true);  
	         conn.setDoOutput(true);  
	         conn.setUseCaches(false);  
	
	         // Use a post method.  
	         conn.setRequestMethod("POST");  
	         conn.setRequestProperty("objectType",name);
	         conn.setRequestProperty("OAuthGraphURL",LSMOauthGraphURL);
	         conn.setRequestProperty("operator", "insert");
		     conn.setRequestProperty("project", "openiot");
	         conn.setRequestProperty("Connection", "Keep-Alive");  
	         conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");  
	        
	         dos = new ObjectOutputStream( conn.getOutputStream() );  
	         dos.writeObject(user);  
	         dos.flush();  
	         dos.close();  
	         
	      // always check HTTP response code from server
	        responseCode = conn.getResponseCode();
	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            // reads server's response
	            BufferedReader reader = new BufferedReader(new InputStreamReader(
	                    conn.getInputStream()));
	            String response = reader.readLine();
	            System.out.println("Server's response: " + response);
	        } else {
	            System.out.println("Server returned non-OK code: " + responseCode);
	        }	  		
        }catch (Exception ex) {  
        	ex.printStackTrace();
            System.out.println("cannot send data to server");     
        }
	}
	
	public LSMServiceTicketImpl getServiceTicketImpl(String ticketId) {
		// TODO Auto-generated method stub
		HttpURLConnection conn = null;  
        ObjectOutputStream dos = null;  
        int responseCode = 0;
        LSMServiceTicketImpl ticket = null;
        try{  
             URL url = new URL(LSMOauthURL);  
             String name="ServiceTicket";             
	      // Open a HTTP connection to the URL  
	
	         conn = (HttpURLConnection) url.openConnection();  
	         conn.setDoInput(true);  
	         conn.setDoOutput(true);  
	         conn.setUseCaches(false);  
	
	         // Use a post method.  
	         conn.setRequestMethod("POST");  
	         conn.setRequestProperty("objectType",name);
	         conn.setRequestProperty("OAuthGraphURL",LSMOauthGraphURL);
	         conn.setRequestProperty("operator", "load");
		     conn.setRequestProperty("project", "openiot");
	         conn.setRequestProperty("Connection", "Keep-Alive");  
	         conn.setRequestProperty("Content-Type", "text/html"); 
	         
	         dos = new ObjectOutputStream( conn.getOutputStream() );  
	         dos.writeObject(ticketId);  
	         dos.flush();  
	         dos.close();   
	         
	      // always check HTTP response code from server
	        responseCode = conn.getResponseCode();
	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            // reads server's response
	        	ObjectInputStream objStream =new ObjectInputStream(conn.getInputStream());
	            ticket = (LSMServiceTicketImpl) objStream.readObject();        
	            System.out.println("Server's response: " + responseCode);
	        } else {
	            System.out.println("Server returned non-OK code: " + responseCode);
	        }	  		
        }catch (Exception ex) {  
        	ex.printStackTrace();
            System.out.println("cannot send data to server");     
        }
		return ticket;
	}

	public void deleteServiceTicketImpl(String ticketId) {
		// TODO Auto-generated method stub
		HttpURLConnection conn = null;  
        ObjectOutputStream dos = null;  
        int responseCode = 0;
        try{  
             URL url = new URL(LSMOauthURL);  
             String name="ServiceTicket";             
	      // Open a HTTP connection to the URL  
	
	         conn = (HttpURLConnection) url.openConnection();  
	         conn.setDoInput(true);  
	         conn.setDoOutput(true);  
	         conn.setUseCaches(false);  
	
	         // Use a post method.  
	         conn.setRequestMethod("POST");  
	         conn.setRequestProperty("objectType",name);
	         conn.setRequestProperty("OAuthGraphURL",LSMOauthGraphURL);
	         conn.setRequestProperty("operator", "delete");
		     conn.setRequestProperty("project", "openiot");
	         conn.setRequestProperty("Connection", "Keep-Alive");  
	         conn.setRequestProperty("Content-Type", "text/html"); 
	         
	         dos = new ObjectOutputStream( conn.getOutputStream() );  
	         dos.writeObject(ticketId);  
	         dos.flush();  
	         dos.close();   
	         
	      // always check HTTP response code from server
	        responseCode = conn.getResponseCode();
	        if (responseCode == HttpURLConnection.HTTP_OK) {	                
	            System.out.println("Server's response: " + responseCode);
	        } else {
	            System.out.println("Server returned non-OK code: " + responseCode);
	        }	  		
        }catch (Exception ex) {  
        	ex.printStackTrace();
            System.out.println("cannot send data to server");     
        }
	}
	
	public void addServiceTicketImpl(LSMServiceTicketImpl serviceTicketImpl){
		// TODO Auto-generated method stub
		HttpURLConnection conn = null;  
        ObjectOutputStream dos = null;  
        int responseCode = 0;
        try{  
             URL url = new URL(LSMOauthURL);  
             String name="ServiceTicket";             
	      // Open a HTTP connection to the URL  
	
	         conn = (HttpURLConnection) url.openConnection();  
	         conn.setDoInput(true);  
	         conn.setDoOutput(true);  
	         conn.setUseCaches(false);  
	
	         // Use a post method.  
	         conn.setRequestMethod("POST");  
	         conn.setRequestProperty("objectType",name);
	         conn.setRequestProperty("OAuthGraphURL",LSMOauthGraphURL);
	         conn.setRequestProperty("operator", "insert");
		     conn.setRequestProperty("project", "openiot");
	         conn.setRequestProperty("Connection", "Keep-Alive");  
	         conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");  
	        
	         dos = new ObjectOutputStream( conn.getOutputStream() );  
	         dos.writeObject(serviceTicketImpl);  
	         dos.flush();  
	         dos.close();  
	         
	      // always check HTTP response code from server
	        responseCode = conn.getResponseCode();
	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            // reads server's response
	            BufferedReader reader = new BufferedReader(new InputStreamReader(
	                    conn.getInputStream()));
	            String response = reader.readLine();
	            System.out.println("Server's response: " + response);
	        } else {
	            System.out.println("Server returned non-OK code: " + responseCode);
	        }	  		
        }catch (Exception ex) {  
        	ex.printStackTrace();
            System.out.println("cannot send data to server");     
        }		
	}
	
	public LSMTicketGrantingTicketImpl getTicketGranting(String grantId) {
		// TODO Auto-generated method stub
		HttpURLConnection conn = null;  
        ObjectOutputStream dos = null;  
        int responseCode = 0;
        LSMTicketGrantingTicketImpl ticketGranting = null;
        try{  
             URL url = new URL(LSMOauthURL);  
             String name=OAUTH_TICKET_GRANTING;             
	      // Open a HTTP connection to the URL  
	
	         conn = (HttpURLConnection) url.openConnection();  
	         conn.setDoInput(true);  
	         conn.setDoOutput(true);  
	         conn.setUseCaches(false);  
	
	         // Use a post method.  
	         conn.setRequestMethod("POST");  
	         conn.setRequestProperty("objectType",name);
	         conn.setRequestProperty("OAuthGraphURL",LSMOauthGraphURL);
	         conn.setRequestProperty("operator", "load");
		     conn.setRequestProperty("project", "openiot");
	         conn.setRequestProperty("Connection", "Keep-Alive");  
	         conn.setRequestProperty("Content-Type", "text/html"); 
	         
	         dos = new ObjectOutputStream( conn.getOutputStream() );  
	         dos.writeObject(grantId);  
	         dos.flush();  
	         dos.close();   
	         
	      // always check HTTP response code from server
	        responseCode = conn.getResponseCode();
	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            // reads server's response
	        	ObjectInputStream objStream =new ObjectInputStream(conn.getInputStream());
	            ticketGranting = (LSMTicketGrantingTicketImpl) objStream.readObject();        
	            System.out.println("Server's response: " + responseCode);
	        } else {
	            System.out.println("Server returned non-OK code: " + responseCode);
	        }	  		
        }catch (Exception ex) {  
        	ex.printStackTrace();
            System.out.println("cannot send data to server");     
        }
		return ticketGranting;
	}

	public void deleteTicketGranting(String grantId) {
		// TODO Auto-generated method stub
		HttpURLConnection conn = null;  
        ObjectOutputStream dos = null;  
        int responseCode = 0;
        try{  
             URL url = new URL(LSMOauthURL);  
             String name=OAUTH_TICKET_GRANTING;             
	      // Open a HTTP connection to the URL  
	
	         conn = (HttpURLConnection) url.openConnection();  
	         conn.setDoInput(true);  
	         conn.setDoOutput(true);  
	         conn.setUseCaches(false);  
	
	         // Use a post method.  
	         conn.setRequestMethod("POST");  
	         conn.setRequestProperty("objectType",name);
	         conn.setRequestProperty("OAuthGraphURL",LSMOauthGraphURL);
	         conn.setRequestProperty("operator", "delete");
		     conn.setRequestProperty("project", "openiot");
	         conn.setRequestProperty("Connection", "Keep-Alive");  
	         conn.setRequestProperty("Content-Type", "text/html"); 
	         
	         dos = new ObjectOutputStream( conn.getOutputStream() );  
	         dos.writeObject(grantId);  
	         dos.flush();  
	         dos.close();   
	         
	      // always check HTTP response code from server
	        responseCode = conn.getResponseCode();
	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            // reads server's response	        	 
	            System.out.println("Server's response: " + responseCode);
	        } else {
	            System.out.println("Server returned non-OK code: " + responseCode);
	        }	  		
        }catch (Exception ex) {  
        	ex.printStackTrace();
            System.out.println("cannot send data to server");     
        }
	}
	
	public void addTicketGrangtingTicket(LSMTicketGrantingTicketImpl ticketGranting){
		// TODO Auto-generated method stub
		HttpURLConnection conn = null;  
        ObjectOutputStream dos = null;  
        int responseCode = 0;
        try{  
             URL url = new URL(LSMOauthURL);  
             String name= OAUTH_TICKET_GRANTING;             
	      // Open a HTTP connection to the URL  
	
	         conn = (HttpURLConnection) url.openConnection();  
	         conn.setDoInput(true);  
	         conn.setDoOutput(true);  
	         conn.setUseCaches(false);  
	
	         // Use a post method.  
	         conn.setRequestMethod("POST");  
	         conn.setRequestProperty("objectType",name);
	         conn.setRequestProperty("OAuthGraphURL",LSMOauthGraphURL);
	         conn.setRequestProperty("operator", "insert");
		     conn.setRequestProperty("project", "openiot");
	         conn.setRequestProperty("Connection", "Keep-Alive");  
	         conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");  
	        
	         dos = new ObjectOutputStream( conn.getOutputStream() );  
	         dos.writeObject(ticketGranting);  
	         dos.flush();  
	         dos.close();  
	         
	      // always check HTTP response code from server
	        responseCode = conn.getResponseCode();
	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            // reads server's response
	            BufferedReader reader = new BufferedReader(new InputStreamReader(
	                    conn.getInputStream()));
	            String response = reader.readLine();
	            System.out.println("Server's response: " + response);
	        } else {
	            System.out.println("Server returned non-OK code: " + responseCode);
	        }	  		
        }catch (Exception ex) {  
        	ex.printStackTrace();
            System.out.println("cannot send data to server");     
        }		
	}
	
	public LSMRegisteredServiceImpl getRegisteredService(long serviceId) {
		// TODO Auto-generated method stub
		HttpURLConnection conn = null;  
        ObjectOutputStream dos = null;  
        int responseCode = 0;
        LSMRegisteredServiceImpl service =  null;
        try{  
             URL url = new URL(LSMOauthURL);  
             String name=OAUTH_SERVICE;             
	      // Open a HTTP connection to the URL  
	
	         conn = (HttpURLConnection) url.openConnection();  
	         conn.setDoInput(true);  
	         conn.setDoOutput(true);  
	         conn.setUseCaches(false);  
	
	         // Use a post method.  
	         conn.setRequestMethod("POST");  
	         conn.setRequestProperty("objectType",name);
	         conn.setRequestProperty("OAuthGraphURL",LSMOauthGraphURL);
	         conn.setRequestProperty("operator", "load");
		     conn.setRequestProperty("project", "openiot");
	         conn.setRequestProperty("Connection", "Keep-Alive");  
	         conn.setRequestProperty("Content-Type", "text/html"); 
	         
	         dos = new ObjectOutputStream( conn.getOutputStream() );  
	         dos.writeObject(serviceId+"");  
	         dos.flush();  
	         dos.close();   
	         
	      // always check HTTP response code from server
	        responseCode = conn.getResponseCode();
	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            // reads server's response
	        	ObjectInputStream objStream =new ObjectInputStream(conn.getInputStream());
	            service = (LSMRegisteredServiceImpl) objStream.readObject();        
	            System.out.println("Server's response: " + responseCode);
	        } else {
	            System.out.println("Server returned non-OK code: " + responseCode);
	        }	  		
        }catch (Exception ex) {  
        	ex.printStackTrace();
            System.out.println("cannot send data to server");     
        }
		return service;
	}

	public void deleteRegisteredService(long serviceId) {
		// TODO Auto-generated method stub
		HttpURLConnection conn = null;  
        ObjectOutputStream dos = null;  
        int responseCode = 0;
        try{  
             URL url = new URL(LSMOauthURL);  
             String name=OAUTH_SERVICE;             
	      // Open a HTTP connection to the URL  
	
	         conn = (HttpURLConnection) url.openConnection();  
	         conn.setDoInput(true);  
	         conn.setDoOutput(true);  
	         conn.setUseCaches(false);  
	
	         // Use a post method.  
	         conn.setRequestMethod("POST");  
	         conn.setRequestProperty("objectType",name);
	         conn.setRequestProperty("OAuthGraphURL",LSMOauthGraphURL);
	         conn.setRequestProperty("operator", "delete");
		     conn.setRequestProperty("project", "openiot");
	         conn.setRequestProperty("Connection", "Keep-Alive");  
	         conn.setRequestProperty("Content-Type", "text/html"); 
	         
	         dos = new ObjectOutputStream( conn.getOutputStream() );  
	         dos.writeObject(serviceId+"");  
	         dos.flush();  
	         dos.close();   
	         
	      // always check HTTP response code from server
	        responseCode = conn.getResponseCode();
	        if (responseCode == HttpURLConnection.HTTP_OK) {    
	            System.out.println("Server's response: " + responseCode);
	        } else {
	            System.out.println("Server returned non-OK code: " + responseCode);
	        }	  		
        }catch (Exception ex) {  
        	ex.printStackTrace();
            System.out.println("cannot send data to server");     
        }
	}
	
	public void addRegisteredService(LSMRegisteredServiceImpl reg_service){
		// TODO Auto-generated method stub
		HttpURLConnection conn = null;  
        ObjectOutputStream dos = null;  
        int responseCode = 0;
        try{  
             URL url = new URL(LSMOauthURL);  
             String name=OAUTH_SERVICE;             
	      // Open a HTTP connection to the URL  
	
	         conn = (HttpURLConnection) url.openConnection();  
	         conn.setDoInput(true);  
	         conn.setDoOutput(true);  
	         conn.setUseCaches(false);  
	
	         // Use a post method.  
	         conn.setRequestMethod("POST");  
	         conn.setRequestProperty("objectType",name);
	         conn.setRequestProperty("OAuthGraphURL",LSMOauthGraphURL);
	         conn.setRequestProperty("operator", "insert");
		     conn.setRequestProperty("project", "openiot");
	         conn.setRequestProperty("Connection", "Keep-Alive");  
	         conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");  
	        
	         dos = new ObjectOutputStream( conn.getOutputStream() );  
	         dos.writeObject(reg_service);  
	         dos.flush();  
	         dos.close();  
	         
	      // always check HTTP response code from server
	        responseCode = conn.getResponseCode();
	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            // reads server's response
	            BufferedReader reader = new BufferedReader(new InputStreamReader(
	                    conn.getInputStream()));
	            String response = reader.readLine();
	            System.out.println("Server's response: " + response);
	        } else {
	            System.out.println("Server returned non-OK code: " + responseCode);
	        }	  		
        }catch (Exception ex) {  
        	ex.printStackTrace();
            System.out.println("cannot send data to server");     
        }		
	}
	
	
	
	
	/**
	 * Returns the list of all LSMTicketGrantingTicketImpl having grantId as
	 * ticketGrantingTicket
	 * 
	 * @param grantId
	 * @return
	 */
	public List<LSMServiceTicketImpl> getAllServiceTicketsOfTicketGrantingTicket(String grantId) {
		String prefix = "http://lsm.deri.ie/resource/";
		String grantURL = prefix + grantId;
		if(grantId.contains(prefix)){
			grantURL = grantId;
			grantId = grantId.substring(grantId.lastIndexOf("/")+1);
		}
		List<LSMServiceTicketImpl> ticketList  = null;
		String sparql = "select ?ticket"+
				" from <"+ LSMOauthGraphURL +"> \n" +
				"where{ "+
				   "?ticket <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> <http://openiot.eu/ontology/ns/Ticket>."+		
				   "?ticket <http://openiot.eu/ontology/ns/grantedBy> "+"<"+grantURL+">. \n" +
				"}";			 
		try{
			String service = "http://lsm.deri.ie/sparql";
			QueryExecution vqe = new QueryEngineHTTP(service, sparql);
			ResultSet results = vqe.execSelect();
			ticketList = new ArrayList<LSMServiceTicketImpl>();
			while (results.hasNext()) {
				QuerySolution soln = results.nextSolution();
				LSMServiceTicketImpl t = getServiceTicketImpl(soln.get("?ticket").toString()); //please use the getTicketService with ticketId is a substring of soln.get("?ticket")
				ticketList.add(t);
			}
			vqe.close();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return  ticketList;
	}

	/**
	 * Returns the list of all LSMTicketGrantingTicketImpls
	 * 
	 * @return
	 */
	public List<LSMTicketGrantingTicketImpl> getAllTicketGrantingTickets() {
		List<LSMTicketGrantingTicketImpl> grantList  = null;
		String sparql = " select ?tic_grant"+
				" from <"+ LSMOauthGraphURL +"> \n" +
				"where{ "+
				   "?tic_grant <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> <http://openiot.eu/ontology/ns/TicketScheduler>."+		
				"}";			 
		try{
			String service = "http://lsm.deri.ie/sparql";
			QueryExecution vqe = new QueryEngineHTTP(service, sparql);
			ResultSet results = vqe.execSelect();
			grantList = new ArrayList<LSMTicketGrantingTicketImpl>();
			while(results.hasNext()){
				QuerySolution soln = results.nextSolution();
				LSMTicketGrantingTicketImpl t = getTicketGranting(soln.get("?tic_grant").toString());
				grantList.add(t);
			}
			vqe.close();	
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return  grantList;
	}

	/**
	 * Returns the list of all LSMServiceTicketImpls
	 * 
	 * @return
	 */
	public List<LSMServiceTicketImpl> getAllServiceTickets() {		
		List<LSMServiceTicketImpl> ticketList  = null;
		String sparql = " select ?ticket"+
				" from <"+ LSMOauthGraphURL +"> \n" +
				"where{ "+
				   "?ticket <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> <http://openiot.eu/ontology/ns/Ticket>."+		
				"}";			 
		try{
			String service = "http://lsm.deri.ie/sparql";
			QueryExecution vqe = new QueryEngineHTTP(service, sparql);
			ResultSet results = vqe.execSelect();	
			ticketList = new ArrayList<LSMServiceTicketImpl>();
			while(results.hasNext()){
				QuerySolution soln = results.nextSolution();
				LSMServiceTicketImpl t = getServiceTicketImpl(soln.get("?ticket").toString());// please use getTicket method
				ticketList.add(t);
			}			
			vqe.close();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return  ticketList;
	}

	/**
	 * Returns the the number of available LSMTicketGrantingTicketImpls
	 * 
	 * @return
	 */
	public int getTicketGrantingTicketsCount() {
		return -1;
	}

	/**
	 * Returns the the number of available LSMServiceTicketImpls
	 * 
	 * @return
	 */
	public int getServiceTicketsCount() {
		return -1;
	}

	/**
	 * Retrievs a user by the username
	 * 
	 * @param username
	 * @return
	 */
	public User getUserByUsername(String username) {
		org.openiot.lsm.security.oauth.mgmt.User user = null;
		String userURL = "http://lsm.deri.ie/resource/user/"+username;
		if(username.contains("http://lsm.deri.ie/resource/user/")){
			userURL = username;
			username = username.substring(username.lastIndexOf("/")+1);
		}
		String sparql = " select ?nick ?mbox ?pass ?role"+
				" from <"+ LSMOauthGraphURL +"> \n" +
				"where{ "+
				   "<"+userURL+"> <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> <http://openiot.eu/ontology/ns/User>."+				   
				   "OPTIONAL{<"+userURL+"> <http://xmlns.com/foaf/0.1/nick> ?nick.}"+
				   "OPTIONAL{<"+userURL+"> <http://xmlns.com/foaf/0.1/mbox> ?mbox.}"+
				   "<"+userURL+"> <http://openiot.eu/ontology/ns/password> ?pass."+
				   "<"+userURL+"> <http://openiot.eu/ontology/ns/role> ?role."+
				"}";			 
		try{
			String service = "http://lsm.deri.ie/sparql";
			QueryExecution vqe = new QueryEngineHTTP(service, sparql);
			ResultSet results = vqe.execSelect();
			user = new org.openiot.lsm.security.oauth.mgmt.User();
			user.setUsername(username);				
			while(results.hasNext()){
				QuerySolution soln = results.nextSolution();
				user.setEmail(soln.get("?mbox").toString());
				user.setPassword(soln.get("?pass").toString());
				user.setName(soln.get("?nick").toString());
				List<Role> roles = user.getRoles();
				if(roles==null){
					roles = new ArrayList<Role>();
					user.setRoles(roles);
				}
				Role role = getRole(soln.get("?role").toString());// please use getRole method
				if(!roles.contains(role)){
					roles.add(role);
				}
			}			
			vqe.close();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return  user;
	}

	/**
	 * Retrieves all LSMRegisteredServiceImpls
	 * 
	 * @return
	 */
	public List<RegisteredService> getAllRegisteredServices() {		
		List<RegisteredService> serviceList  = null;
		String sparql = " select ?service"+
				" from <"+ LSMOauthGraphURL +"> \n" +
				"where{ "+
				   "?service <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> <http://openiot.eu/ontology/ns/CloudService>."+		
				"}";			 
		try{
			String service = "http://lsm.deri.ie/sparql";
			QueryExecution vqe = new QueryEngineHTTP(service, sparql);
			ResultSet results = vqe.execSelect();	
			serviceList = new ArrayList<RegisteredService>();
			while(results.hasNext()){
				QuerySolution soln = results.nextSolution();
				LSMRegisteredServiceImpl t = getRegisteredService(Long.parseLong(soln.get("?service").toString()));//please use the getRegisteredService method which Long service Id
				serviceList.add(t);
			}				
			vqe.close();
		}catch(Exception e){
			e.printStackTrace();			
			return null;
		}
		return  serviceList;
	}
}
