xQUE - Trigger on which will create account record whenever contact is created without an Account

_______Method-1__________

Trigger CreateAccount on Contact(After insert){
    List<Account> Acclist = New List<Account>();
	if((Trigger.isAfter)&&(Trigger.isinsert)){
	  for(Contact con : Trigger.new){
	    if(con.AccountId == Null){
		  Account Acc = new Account();
		  Acc.Name = con.LastName;
		  Acc.Phone = con.Phone;
		  AccList.add(acc);
		}
	  }
	}
	if(!Acclist.isEmpty()){
	  insert Acclist;
	}
}

_______Method-2__________

Trigger

Trigger CreateAccount on Contact(After insert){
  if((Trigger.isAfter) && (Trigger.isinsert)){
    
  }
}


Apex Class

Public CreateAccountHandler{
 public static void Problemtwo(List<Contact> ConList){ 
   List<Account> Acclist = New List <Account> ();
   for(Contact con : conList){
    if(con.AccountId==Null){
	 Account acc = new Account();
	 acc.Name = Con.LastName;
	 acc.phone = con.phone;
	 Acclist.add(acc);
	}
   }   
  }
  if(!AccList.isEmpty){
   insert(AccList);
  }

}




trigger on contact createRelatedAccount(After insert){
	if(trigger.isAfter && trigger.isINsert){
        createRelatedAccountHandler.createAccount(trigger.new);


	}
}

public class createRelatedAccountHandler{
	public static void createAccount(List<contact> conList){

		For(contact con : conList){
			if(con.accountId == Null){
				Account acc  = new Account();
				acc.name  = con.LastName + con.firstName;
				acc.phone = con.phone;
			}
		}
		
	}
}