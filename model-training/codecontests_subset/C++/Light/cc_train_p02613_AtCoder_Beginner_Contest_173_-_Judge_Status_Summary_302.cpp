#include<bits/stdc++.h>
using namespace std;
int main(){
	string s;
	int n,a=0,b=0,c=0,d=0;
	cin>>n;
	while(n--){
		cin>>s;
		if(s=="AC")a++;
		else if(s=="WA")b++;
		else if(s=="RE")c++;
		else d++;
	}
	printf("AC x %d\nWA x %d\nTLE x %d\nRE x %d",a,b,d,c);
}