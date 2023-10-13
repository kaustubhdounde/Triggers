trigger preventDeletionofAssociatedContacts on Account (before delete) {
    
    if((trigger.isBefore) && (trigger.isDelete)){
        // create a list of contact with ID and AccountId and check whether accountID is in old records of contacts
        list <contact> conList = [select ID, AccountID from contact where AccountId IN : Trigger.oldMap.keySet()];
        if(!conList.isEmpty()){
            for(contact con : conList){
                con.AccountId = Null;
            }
            update conList;
        }
    }

}


/*
This Apex code defines a trigger named `preventDeletionofAssociatedContacts` that operates on the `Account` object. The trigger is set to run before an Account is deleted (`before delete`).

Here's a detailed breakdown of what this code does:

1. **Trigger Definition**: The code defines a trigger named `preventDeletionofAssociatedContacts` that is triggered before an Account record is deleted (`before delete`) on the `Account` object.

2. **Trigger Context**: The trigger uses the following context variables:
   - `trigger.isBefore`: This variable is `true` because the trigger is specified as a "before delete" trigger. It indicates that the code should execute before the deletion occurs.
   - `trigger.isDelete`: This variable is also `true` because the trigger is set to run before an Account deletion.

3. **Querying Associated Contacts**: Inside the trigger, it performs a query to retrieve a list of Contact records associated with the Account that is about to be deleted. This is done using a SOQL (Salesforce Object Query Language) query. The query retrieves the `ID` and `AccountId` fields of Contact records where the `AccountId` matches any of the `Account` records in `Trigger.oldMap.keySet()`. `Trigger.oldMap` contains the old values of the records being deleted.

   ```apex
   list <contact> conList = [select ID, AccountID from contact where AccountId IN : Trigger.oldMap.keySet()];
   ```

   - This query retrieves a list of Contact records (`conList`) that are associated with the Account records about to be deleted.

4. **Checking If Contacts Exist**: The code then checks if the `conList` is not empty. If there are associated Contact records found, it means there are Contacts linked to the Account that is being deleted.

   ```apex
   if(!conList.isEmpty()){
   ```

5. **Nullifying Account IDs**: Inside the `if` block, the code iterates through each Contact in `conList` and sets their `AccountId` to `null`. This essentially dissociates these Contacts from the Account they were linked to.

   ```apex
   for(contact con : conList){
       con.AccountId = Null;
   }
   ```

6. **Updating Contacts**: After nullifying the `AccountId` for the associated Contacts, the code then updates these Contact records to save the changes to the database.

   ```apex
   update conList;
   ```

   - This `update` statement commits the changes to the Contact records in the database, effectively removing their association with the Account that's being deleted.

In summary, this trigger ensures that when an Account is deleted, any associated Contact records are first disassociated from that Account by setting their `AccountId` field to `null`. This prevents the Contacts from being deleted along with the Account and ensures that they remain in the system but are no longer linked to the deleted Account.

*/