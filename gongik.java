import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class gongik {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("복무 시작일을 yyyy-MM-dd 형식으로 입력하세요: ");
        String startDateString = scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = dateFormat.parse(startDateString);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);

            int totalMonths = 21;
            int totalSalary = 0;

            for (int i = 0; i < totalMonths; i++) {
                int currentMonth = i + 1;

                int salary;
                if (currentMonth == 1) {
                    // 첫 달은 시작일까지의 근무일에 따라 월급 계산
                    int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
                    int daysWorked = daysInMonth - calendar.get(Calendar.DAY_OF_MONTH) + 1;

                    if (daysWorked > 0) {
                        salary = (int) ((double) 600000 / daysInMonth * daysWorked);
                        System.out.println("첫 달 월급은 " + salary + "원 입니다.");
                    } else {
                        salary = 0;
                    }
                } else if (currentMonth <= 2) {
                    salary = 600000;
                } else if (currentMonth <= 8) {
                    salary = getSalary2023(calendar, currentMonth);
                } else if (currentMonth <= 12) {
                    salary = getSalary2024(calendar, currentMonth);
                } else {
                    salary = getSalary2025(calendar, currentMonth);
                }

                totalSalary += salary;

                // 다음 달로 이동
                calendar.add(Calendar.MONTH, 1);
            }

            System.out.println("총 근무 기간 동안 총 월급은 " + totalSalary + "원 입니다.");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static int getSalary2023(Calendar calendar, int currentMonth) {
        if (currentMonth <= 8) {
            return 680000;
        } else {
            return 800000;
        }
    }

    private static int getSalary2024(Calendar calendar, int currentMonth) {
        if (currentMonth <= 6) {
            return 640000;
        } else if (currentMonth <= 12) {
            return 800000;
        } else {
            return 1000000;
        }
    }

    private static int getSalary2025(Calendar calendar, int currentMonth) {
        if (currentMonth <= 6) {
            return 860000;
        } else if (currentMonth <= 12) {
            return 960000;
        } else {
            return 1200000;
        }
    }
}
