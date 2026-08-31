#include<bits/stdc++.h>
using namespace std;

int main() {
	long n;
	cin>>n;
	string s;
	long a=0,t=0,w=0,r=0;
	for(long i=1;i<=n;++i) {
		cin>>s;
		if(s[0]=='A') ++a;
		else if(s[0]=='W') ++w;
		else if(s[0]=='T') ++t;
		else if(s[0]=='R') ++r;
	}
	printf("AC x %ld\nWA x %ld\nTLE x %ld\nRE x %ld",
	a,w,t,r);
	return 0;
}