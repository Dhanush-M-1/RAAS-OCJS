#include <bits/stdc++.h>
using namespace std;
long long bit[200005][2];
int n, k, a, b, q;
long long get(int idx, int t) {
  long long ret = 0;
  while (idx) {
    ret += bit[idx][t];
    idx -= (idx & (-idx));
  }
  return ret;
}
long long update(int idx, int t, long long val) {
  while (idx <= n) {
    bit[idx][t] += val;
    idx += (idx & (-idx));
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n >> k >> a >> b >> q;
  int op;
  long long int d, v;
  int p;
  while (q--) {
    cin >> op;
    if (op == 1) {
      cin >> d >> v;
      long long int val1 = get(d, 0) - get(d - 1, 0);
      if (val1 < b) update(d, 0, min(b - val1, v));
      val1 = get(d, 1) - get(d - 1, 1);
      if (val1 < a) update(d, 1, min(a - val1, v));
      continue;
    }
    if (op == 2) {
      cin >> p;
      long long ans = get(p - 1, 0);
      if (p + k - 1 <= n) ans += get(n, 1) - get(p + k - 1, 1);
      cout << ans << endl;
    }
  }
  return 0;
}
