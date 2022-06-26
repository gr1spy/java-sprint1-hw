public class StepTracker {
    int maxStepPerDay = 10000;
    int[][] tableDays;


    StepTracker(){
        tableDays = new int[30][12];
    }

    void selectPushDay(int month, int day, int step){
        tableDays[day][month] = step;
    }

    void statusForMonth(int month){
        int count = 0;
        int maxStep = 0;

        Converter converter = new Converter();

        System.out.println("Вы выбрали " + month + "-й месяц!");

        //Количество пройденных шагов по дням
        for (int i = 0; i<30; i++) {
            if (i<29){
                System.out.print(i+1 + " день: " + tableDays[i][month] + ", ");
            } else {
                System.out.println(i+1 + " день: " + tableDays[i][month]);
            }

        }

        //Общее количество шагов за месяц
        for (int i = 0; i<30; i++){
            count += tableDays[i][month];
        }
        System.out.println("Общее количество шагов: " + count);

        //Максимальное пройденное количество шагов в месяце
        for (int i = 0; i<30; i++){
            if (tableDays[i][month] > maxStep) {
                maxStep = tableDays[i][month];
            }
        }
        System.out.println("Максимальное пройденное количество шагов: " + maxStep);

        //Среднее количество шагов
        System.out.println("Среднее число шагов: " + count/30);

        //Пройденная дистанция (в км)
        System.out.println("Общая пройденная дистанция: " + converter.stepToDistance(count)/1000 + " км");

        //Количество сожжённых килокалорий
        System.out.println("Количество сожженных килокалорий: " + converter.stepToCalorie(count) + " ККал");

        //Лучшая серия
        System.out.println("Лучшая серия шагов: " + bestSeriesSteps(month));
    }

    int bestSeriesSteps(int month){
        int seriesBuf = 0;
        int series = 0;
        for (int i=0; i < 30; i++){
            if (tableDays[i][month] >= maxStepPerDay){
                seriesBuf++;
            } else {
                if (series < seriesBuf) {
                    series = seriesBuf;
                    seriesBuf = 0;
                }
            }
        }
        if (series < seriesBuf) {
            series = seriesBuf;
        }
        return series;
    }

    void maxStepPerDay(int countStepPerDay){
        maxStepPerDay = countStepPerDay;
    }
}
