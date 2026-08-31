#include<bits/stdc++.h>
#define ll long long
#define ull unsigned long long
#define MOD 1000000007
#define MODA 998244353
#define pb push_back
#define mp make_pair
#define sortv(v) sort(v.begin(),v.end())
#define sorta(A,N) sort(A,A+N)
#define rep(i,a,N) for(ll i=a;i<N;i++)
#define test(T) ll T; cin>>T; while(T--)
#define f first
#define s second
#define uniq(v) {sort(v.begin(), v.end()); v.erase(unique(v.begin(), v.end()), v.end());}
#define speed ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
using namespace std;
ll gcd(ll a,ll b){
    if(!a)
        return b;
    else
        return gcd(b%a,a);
}
ll power(ll a,ll b,ll mod=MOD){
    a%=mod;
    ll res=1;
    while(b){
        if(b&1)
            res=res*a%mod;
        a=a*a%mod;
        b>>=1;
    }
    return res;
}
/*const ll N=1e6+1;
vector<ll>prime(N);
void sieve(){
    rep(i,0,N) prime[i]=i;
    for(ll i=4;i<N;i+=2)
        prime[i]=2;
    for(ll i=3;i*i<N;i+=2){
        if(prime[i]==i)
            for(ll j=i*i;j<N;j+=i)
                if(prime[j]==j)
                    prime[j]=i;
    }
}
vector<ll> factor(ll N){
    vector<ll> fac;
    while(N!=1){
        fac.pb(prime[N]);
        N/=prime[N];
    }

    return fac;
}*/

void solve(){
    //freopen("output.txt", "r", stdin);
    //freopen("output.txt", "w", stdout);
   ll k,n,m;
   cin>>k>>n>>m;
   ll a[n],b[m],ans[n+m];
   rep(i,0,n) cin>>a[i];
   rep(i,0,m) cin>>b[i];
   ll p1=0,p2=0,p3=0;
   while(p3<n+m){
        ll done=0;
        if(!a[p1] && p1<n) ans[p3++]=a[p1++],k++,done=1;
        else if(!b[p2] && p2<m)ans[p3++]=b[p2++],k++,done=1;
        else if(a[p1] && k>=a[p1] && p1<n)ans[p3++]=a[p1++],done=1;
        else if(b[p2] && k>=b[p2] && p2<m) ans[p3++]=b[p2++],done=1;
        if(!done){cout<<-1<<"\n";return;}
   }
   rep(i,0,n+m)cout<<ans[i]<<' ';
   cout<<"\n";

}
int main(){
    speed;
    test(T){
        solve();
    }
}
