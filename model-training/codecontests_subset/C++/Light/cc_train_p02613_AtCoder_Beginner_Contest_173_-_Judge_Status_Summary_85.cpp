#include<bits/stdc++.h>
using namespace std;
int main(){
	int n,m;
	map<string,int>s;
	string str;
	scanf("%d",&n);
	while(n--){
		cin>>str;
		s[str]++;
	}
	printf("AC x %d\n",s["AC"]);
	printf("WA x %d\n",s["WA"]);
	printf("TLE x %d\n",s["TLE"]);
	printf("RE x %d\n",s["RE"]);
	return 0;
}
