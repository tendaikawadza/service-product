package configuration;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class ProductDto {


    private Long productId;
    private String productName;
    private Date date;
    private String productCode;
    private String productDescription;
    private String productCategory;
    private Integer Quantity;


}