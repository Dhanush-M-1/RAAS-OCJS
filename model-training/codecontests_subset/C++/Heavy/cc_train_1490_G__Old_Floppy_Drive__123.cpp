#include <bits/stdc++.h>
using namespace std;
///////////////////////////////////*****************//////////////////////////////////////
typedef long long ll;
ll z=1000000007;
ll fact[400005];
void buildfact()
{
    fact[0]=1;
    for(ll i=1;i<400005;i++)
    {
        fact[i]=(fact[i-1]*i)%z;
    }
}
ll power(ll a,ll p)
{
    if(p==0)
        return 1;
    if(p%2==0)
        return power((a*a)%z,p/2);
    return (a*power(a,p-1))%z;
}
ll ncr(ll n,ll r)
{
    if(n<r)
        return 0;
    ll num=fact[n];
    ll deno=(fact[r]*fact[n-r])%z;
    deno=power(deno,z-2);
    ll ans=(num*deno)%z;
    return ans;
}
//////////////////////////////////////****************//////////////////////////////////////

void solve(int oper)
{
 ll n,m;
 cin>>n>>m;
 ll sum=0;
 ll arr[n],queries[m];
 for(int i=0;i<n;i++)
    {
        cin>>arr[i];
        sum+=arr[i];
        if(i>0)
            arr[i]+=arr[i-1];
    }
 for(int i=0;i<m;i++)
    cin>>queries[i];
 vector <ll> helper;
 vector <ll> ans(m,0);
 helper.push_back(arr[0]);
 map <int,int> index;
 index[0]=0;
 for(int i=1;i<n;i++)
 {
     if(helper[helper.size()-1]<arr[i])
        {
            helper.push_back(arr[i]);
            index[helper.size()-1]=i;
        }
 }
 for(int i=0;i<m;i++)
 {
     ll x=queries[i];
     ll sol=0;
     ll lastval=helper[helper.size()-1];
     if(x>lastval&&sum<=0)
      ans[i]=-1;
     else
     {
        if(x<=lastval)
        {
            int in=lower_bound(helper.begin(),helper.end(),x)-helper.begin();
            ans[i]=index[in];
        }
        else{
            ll times=ceil(float(x-lastval)/sum);
            x-=(times*sum);
            int in=lower_bound(helper.begin(),helper.end(),x)-helper.begin();
            ans[i]=index[in]+times*n;
        }
     }
 }
 for(int i=0;i<m;i++)
    cout<<ans[i]<<" ";
 cout<<endl;
return;
}
int main()
{
    ll t;
    t=1;
    cin>>t;
   //buildfact();
    int i=1;
    while(i<=t)
    {
        solve(i);
        i++;
    }
    return 0;
}
