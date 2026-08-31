#include <bits/stdc++.h>
#define pi 3.14159
#define MOD 1000000007
using namespace std;
int main()
{
	long long int i,n,m;
	cin>>n>>m;
	int a[m];
	for(i=0;i<m;i++)
		cin>>a[i];
	vector<int>ans(n+1,-1);
	
		
			ans[0]=1;
			ans[1]=1;
			ans[2]=2;
			for(i=0;i<m;i++)
				ans[a[i]]=0;
			for(i=2;i<=n;i++)
				{
					if(ans[i]!=0)
						ans[i]=(ans[i-1]+ans[i-2])%MOD;
				}
		
	cout<<ans[n]<<endl;	
}