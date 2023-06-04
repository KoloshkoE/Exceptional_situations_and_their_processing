import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product product1 = new Product(001, "Журнал", 40);
    Product product2 = new Product(010, "Ручка", 25);
    Product product3 = new Product(015, "Ластик", 34);

    Product product4 = new Product(001, "Журнал", 50);

    @Test
    public void getProductTest() {
        ShopRepository shoprepository = new ShopRepository();

        shoprepository.add(product1);
        shoprepository.add(product2);
        shoprepository.add(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = shoprepository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void removingTheProductTest(){
        ShopRepository shoprepository = new ShopRepository();

        shoprepository.add(product1);
        shoprepository.add(product2);
        shoprepository.add(product3);

        shoprepository.remove(010);
        Product[] expected = {product1, product3};
        Product[] actual = shoprepository.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removingNonExistentTheProductTest(){
        ShopRepository shoprepository = new ShopRepository();

        shoprepository.add(product1);
        shoprepository.add(product2);
        shoprepository.add(product3);

       Assertions.assertThrows(NotFoundException.class, () ->{shoprepository.remove(100);});

    }

    @Test
    public void getProductTest2Test(){
        ShopRepository shoprepository = new ShopRepository();

        shoprepository.add(product1);
        shoprepository.add(product2);
        shoprepository.add(product3);

        Assertions.assertThrows(AlreadyExistsException.class, () ->{shoprepository.add(product4);});

    }
}
