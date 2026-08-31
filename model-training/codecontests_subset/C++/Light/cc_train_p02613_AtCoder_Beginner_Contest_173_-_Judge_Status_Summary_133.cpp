#include<bits/stdc++.h>
using namespace std;
string s;
int a[4],n;
int main(){
	cin>>n;
	for(int i=0;i<n;i++){
		cin>>s;
		if(s=="AC") a[0]++;
		if(s=="WA") a[1]++;
		if(s=="TLE") a[2]++;
		if(s=="RE") a[3]++;
	}
	printf("AC x %d\nWA x %d\nTLE x %d\nRE x %d\n",a[0],a[1],a[2],a[3]);
} 