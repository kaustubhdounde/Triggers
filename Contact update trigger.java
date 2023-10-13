/*Create a trigger that fires before inserting a new Contact record.
 Update the Contact's Description field with "New Contact" before it's saved
 */
 
 Trigger updateContact on contact(before insert){
	 for(Contact con : Trigger.new){
		 con.Description = 'New Contact';
		 system.debug('contact desc is - '+con.Description);
		 
	 }
 }

 trigger on contact addConDescription(before insert){
	if(trigger.isBefore && trigger.isInsert){
		for (contact con :  trigger.new){
			  con.Description = 'new contact';

		}
	}
 }