#pragma GCC optimize("Ofast")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,avx2,fma")
#pragma GCC optimize("unroll-loops")
#include <bits/stdc++.h> 
#include <complex>
#include <queue>
#include <set>
#include <unordered_set>
#include <list>
#include <chrono>
#include <random>
#include <iostream>
#include <algorithm>
#include <cmath>
#include <string>
#include <vector>
#include <map>
#include <unordered_map>
#include <stack>
#include <iomanip>
#include <fstream>
 
using namespace std;
 
typedef long long ll;
typedef long double ld;
typedef pair<int,int> p32;
typedef pair<ll,ll> p64;
typedef pair<double,double> pdd;
typedef vector<ll> v64;
typedef vector<int> v32;
typedef vector<vector<int> > vv32;
typedef vector<vector<ll> > vv64;
typedef vector<vector<p64> > vvp64;
typedef vector<p64> vp64;
typedef vector<p32> vp32;
ll MOD = 998244353;
double eps = 1e-12;
#define forn(i,e) for(ll i = 0; i < e; i++)
#define forsn(i,s,e) for(ll i = s; i < e; i++)
#define rforn(i,s) for(ll i = s; i >= 0; i--)
#define rforsn(i,s,e) for(ll i = s; i >= e; i--)
#define ln "\n"
#define dbg(x) cout<<#x<<" = "<<x<<ln
#define mp make_pair
#define pb push_back
#define fi first
#define se second
#define INF 2e18
#define fast_cin() ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL)
#define all(x) (x).begin(), (x).end()
#define sz(x) ((ll)(x).size())
 v64 x(200020);

 ll hcf(ll p,ll q) {
     if(p>q)return hcf(q,p);
     if(!p)return q;
     return hcf(q%p,p);
 }

 ll lcm( ll p,ll q){
     return p*q/hcf(p,q);
 }

 ll power(ll a, ll n, ll mod){
     ll ans = 1;
     while(n){
         if(n%2)ans*=a;
         a*=a;
         n/=2;
         a%=mod;
         a%=mod;
     }
     return ans;
 }

ll fac(ll k,ll mod){
    ll ans=1;
    forsn(i,1,k+1){
        ans*=i;
        ans%=mod;
    }
    return ans;
}
void solve(){
    ll n;
    cin>>n;
    v64 tag(n),score(n);
    forn(i,n)cin>>tag[i];
    forn(i,n)cin>>score[i];
    v64 ans(n);
    forn(i,n)ans[i]=0;
    forsn(i,1,n){
        rforn(j,i-1){
            if(tag[i]==tag[j])continue;
            ll v=abs(score[i]-score[j]);
            ll v1=ans[i],v2=ans[j];
            ans[i]=max(v1,v2+v);
            ans[j]=max(v2,v1+v);
        }
    }
    ll x=0;
    forn(i,n)x=max(x,ans[i]);
    cout<<x<<ln;
    return ;
}
int main()
{
#ifndef ONLINE_JUDGE
freopen("input.txt", "r", stdin);
freopen("output.txt", "w", stdout);
#endif

 fast_cin();
  ll t;
 cin>>t;
 while(t--) {
     solve();
 }//     */ solve();
 return 0;
}
