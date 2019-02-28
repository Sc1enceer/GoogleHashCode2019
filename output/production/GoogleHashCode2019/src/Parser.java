import java.io.*;
import java.util.HashSet;
import java.util.Set;


public class Parser {
    private static File file = new File("/Users/gongweishi/documents/github/googlehashcode2019/inputFiles/a_example.txt");
    private static BufferedReader br = null;

    public Parser() {
        initialise();
    }

    private static void initialise() {

        try {
            br = new BufferedReader(new FileReader(file));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Photo[] readPhotos() throws IOException {
        Integer numOfPhotos = Integer.parseInt(br.readLine());

        Photo[] photos = new Photo[numOfPhotos];
        Integer photoIdx = 0;
        String line = null;
        while (((line = br.readLine())!= null) && photoIdx < numOfPhotos){
            String[] strs = line.split(" ");
            Set<String> tempTags = new HashSet<>();
            for(int i = 2; i < strs.length; i++){
                tempTags.add(strs[i]);
            }
            Photo tempPhoto = new Photo(strs[0].charAt(0), tempTags );
            photos[photoIdx] = tempPhoto;
            photoIdx++;
        }
        return photos;

    }
}
