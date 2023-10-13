//Prevent duplicate record on candidate object

// Trigger

trigger preventDuplicateRecord on Candidate__c (before insert, before update) {
    // prevent duplicate record on candidate object
    if((trigger.isBefore) && (trigger.isInsert) || (trigger.isUpdate)){
        preventDuplicateRecordHandler.checkDuplicate(trigger.new);
    }

}

// Handler
public class preventDuplicateRecordHandler {
    // prevent duplicate record on candidate object
    public static void checkDuplicate(List <candidate__c> canList){
        for(candidate__c cand : canList){
            Integer count = [select count() from candidate__c where Email__c =:cand.email__c];
            if(count > 0){
                cand.addError('duplicate record found you can not create record with same name');
            }
            
        }
       
        
    }
    
    
    

}

// prevent duplicate record on account

trigger on account preventDuplicateRecord(before insert, bofore update){
    if((trigger.isBefore) && (trigger.isInsert) || (trigger.isUpdate)){

    }
}

Handler

public class preventDuplicateRecordHandler{
    public static void chekDuplicate(List <Account> accList){
        for(Account acc : accList){
            Integer count = [select count(id) from account where email = : acc.Email];
            if(count > 0){
                can.addError('Record with this email already exist');
            }
        }
    }
    
}
