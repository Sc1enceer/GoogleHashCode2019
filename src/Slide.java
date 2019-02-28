import java.util.HashSet;
import java.util.Set;

public class Slide {
    Photo[] photos;
    Set<String> tags = new HashSet<String>();
    Slide nextSlide;


    public Slide(Photo[] photos) {
        this.photos = photos;
        generateTags();
    }

    /*
        this function
     */
    private void generateTags() {
        if(photos[1] == null){
            this.tags = photos[0].getTags();
        } else {
            this.tags.addAll(photos[0].getTags());
            this.tags.addAll(photos[1].getTags());
        }
    }


    public Photo[] getPhotos() {
        return photos;
    }

    public void setPhotos(Photo[] photos) {
        this.photos = photos;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public Slide getNextSlide() {
        return nextSlide;
    }

    public String getIndex(){
        String result = "";
        for (Photo p : photos){
            result += p.getIndex() + " ";
        }
        return result;
    }
}
