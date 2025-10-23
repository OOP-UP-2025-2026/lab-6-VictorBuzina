package ua.opnu.list;

import java.util.Comparator;

public class LastNameSorter implements Comparator {
    private boolean ascending; // Флаг для сортировки (для доп. задания)

    public LastNameSorter(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Student && o2 instanceof Student) {
            Student s1 = (Student) o1;
            Student s2 = (Student) o2;

            // Сравниваем фамилии
            int result = s1.getLastName().compareTo(s2.getLastName());

            // Если ascending = true, возвращаем result (прямой порядок)
            // Если ascending = false, возвращаем -result (обратный порядок)
            return ascending ? result : -result;
        }
        return 0;
    }
}