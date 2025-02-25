import java.util.HashMap;

public class Inbuilt_Hashmap{
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");

        String value = map.get(2);
        System.out.println("Value for key 2: " + value);

        boolean hasKey = map.containsKey(1);
        System.out.println("Contains key 1: " + hasKey);

        boolean hasValue = map.containsValue("Cherry");
        System.out.println("Contains value 'Cherry': " + hasValue);

        map.remove(3);

        for (Integer key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        map.clear();
    }
}
