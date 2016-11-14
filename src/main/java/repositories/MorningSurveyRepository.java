package repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.MorningSurvey;
import model.User;

@Repository("morningRepository")
public interface MorningSurveyRepository extends CrudRepository<MorningSurvey, Long> {
	MorningSurvey[] findByUser(String name);
	MorningSurvey[] findByYear(String user, Integer year);
	MorningSurvey[] findByMonth(String user, Integer year, Integer month);
	MorningSurvey findByDay(String user, Integer year, Integer month, Integer day);
	
	MorningSurvey findbyID(Long id);
}
