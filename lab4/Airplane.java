import java.util.Comparator;

public class Airplane {
    public String Name;
	private String Type; 
	private int Weight; 
    private int AmountOfEngines;
    private int Year; 
	private String Color; 
	private int Capacity;
    private int Price; 
	

	public Airplane(String Name, String Type, int Weight, int AmountOfEngines, int Year, String Color, int Capacity, int Price) {
		this.Name = Name;
        this.Type = Type;
		this.Weight = Weight;
		this.AmountOfEngines = AmountOfEngines;
        this.Year = Year;
		this.Color = Color;
		this.Capacity = Capacity;
        this.Price = Price;
	}

    public int getPrice() {
        return Price;
    }

    public int getYear() {
        return Year;
    }

    @Override
    public String toString() {
        return "Plane : " +
                "name = " + Name +
                ", type = " + Type +
                ", weight = " + Weight + " tons" +
                ", amount of engines = " + AmountOfEngines +
                ", year = " + Year + 
                ", color = " + Color + 
                ", capacity = " + Capacity + 
                ", price = " + Price + " millions dollars.";
    }
    
}

class SortByPrice implements Comparator<Airplane> {
    
    public int compare(Airplane a, Airplane b){
        return a.getPrice() - b.getPrice();
    }
}

class SortByYear implements Comparator<Airplane> {

    public int compare(Airplane a, Airplane b){
        return a.getYear() - b.getYear();
    }
}
