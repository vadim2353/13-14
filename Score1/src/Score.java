import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Score {
    ArrayList<Product> product1 = new ArrayList<>();

    Score() {
    }

    public void addProduct(Product product) {//добавление
        product1.add(product);
    }

    public void addProduct1(Product product) {//добавление с проверкой
        int d = 0;
        for (Product product2 : product1) {
            if (product2.id == product.id) {
                d = -1;
                System.out.print("Takoy id est");
                break;
            } else {
                d = 2;
            }
        }
        if (d == 2) {
            product1.add(product);
            System.out.print("dobavleno");
        }
    }

    public void delete(int id) {
        product1.removeIf(n -> (n.id == id)); // удаление
    }


    public int price(int index) {
        System.out.print(product1.get(index).price);
        return product1.get(index).price;
    }

    public ArrayList<Product> spisok() { // возвращает список
        return product1;
    }

    public void red(Product product) { //редактирование товара
        int i = 0;
        for (int x = 0; x < product1.size(); x++) {
            if (product.id == product1.get(x).id) {
                product1.remove(x);
                i = x;
            }
        }
        product1.add(i, product);
    }

    public static void main(String[] args) {
        Score score = new Score();
        Product yabloko = new Product(13, "Yabloko", 23);
        Product banan = new Product(13, "Banan", 40);
        Product tost = new Product(3, "Tost", 45);
        Product pol = new Product(6, "Lot", 32);
        Product ll = new Product(33, "wef", 67);
        score.addProduct(tost);
        score.addProduct(yabloko);
        score.addProduct(pol);
        score.product1.sort(Comparator.comparing(e -> e.getPrice()));
        for (int x = 0; x < score.product1.size(); x++) {
            System.out.print(score.price(x));
        }
        score.product1.remove(1);
        Collections.reverse(score.product1);


    }

}
