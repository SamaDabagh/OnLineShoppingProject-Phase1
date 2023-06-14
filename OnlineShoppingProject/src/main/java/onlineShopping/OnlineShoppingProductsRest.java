package onlineShopping;

import java.util.*;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/products")
public class OnlineShoppingProductsRest {
	
	 private static Map<String, Product> products = new HashMap<>();
	    static {
	        // Populate the products map with data from the JSON database
	        products.put("1001", new Product("Dove Shampoo", 1, "12.99", "12.99", 1, true, "CAD",
	                "https://images.costco-static.com/ImageDelivery/imageService?profileId=12026539&imageId=170547-894__1&recipeName=350"));
	        products.put("1002", new Product("Kirkland Shampoo", 1, "18.49", "12.49", 2, true, "CAD",
	                "https://images.costco-static.com/ImageDelivery/imageService?profileId=12026539&imageId=348196-894__1&recipeName=350"));
	        products.put("1003", new Product("Safeblend Foam Soap", 1, "64.99", "64.99", 1, false, "CAD",
	                "https://images.costco-static.com/ImageDelivery/imageService?profileId=12026539&itemId=407636-894&recipeName=680"));
	        products.put("2001", new Product("Pokemon Orbeetle", 2, "28.99", "28.99", 1, true, "CAD",
	                "https://images.costco-static.com/ImageDelivery/imageService?profileId=12026539&imageId=1629861-894__1&recipeName=350"));
	        products.put("2002", new Product("Eurographics 2-pack Puzzle Set", 2, "33.89", "33.89", 1, true, "CAD",
	                "https://images.costco-static.com/ImageDelivery/imageService?profileId=12026539&itemId=1581375-894&recipeName=680"));
	        products.put("3001", new Product("Kirkland Yogurt", 3, "4.99", "3.99", 1, true, "CAD",
	                "https://images.costco-static.com/ImageDelivery/imageService?profileId=12026539&itemId=319075-894&recipeName=680"));
	        products.put("3002", new Product("Almond Milk", 3, "3.99", "0.99", 1, false, "CAD",
	                "https://cdn.shopify.com/s/files/1/0599/5983/6823/products/1002374-894__1_1024x.jpg?v=1644714186"));
	        products.put("4001", new Product("Asus Zenbook 4", 4, "1299.99", "1399.99", 1, true, "CAD",
	                "https://images.costco-static.com/ImageDelivery/imageService?profileId=12026539&itemId=1457182-894&recipeName=680"));
	        products.put("4002", new Product("Macbook pro 2000", 4, "3999.79", "3799.79", 1, true, "CAD",
	                "https://images.costco-static.com/ImageDelivery/imageService?profileId=12026539&imageId=4000036480-894__1&recipeName=350"));
	        products.put("5001", new Product("LG TV", 5, "899.89", "899.89", 1, true, "CAD",
	                "https://images.costco-static.com/ImageDelivery/imageService?profileId=12026539&imageId=9912055-894__1&recipeName=350"));
	        products.put("5002", new Product("Samsung TV", 5, "1299.89", "1099.89", 1, false, "CAD",
	                "https://images.costco-static.com/ImageDelivery/imageService?profileId=12026539&itemId=5308165-894&recipeName=680"));
	        products.put("6001", new Product("IKEA Sofa set", 6, "4099.99", "4099.99", 1, true, "CAD",
	                "https://www.ikea.com/ca/en/images/products/uppland-sofa-totebo-light-beige__0818572_pe774494_s5.jpg?f=xl"));
	        products.put("6002", new Product("Tomasville Dining Table", 6, "3299.99", "3099.99", 1, true, "CAD",
	                "https://images.costco-static.com/ImageDelivery/imageService?profileId=12026539&itemId=1635357-894&recipeName=680"));
	    }

	    @GET
        @Produces(MediaType.TEXT_HTML)
	    public String getAllProductsDisplayHTML() {

	    	String htmlTable = 
	    			"<table border = 1 style=\"text-align: center; margin-top: 40px;\"><tr>"
					+"<th style=\"padding: 10px;\"> Product_Id </th>"
					+"<th style=\"padding: 10px;\"> Product_Id </th>"
					+"<th style=\"padding: 10px;\"> Product_Group </th>"
					+"<th style=\"padding: 10px;\"> Product_Price </th>"
					+"<th style=\"padding: 10px;\"> Product_ReducedPrice </th>"
					+"<th style=\"padding: 10px;\"> Product_MinOrder </th>"
					+"<th style=\"padding: 10px;\"> canBeSold </th>"
					+"<th style=\"padding: 10px;\"> pricePreFix </th>"
					+ "<th style=\"padding: 10px;\">imageUrl</th></tr>";
	    	
	        for (Map.Entry<String, Product> entry : products.entrySet()) 
	        {
	            String productId = entry.getKey();
	            Product product = entry.getValue();
	    		htmlTable  += 
			    				"<tr><td style=\"padding: 10px;\">" +productId+ "</td>"
								+ "<td style=\"padding: 10px;\">" +product.getName()+" </td>"
								+ "<td style=\"padding: 10px;\">" +product.getGroup()+" </td>"
								+ "<td style=\"padding: 10px;\">" +product.getPrice()+" </td>"
								+ "<td style=\"padding: 10px;\">" +product.getReducedPrice()+" </td>"
								+ "<td style=\"padding: 10px;\">" +product.getMinOrder()+" </td>"
								+ "<td style=\"padding: 10px;\">" +product.isCanBeSold()+" </td>"
								+ "<td style=\"padding: 10px;\">" +product.getPricePreFix()+" </td>"
								+ "<td style=\"padding: 10px;\">" +product.getImageUrl()+" </td></tr>";

				}
				htmlTable +="</table>";
	     
	        return htmlTable;
	    }

	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public String getAllProductsDisplayJSON() {
	        String json = "{";
	        int count = 0;
	        for (Map.Entry<String, Product> entry : products.entrySet()) {
	            String productId = entry.getKey();
	            Product product = entry.getValue();
	            json += "\"" + productId + "\":" + productToJsonString(product) + ",";
	            count++;
	        }
	        if (count > 0) {
	            json = json.substring(0, json.length() - 1); // Remove the trailing comma
	        }
	        json += "}";
	        return json;
	    }

	    @GET
	    @Path("/search/{productId}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public String searchHTMLProductById(@PathParam("productId") String productId) 
	    {
	        for (Map.Entry<String, Product> entry : products.entrySet()) 
	        { 
	            if (entry.getKey().equals(productId))
	            {
	            	return  productToJsonString(entry.getValue()) ;
	            }
	        }
	        return null;
	    }
	    
	    @GET
	    @Path("/search/{productId}")
	    @Produces(MediaType.TEXT_HTML)
	    public String getProductById(@PathParam("productId") String productId) 
	    {
	    	String htmlTable = 
	    			"<table border = 1 style=\"text-align: center; margin-top: 40px;\"><tr>"
					+"<th style=\"padding: 10px;\"> Product_Id </th>"
					+"<th style=\"padding: 10px;\"> Product_Id </th>"
					+"<th style=\"padding: 10px;\"> Product_Group </th>"
					+"<th style=\"padding: 10px;\"> Product_Price </th>"
					+"<th style=\"padding: 10px;\"> Product_ReducedPrice </th>"
					+"<th style=\"padding: 10px;\"> Product_MinOrder </th>"
					+"<th style=\"padding: 10px;\"> canBeSold </th>"
					+"<th style=\"padding: 10px;\"> pricePreFix </th>"
					+ "<th style=\"padding: 10px;\">imageUrl</th></tr>";
	    	
	        for (Map.Entry<String, Product> entry : products.entrySet()) 
	        { 
	            if (entry.getKey().equals(productId))
	            {

		            Product product = entry.getValue();
		    		htmlTable  += 
				    				"<tr><td style=\"padding: 10px;\">" +entry.getKey()+ "</td>"
									+ "<td style=\"padding: 10px;\">" +product.getName()+" </td>"
									+ "<td style=\"padding: 10px;\">" +product.getGroup()+" </td>"
									+ "<td style=\"padding: 10px;\">" +product.getPrice()+" </td>"
									+ "<td style=\"padding: 10px;\">" +product.getReducedPrice()+" </td>"
									+ "<td style=\"padding: 10px;\">" +product.getMinOrder()+" </td>"
									+ "<td style=\"padding: 10px;\">" +product.isCanBeSold()+" </td>"
									+ "<td style=\"padding: 10px;\">" +product.getPricePreFix()+" </td>"
									+ "<td style=\"padding: 10px;\">" +product.getImageUrl()+" </td></tr>";
					htmlTable +="</table>";
					return htmlTable;	            

					}

		     
	        }
	        return null;
	    }

	    
	    private String productToJsonString(Product product) {
	        String json = "{";
	        json += "\"name\":\"" + product.getName() + "\",";
	        json += "\"group\":" + product.getGroup() + ",";
	        json += "\"price\":" + product.getPrice() + ",";
	        json += "\"reducedPrice\":" + product.getReducedPrice() + ",";
	        json += "\"minOrder\":" + product.getMinOrder() + ",";
	        json += "\"canBeSold\":" + product.isCanBeSold() + ",";
	        json += "\"pricePreFix\":\"" + product.getPricePreFix() + "\",";
	        json += "\"imageUrl\":\"" + product.getImageUrl() + "\"";
	        json += "}";
	        return json;
	    }
	

	   
}
