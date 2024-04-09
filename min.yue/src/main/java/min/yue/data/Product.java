package min.yue.data;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;



@Data
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@NotBlank( message="Code is required")
    private String code;
	
	@NotBlank( message="Name is required")
    private String name;
	
	@NotBlank( message="Category is required")
    private String category;
    private String brand;
    private String type;
    private String description;


}
