package onlineShopping;

import java.util.*;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/groups")
public class OnlineShoppingGroupsRest 
{
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Group> getGroupsDisplayJSON() {

    	List<Group> groups=createGroupsList();
        return groups;
    }
    
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getGroupsDisplayHTML() {

    	List<Group> groups=createGroupsList();
    	String htmlTable = 
			    			"<table border = 1 style=\"text-align: center; margin-top: 40px; margin-left: 25%;\"><tr>"
							+"<th style=\"padding: 10px;\"> Group_Name </th>"
							+ "<th style=\"padding: 10px;\">Group_Id</th></tr>";
    	for (Group group  : groups)
    	{
    		htmlTable  += 
		    				"<tr><td style=\"padding: 10px;\">" +group.getName()+ "</td>"
							+ "<td style=\"padding: 10px;\">" +group.getId()+" </td></tr>";
    	}
    	htmlTable +="</table>";
    	
        return htmlTable;
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/search/{groupId}")
    public Group searchJSONGroupsById(@PathParam("groupId")  int id) {

    	List<Group> groups=createGroupsList();
        for ( Group group : groups)
        {
        	if(group.getId() == id)
        	{
        	  return group;
        	}
        }
        	
     return null;
    }
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/search/{groupId}")
    public String searchHTMLGroupsById(@PathParam("groupId")  int id) {

    	List<Group> groups=createGroupsList();
    	
    	String htmlTable = 
    			"<table border = 1 style=\"text-align: center; margin-top: 40px; margin-left: 25%;\"><tr>"
				+"<th style=\"padding: 10px;\"> Group_Name </th>"
				+ "<th style=\"padding: 10px;\">Group_Id</th></tr>";
    	
        for ( Group group : groups)
        {
        	if(group.getId() == id)
        	{

        		htmlTable  += 
    		    				"<tr><td style=\"padding: 10px;\">" +group.getName()+ "</td>"
    							+ "<td style=\"padding: 10px;\">" +group.getId()+" </td></tr></table>";
        	  return htmlTable;
        	}
        }
        	
     return null;
    }
    
    public List<Group> createGroupsList()
    {
        List<Group> groups = new ArrayList<>();

        groups.add(new Group("Health and beauty", 1));
        groups.add(new Group("Toys", 2));
        groups.add(new Group("Dairy", 3));
        groups.add(new Group("Computers", 4));
        groups.add(new Group("Electronics", 5));
        groups.add(new Group("Home", 6));
        return groups;
    }
    
}
