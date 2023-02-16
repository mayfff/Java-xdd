import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class SixthLab {
    /* C13 =  7
     *  Визначити ієрархію рухомого складу залізничного транспорту.
     *  Створити пасажирський потяг. Порахувати загальну чисельність пасажирів і багажу в потязі.
     *  Провести сортування вагонів потягу за рівнем комфортності.
     *  Знайти вагон в потязі, що відповідає заданому діапазону кількості пасажирів. */
    public static int SumOfPassangers(Train[] trains) {
        int sum = 0;
        for(Train train: trains) {
            sum += train.getCapacity();
        }
        return sum;
    }

    public static float SumOfLuggage(Train[] trains) {
        float sum = 0.0f;
        for(Train train: trains) {
            sum += train.getLuggage();
        }
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Intercity intercity = new Intercity(2, "intercity", 57, 2.0f);
        SV sv = new SV(3, "sv", 20, 1.5f);
        Compartment compartment = new Compartment(2, "compartment", 40, 2.5f);
        Plackart plackart = new Plackart(1, "plackart", 52, 1.8f);
        Train[] cars = {intercity, sv, compartment, plackart};

        System.out.println("List of train cars: ");
        for(Train train: cars) {
            System.out.println(train);
        }

        Arrays.sort(cars, new SortByComfort());
        System.out.println("\nSorted list by comfort level: ");
        for(Train train: cars) {
            System.out.println(train);
        }

        System.out.printf("\n\nThe total number of passengers on the train - %d.\n", SumOfPassangers(cars));
        System.out.printf("The total amount of train baggage - %.1f tons.", SumOfLuggage(cars));

        System.out.println("\nFinding the train car by number of passengers");
        System.out.print("Enter the lower number: ");
        int lower = scn.nextInt();
        System.out.print("Enter the extreme number: ");
        int extreme = scn.nextInt();
        boolean flag = false;
        for(Train train: cars) {
            int amount = train.getCapacity();
            if(amount >= lower && amount <= extreme) {
                System.out.println(train);
                flag = true;
            }
        }
        if(!flag) {
            System.out.println("There is no such train car");
        }
        scn.close();
    }
}

class Train {
    private int ComfortLevel;
    private String Type;
    private int Capacity;
    private float Luggage;

    public Train(int ComfortLevel, String Type, int Capacity, float Luggage) {
        this.ComfortLevel = ComfortLevel;
        this.Type = Type;
        this.Capacity = Capacity;
        this.Luggage = Luggage;
    }

    public int getComfortLevel() {
        return ComfortLevel;
    }

    public String getType() {
        return Type;
    }
    
    public int getCapacity() {
        return Capacity;
    }

    public float getLuggage() {
        return Luggage;
    }

    @Override
    public String toString() {
        return "Train : " + 
                " Type: " + Type +
                ". Comfort level: " + ComfortLevel +
                ". Capacity: " + Capacity + 
                ". Luggage: " + Luggage + " tons.";
    }
}


class Intercity extends Train {

    public Intercity(int ComfortLevel, String Type, int Capacity, float Luggage) {
        super(ComfortLevel, Type, Capacity, Luggage);
    }
}

class SV extends Train {

    public SV(int ComfortLevel, String Type, int Capacity, float Luggage) {
        super(ComfortLevel, Type, Capacity, Luggage);
    }
}

class Compartment extends Train {

    public Compartment(int ComfortLevel, String Type, int Capacity, float Luggage) {
        super(ComfortLevel, Type, Capacity, Luggage);
    }
}

class Plackart extends Train {

    public Plackart(int ComfortLevel, String Type, int Capacity, float Luggage) {
        super(ComfortLevel, Type, Capacity, Luggage);
    }
}

class SortByComfort implements Comparator<Train> {
    
    public int compare(Train a, Train b){
        return a.getComfortLevel() - b.getComfortLevel();
    }
}
