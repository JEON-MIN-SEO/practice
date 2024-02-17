public class OuterClass {
    void outerMethod() {
        // 메서드 내부에 정의된 지역 내부 클래스
        class LocalInnerClass {
            void innerMethod() {
                System.out.println("LocalInnerClass method");
            }
        }

        // 지역 내부 클래스의 인스턴스 생성
        LocalInnerClass localInner = new LocalInnerClass();
        localInner.innerMethod();
    }

    public static void main(String[] args) {
        // 외부 클래스의 인스턴스 생성
        OuterClass outer = new OuterClass();

        // 외부 클래스의 메서드를 호출하여 지역 내부 클래스 사용
        //outer.outerMethod();
    }
}
