package Lambda.learnJava.streams;

import java.util.Map;

/**
 * @author rbhavsar
 * Created on 5/24/20.
 */
public class TestMap {
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  String id;
  String number;

  public TestMap(Map<String,String> map){
    for (Map.Entry<String, String> entry : map.entrySet()) {
      String key = entry.getKey().toLowerCase();

        this.setId(key);
        this.setNumber(entry.getValue());

    }
  }
}
