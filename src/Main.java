import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    private static ArrayList<Photo> horizontalPhotos;
    private static ArrayList<Photo> verticalPhotos;

    public static void main(String[] agrs) throws IOException {
        Main main = new Main();
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

        InterestAlg alg = new InterestAlg(horizontalPhotos, verticalPhotos);
        main.submission(alg.getSlideshow());
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

    //LinkedList<Slide> slides = new LinkedList<Slide>();

    public void submission(LinkedList<Slide> slides) throws IOException {
        Writer fileWriter = new FileWriter("output.txt", true);
        fileWriter.write(slides.size() + "\n");
        for (Slide s : slides){
            fileWriter.write(s.getIndex() + "\n");
        }
    }
}
