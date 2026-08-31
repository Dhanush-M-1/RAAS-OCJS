#include <bits/stdc++.h>
using namespace std;
bool z[100011];
int ans[100011];
int n,m;
int main()
{
	cin >>n>>m;
	for(int i=0;i<m;i++)
	{
		int a;
		cin >>a;
		z[a]=true;
	}
	ans[0]=1;
	ans[1]=(int)(!z[1])*1;
	for(int i=2;i<=n;i++)
	if(!z[i])
	ans[i]=(ans[i-1]+ans[i-2])%1000000007;
	cout <<ans[n]<<endl;
	return 0;
}