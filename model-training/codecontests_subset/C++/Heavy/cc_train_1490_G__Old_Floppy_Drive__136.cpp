#include <bits/stdc++.h>
using ll = long long;
char df = '\n';
using namespace std;

void solve() {
    int n, m;
    cin >> n >> m;
    ll A[n], ar[n], mx[n];
    for (int i = 0; i < n; i++) cin >> A[i];
    ar[0] = A[0];
    for (int i = 1; i < n; i++) ar[i] = A[i]+ar[i-1];
    mx[0] = ar[0];
    for (int i = 1; i < n; i++) mx[i] = max(mx[i-1], ar[i]);
    while (m--) {
        ll x;
        cin >> x;
        if (x > mx[n-1]) {
            if (ar[n-1] <= 0) {
                cout << -1 << " ";
            } else {
                ll y = (x-mx[n-1])/ar[n-1];
                if ((x-mx[n-1])%ar[n-1]) y++;
                auto it = lower_bound(mx, mx+n, x-y*ar[n-1]);
                cout << it-mx+y*n << " ";
            }
        } else {
            auto it = lower_bound(mx, mx+n, x);
            cout << it-mx << " ";
        }
    }
    cout << df;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int tt = 1;
    cin >> tt;
    while (tt--) solve();
    return 0;
}