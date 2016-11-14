package repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.EveningSurvey;
import model.User;

@Repository("eveningRepository")
public interface EveningSurveyRepository extends CrudRepository<EveningSurvey, Long> {
	EveningSurvey[] findByUser(String name);
	EveningSurvey[] findByYear(String user, Integer year);
	EveningSurvey[] findByMonth(String user, Integer year, Integer month);
	EveningSurvey findByDay(String user, Integer year, Integer month, Integer day);
	
	EveningSurvey findbyID(Long id);
}
