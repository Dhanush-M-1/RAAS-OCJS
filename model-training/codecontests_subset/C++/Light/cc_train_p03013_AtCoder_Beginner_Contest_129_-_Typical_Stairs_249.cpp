#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;

int M=1000000007;
int a[100003];
int main()
{
	int n,m;
	cin>>n>>m; a[0]=1;
	for (int i=1; i<=m; i++)
	{
	    int x;
		cin>>x; a[x]=-1;
	}
	if (a[1]==0) a[1]=1;
	for (int i=2; i<=n; i++)
	{
		if (a[i]==-1) continue;
		int res=0;
		if (a[i-1]!=-1) res+=a[i-1];
		if (a[i-2]!=-1) res+=a[i-2];
		a[i]=res%M;
	}

	cout << a[n];
}