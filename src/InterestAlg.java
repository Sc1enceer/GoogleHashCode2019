import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toList;

public class InterestAlg {

  ArrayList<Photo> HPhoto;
  ArrayList<Photo> VPhoto;
  ArrayList<Photo> PhotoList;

  InterestAlg(){

  }
    public class Tuple<X, Y> {
        public final X x;
        public final Y y;
        public Tuple(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }

    ArrayList<Tuple<Photo, Photo>> vPairs;

  public void createVPairs(){
      vPairs = VPhoto.stream()
              .flatMap(x -> (VPhoto.stream().map(y -> new Tuple((Photo)x, (Photo)y))))
              .collect(toList());

      for (Tuple<Photo, Photo> t : vPairs){
          Set<String> tagA = t.x.getTags();
          Set<String> tagB = t.y.getTags();
          tagA.addAll(tagB);
          Photo[] ps = new Photo[2];
          ps[0] = t.x;
          ps[1] = t.y;
          Slide s = new Slide(ps);
          p.setTags(tagA);
          p.setOrientation('W');
          PhotoList.add(p);
      }
  }

  public Integer interestFactor(Tuple<Photo, Photo> slides){
      ArrayList<String> s1 = new ArrayList<String>(slides.x.getTags());
      s1.removeAll(slides.y.getTags());

      ArrayList<String> common = new ArrayList<String>(slides.x.getTags());
      common.removeAll(s1);

      ArrayList<String> s2 = new ArrayList<String>(slides.y.getTags());
      s2.removeAll(common);

      ArrayList<Integer> integer = new ArrayList<Integer>();
      integer.add(s1.size());
      integer.add(s2.size());
      integer.add(common.size());

      return Collections.min(integer);

  }

  ArrayList<Tuple<Photo, Photo>> ComparisonSet;
  public void createComparisonSet(){
      ComparisonSet = PhotoList.stream()
              .flatMap(x -> (PhotoList.stream().map(y -> new Tuple((Photo)x, (Photo)y))))
              .collect(toList());
  }

  public void alg(ArrayList<Tuple<Photo,Photo>> set){
      if()
  }






}
