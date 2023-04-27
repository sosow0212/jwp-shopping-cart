package cart.dto.product;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class ProductEditRequestDto {

    @NotBlank(message = "상품명은 공백일 수 없습니다.")
    @Length(max = 10, message = "상품명은 최대 10자까지 가능합니다.")
    private String name;

    @NotNull(message = "가격은 공백일 수 없습니다.")
    @PositiveOrZero(message = "가격은 0원 이상이어야 합니다.")
    private int price;

    @NotNull(message = "상품 이미지 url을 넣어주세요.")
    private String imgUrl;

    private ProductEditRequestDto() {

    }

    public ProductEditRequestDto(final String name, final int price, final String imgUrl) {
        this.name = name;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}