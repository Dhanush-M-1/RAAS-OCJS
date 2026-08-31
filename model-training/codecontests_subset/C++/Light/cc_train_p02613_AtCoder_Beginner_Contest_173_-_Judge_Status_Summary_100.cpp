#include<bits/stdc++.h>
using namespace std;
map<string,int>num;
int main()
{
	int n;
	scanf("%d",&n);
	for(int i=1;i<=n;i++)
	{
		string s;
		cin>>s;
		num[s]++;
	}
	printf("AC x %d\n",num["AC"]);
	printf("WA x %d\n",num["WA"]);
	printf("TLE x %d\n",num["TLE"]);
	printf("RE x %d\n",num["RE"]);
	return 0;
}
