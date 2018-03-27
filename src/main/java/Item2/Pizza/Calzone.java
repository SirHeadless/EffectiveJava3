package Item2.Pizza;

import java.util.Objects;

public class Calzone extends Pizza {

    public final Boolean souceInside;
    public static class Builder extends Pizza.Builder<Builder>{

        public final Boolean souceInside;

        public Builder(Boolean souceInside) {
            this.souceInside = Objects.requireNonNull(souceInside);

        }

        @Override
        public Calzone build() {
            return  new Calzone(this);
        }

        @Override
        public Builder self() {
            return this;
        }
    }

    private Calzone(Builder builder) {
        super(builder);
        this.souceInside = builder.souceInside;
    }

    @Override
    public String toString() {
        return "Calzone{" +
                "souceInside=" + souceInside +
                ", toppings=" + toppings +
                '}';
    }
}
