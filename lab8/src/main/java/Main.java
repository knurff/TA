import Entity.Recipient;
import Collections.Map.Containers.Impls.LinkedList;
import Collections.Map.Impls.MapImpl;
import Collections.Map.Map;


public class Main {
    public static void main(String[] args) {
        System.out.println(new Recipient("Carl", "Grove Street", 6426).hashCode());
        Map<Integer, Integer> map = new MapImpl<>(new LinkedList<>());
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.remove(4);
        System.out.println(map.contains(4));
        System.out.println(map);
        map.put(4, 4);
        System.out.println(map);
    }
}
