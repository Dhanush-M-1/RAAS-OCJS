#include <bits/stdc++.h>
using namespace std;
const int mod = 1000000007;
const int inf = INT_MAX;
const int lim = 2e5 + 5;
int power(int a, int b) {
  int ret = 1;
  while (b) {
    if (b & 1) ret *= a;
    a *= a;
    if (ret >= mod) ret %= mod;
    if (a >= mod) a %= mod;
    b >>= 1;
  }
  return ret;
}
int inv(int x) { return power(x, mod - 2); }
int cnt[2][lim];
long long BIT[2][lim];
int n, k, a, b, q;
void update(int type, int idx, int val) {
  while (idx <= n) {
    BIT[type][idx] += val;
    idx += idx & (-idx);
  }
}
long long query(int type, int idx) {
  long long ans = 0;
  while (idx > 0) {
    ans += BIT[type][idx];
    idx -= idx & (-idx);
  }
  return ans;
}
int main() {
  cin >> n >> k >> a >> b >> q;
  int type, x, y;
  while (q--) {
    cin >> type;
    if (type == 1) {
      cin >> x >> y;
      if (cnt[0][x] < b) {
        int val = min(y, b - cnt[0][x]);
        update(0, x, val);
        cnt[0][x] += val;
      }
      if (cnt[1][x] < a) {
        int val = min(y, a - cnt[1][x]);
        update(1, x, val);
        cnt[1][x] += val;
      }
      continue;
    }
    cin >> x;
    cout << query(1, n) - query(1, x + k - 1) + query(0, x - 1) << endl;
  }
}
