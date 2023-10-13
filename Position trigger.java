Trigger positionTrigger on position__C(before insert, before update){
	
	/* If user didnot gave status for IT department then status should be new
    If user did not gave status for Sales department then status should be Open
	and sub status should be pending
	*/
	for(position__C pos : trigger.new){
		system.debug('position status '+pos.status__c);
		
		if(pos.status__c == Null && pos.Department__c == 'IT'){
			pos.status__c = 'New';
		}
		else if (pos.Department == 'Sales' & pos.Department__c = Null){
			pos.status__c = 'Open';
			pos.subStatus__c = 'Pending';
		}
	}
}