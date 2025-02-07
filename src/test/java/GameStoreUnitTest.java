import com.keyin.Cart;
import com.keyin.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


//  Validate game addition/removal,
// cart total calculation
// purchase processing
public class GameStoreUnitTest {

    private Cart cart;
    private Game gameTest;

    @BeforeEach
    void setCartUp(){
        cart = new Cart();
        gameTest = new Game ("Game Test", 19.99,8);
    }

    @Test
    void deleteGameTest(){
        cart.addGame(gameTest, true);
        assertFalse(cart.cartIsEmpty(), "Your cart should not be empty..");
        cart.deleteGames();
        assertTrue(cart.cartIsEmpty(), "Your cart should be empty.");
        assertEquals(0.0, cart.getTotal(), "Total should be $0 when the cart is empty.");
    }

    @Test
    void cartTotalTest(){
        cart.addGame(new Game("Goose Goose Duck", 29.99,7), true);
        cart.addGame(new Game("Among Us", 39.99,8), true);
        assertEquals(69.98, cart.getTotal(), 0.01);
    }

    @Test
    void purchaseProcessingTest(){
        cart.addGame(new Game("Call of Duty", 49.99,9), true);
        String order = cart.processingCheckOut();
        assertTrue(order.contains("Your order was processed."));
        assertTrue(cart.cartIsEmpty());
    }
}
