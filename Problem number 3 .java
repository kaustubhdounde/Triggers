// Que - Create a record on contact object to make email and phone fields mandatory upon creating or updating a contact record


__________Method No 1_____________
Trigger mandatoryfields on contact (before insert , before update){
	if((Trigger.isbefore) && (Trigger.isinsert) ||(Trigger.isupdate)){
		for(contact con : Trigger.new){
			if(con.phone==null) && (con.Email=="){
			 con.phone.adderror('Please enter a phone number');
			}
			if(con.email==null) && (con.phone=="){
			 con.email.adderror('please enter a email address');
			}
		}
	}
}

__________Method No 2_____________

Trigger

Trigger mandatoryfields on contact (Before insert , before update){
	if((Trigger.isBefore) && (Trigger.isinsert) || (Trigger.isUpdate)){
		
	}
}

Trigger Handler

Public mandatoryfieldsHandler {
	public static void problemthree (List <Contact> conlist){
		for(contact con : conlist){
			if((con.Phone == null) && (con.Email=='')){
				con.phone.addError('Please Enter Phone number');
			}
			if((con.Email == null) && (con.phone == '')){
				con.Email.addError('Please Enter a Email Address');
			}
		}
	}
}