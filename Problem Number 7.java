Que - Write an apex trigger to prevent duplicate candidate record inside the object

Trigger PreventDuplicate on candidate__c(Before Insert , Before update){
	for(Candidate__c cand : Cand){
		Inetger recordCount = [Select count() from Candidate__c where Name =: cand.Name];
		if(recordCount>0){
			cand.addError('Duplicate record found');
		}
	}
}