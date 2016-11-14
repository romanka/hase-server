package repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.Productivity;
import model.User;

@Repository("productivityRepository")
public interface ProductivityRepository extends CrudRepository<Productivity, Long> {
	List<Productivity> findByUser(String name);
	List<Productivity> findByYear(String user, Integer year);
	List<Productivity> findByMonth(String user, Integer year, Integer month);
	List<Productivity> findByDay(String user, Integer year, Integer month, Integer day);
	Productivity findByDayHour(String user, Integer year, Integer month, Integer day, Integer hour);
	
	Productivity findbyID(Long id);
}
