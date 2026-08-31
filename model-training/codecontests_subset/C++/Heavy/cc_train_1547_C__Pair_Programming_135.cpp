#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef vector <int> ve;
#define int ll
#define pb push_back
#define f first
#define s second
#define in(a) ll a;scanf(" %lld",&a)
#define out(a) printf("%lld ",a);
#define cs(name) set <ll> name
#define cm(name) multiset <type> name
#define lpi(n) for(i=0;i<n;i++)
#define NO printf("NO")
#define YES printf("YES")
#define pow bpow
#define gcd(a,b) __gcd(a,b)
#define endl '\n'
#define ret return
#define cont continue
#define br break

void solve();
signed main(){
     
     in(t);
     while(t--) solve(),cout<<endl;   ret 0;
}

ull bpow(ull a,ull b){
    if(b==0) return 1;
    else if(b%2) return a*bpow(a,b/2)*bpow(a,b/2);
    else return bpow(a,b/2)*bpow(a,b/2);
}

void solve()
{
    ll a,b,c; cin>>a>>b>>c;
    ll i=0,j=0,ct=0,flag=1;
    ll x[b],y[c],z[b+c];
    lpi(b) cin>>x[i];
    lpi(c) cin>>y[i];
    i=0,j=0;
    while(i<b && j<c)
    {
        if(x[i]==0) a++,z[ct]=x[i],i++;
        else if(y[j]==0) a++,z[ct]=y[j],j++;
        else if(x[i]<=y[j] && a>=x[i]) z[ct]=x[i],i++;
        else if(y[j]<x[i] && a>=y[j]) z[ct]=y[j],j++;
        else 
        {
            flag=0;
            break;
        }
        ct++;
    }
    if(flag==0) {cout<<-1;return;}
    while(i<b)
    {
        if(x[i]==0) z[ct]=x[i],a++,i++,ct++;
        else if(x[i]<=a) z[ct]=x[i],i++,ct++;
        else
        {
            flag=0;
            break;
        }
       
    }
    if(flag==0) {cout<<-1;return;}
    while(j<c)
    {
        if(y[j]==0) z[ct]=y[j],a++,j++,ct++;
        else if(y[j]<=a) z[ct]=y[j],j++,ct++;
         else
        {
            flag=0;
            break;
        }
       
    }
    if(flag==0) {cout<<-1;return;}
    lpi(b+c) cout<<z[i]<<' ';

}