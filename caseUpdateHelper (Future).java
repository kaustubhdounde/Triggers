/*
 Scenario 3: Mass Update on Case Records
Objective: Write a future method to update the status of Case records that are older than 30 days to "Escalated."
*/
public class caseUpdateHelper {
    
    @future 
    public static void caseUpdate(){
        List <Case> caseList = [select id, status from case];
        
        for(case c : caseList){
            if(c.CreatedDate < date.today().addDays(-30) && c.status != 'Esclated'){
                
                c.Status = 'Escalated';
                caseList.add(c);
                
                
            }
        }
        
        if(!caseList.isEmpty()){
            update caseList;
        }
    }

}