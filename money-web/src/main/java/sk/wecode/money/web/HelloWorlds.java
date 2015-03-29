package sk.wecode.money.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * Created by Slafko Žiak on 28.3.2015.
 */
@RestController
public class HelloWorlds {

    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.queryForMap("select * from test").toString();
    }

}
