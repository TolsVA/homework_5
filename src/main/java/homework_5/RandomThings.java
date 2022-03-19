package homework_5;

public enum RandomThings {
    N("Ноутбук", 500, 3), C("Часы", 30, 1), U("Зонтик", 10, 1), W("Гиря", 10, 3), S("Смартфон", 70, 2);

    private final String name;
    private final int price;
    private final int weight;

    RandomThings(String name, int price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "[" + name +
                " -> цена = " + price +
                ", вес = " + weight + "], ";
    }
}
