#include<bits/stdc++.h>
using namespace std;
string s[100005];
map<string,int>mp;
int main(){
	int n;
	scanf("%d",&n);
	for(int i=1;i<=n;i++) cin>>s[i],mp[s[i]]++;
	printf("AC x %d\n",mp["AC"]);
	printf("WA x %d\n",mp["WA"]);
	printf("TLE x %d\n",mp["TLE"]);
	printf("RE x %d\n",mp["RE"]);
	return 0;
}