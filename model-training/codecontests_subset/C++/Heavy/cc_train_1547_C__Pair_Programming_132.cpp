#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
#pragma GCC optimization ("unroll-loops")

#include <bits/stdc++.h>
using namespace std;

void __print(int x) {cerr << x;}
void __print(long x) {cerr << x;}
void __print(long long x) {cerr << x;}
void __print(unsigned x) {cerr << x;}
void __print(unsigned long x) {cerr << x;}
void __print(unsigned long long x) {cerr << x;}
void __print(float x) {cerr << x;}
void __print(double x) {cerr << x;}
void __print(long double x) {cerr << x;}
void __print(char x) {cerr << '"' << x << '"';}
void __print(const char *x) {cerr << '"' << x << '"';}
void __print(const string &x) {cerr << '"' << x << '"';}
void __print(bool x) {cerr << (x ? "true" : "false");}

template<typename T, typename V>
void __print(const pair<T, V> &x) {cerr << '{'; __print(x.first); cerr << ','; __print(x.second); cerr << '}';}
template<typename T>
void __print(const T &x) {int f = 0; cerr << '{'; for (auto &i: x) cerr << (f++ ? "," : ""), __print(i); cerr << "}";}
void _print() {cerr << "]" << endl;}
template <typename T, typename... V>
void _print(T t, V... v) {__print(t); if (sizeof...(v)) cerr << ", "; _print(v...);}
#ifndef ONLINE_JUDGE
#define deb(x...) cerr << "[" << #x << "] = ["; _print(x)
#else
#define deb(x...)
#endif

typedef long long int ll;
typedef pair<int,int> pi;
typedef pair<ll,ll> pll;
typedef vector<int> vi;
typedef vector<ll> vll;
typedef vector<pi> vpi;
typedef vector<pll> vpll;

#define  ff                 first
#define  ss                 second
#define  pb                 push_back
#define  MESSI              ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
#define  all(x)             (x).begin(), (x).end()
#define  rep(i,a,b)         for(ll i=a ; i<b ; ++i)
#define  VectorInput(v,n)   for(ll i=0;i<n;i++)cin>>v[i];
#define  VectorPrint(v)     for(ll i=0;i<v.size();i++)cout<<v[i]<<" ";
#define  line               "\n"
#define  YES                "YES"
#define  NO                 "NO"
#define  Variable(x)        ll x;cin>>x;      

const ll MOD = 1e9 + 7;
const ll maxn = 1e6 + 4;
const ll INF = 1e18;

void answer()
{
    ll k,n,m;cin>>k>>n>>m;
    vll one(n);VectorInput(one,n);
    vll two(m);VectorInput(two,m);
    vll ans;
    bool fuckedup=false;
    ll oi=0,ti=0;
    ll c=0;
    ll curr=k;
    while(c<n+m)
    {
        ll newo=(oi<n?one[oi]:-1);
        ll newt=(ti<m?two[ti]:-1);

        if(newo>curr && newt>curr)
        {
            fuckedup=true;
            break;
        }
        if(newo==-1 && newt==-1)break;
        
        if(newo==-1)
        {
            if(newt==0)
            {
                ti++;c++;curr++;
                ans.pb(0);
            }
            else
            {
                if(newt>curr)
                {
                    fuckedup=true;
                    break;
                }
                else
                {
                    ti++;c++;
                    ans.pb(newt);
                }
            }
            continue;
        }

        if(newt==-1)
        {
            if(newo==0)
            {
                oi++;c++;curr++;
                ans.pb(0);
            }
            else
            {
                if(newo>curr)
                {
                    fuckedup=true;
                    break;
                }
                else
                {
                    oi++;c++;
                    ans.pb(newo);
                }
            }
            continue;
        }

        if(newo==0)
        {
            oi++;c++;curr++;
            ans.pb(0);
        }
        if(newt==0)
        {
            ti++;c++;curr++;
            ans.pb(0);
        }
        if(newo<=curr && newo!=0 && newo!=-1)
        {
            oi++;c++;
            ans.pb(newo);
        }
        if(newt<=curr && newt!=0 && newo!=-1)
        {
            ti++;c++;
            ans.pb(newt);
        }
    }
    if(fuckedup==true || ans.size()!=n+m){cout<<-1<<line;return;}
    VectorPrint(ans);cout<<line;
}

int main()
{
    MESSI
    int t;cin>>t;
    while(t--)answer();
    return 0;
}