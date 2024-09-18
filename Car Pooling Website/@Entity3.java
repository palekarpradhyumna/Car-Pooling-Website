@Entity
public class RideRequest {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @ManyToOne
  @JoinColumn(name = "rider_id")
  private User rider;
  private String pickupLocation;
  private String dropoffLocation;
  private Date rideDate;
  private Time rideTime;
  private int numPassengers;

  // getters and setters
}