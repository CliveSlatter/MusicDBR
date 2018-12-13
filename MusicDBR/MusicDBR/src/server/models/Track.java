package server.models;
import java.util.ArrayList;
import org.json.simple.JSONObject;

public class Track {
    private int trackId;
    private int year;
    private String artist;
    private String title;

    public Track(int trackId, int year, String artist, String title) {
        this.trackId = trackId;
        this.year = year;
        this.artist = artist;
        this.title = title;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static ArrayList<Track> tracks = new ArrayList<>();

    public static int nextId() {
        int id = 0;
        for (Track t: tracks) {
            if (t.getTrackId() > id) {
                id = t.getTrackId();
            }
        }
        return id + 1;
    }

    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject j = new JSONObject();
        j.put("trackId", getTrackId());
        j.put("year", getYear());
        j.put("artist", getArtist());
        j.put("title", getTitle());
        return j;
    }
}
