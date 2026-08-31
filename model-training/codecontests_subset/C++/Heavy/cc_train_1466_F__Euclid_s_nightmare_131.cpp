#include<bits/stdc++.h>
using namespace std;
#ifndef ONLINE_JUDGE
#define dbg(x...) do { cout << "\033[32;1m " << #x << " -> "; err(x); } while (0)
void err() { cout << "\033[39;0m" << endl; }
template<template<typename...> class T, typename t, typename... A>
void err(T<t> a, A... x) { for (auto v: a) cout << v << ' '; err(x...); }
template<typename T, typename... A>
void err(T a, A... x) { cout << a << ' '; err(x...); }
#else
#define dbg(...)
#endif
typedef long long ll;
typedef pair<int,int> pi;
typedef vector<int> vi;
template<class T> using vc=vector<T>;
template<class T> using vvc=vc<vc<T>>;
template<class T> void mkuni(vector<T>&v)
{
    sort(v.begin(),v.end());
    v.erase(unique(v.begin(),v.end()),v.end());
}
ll rand_int(ll l, ll r) //[l, r]
{
    static mt19937_64 gen(chrono::steady_clock::now().time_since_epoch().count());
    return uniform_int_distribution<ll>(l, r)(gen);
}
template<class T>
void print(T x,int suc=1)
{
    cout<<x;
    if(suc==1) cout<<'\n';
    else cout<<' ';
}
template<class T>
void print(const vector<T>&v,int suc=1)
{
    for(int i=0;i<v.size();i++)
    print(v[i],i==(int)(v.size())-1?suc:2);
}
const int maxn = 5e5 + 5;
const int mod = 1e9 + 7;
int n, m, fa[maxn], x, y, t, vis[maxn];
pair<int, int> p[maxn];
vector<int> ans;
int fnd(int x)
{
    if (fa[x] == x) return x;
    return fa[x] = fnd(fa[x]);
}

void init()
{
    for (int i = 0; i <= m; i++)
        fa[i] = i;
}
ll qpow(ll a, ll b)
{
    ll ans = 1;
    while (b) {
        if (b & 1) ans = ans * a % mod;
        a = a * a % mod;
        b >>= 1;
    }
    return ans;
}
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    init();
    int cnt = 0;
    for (int i = 0; i < n; i++) {
        cin >> t;
        if (t == 2) {
            cin >> x >> y;
            int fx = fnd(x), fy = fnd(y);
            if (fx == fy) continue;
            if (vis[fx] && vis[fy]) 
                fa[fx] = fy;
            else
                fa[fx] = fy, vis[fy] |= vis[fx] , ans.push_back(i+1);
        }
        else {
            cin >> x;
            if (!vis[fnd(x)]) vis[fnd(x)] = 1, ans.push_back(i+1);
        }
        //cout << ans.size() << '\n';
    }
    cout << qpow(2, ans.size()) << ' ' << ans.size() <<'\n';
    for (auto &x : ans)
        cout << x << ' ';
    cout << '\n';
}