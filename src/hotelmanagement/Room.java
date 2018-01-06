package hotelmanagement;



public class Room {
	     int roomNo;
	     String status;
	     int capacity;
	     String roomType;
	     Room(){
	    	 
	     }
	     Room(int roomNo,String status,int capacity,String roomType){
	    	 this.roomNo=roomNo;
	    	 this.status=status;
	    	 this.capacity=capacity;
	    	 this.roomType=roomType;
	    	 
	     }
		public int getRoomNo() {
			return roomNo;
		}
		public void setRoomNo(int roomNo) {
			this.roomNo = roomNo;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public int getCapacity() {
			return capacity;
		}
		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}
		public String getRoomType() {
			return roomType;
		}
		public void setRoomType(String roomType) {
			this.roomType = roomType;
		}
	     
	     
       
}
