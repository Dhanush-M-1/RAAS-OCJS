#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const int MOD = 1000000007;
const int maxn = 1e5 + 10;
const double eps = 1e-8;
const double PI = acos(-1.0);
long long sum[2 * maxn][2];
int now[2 * maxn];
void add(int x, int val1, int val2) {
  while (x < (maxn << 1)) {
    sum[x][0] += val1;
    sum[x][1] += val2;
    x += ((x) & (-x));
  }
}
long long query(int t, int x) {
  long long res = 0;
  while (x > 0) {
    res += sum[x][t];
    x -= ((x) & (-x));
  }
  return res;
}
int main() {
  int n, a, b, k, q;
  cin >> n >> k >> b >> a >> q;
  while (q--) {
    int t, d, order;
    cin >> t;
    if (t == 1) {
      cin >> d >> order;
      int pre = now[d];
      now[d] += order;
      int or0 = min(now[d], a) - min(pre, a);
      int or1 = min(now[d], b) - min(pre, b);
      add(d, or0, or1);
    } else {
      cin >> d;
      long long ans = query(0, d - 1) + query(1, n) - query(1, d + k - 1);
      cout << ans << endl;
    }
  }
  return 0;
}
