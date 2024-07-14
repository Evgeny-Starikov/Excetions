package ProductManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
//
//    @BeforeEach
//    void setUp() {
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
//
//    @Test
//    void add() {
//    }
//
//    @Test
//    void findAll() {
//    }

    @Test
    void testRemoveIfProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "смартфон", 30_000);
        Product product2 = new Product(2, "книга", 300);
        Product product3 = new Product(3, "машина", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.remove(2);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testRemoveIfProductNotExist() {

        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "смартфон", 30_000);
        Product product2 = new Product(2, "книга", 300);
        Product product3 = new Product(3, "машина", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

//        repo.remove(22222);

//        Product[] actual = repo.findAll();
//        Product[] expected = {product1, product2, product3};
//
//        Assertions.assertArrayEquals(expected, actual);
        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(22222222)
        );
    }
}