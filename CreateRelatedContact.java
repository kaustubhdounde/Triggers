
//Create related contact when contact is created
trigger createRelatedContact on Account (After insert) {
    
    if(trigger.isAfter && trigger.isInsert){
        List <Contact> conList = new list <contact>();
        for(Account acc :trigger.new){
            contact con = new contact ();
            con.firstName = acc.Name + 'FN';
            con.LastName = acc.name + 'LN';
            con.AccountId = acc.id;
            con.phone = acc.Phone;
            conList.add(con);
        }
        if(!conList.isEmpty()){
            insert conList;
        }
        
    }

}

trigger on account createRelatedContact(after insert){
    if(trigger.isAfter && trigger.isUpdate){
        List<contact. conList = new List <Contact>();
        for(Account acc : trigger.new){
            contact con = new contact();
            con.LastName = acc. name + 'LN';
            con.firstName = acc.name + 'FN';
            con.email = acc.email;
            con.phone = acc.phone;
            con.AccountId = acc.Id;
            conList.add(con);

        }
        if(!conList.isEmpty())
        insert conList;
    }
}