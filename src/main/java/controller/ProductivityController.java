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

import model.Productivity;
import model.User;
import repositories.ProductivityRepository;
import repositories.UserRepository;


@RestController
@RequestMapping(ProductivityController.CONTEXT)
public class ProductivityController
        extends GenericService {

    Logger                 logger  = LoggerFactory.getLogger(ProductivityController.class);

    static final String    CONTEXT = "/productivity/{year}/{month}/{day}";

    @Autowired
    private ProductivityRepository productivityRepo;

    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Productivity getDayActivity(@PathVariable Integer year, @PathVariable Integer month, @PathVariable Integer day, @RequestParam ("token") String userToken) {
        logger.debug("getDayActivity: " + year + "-" +month +"-" +day);

        List<Productivity> productivities = productivityRepo.findByDay(userToken, year, month, day);

        Integer max = 0;
        for(Productivity a : productivities){
        	if(a.getHour()>max)
        		max = a.getHour();
        }
        return productivityRepo.findByDayHour(userToken, year, month, day, max);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = CONTEXT + "/{hour}")
    @ResponseStatus(HttpStatus.OK)
    public Productivity getHourActivity(@PathVariable Integer year, @PathVariable Integer month, @PathVariable Integer day, @PathVariable Integer hour, @RequestParam ("token") String userToken) {
        logger.debug("getDayActivity: " + year + "-" +month +"-" +day);

        
        return productivityRepo.findByDayHour(userToken, year, month, day, hour);
    }
    
}
