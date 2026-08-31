#include <bits/stdc++.h>
using namespace std;
using ll = long long int;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    ll l, r;
    cin >> l >> r;
    ll idx = 1;
    bool done = false;
    for (int start = 1; start <= n; start++) {
      if (idx <= l && idx + (n - start) * 2ll > l) {
        int now = start;
        int nxt = start + 1;
        for (; idx < l; idx++) {
          int prev_now = now;
          now = nxt;
          nxt = (prev_now == start ? start : prev_now + 1);
          if (nxt == n + 1) {
            assert(now == start);
            now = ++start;
            nxt = start + 1;
          }
        }
        for (; idx <= r; idx++) {
          cout << now << " ";
          int prev_now = now;
          now = nxt;
          nxt = (prev_now == start ? start : prev_now + 1);
          if (nxt == n + 1) {
            assert(now == start);
            now = ++start;
            nxt = start + 1;
            if (now == n) {
              now = 1;
            }
          }
        }
        cout << endl;
        done = true;
        break;
      } else {
        idx += (n - start) * 2ll;
      }
    }
    if (!done) cout << 1 << '\n';
  }
}
