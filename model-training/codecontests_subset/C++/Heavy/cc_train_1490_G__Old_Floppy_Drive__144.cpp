#include<bits/stdc++.h>
#define IOS ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);cout<<setprecision(25);
#define pb push_back
typedef long long int ll;
ll M=1000000007;
using namespace std;
int main()
{
   IOS;
   ll T;
   cin>>T;
   while(T--)
   {
   	ll n,m,i,sum=0;
   	cin>>n>>m;
   	ll a[n],mx[n],pref[n];
   	for(i=0;i<n;i++)
   	{
   		cin>>a[i];
   		sum+=a[i];
	}
	pref[0]=a[0];
	mx[0]=a[0];
	for(i=1;i<n;i++){
	pref[i]=pref[i-1]+a[i];
	mx[i]=max(mx[i-1],pref[i]);
    }
   	for(i=0;i<m;i++)
   	{
   		ll q,ans=0;
   		cin>>q;
   		if(q>mx[n-1]){
            if(pref[n-1]<=0){
                cout<<-1<<" ";
                continue;
            }
            else{
                ans=(q-mx[n-1]+pref[n-1]-1)/pref[n-1];
                q-=ans*pref[n-1];
            }
        }
        ll idx=lower_bound(mx,mx+n,q)-mx;
        cout<<(ans*n)+idx<<" ";
	}
	cout<<endl;
   }
}
