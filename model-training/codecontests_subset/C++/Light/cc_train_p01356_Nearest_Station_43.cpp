#include <bits/stdc++.h>
using namespace std;

using ll = long long;

constexpr ll inf = 1e18;

ll mul(ll a, ll b) {
    if(a > inf / b) return inf;
    return a * b;
}

ll mypow(ll x, ll n) {
    ll res = 1;
    while(n > 0) {
        if(n & 1) {
            res = mul(res, x);
        }
        x = mul(x, x);
        n >>= 1;
    }
    return res;
}

ll solve(ll n, ll m, ll a, ll b, ll p, ll q) {
    if(a == 1 && b == 1) {
        const ll t = (p + q);
        ll sum = mul(t, n);
        if(sum <= m) return m - sum;
        return min(m % t, t - m % t);
    }

    vector<ll> s1, s2, t1, t2;
    for(int i = 0; i < min(n, 40LL); ++i) {
        (i & 1 ? s1 : s2).push_back(mul(mypow(a, i), p) + mul(mypow(b, i), q));
    }
    const int sz1 = s1.size(), sz2 = s2.size();
    for(int S = 0; S < (1 << sz1); ++S) {
        ll sum = 0;
        for(int i = 0; i < sz1; ++i) {
            if(S & (1 << i)) sum = min(inf, sum + s1[i]);
        }
        t1.push_back(sum);
    }
    for(int S = 0; S < (1 << sz2); ++S) {
        ll sum = 0;
        for(int i = 0; i < sz2; ++i) {
            if(S & (1 << i)) sum = min(inf, sum + s2[i]);
        }
        t2.push_back(sum);
    }
    sort(begin(t1), end(t1));
    sort(begin(t2), end(t2));

    ll res = m;
    const int tsz2 = t2.size();
    for(auto x1 : t1) {
        const ll target = m - x1;
        const int idx = lower_bound(begin(t2), end(t2), target) - begin(t2);
        for(int i = idx - 1; i <= idx + 1; ++i) {
            if(i < 0 || tsz2 <= i) continue;
            res = min(res, abs(m - (x1 + t2[i])));
        }
    }

    return res;
}

int main() {
    ll n, m, a, b, p, q;
    cin >> n >> m >> a >> b >> p >> q;

    cout << solve(n, m, a, b, p, q) << endl;
}
