package Repository;

import java.util.HashMap;
public class DAO {
    static HashMap<String, Object> hashMap = new HashMap<>();
    public static void Insert(String id, Object Register){
        hashMap.put(id, Register);
    }
}
