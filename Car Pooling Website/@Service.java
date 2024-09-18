@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserById(int id) {
    return userRepository.findById(id).orElse(null);
  }

  public void add