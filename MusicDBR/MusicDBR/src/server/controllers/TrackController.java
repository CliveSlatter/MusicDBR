package server.controllers;

import server.Console;
import server.models.Track;
import server.models.services.TrackService;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("track/")
public class TrackController {

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public String trackList() {

        Console.log("/track/list - Getting all tracks from database");

        String status = TrackService.selectAllInto(Track.tracks);

        if (status.equals("OK")) {

            JSONArray trackList = new JSONArray();
            for (Track c: Track.tracks) {

                JSONObject jc = c.toJSON();
                trackList.add(jc);

            }

            return trackList.toString();

        } else {

            System.out.println("An error occurred! " + status);
            return "";

        }

    }

}

