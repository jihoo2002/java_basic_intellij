package etc.stream;

import java.util.Comparator;
import java.util.Optional;

import static etc.stream.Menu.*;
import static java.util.Comparator.*;

public class finding {
    public static void main(String[] args) {
        //음식 메뉴 중에 채식 주의자가 먹을 수 있는 음식이 있는가?
      boolean flag1 =  menuList.stream()
                .anyMatch(dish -> dish.isVegetarian()); //boolean타입으로 리턴
        System.out.println("flag1 = " + flag1); //anyMatch는 채식주의자가 하나라도 트루라면 트루리턴

        
        //음식 메뉴 중에 칼로리가 50미만인 음식이 있는가>
       boolean flag2 = menuList.stream()
                .anyMatch(dish -> dish.getCalories() <50);
        System.out.println("flag2 = " + flag2);
        //for문으로도 가능하지만 성능의 차이가 있다. 스트림이 더 좋다.
        //스트림은 병렬처리, 구간을 나누어 동시에 일처리 함
        
    //음식메뉴 중 모든 요리가 1000칼로리 미만입니까>
     boolean flag3=   menuList.stream()
                .allMatch(dish -> dish.getCalories() <1000);
        System.out.println("flag3 = " + flag3);



        //음식메뉴 중 모든 요리가 1000칼로리 미만이  아닙니까>
        boolean flag4=   menuList.stream()
                .noneMatch(dish -> dish.getCalories() <1000); //하나라도 일치하지 않으면 true

        System.out.println("flag4 = " + flag4);

        //음식 중에 칼로리가 가장 낮은 음식을 조회해 주세요.
     //   Dish dish = menuList.stream()
//                .min(new Comparator<Dish>() {
//                    @Override
//                    public int compare(Dish o1, Dish o2) {
//                        return o1.getCalories() - o2.getCalories();
//                    } //리스트를 순차적으로 두개씩 뽑아 비교한다음 양수인지 음수인지 판단하고 o1, 아님 o2로 출력
//                }).get();


                //.min((o1, o2) -> o1.getCalories() - o2.getCalories()).get();
        Optional<Dish> min = menuList.stream()
                .min(comparing(Dish::getCalories));
        min.ifPresent(dish -> System.out.println(dish)); //만약 존재한다면 출력하겠다.
        //만약 min쪽에 null이 온다면 sys문장은 아예 실행되지 않는다.
        //-> null 오류를 방지하기 위해 !

        //comparing이라는 메서드에 칼로리를 주면 알아서
                                // dish에 칼로리를 비교해서 계속 뺸다음 최소 칼로리를 줌

        System.out.println("dish = " + min);

        
        

    }
}
