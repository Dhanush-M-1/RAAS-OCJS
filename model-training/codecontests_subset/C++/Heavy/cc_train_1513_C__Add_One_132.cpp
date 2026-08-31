#include <bits/stdc++.h>
#define FAST ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
#define ll long long int
#define fab(i,a,b) for(i=a;i<=b;i++)
#define fabr(i,a,b) for(i=b;i>=a;i--)
#define f(i,n) for(i=0;i<n;i++)
#define sc second
#define fr first
#define pb push_back
#define mp make_pair
#define mod 1000000007
#define max 1000000000000000000
#define nl "\n"
using namespace std;
ll dp[200001];
void fun()
{
    ll i;
    f(i,200001)
    {
        if(i<=8)
        dp[i]=2;
        else if(i==9)
        dp[i]=3;
        else
        dp[i]=(dp[i-9]+dp[i-10])%mod;
    }
}
int main()
{
    FAST;
    ll t,i,m,z,u,ans,b,c,l,q,p,j,sum,d,n,a,x,y,k,w,h,r;
    t=1;
    char ch;
    string s,aa,bb,dd,rr,tt,ss="";
    fun();
    cin>>t;
    while(t--)
    {
       ans=0;
       cin>>n>>m;
       //cout<<dp[92]<<nl;
       while(n>0)
       {
           k=n%10;
           if(k+m<10)
           ans+=1;
           else
           ans+=dp[k+m-10];
           ans%=mod;
           n=n/10;
       }
       cout<<ans<<nl;
    }  
	return 0;
}
