#include<cstdio>
long long gcd(long long a,long long b){return b?gcd(b,a%b):a;}
bool chk(long long A,long long B,long long C,long long D){
	if(B>A||D<B)return 0;
	long long g=gcd(B,D),t=A+B-C-1;
	if(t<0&&t%g!=0)t=t/g-1;
	else t/=g;
	return A-g*t>=0;
}
int main(){
	int T;scanf("%d",&T);
	while(T--){
		long long A,B,C,D;
		scanf("%lld%lld%lld%lld",&A,&B,&C,&D);
		puts(chk(A,B,C,D)?"Yes":"No"); 
	}
}