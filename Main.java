package java_1.lesson_5;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Employee[] mass = new Employee[5];

        mass[0] = new Employee("Иванов И. И.", "директор",
                "dir@mail.ru", "22233311", 100000.00, 35);
        mass[1] = new Employee("Петров И. И.", "гл. инженер",
                "inggl@mail.ru", "33300111", 90000.00, 39);
        mass[2] = new Employee("Долина Ф.А", "гл. бухгалтер",
                "byx@mail.ru", "938112222", 80000.00, 33);
        mass[3] = new Employee("Лапочкин А.И", "менеджер",
                "men@mail.ru", "961008911", 50000.00, 38);
        mass[4] = new Employee("Савочкина Е. П.", "уборщица",
                "ubr@mail.ru", "9380612234", 200000.00, 45);

        for (int i = 0; i < mass.length; i++) {
            if ( mass[i].getVozrast() < 40)
              mass[i];
        }


    }
}

public class Employee {

        private String nameFIO;
        private String dolgnost;
        private String email;
        private String telefon;
        private double zarplata = 0;
        private int vozrast = 0;

        public Employee(String anFIO, String  adolgnost,String  aemail,
                        String  atelefon,double azarplata, int avozrast) {
            nameFIO = anFIO;
            dolgnost = adolgnost;
            email = aemail;
            telefon = atelefon;
            zarplata = azarplata;
            vozrast = avozrast;
        }

        public void outInfo() {

            System.out.println("ФИО - "+ getFIO() + " Должность - " + getDolgnost() +
                    " email - " + getEmail() + " телефон -" + getTelefon() + " зарплата - "+
                    getZarplata() + " возраст - " + getVozrast());
        }


        public String getFIO(){
            return nameFIO;
        }

        public String getDolgnost()
        {
            return dolgnost;

        }

        public String getEmail() {
            return email;
        }

        public String getTelefon() {
            return telefon;
        }

        public double getZarplata(){
            return zarplata;
        }

        public int getVozrast() {
            return vozrast;
}

}
