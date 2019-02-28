import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    private static ArrayList<Photo> horizontalPhotos;
    private static ArrayList<Photo> verticalPhotos;

    public static void main(String[] agrs){
        Parser parser = new Parser();
        Photo[] photos;
        try {
            photos = parser.readPhotos();
            for(Photo photo : photos){
                System.out.print(photo.getOrientation() + "       ");
                Iterator<String> iter = photo.getTags().iterator();
                while (iter.hasNext()){
                    System.out.print(iter.next() + " ");
                }
                System.out.println();
            }
            splitOrientation(photos);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void splitOrientation(Photo[] photos){
        horizontalPhotos = new ArrayList<>();
        verticalPhotos = new ArrayList<>();
        int n = photos.length;
        for(int i = 0; i < n; i++){
            if (photos[i].getOrientation() == 'H'){
                horizontalPhotos.add(photos[i]);
            } else {
                verticalPhotos.add(photos[i]);
            }
        }
    }
}
