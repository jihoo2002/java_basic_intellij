package etc.stream;
import java.util.Comparator;
import java.util.stream.Collectors;

import static etc.stream.Menu.*;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class Sorting {
    public static void main(String[] args) {

        //음식 목록 중에서 칼로리가 낮은 순으로 정렬
        menuList.stream()
                .sorted(comparing(Dish::getCalories)) //dish의 getCalories를 받는다.
                .collect(toList()) //리스트로 받는다.
                .forEach(System.out::println); //람다식으로 출력

        System.out.println("======================================================");

        //칼로리로 내림차 정렬(높은 순)
        menuList.stream()
                .sorted(comparing(Dish::getCalories).reversed()) //dish의 getCalories를 받아 뒤집는다.
                .collect(toList()) //리스트로 받는다.
                .forEach(System.out::println); //람다식으로 출력

        System.out.println("======================================================");
    //500칼로리보다 작은 요리 중에 칼로리가 높은 top3 필터링,
        menuList.stream()
                .filter(dish -> dish.getCalories() <500) //칼로리가 500미만 애들 걸러
                .sorted(comparing(Dish::getCalories).reversed()) //걸른 애들 정렬(높은순)
                .limit(3) //정렬된 애들 중 상위 3개만 짤라
                .collect(toList())//리스트로 줘
                .forEach(System.out::println); //반복해서 출력해







    }
}
