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

}
