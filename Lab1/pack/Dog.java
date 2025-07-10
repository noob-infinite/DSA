package Lab1.pack;

public class Dog {
    private Breed breed;
    private int weight;
    public Dog(Breed b, int w) {
        breed = b;
        weight = w;
    }
    public String getBreed() {
        return breed.toString();
    }
    public Breed myBreed() {
        return breed;
    }
    public String toString() {
        return "Dog(" + breed + ", " + weight + ")";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((breed == null) ? 0 : breed.hashCode());
        result = prime * result + weight;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dog other = (Dog) obj;
        if (breed == null) {
            if (other.breed != null)
                return false;
        } else if (!breed.equals(other.breed))
            return false;
        if (weight != other.weight)
            return false;
        return true;
    }  
}
