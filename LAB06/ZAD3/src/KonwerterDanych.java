public class KonwerterDanych {
    public String konwersjaNaCale(String metry){

        try{
            double cale = (Double.parseDouble(metry)/39.370);
            if(Double.parseDouble(metry)<0){
                return "Błąd danych.";
            }
            return String.valueOf(cale);
        }catch (Exception e){
            return "Błąd danych.";
        }
    }
    public String konwersjaNaMetry(String cale){

        try{
            double metry = Double.parseDouble(cale)/39.370;

            if(Double.parseDouble(cale)<0){
                return "Błąd danych.";
            }
            return String.valueOf(metry);
        }catch (Exception e){
            return "Błąd danych.";
        }
    }
    public String konwersjaNaCelcjusza(String Farenheit){

        try{
            double celcjusz =(Double.parseDouble(Farenheit)-32)/1.8;


            return String.valueOf(celcjusz);
        }catch (Exception e){
            return "Błąd danych.";
        }
    }
    public String konwersjaNaFarenheit(String Celcjusz){


        try{
            double farenheit = (Double.parseDouble(Celcjusz)*1.8)+32;
            return String.valueOf(farenheit);
        }catch (Exception e){
            return "Błąd danych.";
        }
    }
    public String konwersjaNaKilogramy(String funt){

        try{
            double kilogram = (Double.parseDouble(funt)/2.2046);
            if(Double.parseDouble(funt)<0){
                return "Błąd danych.";
            }
            return String.valueOf(kilogram);
        }catch (Exception e){
            return "Błąd danych.";
        }
    }
    public String konwersjaNaFunty(String kilogram){

        try{
            double funt = (Double.parseDouble(kilogram)* 2.2046);
            if(Double.parseDouble(kilogram)<0){
                return "Błąd danych.";
            }
            return String.valueOf(funt);
        }catch (Exception e){
            return "Błąd danych.";
        }
    }

}
