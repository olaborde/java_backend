package com.ol.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.ol.beans.Contact;

@Path("/webservice")
public class WebController {
//	
	private static Map<Integer, Contact> contacts = new HashMap<Integer, Contact>();

	static {

		contacts.put(1, new Contact(11, "Kobe Bryant"));
		contacts.put(2, new Contact(12, "Kink Lebron"));

	}

//	
	@GET
	@Path("/hello")
	@Produces("text/plain")
	public String hello() {
		return "Hello World!! Resful Web Services By Osse Laborde";
	}

	@GET
	@Path("/contacts/{id}")
//	@Produces("application/json")
	public Contact getContact(@PathParam("id") int id) throws Exception {
		if (contacts.get(id) != null) {
			return contacts.get(id);
		} else
			throw new Exception("Contact Boss for your id");
	}
	
	public void deleteContact(@PathParam("id") int id, Contact contact) throws Exception {
		if (contacts.get(id) != null) {
			
		} else
			throw new Exception("Contact Boss for your id");
		
		
	}

	@GET
	@Path("/contacts/")
//	@Produces("application/json")
	public List<Contact> listContacts() {
		return new ArrayList<Contact>(contacts.values());
	}
	
	
	@POST
    @Path("/contacts/byjson")
   // @Consumes("MediaType.APPLICATION_FORM_URLENCODED")
//    @Produces("application/xml")
    public Contact createContact1(  Contact contact)throws Exception
    {  
        try{
            //int id1 = Integer.parseInt(id);
        System.out.println("hi");
       // Contact contact =new Contact(id1,name);
        contacts.put(contact.getId(),contact);
        return (contacts.get(contact.getId()));
        }
        catch(Exception e)
        {
        	throw new Exception("Contact Boss fro your id");
        }
        }
	
	
	@POST
    @Path("/contacts")
   // @Consumes("MediaType.APPLICATION_FORM_URLENCODED")
    @Produces("application/json")
    public Contact createContact( @FormParam("id")String id,@FormParam("name")String name)throws Exception
    {  
        try{
            int id1 = Integer.parseInt(id);
        System.out.println("hi");
        Contact contact =new Contact(id1,name);
        contacts.put(contact.getId(),contact);
        return (contacts.get(contact.getId()));
        }
        catch(Exception e)
        {
        	throw new Exception("Contact Boss fro your id");
        }
        }
	
	
	
	

}
