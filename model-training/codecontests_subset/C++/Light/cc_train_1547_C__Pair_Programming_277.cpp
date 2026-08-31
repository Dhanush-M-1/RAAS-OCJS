#include<bits/stdc++.h>
using namespace std;

void solve()
{
	int n,k,m;
	cin>>k>>n>>m;
	int a1[n],a2[m];
	for(int i=0;i<n;i++) cin>>a1[i];
	for(int i=0;i<m;i++) cin>>a2[i];
	int curr = k;
	int s1 =0, s2=0;
	vector<int> ans;
	while(1)
	{
		if(s1==n && s2==m) break;
		if(a1[s1]<=curr && s1<n)
		{
			if(a1[s1]==0) curr++;
			ans.push_back(a1[s1]);
			s1++;
		}
		else if(a2[s2]<=curr && s2<m)
		{
			if(a2[s2]==0) curr++;
			ans.push_back(a2[s2]);
			s2++;
		}
		else
		{
			cout<<"-1\n";
			return;
		}
	}
	for(int x: ans) cout<<x<<" ";
	cout<<endl;
}

int main()
{
	int t;
	cin>>t;
	while(t--) solve();
}