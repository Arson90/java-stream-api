package beans;

public class PersonDTO {
    private final int id;
    private final String name;
    private final String country;
    private final String city;

    public PersonDTO(int id, String name, String country, String city) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    private static PersonDTO map(Person person) {
        return new PersonDTO(person.getId(), person.getFirst_name(), person.getCountry(), person.getCity());
    }
}
