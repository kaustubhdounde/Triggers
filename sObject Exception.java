// If we try to retrieve a field without querying in soql then it will throw a "sObject exception"

public class sObjectException{
	public static void testException(){
		 try{
			 List <Account> accList = [Select name from Account];
			 
			 for(Account acc : accList){
				 system.debug(acc.numberOfEmployees);  // it will thrown an exception bcoz we did not queries a numberOfEmployee field
			 }
			 catch(sObjectException soe){
				 system.debug(soe.getMessage);
			 }
		 }
	}
}