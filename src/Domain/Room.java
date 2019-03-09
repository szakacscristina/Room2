
package Domain;

    public class Room {
        public boolean isLeftHotel;
        private int id, numberOfpersons;
        private int roomnumber;
        private int days;
        private boolean leftHotel;
        private String feedback;
        private int rating;

        @Override
        public String toString() {
            String leftRoom = null;
            return "Room{" +
                    "id=" + id +
                    ", numberOfpersons=" + numberOfpersons +
                    ", roomnumber='" + roomnumber + '\'' +
                    ", days=" + days +
                    ", leftRoom=" + leftRoom +
                    ", feedback='" + feedback + '\'' +
                    ", rating=" + rating +
                    '}';
        }

        public Room(int id, int numberOfpersons, int roomnumber, int days) {
            this.id = id;
            this.numberOfpersons= numberOfpersons;
            this.roomnumber = roomnumber;
            this.days = days;
            boolean leftRoom = false; // nu e necesar, e default
        }

        public Room(int id, int numberOfpersons, int roomnumber, int days, boolean leftHotel, String feedback, int rating) {
            this.id = id;
            this.numberOfpersons = numberOfpersons;
            this.roomnumber = roomnumber;
            this.days = days;
            this.leftHotel = leftHotel;
            this.feedback = feedback;
            this.rating = rating;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getNumberOfpersons() {
            return numberOfpersons;
        }

        public void setNumberOfpersons(int numberOfpersons) {
            this.numberOfpersons = numberOfpersons;
        }

        public int getRoomnumber() {
            return roomnumber;
        }

        public void setRoomnumber(int roomnumber) {
            this.roomnumber = roomnumber;
        }

        public int getDays() {
            return days;
        }

        public void setDays(int days) {
            this.days = days;
        }

        public boolean isLeftHotel() {
            return leftHotel;
        }

        public void setLeftHotel(boolean leftHotel) {
            this.leftHotel = leftHotel;
        }

        public String getFeedback() {
            return feedback;
        }

        public void setFeedback(String feedback) {
            this.feedback = feedback;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        public boolean isEmpty() {
            return false;
        }

    }



