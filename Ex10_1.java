//2010 年の毎月2回目, 日曜日の日付を印刷してください。

import java.time.LocalDate;

public class Ex10_1 {
    public static void main(String[] args) {
     LocalDate tarDate = LocalDate.of(2010, 1, 1);   
    }

}
//============================1=====
// import java.util.Calendar;

// public class SecondSundayExample {
//     public static void main(String[] args) {
//         // 2010년 1월 1일로 Calendar 객체 생성
//         Calendar calendar = Calendar.getInstance();
//         calendar.set(2010, Calendar.JANUARY, 1);

//         // 2010년부터 12월까지 반복
//         for (int month = Calendar.JANUARY; month <= Calendar.DECEMBER; month++) {
//             // 해당 월의 첫 번째 일요일로 설정
//             calendar.set(Calendar.MONTH, month);
//             calendar.set(Calendar.DAY_OF_MONTH, 1);
//             while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
//                 calendar.add(Calendar.DAY_OF_MONTH, 1);
//             }

//             // 두 번째 일요일로 이동
//             calendar.add(Calendar.DAY_OF_MONTH, 7);

//             // 결과 출력
//             System.out.println("Year: " + calendar.get(Calendar.YEAR) +
//                                ", Month: " + (calendar.get(Calendar.MONTH) + 1) +
//                                ", Second Sunday: " + calendar.get(Calendar.DAY_OF_MONTH));
//         }
//     }
// }

//====================
// import java.time.DayOfWeek;
// import java.time.LocalDate;
// import java.time.temporal.TemporalAdjusters;

// public class SecondSundayExample {
//     public static void main(String[] args) {
//         // 2010년 1월 1일부터 12월 31일까지 반복
//         for (int month = 1; month <= 12; month++) {
//             // 해당 월의 첫 번째 날짜로 설정
//             LocalDate firstDayOfMonth = LocalDate.of(2010, month, 1);

//             // 해당 월의 첫 번째 일요일로 이동
//             LocalDate firstSunday = firstDayOfMonth.with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY));

//             // 두 번째 일요일로 이동
//             LocalDate secondSunday = firstSunday.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));

//             // 결과 출력
//             System.out.println("Year: 2010, Month: " + month + ", Second Sunday: " + secondSunday);
//         }
//     }
// }

