package udemy.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

 

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import udemy.base.Base;
import udemy.pages.refer;

public class referTest  extends Base {
	refer hp;
	public referTest() throws IOException {
		super();
			}
	 
	@BeforeClass
	public void Setup() throws IOException {
		initialization();	
		  hp=new refer();
	}
	
	@AfterSuite
	public void Close() {
	close();
	}
	
	@Test
	public void verifyTitleofHomePage() {
		System.out.println("in home class"); 
        String actualTitle= refer.getTitle();
        String expectedTitle=  prop.getProperty("expectedTitle");
        System.out.println(actualTitle);
        if(actualTitle.equals(expectedTitle) )
        {
        	System.out.println("actual title and excepted title are same ");
        }
	}
	@Test
	public void verifyHomebuttonidDisplayed() {
		Boolean home =refer.getHeaderButtons();
		if(home==true) {
			System.out.println("Displayed");
			
		}
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
  
}
