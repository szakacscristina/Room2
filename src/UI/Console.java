
    package UI;

        import Domain.Room;
        import Domain.NumberOfPersonsAverageRatingViewModel;
        import Service.RoomService;

        import java.util.Scanner;

    public class Console {

        private RoomService service;
        private Scanner scanner;

        public Console(RoomService service) {
            this.service = service;
            scanner = new Scanner(System.in);
        }

        private void showMenu() {
            System.out.println("1. Intrare in hotel");
            System.out.println("2. Iesire din hotel");
            System.out.println("3. Feedback rating si numar de persoane");
            System.out.println("a. Afisare toate camerele");
            System.out.println("x. Iesire");
        }

        public void run() {

            while (true) {
                showMenu();
                String option = scanner.nextLine();
                if (option.equals("1")) {
                    handleHotelEntry();
                } else if (option.equals("2")) {
                    handleHotelExit();
                } else if (option.equals("3")) {
                    handlenumberOfpersonsFeedback();
                } else if (option.equals("a")) {
                    handleShowAll();
                } else if (option.equals("x")) {
                    break;
                }
            }
        }

        private void handlenumberOfpersonsFeedback() {
            for (NumberOfPersonsAverageRatingViewModel numberOfpersonsAverage : service.getnumberOfpersonsRatingAverages())
                System.out.println(numberOfpersonsAverage);
        }

        private void handleHotelExit() {
            try {
                System.out.println("Dati numarul de persoane:");
                int numberOfpersons = Integer.parseInt(scanner.nextLine());
                System.out.println("Dati feedback de hotel:");
                String feedback = scanner.nextLine();
                System.out.println("Dati rating-ul:");
                int rating = Integer.parseInt(scanner.nextLine());


                service.exitHotel(numberOfpersons, feedback, rating);
            } catch (RuntimeException runtimeException) {
                System.out.println("Avem erori: " + runtimeException.getMessage());
            }
        }

        private void handleShowAll() {
            for (Room r : service.getAll())
                System.out.println(r);
        }

        private void handleHotelEntry() {

            try {
                System.out.println("Dati id-ul:");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Dati numarul de persoane:");
                int numberOfpersons = Integer.parseInt(scanner.nextLine());
                System.out.println("Dati numarul camerei:");
                int roomnumber = Integer.parseInt(scanner.nextLine());
                System.out.println("Dati numarul de zile:");
                int days = Integer.parseInt(scanner.nextLine());


                service.enterHotel(id, numberOfpersons, roomnumber, days);
            } catch (RuntimeException runtimeException) {
                System.out.println("Avem erori: " + runtimeException.getMessage());
            }
        }
    }




