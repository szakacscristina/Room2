package Domain;

        public class NumberOfPersonsAverageRatingViewModel {

            private int numberOfpersons;
            private int averageRating;

            @Override       public String toString(){
                return "NumberOfpersonsAverageRatingViewModel{" +
                        "numberOfpersons=" + numberOfpersons +
                        ", averageRating=" + averageRating +
                        '}';
            }

            public int getNumberOfpersons() {
                return numberOfpersons;
            }

            public void setNumberOfpersons (int numberOfpersons){
                this.numberOfpersons = numberOfpersons;
            }

            public int getAverageRating() {
                return averageRating;
            }

            public void setAverageRating(int averageRating) {
                this.averageRating = averageRating;
            }

            public NumberOfPersonsAverageRatingViewModel(int numberOfpersons, int averageRating){
                this.numberOfpersons = numberOfpersons;
                this.averageRating = averageRating;
            }
        }





