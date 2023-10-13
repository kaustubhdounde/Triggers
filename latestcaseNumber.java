
// when a case is created a latest case number field will be filled on account object with nwe cas number
trigger latestCaseNum on Case (After insert) {
    
    if(trigger.isAfter && trigger.isInsert){
        List <Account> AccList = new list <Account>();
        for(case c : trigger.new){
            Account acc = new account();
            acc.Id = c.AccountId;
            acc.Latest_case_Number__c = c.CaseNumber;
            accList.add(acc);
         }
        
        if(!accList.isEmpty()){
            update accList; 
        }
            
     }
        
}

trigger on case latestCaseNumber (after insert){
    if(trigger.isInsert and triger.isAfter){
        List<Account> accList = new List <Account> ();
        for(case c : trigger.new){
            Account acc = new Account();
            acc.id = c.AccountId;
            acc.latestCaseNumber__C = c.CaseNumber
            accLIst.add(acc); 
        }
        if(!accList.isEmpty()){
            insert accList;
        }
    }
}
        

