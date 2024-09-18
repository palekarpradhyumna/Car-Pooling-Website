@Entity
public class Payment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @ManyToOne
  @JoinColumn(name = "ride_id")
  private Ride ride;
  private Date paymentDate;
  private BigDecimal paymentAmount;
  private String paymentStatus;

  // getters and setters
}