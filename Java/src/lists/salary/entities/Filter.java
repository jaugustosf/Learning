package lists.salary.entities;

import java.util.List;
public class Filter {
    public static boolean hasId(List<Employee> list, int id) {
        Employee temp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
//        return temp != null;
        return true;
    }
}