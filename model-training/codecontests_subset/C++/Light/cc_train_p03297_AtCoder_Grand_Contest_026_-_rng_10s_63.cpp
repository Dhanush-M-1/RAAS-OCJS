# include "cstdio"
# include "iostream"

using namespace std;

long long GCD(long long x,long long y){
	return y==0?x:GCD(y,x%y); 
} 

int main(){
	int t; 
	scanf("%d",&t);
	while(t--){
		long long a,b,c,d;
		scanf("%lld%lld%lld%lld",&a,&b,&c,&d);
		if(a<b || b>d){
			puts("No"); 
		}else if(b<=c){
			puts("Yes"); 
		}else{
			long long gcd=GCD(b,d);
			if(b-gcd+a%gcd>c){
				puts("No"); 
			}else{
				puts("Yes"); 
			} 
		} 
	} 
	return 0; 
} 