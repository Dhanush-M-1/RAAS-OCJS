#include<iostream>
#include<bits/stdc++.h>
using namespace std;
//#pragma comment(linker, "/STACK:2000000000")
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
#pragma GCC optimization ("unroll-loops")
#define ll long long int
#define pb push_back
#define mod 998244353
#define endl "\n"
#define inarr(arr,n); for(int i=0;i<n;i++) cin >> arr[i];
#define outarr(arr,n); for(int i=0;i<n;i++) cout<<arr[i]<<' ';
#define ve vector
#define fi first
#define se second
#define pa pair
#define fastio ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
#define ld long double
#define __ freopen("input.txt","r",stdin);freopen("output.txt","w",stdout);
#define all(c) c.begin(),c.end()
#define pii pair<int, int>
#define pll pair<ll,ll>
#define fr(i, a, b); for (int i = a; i < b; i++)
#define frn(i, a, b); for (int i = a; i > b; i--)
#define mk make_pair
#define setvector(vname,value,size); for(int i=0;i<size;i++)vname[i]=value;
#define sz(a) (int)((a).size())
#define deci fixed<<setprecision(9)
const ll inf = 9e18;
const ld pi = 2*acos(0.0);
const int N=1000005;
ll tes,n;
vector <ll> sieve(N,0);
void si()
{
    sieve[1]=1;
    for(int i=2;i<N;i++){
        if(sieve[i]==0){
            for(int j=i;j<N;j+=i){
                sieve[j]=i;
            }
        }
    }
}
ll power(ll x,ll y)
{
   ll res=1ll;
   while(y>0)
   {
       if(y&1) res=res*x;
       res%=mod;
       y>>=1;
       x=x*x;
       x%=mod;
   }
   return res;
}
void solve()
{
    ll  k, m, poi1 = 0, poi2 = 0;
    cin>>k>>n>>m;
    vector<ll> arr(n), brr(m), crr;
    fr(i, 0, n )cin>>arr[i];
    fr(i, 0, m)cin>>brr[i];
    while (poi1 < n || poi2 < m)
    {
        fr(i, poi1, n)
        {
            if(arr[i] == 0)k++, crr.push_back(0), poi1 = i + 1;
            else break;
        }
        fr(i, poi2, m)
        {
            if(brr[i] == 0)k++, crr.push_back(0), poi2 = i + 1;
            else break;
        }
        if(poi1 < n && poi2 < m && k < arr[poi1] && k < brr[poi2])
        {
            cout<<-1<<endl;
            return;
        }
        if(poi1 < n)
        {
            if(k >= arr[poi1])
            {
                crr.push_back(arr[poi1]);
                poi1++;
            }
            else if(k < arr[poi1] && poi2 == m)
            {
                cout<<-1<<endl;
                return;
            }
        }
        if(poi2 < m)
        {
            if(k >= brr[poi2])
            {
                crr.push_back(brr[poi2]);
                poi2++;
            }
            else if(k < brr[poi2] && poi1 == n)
            {
                cout<<-1<<endl;
                return;
            }
        }
    }
    fr(i, 0, sz(crr))cout<<crr[i]<<" ";
    cout<<endl;
}
int32_t main(void)
{
    fastio;
    cin>>tes;
    while(tes--)
    {
        solve();
    }
}