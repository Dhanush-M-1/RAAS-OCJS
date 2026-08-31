#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef pair<int, int> pii;
#define FOR(i, n) for(int (i)=0; (i)<(n); (i)++)
#define FOR1(i, n) for(int (i)=1; (i)<=(n); (i)++)
#define FORI(i, n) for(int (i)=n-1; (i)>=0; (i)--)
template<class T, class U> void umin(T& x, const U& y){ x = min(x, (T)y);}
template<class T, class U> void umax(T& x, const U& y){ x = max(x, (T)y);}
template<class T, class U> void init(vector<T> &v, U x, size_t n) { v=vector<T>(n, (T)x); }
template<class T, class U, typename... W> void init(vector<T> &v, U x, size_t n, W... m) { v=vector<T>(n);  for(auto& a : v) init(a, x, m...); }
const ll MOD = 1e9+7;
template<class T> T powmod(T x, ll n, ll m)
{
    T r = 1;
    T a = x % m;
    while (n>0)
    {
        if (n & 1)
            r = (r*a)%m;
        a = (a*a)%m;
        n = n >> 1;
    }
    return r;
}
int get(int x, vector<int>& mp){
    if (x == mp[x])
        return x;
    return mp[x] = get(mp[x], mp);
}

int main(int argc, char** argv) {
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0); cout << setprecision(15);
    if (argc == 2 && atoi(argv[1]) == 123456789) freopen("d:\\code\\cpp\\contests\\stdin", "r", stdin);
    int n, m;
    cin >> n >> m;
//    n = m = 1e5;
//    vector<list<int>> L(m+1);
    set<pii> S;
    vector<pii> v(n+1);
    vector<bool> skip(n+1);
    FOR1(i, n){
        int k;
#if 0
        if (i < n) {
            v[i].first = i;
            v[i].second = i + 1;
        }
        else{
            v[i].first = 1;
            v[i].second = i;
        }

#else
        cin >> k;
        if(k==1) {
            cin >> v[i].first;
            v[i].second = m+1;
        }
        else
            cin >> v[i].first >> v[i].second;
        if (v[i].first > v[i].second)
            swap(v[i].first, v[i].second);
#endif
        if (!S.count(v[i])){
            S.insert(v[i]);
//            L[v[i].first].push_back(i);
//            if (v[i].second != m+1)
//                L[v[i].second].push_back(i);
        }
        else
            skip[i] = 1;
    }
    vector<int> sol;
    vector<int> mp(m+2);
    vector<bool> done(m+2); done[m+1] = 1;

    iota(mp.begin(), mp.end(), 0);
    S.clear();
    FOR1(i, n){
        if (skip[i]) continue;
        int x = get(v[i].first, mp);
        int y = get(v[i].second, mp);
        if (x == y) continue;
        if (S.count({x, y})) continue;
        if (done[x] && done[y]) continue;
        if (x > y) swap(x, y);
        if (!done[x] && !done[y]){
            mp[x] = y;
            done[x] = 1;
        }
        else if (!done[x] && done[y]){
            done[x] = 1;
        }
        else{
            done[y] = 1;
        }
        S.insert({x, y});
        sol.push_back(i);
    }
    cout << powmod(2ll, sol.size(), MOD) << " " << sol.size() << endl;
    for(auto it : sol) cout << it << " "; cout << endl;

    if (argc == 2 && atoi(argv[1]) == 123456789) cout << clock()*1.0/CLOCKS_PER_SEC << " sec\n";
    return 0;
}

