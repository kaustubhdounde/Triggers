/*Write a trigger that runs before updating an Account record. 
Check if the Account's "AnnualRevenue" field is being increased by more than 10%, 
and if so, prevent the update and display an error message.
*/

Trigger accountTrigger on Account(Before Update){
	for(Account acc: Trigger.new){
		
		Account oldAccount = Trigger.oldMap.get(acc.Id);
		if(oldAccount.AnnualRevenue * 1.1 < acc.AnnualRevenue){
			acc.addError('Annual revenue cannot be increased by more than 10%');

		}
	}
	
}