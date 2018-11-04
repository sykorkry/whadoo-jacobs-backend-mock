package whadoo;

public class Purchase {

        private Integer eventId;
        private String userName;

        public Purchase(int eventId, String userName) {
            this.eventId = eventId;
            this.userName = userName;
        }

        public Integer getEventId() {
            return eventId;
        }

        public String getUserName() {
            return userName;
        }
}
