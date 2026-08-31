#include<stdio.h>
#include<stdlib.h>
#include<string>
#include<sstream>
#include<algorithm>
using namespace std;
int Solve(int n)
{
	if(n<10)
		return 0;
	stringstream ss;
	ss<<n;
	string s=ss.str();
	int t=0;
	for(int i=1;i<s.size();++i)
		t=max(t,atoi(s.substr(0,i).c_str())*atoi(s.substr(i).c_str()));
	return 1+Solve(t);
}

int main()
{
	int q,n;
	for(scanf("%d",&q);q--;)
	{
		scanf("%d",&n);
		printf("%d\n",Solve(n));
	}
	return 0;
}