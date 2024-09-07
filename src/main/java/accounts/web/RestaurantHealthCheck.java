package accounts.web;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import rewards.internal.restaurant.RestaurantRepository;

@Component
public class RestaurantHealthCheck implements HealthIndicator {
	private final RestaurantRepository restaurant;
	
	public RestaurantHealthCheck(RestaurantRepository restaurant) {
		this.restaurant = restaurant;
	}
	
	@Override
	public Health health() {
		long count = restaurant.getRestaurantCount();
		
		return count > 0 ? Health.up().build() : Health.status("NO_RESTAURANTS").build();
	}
}