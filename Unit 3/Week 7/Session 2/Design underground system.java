
import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    class CheckInInfo {
        String station;
        int time;

        CheckInInfo(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    class TravelInfo {
        int totalTime;
        int totalTrips;

        TravelInfo() {
            totalTime = 0;
            totalTrips = 0;
        }
    }

    private Map<Integer, CheckInInfo> checkIns;
    private Map<String, TravelInfo> journeys;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        journeys = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInInfo(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInInfo info = checkIns.get(id);

        int duration = t - info.time;
        String route = info.station + "->" + stationName;

        TravelInfo travel = journeys.getOrDefault(route, new TravelInfo());
        travel.totalTime += duration;
        travel.totalTrips++;

        journeys.put(route, travel);
        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;
        TravelInfo travel = journeys.get(route);

        return (double) travel.totalTime / travel.totalTrips;
    }
}
