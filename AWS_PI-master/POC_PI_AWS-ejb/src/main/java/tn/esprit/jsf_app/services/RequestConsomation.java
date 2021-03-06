package tn.esprit.jsf_app.services;


import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;

import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.esprit.jsf_app.entities.Request;
import tn.esprit.jsf_app.entities.Request.Category;
import tn.esprit.jsf_app.entities.Request.Kind;
import tn.esprit.jsf_app.entities.Request.Priority;
import tn.esprit.jsf_app.entities.Request.Status;




/**
 * Session Bean implementation class DemandeurConsom
 * @param <Meeting>
 */
@Stateless
@LocalBean
public class RequestConsomation implements RequestConsomationRemote {

    public RequestConsomation() {
        // TODO Auto-generated constructor stub
    }

    public List<Request> consomation1()
    {
    	List<Request>  lasp = new ArrayList<Request>();
    	
    	Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://localhost:6795/api/RequestWebApi"); 
    	
    	Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	//System.out.println(result);
    	JsonReader jsonReader = Json.createReader(new StringReader(result));
    	JsonArray object =  jsonReader.readArray();
    	System.out.println("erreuuur");
   
    	
    	for (int i=0;i<object.size();i++)
    	{
    	 
    		Request m = new Request();
    	m.setRequestId(Integer.parseInt(object.getJsonObject(i).get("RequestId").toString()));
    	System.out.println("fffffff "+Integer.parseInt(object.getJsonObject(i).get("RequestId").toString()));
    	 m.setName(object.getJsonObject(i).get("Name").toString()); 
    	 m.setSubject(object.getJsonObject(i).get("Subject").toString());
    	 m.setCategory(Category.values()[Integer.parseInt(object.getJsonObject(i).get("Category").toString())] );
    	 m.setPriority(Priority.values()[Integer.parseInt(object.getJsonObject(i).get("Priority").toString())] );
    	 m.setKind(Kind.values()[Integer.parseInt(object.getJsonObject(i).get("Kind").toString())] );
    	 m.setStatus(Status.values()[Integer.parseInt(object.getJsonObject(i).get("Status").toString())] );
    	 
    	 
    	 m.setProjectId(Integer.parseInt(object.getJsonObject(i).get("ProjectId").toString()));
    	 m.setId(Integer.parseInt(object.getJsonObject(i).get("Id").toString()));
    	 m.setUserCreate(object.getJsonObject(i).get("UserCreate").toString());
    	 
    	 Boolean x= Boolean.parseBoolean(object.getJsonObject(i).get("flag").toString());
    	 System.out.println("boolean "+x);
    	 m.setFlag(Boolean.parseBoolean(object.getJsonObject(i).get("flag").toString()));
    	 
    	 
    	 SimpleDateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    	 
    	 String dateString;
    	 dateString = object.getJsonObject(i).get("UpdateDate").toString();
    	dateString = dateString.replaceAll("\"", "");
    	 Date date = null;
    	 try {
        
    	  date = sourceFormat.parse(dateString);
    	   
    	 } 
    	 catch (ParseException e) {
    	   e.printStackTrace();
    	 }
    	
    	 m.setUpdateDate(date); 


    	
    	 if (x==false) {
    		 lasp.add(m);
    	 }
    	 
    	    	}
    	

return lasp;    	
    }
   

    public List<Request> consomation()
    {
    	List<Request>  lasp = new ArrayList<Request>();
    	
    	Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://localhost:6795/api/RequestWebApi"); 
    	
    	Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	//System.out.println(result);
    	JsonReader jsonReader = Json.createReader(new StringReader(result));
    	JsonArray object =  jsonReader.readArray();
    	System.out.println("erreuuur");
   
    	
    	for (int i=0;i<object.size();i++)
    	{
    	 
    		Request m = new Request();
    	m.setRequestId(Integer.parseInt(object.getJsonObject(i).get("RequestId").toString()));
    	System.out.println("fffffff "+Integer.parseInt(object.getJsonObject(i).get("RequestId").toString()));
    	 m.setName(object.getJsonObject(i).get("Name").toString()); 
    	 m.setSubject(object.getJsonObject(i).get("Subject").toString());
    	 m.setCategory(Category.values()[Integer.parseInt(object.getJsonObject(i).get("Category").toString())] );
    	 m.setPriority(Priority.values()[Integer.parseInt(object.getJsonObject(i).get("Priority").toString())] );
    	 m.setKind(Kind.values()[Integer.parseInt(object.getJsonObject(i).get("Kind").toString())] );
    	 m.setStatus(Status.values()[Integer.parseInt(object.getJsonObject(i).get("Status").toString())] );
    	 
    	 
    	 m.setProjectId(Integer.parseInt(object.getJsonObject(i).get("ProjectId").toString()));
    	 m.setId(Integer.parseInt(object.getJsonObject(i).get("Id").toString()));
    	 m.setUserCreate(object.getJsonObject(i).get("UserCreate").toString());
    	 
    	 Boolean x= Boolean.parseBoolean(object.getJsonObject(i).get("flag").toString());
    	 System.out.println("boolean "+x);
    	 m.setFlag(Boolean.parseBoolean(object.getJsonObject(i).get("flag").toString()));
    	 
    	 
    	 SimpleDateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    	 
    	 String dateString;
    	 dateString = object.getJsonObject(i).get("UpdateDate").toString();
    	dateString = dateString.replaceAll("\"", "");
    	 Date date = null;
    	 try {
        
    	  date = sourceFormat.parse(dateString);
    	   
    	 } 
    	 catch (ParseException e) {
    	   e.printStackTrace();
    	 }
    	
    	 m.setUpdateDate(date); 


    	
    	 if (x==true) {
    		 lasp.add(m);
    	 }
    	 
    	    	}
    	

return lasp;    	
    }
    
    public void  ajouterRequest(Request r)
    {
    String uri = "http://localhost:6795/api/Request/Create";

	Client client = ClientBuilder.newClient();
	WebTarget target = client.target(uri);

	Entity<Request> jsonEntity = Entity.json(r);

	Invocation.Builder builder = target.request();
	Response message = builder.post(jsonEntity);
}
    
    
    
    public  void deleteRequest(Integer id) {

    	System.out.println("id"+id);
    	Client client = ClientBuilder.newClient();
    	WebTarget webTarget = client.target("http://localhost:6795/api/RequestWebApi/"+id);
    	 
    	Invocation.Builder invocationBuilder =  webTarget.request();
    	Response response = invocationBuilder.delete();
    	//System.out.println("id"+id);
    	System.out.println(response.getStatus());
    	System.out.println(response.readEntity(String.class));
    }
    
    
    public void updateRequest(Request r, int id) {
		
    	Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:6795/api/Request/Update?RequestId="+id);
		WebTarget hello =target.path("");
		
		Response response =hello.request().put(Entity.entity(r, MediaType.APPLICATION_JSON) );
		
		String result=response.readEntity(String.class);
		System.out.println(result);

		response.close();
		
	}
    
    
    
    
    
    
    
    
}
    
