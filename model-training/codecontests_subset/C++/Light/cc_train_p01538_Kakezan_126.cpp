#include<iostream>
#include<algorithm>
#include<set>
using namespace std;
int main()
{
	int q; cin>>q;
	while(q--) 
	{
		int n; cin>>n;
		//set<int> used;
		bool used[1000001];
		fill(used,used+1000001,0);
		int ans=0;
		//while(used.find(n)==used.end()&&9<n)
		while(!used[n]&&9<n)
		{
			int next=0,r=0;
			//used.insert(n);
			used[n]=true;
			int mul=1;
			while(1)
			{
				r+=n%10*mul;
				n/=10;
				mul*=10;
				if(n==0) break;
				next=max(next,r*n);
			}
			n=next;
			ans++;
		}
		if(n<=9) cout<<ans<<endl;
		else cout<<-1<<endl;
	}
  return 0;
}