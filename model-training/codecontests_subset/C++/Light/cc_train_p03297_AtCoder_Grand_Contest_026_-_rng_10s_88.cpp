#include <bits/stdc++.h>

using namespace std;

inline long long gcd(long long a,long long b){
	for(long long r;b;) r=a%b,a=b,b=r;
	return a;
}

inline bool jud(long long A,long long B,long long C,long long D){
	if(A<B || D<B) return false;
	if(C>=B) return true;
	long long g=gcd(B,D);
	return B-g+A%g<=C;
}

int main(){
	int T;
	scanf("%d",&T);
	while(T--){
		long long A,B,C,D;
		scanf("%lld%lld%lld%lld",&A,&B,&C,&D);
		puts(jud(A,B,C,D) ? "Yes":"No");
	}
	return 0;
}