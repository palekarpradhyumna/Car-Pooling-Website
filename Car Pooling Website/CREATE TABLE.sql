CREATE TABLE users (
  id INT PRIMARY KEY,
  username VARCHAR(255),
  password VARCHAR(255),
  email VARCHAR(255),
  phone_number VARCHAR(20)
);

CREATE TABLE ride_requests (
  id INT PRIMARY KEY,
  rider_id INT,
  pickup_location VARCHAR(255),
  dropoff_location VARCHAR(255),
  ride_date DATE,
  ride_time TIME,
  num_passengers INT,
  FOREIGN KEY (rider_id) REFERENCES users(id)
);

CREATE TABLE rides (
  id INT PRIMARY KEY,
  driver_id INT,
  ride_request_id INT,
  pickup_location VARCHAR(255),
  dropoff_location VARCHAR(255),
  ride_date DATE,
  ride_time TIME,
  num_passengers INT,
  FOREIGN KEY (driver_id) REFERENCES users(id),
  FOREIGN KEY (ride_request_id) REFERENCES ride_requests(id)
);

CREATE TABLE payments (
  id INT PRIMARY KEY,
  ride_id INT,
  payment_date DATE,
  payment_amount DECIMAL(10, 2),
  payment_status VARCHAR(20),
  FOREIGN KEY (ride_id) REFERENCES rides(id)
);