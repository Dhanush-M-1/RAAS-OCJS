#include<bits/stdc++.h>
using namespace std;
typedef long long int LL;
LL red(LL s, LL c, LL b){
	LL ret=(s-c)/b*b;
	ret=max(ret,0ll);
	if ((s-c)%b!=0)ret+=b;
	ret=max(ret,b);
	return ret;
}
LL gcd(LL a, LL b){
	LL ret=1;
	while (ret>0){
		ret=a%b;
		a=b;
		b=ret;
	}
	return a;
}
int main(){
	int tc;
	cin>>tc;
	while (tc--){
		LL a,b,c,d;
		cin>>a>>b>>c>>d;
		if (d<b){
			printf ("No\n");
		}
		else{
			LL rep=gcd(b,d);
			LL init=a-red(a,c,b);
			LL low=c+rep;
			if (low-b<0||init<0)printf ("No\n");
			else printf ("Yes\n");
		}
	}
}