package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import model.Activity;
import model.User;
import repositories.ActivityRepository;
import repositories.UserRepository;


@RestController
@RequestMapping(ActivityController.CONTEXT)
public class ActivityController extends GenericService {

    Logger                 logger  = LoggerFactory.getLogger(ActivityController.class);

    static final String    CONTEXT = "/activity/{year}/{month}/{day}";

    @Autowired
    private ActivityRepository activityRepo;

    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Activity getDayActivity(@PathVariable Integer year, @PathVariable Integer month, @PathVariable Integer day, @RequestParam ("token") String userToken) {
        logger.debug("getDayActivity: " + year + "-" +month +"-" +day);

        List<Activity> activities = activityRepo.findByDay(userToken, year, month, day);

        Integer max = 0;
        for(Activity a : activities){
        	if(a.getHour()>max)
        		max = a.getHour();
        }
        return activityRepo.findByDayHour(userToken, year, month, day, max);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = CONTEXT + "/{hour}")
    @ResponseStatus(HttpStatus.OK)
    public Activity getHourActivity(@PathVariable Integer year, @PathVariable Integer month, @PathVariable Integer day, @PathVariable Integer hour, @RequestParam ("token") String userToken) {
        logger.debug("getDayActivity: " + year + "-" +month +"-" +day);

        
        return activityRepo.findByDayHour(userToken, year, month, day, hour);
    }
    
}
