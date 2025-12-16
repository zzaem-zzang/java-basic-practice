package store;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Content> contents = new ArrayList<>();
        contents.add(new Book("해리포터", 12000, "J.K. Rowling"));
        contents.add(new Movie("인셉션", 15000, 148));
        contents.add(new Music("Dynamite", 2000, "BTS"));

        while (true) {
            System.out.println("\n=== 구매 / 대여 ===");
            System.out.println("1. Book");
            System.out.println("2. Movie");
            System.out.println("3. Music");
            System.out.println("0. 종료");
            System.out.print("선택: ");

            int type;
            try {
                type = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
                continue;
            }

            if (type == 0) break;

            System.out.print("제목 입력: ");
            String title = sc.nextLine();

            Content target = null;
            for (Content c : contents) {
                if (c.getTitle().equals(title)) {
                    target = c;
                    break;
                }
            }

            if (target == null) {
                System.out.println("해당 콘텐츠가 없습니다.");
                continue;
            }

            System.out.println("1. 구매");
            System.out.println("2. 대여");
            System.out.println("3. 대여 기간 연장");
            System.out.print("선택: ");

            int action;
            try {
                action = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
                continue;
            }

            // === 기능 실행 ===
            if (action == 1) {
                if (target instanceof Purchasable) {
                    ((Purchasable) target).buy();
                }
            } else if (action == 2) {
                if (target instanceof Rentable) {
                    ((Rentable) target).rent();
                } else {
                    System.out.println("대여할 수 없는 콘텐츠입니다.");
                }
            } else if (action == 3) {
                if (target instanceof Rentable) {
                    ((Rentable) target).extendRent();
                } else {
                    System.out.println("대여할 수 없는 콘텐츠입니다.");
                }
            }
        }

        sc.close();
    }
}
