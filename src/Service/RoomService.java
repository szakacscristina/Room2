package Service;

import Domain.NumberOfPersonsAverageRatingViewModel;
import Domain.Room;
import Repository.RoomRepository;

import java.util.*;

    public class RoomService {

        private RoomRepository repository;

        /**
         * ...
         * @param repository
         */
        public RoomService(RoomRepository repository) {
            this.repository = repository;
        }

        /**
         * ...
         * @param id
         * @param numberOfpersons
         * @param roomnumber
         * @param days
         */
        public void enterHotel(int id, int numberOfpersons, int roomnumber, int days) {

            Room room = new Room(id, numberOfpersons, roomnumber, days);
            List<Room> rooms = repository.getAll();
            for (Room r : rooms) {
                if (r.getNumberOfpersons() == numberOfpersons && !r.isLeftHotel()){
                    throw new RuntimeException("That numberOfpersons is already taken!");
                }
            }
            repository.add(room);
        }

        /**
         *
         * @param numberOfpersons
         * @param feedback
         * @param rating
         */
        public void exitHotel(int numberOfpersons, String feedback, int rating) {
            Room roomDependingonnumberOfpersons = null;
            List<Room> rooms = repository.getAll();
            for (Room r : rooms) {
                if (r.getNumberOfpersons() == numberOfpersons && !r.isLeftHotel()){
                    roomDependingonnumberOfpersons = r;
                }
            }

            if (roomDependingonnumberOfpersons != null) {
                roomDependingonnumberOfpersons.setFeedback(feedback);
                roomDependingonnumberOfpersons.setRating(rating);
                roomDependingonnumberOfpersons.setLeftHotel(true);
                repository.update(roomDependingonnumberOfpersons);
            } else {
                throw new RuntimeException("There is no room with the given numberOfpersons!");
            }
        }

        public List<NumberOfPersonsAverageRatingViewModel> getnumberOfpersonsRatingAverages() {
            List<NumberOfPersonsAverageRatingViewModel> results = new ArrayList<>();

            Map<Integer, List<Integer>> ratingsfornumberOfpersons = new HashMap<>();
            for (Room r : repository.getAll()) {
                if (r.isLeftHotel()) {
                    int numberOfpersons = r.getNumberOfpersons();
                    int rating = r.getRating();

                    if (!ratingsfornumberOfpersons.containsKey(numberOfpersons)) {
                        ratingsfornumberOfpersons.put(numberOfpersons, new ArrayList<>());
                    }
                    ratingsfornumberOfpersons.get(numberOfpersons).add(rating);
                }
            }

            for (Integer numberOfpersons : ratingsfornumberOfpersons.keySet()) {
                List<Integer> ratings = ratingsfornumberOfpersons.get(numberOfpersons);
                int average = 0;
                for (int p : ratings) {
                    average += p;
                }
                average /= ratings.size();
                results.add(new NumberOfPersonsAverageRatingViewModel(numberOfpersons, average));
            }

//        results.sort((r1, r2) -> r1.getAverageRating() > r2.getAverageRating() ? -1 : 1);
            results.sort((r1, r2) -> {
                if (r1.getAverageRating() > r2.getAverageRating())
                    return -1;
                else if (r1.getAverageRating() == r2.getAverageRating())
                    return 0;
                else
                    return 1;
            });
            return results;
        }

        public List<Room> getAll() {
            return repository.getAll();
        }
    }






