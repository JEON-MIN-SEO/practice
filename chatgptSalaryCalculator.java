import java.text.DecimalFormat;

public class chatgptSalaryCalculator {
    public static void main(String[] args) {
        // 초기 월급 및 적금 설정
        double[] salaries = {600000, 600000, 800000, 800000, 800000, 800000, 800000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1500000, 1500000, 1500000, 1500000, 1500000, 1500000, 1500000, 1500000};
        double savings = 0;  // 초기 적금

        // 각 달의 월급 곱하기 및 더하기
        double totalEarnings = 0;
        for (int month = 1; month <= 21; month++) {
            // 현재 월의 월급 가져오기
            double baseSalary = salaries[month - 1];

            // 추가로 받는 월급 및 적금 계산
            double additionalSalary = 200000;
            double monthlySavings = 400000;

            // 월급과 적금을 합산
            totalEarnings = baseSalary + additionalSalary + savings;

            // 숫자를 000,000 형식으로 포맷팅
            DecimalFormat formatter = new DecimalFormat("#,###");
            String formattedEarnings = formatter.format(totalEarnings);

            // 결과 출력
            System.out.println("월 " + month + ": 총 수입 - " + formattedEarnings + "원 (월급: " +
                    formatter.format(baseSalary) + "원, 적금: " + formatter.format(savings) + "원)");

            // 다음 달을 위해 적금 누적
            savings += monthlySavings;
        }
    }
}
