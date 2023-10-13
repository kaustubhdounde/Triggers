
//Account record should have a filed named recent opportunity amount. It should contain opportunity amount of latest created opportunity on account
trigger recentOpportunityAmount on Opportunity (After insert) {
    
    if(trigger.isAfter && trigger.isInsert){
        List <Account> accList = new List <Account>();
        for(Opportunity opp :trigger.new){
            Account acc = new Account();
            acc.id = opp.AccountId;
            acc.Recent_opportunity_amount__c = opp.Amount;
            accList.add(acc);
        }
        if(!accList.isEmpty()){
            update accList;
        }
    }

}