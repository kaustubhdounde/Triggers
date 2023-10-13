public Boolean isPrime(Integer num) {
    //code here
    if (num <= 1){
        return false;
    } 
    for ( integer i = 2; i <= math.sqrt(num); i++){
        if (math.mod(num,i) == 0){
            return false;

        }
    }
    return true;


}]
num - 16; sqrt = 4 ;
