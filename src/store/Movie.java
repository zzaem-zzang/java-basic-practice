package store;

public class Movie extends Content implements Purchasable, Rentable {

    private int runningTime;
    private boolean rented = false;

    public Movie(String title, int price, int runningTime) {
        super(title, price);
        this.runningTime = runningTime;
    }

    @Override
    public void showInfo() {
        System.out.println("[Movie] Title: " + title + " / Price: " + price +
                " / Running Time: " + runningTime + "min");
    }

    @Override
    public void buy() {
        System.out.println("[Movie] " + title + " 구매 완료");
    }

    @Override
    public void rent() {
        if (!rented) {
            rented = true;
            System.out.println("[Movie] " + title + " 대여 완료");
        } else {
            System.out.println("이미 대여 중입니다.");
        }
    }

    @Override
    public void extendRent() {
        if (!rented) {
            System.out.println("대여 중인 상품이 아닙니다.");
        } else {
            System.out.println("대여 기간 연장 완료");
        }
    }
}
