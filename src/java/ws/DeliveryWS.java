/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

/**
 *
 * @author Cátia
 */

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import receiver.RequestReceiver;

@Path("/deliveryWS")
public class DeliveryWS {
    
    private RequestReceiver requestReceiver = new RequestReceiver();
    
    @GET
    @Path("/createCity")
    @Produces(MediaType.TEXT_PLAIN)
    public String createCity(@QueryParam("username") String username, @QueryParam("cityname") String cityName){
        
        if(username == null || cityName == null){
            return "Nulls found, please insert values";
        }
        
        return requestReceiver.requestCreateCity(username, cityName);
    }
    
    @GET
    @Path("/selectCity")
    @Produces(MediaType.TEXT_PLAIN)
    public String selectCity(@QueryParam("cityname") String cityName){
        
        if(cityName == null){
            return "Nulls found, please insert values";
        }
        
        return requestReceiver.requestReadCity(cityName);
    }
    
    @GET
    @Path("/updateCity")
    @Produces(MediaType.TEXT_PLAIN)
    public String updateCity(@QueryParam("username") String username, @QueryParam("oldcityname") String oldCityName,
            @QueryParam("newcityname") String newCityName){
        
        if(username == null || oldCityName == null || newCityName == null){
            return "Nulls found, please insert values";
        }
        
        return requestReceiver.requestUpdateCity(username, oldCityName, newCityName);
    }
    
    @GET
    @Path("/deleteCity")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteCity(@QueryParam("username") String username, @QueryParam("cityname") String cityName){
        
        if(username == null || cityName == null){
            return "Nulls found, please insert values";
        }
        
        return requestReceiver.requestDeleteCity(username, cityName);
    }
    
    @GET
    @Path("/createRoute")
    @Produces(MediaType.TEXT_PLAIN)
    public String createRoute(@QueryParam("username") String username, @QueryParam("origin") String origin,
            @QueryParam("destination") String destination, @QueryParam("time") int time, @QueryParam("cost") int cost){
        
        if(username == null || origin == null || destination == null || time == 0 || cost == 0){
            return "Nulls found, please insert values";
        }
        
        return requestReceiver.requestCreateRoute(username, origin, destination, time, cost);
    }
    
    @GET
    @Path("/selectRoute")
    @Produces(MediaType.TEXT_PLAIN)
    public String selectRoute(@QueryParam("origin") String origin, @QueryParam("destination") String destination){
        
        if(origin == null || destination == null){
            return "Nulls found, please insert values";
        }
        
        return requestReceiver.requestReadRoute(origin, destination);
    }
    
    @GET
    @Path("/updateRoute")
    @Produces(MediaType.TEXT_PLAIN)
    public String updateRoute(@QueryParam("username") String username, @QueryParam("origin") String origin, @QueryParam("destination") String destination,
            @QueryParam("time") int time, @QueryParam("cost") int cost){
        
        if(username == null || origin == null || destination == null || time == 0 || cost == 0){
            return "Nulls found, please insert values";
        }
        
        return requestReceiver.requestUpdateRoute(username, origin, destination, time, cost);
    }
    
    @GET
    @Path("/deleteRoute")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteRoute(@QueryParam("username") String username, @QueryParam("origin") String origin,
            @QueryParam("destination") String destination){
        
        if(username == null || origin == null || destination == null){
            return "Nulls found, please insert values";
        }
        
        return requestReceiver.requestDeleteRoute(username, origin, destination);
    }
    
    @GET
    @Path("/getShortestPath")
    @Produces(MediaType.TEXT_PLAIN)
    public String getShortestPath(@QueryParam("origin") String origin, @QueryParam("destination") String destination,
            @QueryParam("measure") String measure){
        
        if(origin == null || destination == null || measure == null){
            return "Nulls found, please insert values";
        }
        
        return requestReceiver.getShortestPath(origin, destination, measure);
    }
}
