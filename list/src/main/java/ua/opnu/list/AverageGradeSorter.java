package ua.opnu.list;

import java.util.Comparator;

public class AverageGradeSorter implements Comparator {
    private boolean ascending; // Флаг для сортировки

    public AverageGradeSorter(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Student && o2 instanceof Student) {
            Student s1 = (Student) o1;
            Student s2 = (Student) o2;

            // Для double используем Double.compare
            int result = Double.compare(s1.getAvgMark(), s2.getAvgMark());

            // Возвращаем результат в зависимости от флага
            return ascending ? result : -result;
        }
        return 0;
    }
}