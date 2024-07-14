package ProductManager;

public class NotFoundException extends RuntimeException {

    public NotFoundException(int id) {
        super("Этовара с id = " + id + " не существует");
    }
}
