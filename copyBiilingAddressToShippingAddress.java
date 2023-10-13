// when account inserts and copybillingtoshipping (custom field) is checked then automaticaaly copy billing address in account shipping address
trigger copyBillingAddressToShippingAddres on Account (Before insert){
	if(trigger.isBefore && trigger.isInsert){
		for(Account acc: trigger.new){
			if(acc.CopyBillingToShipping__c == True){
				acc.ShippingAddress = cc.billingAddress;
			}
		}
	}
}

trigger on account copyAddresses(before insert){
	if(trigger.isBefore && trigger.isInsert){
		for(account acc : trigger.new){
			 if(copybillingtoshipping == True){
				acc.shippingAddress = billingAddress;
			 }
		}
	}
}