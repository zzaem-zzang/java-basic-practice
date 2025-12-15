public abstract class Content {

    protected String title;
    protected int price;

    public Content(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public abstract void showInfo();
}
