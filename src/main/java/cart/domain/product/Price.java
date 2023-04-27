package cart.domain.product;

import java.util.Objects;

public class Price {

    private static final int MINIMUM_PRICE = 0;

    private int price;

    public Price(final int price) {
        validate(price);
        this.price = price;
    }

    private void validate(final int price) {
        if (price < MINIMUM_PRICE) {
            throw new IllegalArgumentException("최소 가격은 0원 이상입니다.");
        }
    }

    public void edit(final int price) {
        validate(price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price)) return false;
        Price price1 = (Price) o;
        return price == price1.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
