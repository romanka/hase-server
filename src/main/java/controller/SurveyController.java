package controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import model.EveningSurvey;
import model.HourlySurvey;
import model.MorningSurvey;
import model.User;
import repositories.EveningSurveyRepository;
import repositories.HourlySurveyRepository;
import repositories.MorningSurveyRepository;
import repositories.UserRepository;


@RestController
public class SurveyController
        extends GenericService {

    Logger logger  = LoggerFactory.getLogger(SurveyController.class);

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private MorningSurveyRepository morningRepo;
    @Autowired
    private HourlySurveyRepository hourlyRepo;
    @Autowired
    private EveningSurveyRepository eveningRepo;

    private final String   CONTEXT = "/survey";

    /*
     * Context: /survey/morning
     */
    @RequestMapping(value = CONTEXT + "/morning", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public MorningSurvey newMorningEntry(@RequestParam ("token") String userToken, @RequestBody MorningSurvey entry) {
        logger.debug("newEntry: " + entry);

        MorningSurvey newEntry = morningRepo.save(entry);

        return newEntry;
    }

    /*
     * Context: /survey/hourly
     */
    @RequestMapping(value = CONTEXT + "/hourly", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public HourlySurvey newHourlyEntry(@RequestBody HourlySurvey entry) {
        logger.debug("newEntry: " + entry);

        HourlySurvey newEntry = hourlyRepo.save(entry);

        return newEntry;
    }
    
    /*
     * Context: /survey/evening
     */
    @RequestMapping(value = CONTEXT + "/evening", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public EveningSurvey newEveningEntry(@RequestBody EveningSurvey entry) {
        logger.debug("newEntry: " + entry);

        EveningSurvey newEntry = eveningRepo.save(entry);

        return newEntry;
    }
    

}