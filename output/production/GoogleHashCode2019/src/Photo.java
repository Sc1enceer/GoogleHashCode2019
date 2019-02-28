import java.util.HashSet;
import java.util.Set;

public class Photo {
    char orientation; // H/V
    Set<String> tags = new HashSet<String>();

    public Photo(char orientation, Set<String> tags) {
        this.orientation = orientation;
        this.tags = tags;
    }

    // getter and setters
    public char getOrientation() {
        return orientation;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
}
