public class Solution {

    public static class Meeting {

        private int startTime;
        private int endTime;

        public Meeting(int startTime, int endTime) {
            // number of 30 min blocks past 9:00 am
            this.startTime = startTime;
            this.endTime   = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Meeting)) {
                return false;
            }
            final Meeting meeting = (Meeting) o;
            return startTime == meeting.startTime && endTime == meeting.endTime;
        }
    }

    public static List<Meeting> mergeRanges(List<Meeting> meetings) {
        if (meetings==null || meetings.size()<2) {
            return meetings;
        }
        meetings.sort((Meeting meeting, Meeting otherMeeting) -> 
            new Integer(meeting.getStartTime()).compareTo(new Integer(otherMeeting.getStartTime())));
        List<Meeting> mergedMeetings = new ArrayList<>(meetings.size());
        int currentStartTime = meetings.get(0).getStartTime();
        int currentEndTime = meetings.get(0).getEndTime();
        Meeting currentMeeting = new Meeting(currentStartTime, currentEndTime);
        mergedMeetings.add(currentMeeting);
        for (Meeting meeting: meetings) {
            int startTime = meeting.getStartTime();
            int endTime = meeting.getEndTime();
            if (startTime <= currentEndTime) {
                currentEndTime = Math.max(currentEndTime, endTime);
                currentMeeting.setEndTime(currentEndTime);
            } else {
                currentMeeting = new Meeting(startTime, endTime);
                currentEndTime = endTime;
                mergedMeetings.add(currentMeeting);
            }
        }
        return mergedMeetings;
    }
}
