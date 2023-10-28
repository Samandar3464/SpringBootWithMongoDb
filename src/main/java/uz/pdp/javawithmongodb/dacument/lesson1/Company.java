package uz.pdp.javawithmongodb.dacument.lesson1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Company {
    private String name;
    private String catchPhrase;
    private String bs;
}
