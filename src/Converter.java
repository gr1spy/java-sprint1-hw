public class Converter {

    /**
     * Шаги -> метры (один шаг равен 75 см)
     */
    double stepToDistance(int stepFinal){
        return stepFinal*0.75/1000;
    }

    /**
     * Шаги -> калории (1 шаг = 50 калорий)
     */
    double stepToCalorie(int stepFinal){
        return stepFinal*0.05;
    }
}
