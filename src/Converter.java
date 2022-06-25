public class Converter {
    //один шаг равен 75 см
    //1 шаг = 50 калорий
    //1 килокалория = 1 000 калорий

    double stepToDistance(int step){
        return step*0.75;
    }

    double stepToCalorie(int step){
        return step*0.05;
    }
}
