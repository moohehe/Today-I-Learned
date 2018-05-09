
// gender1, gender2 에는 male, female값만 입력하도록 하고 싶다.
public class EnumTest {
    public static void main(String[] args) {
        
        String gender1;

        gender1 = "MALE";
        gender1 = "FEMALE";

        // male, female이 아닌 상수값이 입력될 때
        // 컴파일시 에러가 나지 않음 -> 오류
        gender1 = "boy";
        // ↑ no error


        Gender gender2;

        gender2 = Gender.MALE;
        gender2 = Gender.FEMALE;

        // Enum 타입의 값을 갖고 있기 때문에
        // 원하지 않는 상수값을 체크할 수 있다.
        // ↓ error!
        gender2 = "boy";


    }


}
Enum Gender {
    MALE,FEMALE;
}