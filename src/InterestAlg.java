import java.util.*;

import static java.util.stream.Collectors.toList;

public class InterestAlg {

  ArrayList<Photo> HPhoto;
  ArrayList<Photo> VPhoto;
  ArrayList<Slide> SlideList;
  ArrayList<Tuple<Slide, Slide>> beautifulTransition = new ArrayList<>();
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

    List<Tuple<Photo, Photo>> vPairs;

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
          s.setTags(tagA);
          SlideList.add(s);

      }

      for (Photo h : HPhoto){
          Photo[] ps = new Photo[1];
          ps[0] = h;
          Slide s = new Slide(ps);
          s.setTags(h.getTags());
          SlideList.add(s);

      }

      for (Photo v : VPhoto){
          Photo[] ps = new Photo[1];
          ps[0] = v;
          Slide s = new Slide(ps);
          s.setTags(v.getTags());
          SlideList.add(s);
      }
  }

  public Integer interestFactor(Slide slide, Slide slide2){
      ArrayList<String> s1 = new ArrayList<String>(slide.getTags());
      s1.removeAll(slide2.getTags());

      ArrayList<String> common = new ArrayList<String>(slide.getTags());
      common.removeAll(s1);

      ArrayList<String> s2 = new ArrayList<String>(slide2.getTags());
      s2.removeAll(common);

      ArrayList<Integer> integer = new ArrayList<Integer>();
      integer.add(s1.size());
      integer.add(s2.size());
      integer.add(common.size());

      return Collections.min(integer);

  }

  List<Tuple<Slide, Slide>> ComparisonSet;
  public void createComparisonSet(){
      ComparisonSet = SlideList.stream()
              .flatMap(x -> (SlideList.stream().map(y -> new Tuple((Slide)x, (Slide)y))))
              .collect(toList());
  }

  public void alg(ArrayList<Tuple<Slide,Slide>> set){

      do{
          for(int i = 0; i < set.size(); i++){
              if (set.get(i).x.equals(set.get(i).y)){
                  set.remove(set.get(i));
              }
              if (comparePhotos(set.get(i).x.getPhotos(), set.get(i).y.getPhotos())){
                  set.remove(set.get(i));
              }
              for (int j = 0; j < set.size(); j++){
                  if(set.get(i).x.equals(set.get(j).y)){
                      set.remove(set.get(j));
                  }
              }
          }

          Map<Integer, Tuple<Slide, Slide>> tempMap = new HashMap<>();
          for (int i = 0; i < set.size(); i++){
              Slide tempSlide = set.get(i).x;
              Integer tempValue = interestFactor(tempSlide, set.get(i).y);
              tempMap.put(tempValue, set.get(i));
          }

          Set<Integer> keyValues = tempMap.keySet();
          int maxKey =  Collections.max(keyValues);
          beautifulTransition.add(tempMap.get(maxKey));

          for (int i = 0; i< beautifulTransition.size(); i++){
              for (int j = 0; j< set.size(); j++){
                  if (beautifulTransition.get(i).x.equals(set.get(j).x)){
                      set.remove(set.get(j));
                  }
              }
          }
      } while (!set.isEmpty());
  }

  private boolean comparePhotos(Photo[] p1, Photo[] p2){
      for (Photo p11: p1 ) {
          for (Photo p22 : p2  ) {
              if (p11.equals(p22)){
                  return true;
              }
          }

      }
      return false;
  }






}
