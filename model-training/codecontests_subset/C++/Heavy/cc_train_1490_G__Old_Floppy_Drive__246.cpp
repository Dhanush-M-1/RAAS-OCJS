#include <bits/stdc++.h>
using namespace std;
#ifdef LOCAL
#include "trace.h"
#else
#define trace(args...)
#endif

using ll = long long;
using ld = long double;
using pii = pair<int, int>;
using vi = vector<int>;
#define mp make_pair
#define ub upper_bound
#define lb lower_bound
#define fi first
#define se second
#define pb push_back
#define eb emplace_back
#define all(v) (v).begin(), (v).end()
#define rall(v) (v).rbegin(), (v).rend()

const int inf = 1e9 + 7;

struct seg_tree {
    vector<ll> t;
    int n;
    void init(int m) {
        n = m;
        t.assign(4 * n, 0);
    }
    int query_aux(int v, int tl, int tr, int l, int r, ll x) {
        if (l > r || t[v] < x) return -1;
        if (tl == tr) return tl;
        int tm = (tl + tr) / 2;
        int res = query_aux(v * 2, tl, tm, l, min(r, tm), x);
        if (res == -1) res = query_aux(v * 2 + 1, tm + 1, tr, max(l, tm + 1), r, x);
        return res;
    }
    void update_aux(int v, int tl, int tr, int pos, ll new_val) {
        if (tl == tr) {
            t[v] = new_val;
            return;
        }
        int tm = (tl + tr) / 2;
        if (pos <= tm)
            update_aux(v * 2, tl, tm, pos, new_val);
        else
            update_aux(v * 2 + 1, tm + 1, tr, pos, new_val);
        t[v] = max(t[v * 2], t[v * 2 + 1]);
    }
    void update(int i, ll x) {
        return update_aux(1, 0, n - 1, i, x);
    }
    int query(int l, int r, ll x) {
        return query_aux(1, 0, n - 1, l, r, x);
    }
};

void solve(int test) {
    seg_tree stree;
    int n, m;
    cin >> n >> m;
    vector<ll> a(n + 1, 0);
    stree.init(n + 1);
    stree.update(0, 0);
    ll mx = 0;
    for (int i = 1; i <= n; i++) {
        cin >> a[i];
        a[i] += a[i - 1];
        stree.update(i, a[i]);
        mx = max(mx, a[i]);
    }
    trace(a);
    for (int i = 0, x; i < m; i++) {
        cin >> x;
        int res = stree.query(0, n, x);
        if (res == -1) {
            if (a[n] <= 0) {
                cout << -1;
            } else {
                int q = 1 + (x - mx - 1) / a[n];
                x -= q * a[n];
                res = stree.query(0, n, x);
                ll ans = 1LL * q * n;
                ans += (res - 1);
                cout << ans;
            }
        } else {
            cout << (res - 1);
        }
        cout << ' ';
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int t = 1;
    cin >> t;
    for (int i = 1; i <= t; i++) {
        // cout << "Case #" << i << ": ";
        solve(i);
        cout << '\n';
    }
}
