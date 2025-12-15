public class Music extends Content implements Purchasable {

    private String singer;

    public Music(String title, int price, String singer) {
        super(title, price);
        this.singer = singer;
    }

    @Override
    public void showInfo() {
        System.out.println("[Music] Title: " + title +
                " / Price: " + price +
                " / Singer: " + singer);
    }

    @Override
    public void buy() {
        System.out.println("[Music] " + title + " 구매 완료");
    }
}
