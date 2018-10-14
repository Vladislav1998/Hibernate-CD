package entities;

public class Cd {
    private  int CD_ID;
    private  String Album;
    private String Genre;
    private  Artist artist;
    private  Organization organization;



    public Cd(){

    }
    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Artist getArtist() {
        return artist;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public int getCD_ID() {
        return CD_ID;
    }

    public void setCD_ID(int CD_ID) {
        this.CD_ID = CD_ID;
    }

    public String getAlbum() {
        return Album;
    }

    public void setAlbum(String album) {
        Album = album;
    }

    public String getGanre() {
        return Genre;
    }

    public void setGanre(String ganre) {
        Genre = ganre;
    }
    @Override
    public String toString() {
        return "Cd{" +
                "---->CD_ID=" + CD_ID +
                ", ------>Album='" + Album + '\'' +
                ", ------>Ganre='" + Genre + '\'' +
                ", ------>Artist_ID=" + artist.getArtist_ID() +
                ", ------>Organization_id=" + organization.getOrganization_id() +
                '}';
    }

}
