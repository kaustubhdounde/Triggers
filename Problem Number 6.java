Que - Create a trigger to prevent deletion of Active account Record

__________Method No 1_____________

Trigger preventAccountDelete(Before Delete){
	if(Trigger.isBefore) && (Trigger.isDelete){
		for(Account Acc : Trigger.old){
			if(Acc.Acive__c == 'Yes'){
				Acc.Active__c.addError('You can not Delete an Active Account');
			}
		}
	}
}


__________Method No 2____________

Trigger

Trigger preventAccountDelete (Before Delete){
if(Trigger.isBefore) && (Trigger.isDelete){
	preventAccountDeleteHandler.ProblemSix(Trigger.old)
}
}


Trigger Handler

public class preventAccountDeleteHandler{
	public static void ProblemSix(List <Account> Acclist){
		for(Account Acc : Acclist){
			if( Acc.Active__c == 'Yes'){
				Acc.Active__c.addError('You can Delete a Active Account');
			}
		}
	}
}