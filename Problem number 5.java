Que - Create a trigger to make sure each contact associated with an account

__________Method No 1_____________

Trigger AccountAssociation on contact ( before insert , before update ){
	if((Trigger.isBefore) && (Trigger.isInsert) || (Trigger.isUpdate)){
		for(Contact con : Trigger.New){
			if(con.AccountId == Null){
				con.AccountId.addError('Please select a Account');
			}
		}
	}
}

__________Method No 2_____________

Trigger

Trigger AccountAssociation on contact (Before insert , Before Update){
	If((Trigger.isBefore) && (Trigger.isInsert) || (Trigger.isUpdate)){
		
	}
}

Trigger Handler

Public AccountAssociationHandler {
	public static void problemfive (List <contact> conlist){
	for(Contact con : conlist){
		if(con.AccountId == Null){
			con.AccountId.addError('Please select a account');
		}
	}
	}
}