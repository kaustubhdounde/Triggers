// Upon account creation if industry is not null and having value as 'insurance' then populate rating as 'Hot'
Trigger setAccountRating on Account(Before insert, Before update){
	if((trigger.isBefore) && (trigger.isInsert) || (trigger.isUpdate)){
		for(Account acc : trigger.new){
			if(acc.industry != Null && acc.industry == 'insurance'){
				acc.Rating = 'Hot';
			}
		}
	}
}


// or can create as seprate trigger handler
public class setAccountRatingHandler{
	
	public static void setRating(List <Account> accList){
		for(Account acc : accList){
			if(acc.industry != Null && acc.industry == 'insurance'){
				acc.rating = 'hot';
			}
		}
	}
}

trigger on account updateRating(before insert){
	if(trigger.isBefore && trigger.isInsert){
		for(Account acc: Trigger.new){
			if(acc.industry != null && acc.industry == 'Insirance'){
				acc.rating = 'Hot';
			}
		}
	}
}

public class UpdateRatingHandler{
    public class setRatingHot(List <Account> accList){
		
	}

}