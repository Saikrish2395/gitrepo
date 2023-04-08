package GlueCode;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class Steps {

	WebDriver driver;
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
	    
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	
	@When("User opens URL {string}")
	public void user_opens_url(String TestUrl) {
		driver.get(TestUrl);
		
	}
	
	
	
	@When("User enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) throws Exception {
		findElement(By.name("username")).sendKeys(username);
		findElement(By.name("password")).sendKeys(password);
		findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();  
		
	}
	
	
	@Then("Create Skills Record")
	public void create_skills_record(io.cucumber.datatable.DataTable dataTable) throws Exception {
		
		
		List<List<String>> SkillsData=dataTable.cells();
		
		System.out.println("Number of rows :"+SkillsData.size());
		
		for(int i=0;i<SkillsData.size();i++) {
			
			//System.out.println(SkillsData.get(i).get(0));
			
			String SkillName=SkillsData.get(i).get(0);
			String SkillDescr=SkillsData.get(i).get(1);
			
			System.out.println("____________________________");
			
			  findElement(By.xpath("//span[text()='Admin']")).click();
			  findElement(By.xpath("//span[text()='Qualifications ']")).click();
			  findElement(By.xpath("//a[text()='Skills']")).click();
			  findElement(By.xpath("//button[text()=' Add ']")).click();
			  
			 findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(SkillName);
			  findElement(By.xpath("//textarea[@placeholder='Type description here']")).sendKeys(SkillDescr);
			  
			  Thread.sleep(5000);
			  findElement(By.xpath("//button[text()=' Save ']")).click();
			

	}

		
	}
	
	

    
	

	@Then("Create Nationality Record")
	public void create_nationality_record(io.cucumber.datatable.DataTable dataTable) throws Exception {
	    
		 List<List<String>> NationalityData=dataTable.cells();
			
			
			System.out.println("Number of rows :"+NationalityData.size());
			
			for(int i=0;i<NationalityData.size();i++) {
				
				//System.out.println(SkillsData.get(i).get(0));
				
				String NationalityText=NationalityData.get(i).get(0);
				
				
				System.out.println("____________________________");
				
				  findElement(By.xpath("//span[text()='Admin']")).click();
				  findElement(By.linkText("Nationalities")).click();
				  findElement(By.xpath("//button[text()=' Add ']")).click();
				  findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(NationalityText);
				  Thread.sleep(5000);
				  driver.findElement(By.xpath("//button[text()=' Save ']")).click();
				
				}
	
	}
	
	
	
	
	
	@Then("Create Jobs Record")
	public void create_jobs_record(io.cucumber.datatable.DataTable dataTable) throws Exception {
	
		
        List<List<String>> JobsData=dataTable.cells();
		
		
		for(int i=0;i<JobsData.size();i++) {
			
			
			String JobTitle=JobsData.get(i).get(0);
			String JobDescr=JobsData.get(i).get(1);
			String Jobnote=JobsData.get(i).get(2);
			
			System.out.println("____________________________");
			
			  findElement(By.xpath("//span[text()='Admin']")).click();
			  findElement(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[2]/nav/ul/li[2]/span")).click();
			  findElement(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[2]/nav/ul/li[2]/ul/li[1]/a")).click();
			  findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div[1]/div/button")).click();
			  
			 findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")).sendKeys(JobTitle);
			 findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/textarea")).sendKeys(JobDescr);
			 findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[4]/div/div[2]/textarea")).sendKeys(Jobnote);
			  
			  Thread.sleep(5000);
			  findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[5]/button[2]")).click();
			
			  
			

	}
		
		


		
	}
	
	
	@When("Click on logout button")
	public void click_on_logout_button() throws Exception {
		findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		findElement(By.linkText("Logout"));    
		
	}
	
	
	@Then("Close Browser")
	public void close_browser() {
	   
		driver.close();
	}

	
	
	 public  WebElement findElement(By by) throws Exception 
		{

			WebElement elem = driver.findElement(by);  
			
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		 
			}
			return elem;
		}
	
	
}
