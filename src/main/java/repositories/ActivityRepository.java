package repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.Activity;
import model.User;

@Repository("activityRepository")
public interface ActivityRepository extends CrudRepository<Activity, Long> {
	List<Activity> findByUser(String name);
	List<Activity> findByYear(String user, Integer year);
	List<Activity> findByMonth(String user, Integer year, Integer month);
	List<Activity> findByDay(String user, Integer year, Integer month, Integer day);
	Activity findByDayHour(String user, Integer year, Integer month, Integer day, Integer hour);
	
	Activity findbyID(Long id);
}
