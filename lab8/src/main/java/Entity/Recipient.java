package Entity;

import HashCoder.HashCoder;
import HashCoder.Impls.StringHashCoder;
import lombok.*;
import java.util.Objects;

@AllArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class Recipient implements Comparable<Recipient>{

    private String name;
    private String city;
    int zip;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipient recipient = (Recipient) o;
        return zip == recipient.zip && Objects.equals(name, recipient.name) && Objects.equals(city, recipient.city);
    }

    @Override
    public int hashCode() {
        HashCoder hashCoder = new StringHashCoder();
        int result = name != null ? hashCoder.getHashCode(name) : 7;
        result = 31 * result + (city != null ? hashCoder.getHashCode(city) : 7);
        result = 31 * result + zip;
        return result;
    }

    @Override
    public int compareTo(Recipient o) {
        if (name.compareTo(o.name) == 0){
            if (city.compareTo(o.city) == 0){
                if (zip == o.zip) {
                    return 0;
                }
                return Integer.compare(zip, o.zip);
            }
            return city.compareTo(o.city);
        }
        return name.compareTo(o.name);
    }
}
