// RideRequest.java (Entity class)
public class RideRequest {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private User rider;
  private String pickupLocation;
  private String dropoffLocation;
  private Date rideDate;
  private Time rideTime;
  private int numPassengers;

  // getters and setters
}
// RideRequestService.java (Service class)
@Service
public class RideRequestService {
  @Autowired
  private RideRequestRepository rideRequestRepository;

  public List<RideRequest> getAllRideRequests() {
    return rideRequestRepository.findAll();
  }

  public RideRequest createRideRequest(RideRequest rideRequest) {
    return rideRequestRepository.save(rideRequest);
  }

  public RideRequest getRideRequestById(int id) {
    return rideRequestRepository.findById(id).orElse(null);
  }

  public void updateRideRequest(RideRequest rideRequest) {
    rideRequestRepository.save(rideRequest);
  }

  public void deleteRideRequest(int id) {
    rideRequestRepository.deleteById(id);
  }
}

// RideRequestController.java (Controller class)
@RestController
@RequestMapping("/ride-requests")
public class RideRequestController {
  @Autowired
  private RideRequestService rideRequestService;

  @PostMapping
  public RideRequest createRideRequest(@RequestBody RideRequest rideRequest) {
    return rideRequestService.createRideRequest(rideRequest);
  }

  @GetMapping
  public List<RideRequest> getAllRideRequests() {
    return rideRequestService.getAllRideRequests();
  }

  @GetMapping("/{id}")
  public RideRequest getRideRequestById(@PathVariable int id) {
    return rideRequestService.getRideRequestById(id);
  }

  @PutMapping("/{id}")
  public RideRequest updateRideRequest(@PathVariable int id, @RequestBody RideRequest rideRequest) {
    return rideRequestService.updateRideRequest(rideRequest);
  }

  @DeleteMapping("/{id}")
  public void deleteRideRequest(@PathVariable int id) {
    rideRequestService.deleteRideRequest(id);
  }
}