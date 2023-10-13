Que - Create a trigger on Account object to assign annual revenue as below
Banking = 5000000
Finance = 4000000
Insurance = 3500000
Healthcare = 2500000
Else = 500000

__________Method No 1_____________

Trigger AnnualRevenue on Account (Before Insert , Before Update ) {
	if ((Trigger.isBefore) && (Trigger.isInsert) || (Trigger.isUpdate)){
		for (Account Acc : Trigger.New){
			if(Acc.Industry == 'Banking'){
				Acc.AnnualRevenue = 5000000;
			}
			else if (Acc.Industry == 'Finance'){
				Acc.AnnualRevenue = 4000000;
			}
			else if (Acc.Industry == 'Insurance'){
				Acc.AnnualRevenue = 3500000;
			}
			else if (Acc.Industry == 'Healthcare'){
				Acc.AnnualRevenue = 2500000;
			}
			else if (Acc.Industry == Null){
				Acc.AnnualRevenue = Null;
			}
			else{
				Acc.AnnualRevenue = 500000;
			}
		}
	}	
}


__________Method No 2_____________

Trigger
Trigger AnnualRevenue on Account (Before Insert , Before Update ) {
	if ((Trigger.isBefore) && (Trigger.isInsert) || (Trigger.isUpdate)){
		AnnualRevenueHandler.problemnumberfour(Trigger.new);
		
	}
}


Trigger Handler
Public AnnualRevenueHandler {
	public static void problemnumberfour(List <Account> Acclist){
		f(Acc.Industry == 'Banking'){
				Acc.AnnualRevenue = 5000000;
			}
			else if (Acc.Industry == 'Finance'){
				Acc.AnnualRevenue = 4000000;
			}
			else if (Acc.Industry == 'Insurance'){
				Acc.AnnualRevenue = 3500000;
			}
			else if (Acc.Industry == 'Healthcare'){
				Acc.AnnualRevenue = 2500000;
			}
			else if (Acc.Industry == Null){
				Acc.AnnualRevenue = Null;
			}
			else{
				Acc.AnnualRevenue = 500000;
			}
		
	}
}