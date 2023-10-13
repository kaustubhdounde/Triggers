/*
 On account create two checkbox field labeled as contact and opportunity 
when. Now when a new account record is created and if a particular contact
or opportunity checkbox is checked then create that related record. 
also opportunity record should be created only if the account record active
picklist is poputaed with yes
*/
trigger createContactandOpp on Account (After insert) {
    
    if(trigger.isAfter && Trigger.isInsert){
        List <contact> conList = new list <contact>();
        List<opportunity> oppList = new List <opportunity>();
        for(Account acc : Trigger.new){
            if(acc.contact__c == True){
                contact con = new contact();
                con.lastName = acc.name + 'LN';
                con.FirstName = acc.name + 'FN';
                con.Phone = acc.Phone;
                con.AccountId = acc.Id;
                conList.add(con);
            }
            if(acc.Active__c == 'Yes'&& acc.opportunity__c == True ){
                Opportunity opp = new opportunity();
                opp.Name = acc.Name + 'Opportunity';
                opp. = acc.Id;
                opp.Type = 'New Customer';
                opp.StageName = 'prospecting';
                opp.CloseDate = date.today() + 30;
                opp.Credit_Card__c = 'XXXXXXXXXX';
                oppList.add(opp);
            }
        }
        if(!conList.isEmpty()){
            insert conList;
        }
        if(!oppList.isEmpty()){
            insert oppList; 
        }
    }    

}