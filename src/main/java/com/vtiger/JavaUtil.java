package com.vtiger;

import java.util.Random;

import com.github.javafaker.Faker;

public class JavaUtil {

	/**
	 * This is method is used to generate a Random number
	 * @return random number
	 */
		
      public int generateRandomNumber() {
    	  Random random = new Random();
    	  return random.nextInt(1000);
      }
	/**
	 * this method is going to generate fake first name
	 * @return fake first number
	 */
     
      public String fakeFirstName() {
    	  Faker faker = new Faker();
    	  return faker.name().firstName();
      }
    	  
    	  /**
    	   * this method is going to generate fake last name
    	   * @return last name
    	   */
     public String fakeLastName(){
    	 Faker faker = new Faker();
    	 return faker.name().lastName();
    
     }
     
     /**
      * This is going to generate a Fake address
      * @return Fake address
      */
    	  public String fakeAddress() {
    		  Faker faker = new Faker();
    		return  faker.address().fullAddress();
    	  }
    	  
      /**
       * This method is going to generate fake company name
       * @return fake company name
       */
		public String fakeCompanyName() {
			Faker faker = new Faker();
			return faker.company().name();
			
		}
	}

