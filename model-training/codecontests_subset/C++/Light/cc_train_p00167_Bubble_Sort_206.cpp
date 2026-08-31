#include<iostream>
#include<cstdio>
#include<cstring>
#include<vector>
#include<algorithm>
#include<utility>
#include<cmath>
using namespace std;
#define all(a) a.begin(),a.end()
int main()
{
	int n;
	while(cin>>n&&n)
	{
		vector<int> a;
		for(int i=0;i<n;i++)
		{
			int x;cin>>x;
			a.push_back(x);
		}
		int ans=0;
		bool ok=true;
		while(ok)
		{
			ok=false;
			for(int i=0;i<n-1;i++)
			{
				if(a[i]>a[i+1])
				{
					ans++;ok=true;
					swap(a[i],a[i+1]);
				}
			}
		}
		cout<<ans<<endl;
		
		
		
	}
	
}