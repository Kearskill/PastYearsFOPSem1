package paper2020;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Location 1");
        // for latitude 1
        System.out.println("Enter Direction: [N, S, E, W] : ");
        char latitudeDirection1 = sc.next().charAt(0);
        System.out.println("Enter Degree, Minute and Second : ");
        int latitudeDegree1 = sc.nextInt();
        int latitudeMinute1 = sc.nextInt();
        int latitudeSecond1 = sc.nextInt();
        double latitudeDecimalDegree1 = decimalDegreeConvert(latitudeDirection1, latitudeDegree1, latitudeMinute1, latitudeSecond1);

        // for longitude 1
        System.out.println("Enter Direction: [N, S, E, W] : ");
        char longitudeDirection1 = sc.next().charAt(0);
        System.out.println("Enter Degree, Minute and Second : ");
        int longitudeDegree1 = sc.nextInt();
        int longitudeMinute1 = sc.nextInt();
        int longitudeSecond1 = sc.nextInt();
        double longitudeDecimalDegree1 = decimalDegreeConvert(longitudeDirection1, longitudeDegree1, longitudeMinute1, longitudeSecond1);

        System.out.println("Enter Location 2");
        // for latitude 2
        System.out.println("Enter Direction: [N, S, E, W] : ");
        char latitudeDirection2 = sc.next().charAt(0);
        System.out.println("Enter Degree, Minute and Second : ");
        int latitudeDegree2 = sc.nextInt();
        int latitudeMinute2 = sc.nextInt();
        int latitudeSecond2 = sc.nextInt();
        double latitudeDecimalDegree2 = decimalDegreeConvert(latitudeDirection2, latitudeDegree2, latitudeMinute2, latitudeSecond2);

        // for longitude 2
        System.out.println("Enter Direction: [N, S, E, W] : ");
        char longitudeDirection2 = sc.next().charAt(0);
        System.out.println("Enter Degree, Minute and Second : ");
        int longitudeDegree2 = sc.nextInt();
        int longitudeMinute2 = sc.nextInt();
        int longitudeSecond2 = sc.nextInt();
        double longitudeDecimalDegree2 = decimalDegreeConvert(longitudeDirection2, longitudeDegree2, longitudeMinute2, longitudeSecond2);

        System.out.printf("\nLocation 1 : %2.6f Latitude , %2.6f Longitude",latitudeDecimalDegree1,longitudeDecimalDegree1);
        System.out.printf("\nLocation 2 : %2.6f Latitude , %2.6f Longitude",latitudeDecimalDegree2,longitudeDecimalDegree2);

        System.out.println("\nDistance : " + calcDistance(latitudeDegree1,longitudeDegree1,latitudeDegree2,longitudeDegree2));

    }
    private static double decimalDegreeConvert(char direction, int degree, int minute, int second){
        int factor;
        if (Character.toUpperCase(direction) == 'N' || Character.toUpperCase(direction) == 'E'){
            factor = 1; // positive
        } else {
            factor = -1; // negative
        }
        return (double) factor * degree + (double) (minute * 60 + second) / 3600;
    }

    private static double calcDistance(double latitude1, double latitude2, double longitude1, double longitude2){
        double differenceLatitude = (Math.abs(latitude1 - latitude2));
        double differenceLongitude = (Math.abs(longitude1 - longitude2));
        double a = Math.pow(Math.sin(differenceLatitude / 2.0), 2) + Math.cos(latitude1) * Math.cos(latitude2) * Math.pow(Math.sin(differenceLongitude/2.0),2);
        double c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
        return 6371.0 * c; // the distance
    }
}
