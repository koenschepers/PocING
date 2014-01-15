package be.contribute.controller;

/**
 * Created by kschepers on 1/13/14.
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

@Controller
public class EidController {

	@RequestMapping(value = "/readEid", method = RequestMethod.GET)
	public String readEid(ModelMap model) {
		return "readEid";
	}

	@RequestMapping(value = "/readEidPin", method = RequestMethod.GET)
	public String readEidPin(ModelMap model) {
		return "readEidPin";
	}


	@RequestMapping(value = "/showEidData", method = RequestMethod.GET)
	public String getEidData(ModelMap model) {
		return "showEidData";
	}

}
