@Entity
public class Ride {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @ManyToOne
  @JoinColumn(name = "driver_id")
  private User driver;
  @ManyToOne
  @JoinColumn(name = "ride_request_id")
  private RideRequest rideRequest;
  private String pickupLocation;
  private String dropoffLocation;
  private Date rideDate;
  private Time rideTime;
  private int numPassengers;

  // getters and setters
}