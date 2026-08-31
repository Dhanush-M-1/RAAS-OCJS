#include<bits/stdc++.h>
using namespace std;
long long l[200003],n,d,dpl[200003],dpr[200003],ans;
int main(){
	cin>>n>>d;
	ans+=(n-1)*d;
	for(int i=0;i<n;i++)
		cin>>l[i],
		ans+=l[i];
	dpr[0]=l[0];dpl[n-1]=l[n-1];
	for(int i=1;i<n;i++)
		dpr[i]=min(l[i],dpr[i-1]+d);
	for(int i=n-2;i>=0;i--)
		dpl[i]=min(l[i],dpl[i+1]+d);
	for(int i=1;i<n-1;i++)
		ans+=min(dpl[i],dpr[i]);
	cout<<ans;
}
