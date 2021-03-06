package step_definitions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cookies.abstractdriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageobjects.signin;

public class steps extends abstractdriver {

	WebDriver driver = getDriver();

	signin s = new signin(driver);
	public Map<String, String> url;
	HttpURLConnection huc = null;
	int respCode = 200;

	@Given("^I entered  website url in browser$")
	public void i_entered_website_url_in_browser(Map<String, String> url) throws Throwable {

		this.url = url;
		System.out.println(this.url);
	}

	@Then("^I should be able to access the site with given \"(.*?)\" successfully$")
	public void i_should_be_able_to_access_the_site_with_given_successfully(String site_url) throws Throwable {

		String t = url.get(site_url);
		driver.get(t);
		try {

			huc = (HttpURLConnection) (new URL(t).openConnection());

			huc.setRequestMethod("HEAD");

			huc.connect();

			respCode = huc.getResponseCode();

			if (respCode >= 400) {
				System.out.println("url  is a broken link");
			} else {
				System.out.println("url is a valid link");
			}

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@And("^Insomnia cookies HomePage images should load successfully$")
	public void logo_verification() throws Throwable {

		s.validateInvalidImages(driver);
		
	}
	

}
