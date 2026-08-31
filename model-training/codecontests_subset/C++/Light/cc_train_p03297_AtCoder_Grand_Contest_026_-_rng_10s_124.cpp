#include <bits/stdc++.h>
using namespace std;
int n,m;
long long gcd(long long a,long long b) {
	if(a%b==0)
		return b;
	return gcd(b,a%b);
}
int main() {
	int i,j,k,ans=0;
	cin>>n;
	for(i=0; i<n; i++) {
		long long a,b,c,d;
		scanf("%lld%lld%lld%lld",&a,&b,&c,&d);
		if(d<b || a<b) {
			printf("No\n");
			continue;
		}
		if(c+1>=b) {
			printf("Yes\n");
			continue;
		}
		long long g=gcd(b,d);
		if((a-c-1ll)/g-(a-b)/g<=0)
			printf("Yes\n");
		else
			printf("No\n");
	}
	return 0;
}