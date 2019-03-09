import Domain.RoomValidator;
import Repository.RoomRepository;
import Service.RoomService;
import UI.Console;

public class Main {

    public static void main(String[] args) {
        RoomValidator validator = new RoomValidator();
        RoomRepository repository = new RoomRepository(validator);
        RoomService service = new RoomService(repository);
        // service.enterHotel(1, 1, 112, 2);
        // service.enterHotel(2, 2, 150, 2);
        //service.exitHotel(1, "Multumit", 100);
        // service.enterHotel(3, 1, 70, 2);
        // service.exitHotel(2, "Multumit", 80);
        // service.enterHotel(4, 2, 15, 2);
        //service.exitHotel(1, "Multumit", 60);
        // service.enterHotel(5, 3, 255, 2);
        // service.exitHotel(2, "Multumit", 90);
        // service.enterHotel(6, 2, 88, 2);
        // service.enterHotel(9, 12, 99, 2);
        Console console = new Console(service);
        console.run();
    }
}





