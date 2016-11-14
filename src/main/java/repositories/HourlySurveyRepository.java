package repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.HourlySurvey;
import model.User;

@Repository("hourlyRepository")
public interface HourlySurveyRepository extends CrudRepository<HourlySurvey, Long> {
	HourlySurvey[] findByUser(String name);
	HourlySurvey[] findByYear(String user, Integer year);
	HourlySurvey[] findByMonth(String user, Integer year, Integer month);
	HourlySurvey[] findByDay(String user, Integer year, Integer month, Integer day);

	HourlySurvey findByHour(String user, Integer year, Integer month, Integer day, Integer hour);
	
	HourlySurvey findbyID(Long id);
}
