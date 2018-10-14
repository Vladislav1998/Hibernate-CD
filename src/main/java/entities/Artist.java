package entities;

import java.util.Set;

public class Artist {
    private  int Artist_ID;
    private  String  Name;
    private  int Number_of_albums;
    private Set<Cd> cds;
    public Artist(String name, int number_of_albums, Set<Cd> cds) {
        Name = name;
        Number_of_albums = number_of_albums;
        this.cds = cds;
    }

    public Artist() {
    }

    public Set<Cd> getCds() {
        return cds;
    }

    public void setCds(Set<Cd> cds) {
        this.cds = cds;
    }

    public void setArtist_ID(int artist_ID) {
        Artist_ID = artist_ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setNumber_of_albums(int number_of_albums) {
        Number_of_albums = number_of_albums;
    }

    public int getArtist_ID() {

        return Artist_ID;
    }

    public String getName() {
        return Name;
    }

    public int getNumber_of_albums() {
        return Number_of_albums;
    }

    @Override
    public String toString() {
        return  "Artist{" +
                "Artist_ID=" + Artist_ID +
                ", Name='" + Name + '\'' +"      "+
                ", Number_of_albums=" + Number_of_albums +
                '}';
    }
}
