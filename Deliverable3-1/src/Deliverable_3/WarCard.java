package Deliverable_3;
/* Since War only uses the rank and not suit, this is reflected
 * in the simplicity of the class.
 * @author Austin Priest, Emre Erdonmez, Jaycob Bond
*/

public class WarCard extends Card {

	public WarCard() {
	}
        
        public WarCard(int value) {
            this.setRank(value);
        }
        
        private int rank;
        
        public void setRank(int num) {
            if (num > 0 && num < 14)
                this.rank = num;
            else
                throw new IllegalArgumentException("Rank must be between 1 and 13.");
        }
        
        public int getRank() {
            return this.rank;
        }
     
        @Override
	public String toString() {
            return Integer.toString(this.getRank());
	}

}