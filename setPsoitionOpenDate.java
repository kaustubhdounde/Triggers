//Upon creationof position if it is a new position and open date is not populated then popluate date as today
trigger populatePositionFields on Position__c (before insert) {
    
    if(trigger.isBefore && trigger.isInsert){
        for(position__c pos : Trigger.new){
            if(pos.status__c == 'new' && pos.Date_Opened__c == Null){
                pos.Date_Opened__c = date.today();
            }
        }
    }

}