package be.contribute.controller;

/**
 * Created by kschepers on 1/13/14.
 */
import be.fedict.eid.applet.service.Address;
import be.fedict.eid.applet.service.EIdData;
import be.fedict.eid.applet.service.Identity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@Controller
public class EidController {

	@RequestMapping(value = "/showEidData", method = RequestMethod.GET)
	public String getEidData(ModelMap model) {
		return "showEidData";
	}

	@RequestMapping(value = "/showEidDataJSON", method = RequestMethod.GET)
	public String getEidDataJSON(ModelMap model) {
		return "showEidDataJSON";
	}

	@RequestMapping(value = "/postJson", method = RequestMethod.GET)
	public ModelAndView postEidData(HttpServletRequest request) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		EIdData eIdData = (EIdData) httpSession.getAttribute("eid");
		if (null == eIdData) {
			throw new ServletException("no eID data available");
		}

		JSONObject eidJSONObject = eidDataToJson(eIdData);
		System.out.println("eidJSONObject = " + eidJSONObject.toJSONString());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("eidData", eidJSONObject.toJSONString());

		return new ModelAndView("showEidDataJSON", model);
	}

	private JSONObject eidDataToJson(EIdData eIdData) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		JSONObject eidJSONObject = new JSONObject();

		JSONObject identityJSONObject = new JSONObject();
		eidJSONObject.put("identity", identityJSONObject);
		Identity identity = eIdData.identity;
		identityJSONObject.put("nationalNumber", identity.nationalNumber);
		identityJSONObject.put("name", identity.name);
		identityJSONObject.put("firstName", identity.firstName);
		identityJSONObject.put("middleName", identity.middleName);
		identityJSONObject.put("dateOfBirth", simpleDateFormat
				.format(identity.dateOfBirth.getTime()));
		identityJSONObject.put("placeOfBirth", identity.placeOfBirth);
		identityJSONObject.put("gender", identity.gender.toString());

		JSONObject cardJSONObject = new JSONObject();
		eidJSONObject.put("card", cardJSONObject);
		cardJSONObject.put("cardNumber", identity.cardNumber);
		cardJSONObject.put("chipNumber", identity.chipNumber);
		cardJSONObject.put("cardDeliveryMunicipality",
				identity.cardDeliveryMunicipality);
		cardJSONObject.put("cardValidityDateBegin", simpleDateFormat
				.format(identity.cardValidityDateBegin.getTime()));
		cardJSONObject.put("cardValidityDateEnd", simpleDateFormat
				.format(identity.cardValidityDateEnd.getTime()));

		Address address = eIdData.address;
		if (null != address) {
			JSONObject addressJSONObject = new JSONObject();
			eidJSONObject.put("address", addressJSONObject);
			addressJSONObject.put("streetAndNumber", address.streetAndNumber);
			addressJSONObject.put("municipality", address.municipality);
			addressJSONObject.put("zip", address.zip);
		}

		return eidJSONObject;
	}

}
