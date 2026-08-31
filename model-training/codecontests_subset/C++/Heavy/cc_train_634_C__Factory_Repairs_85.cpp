#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 200333;
int orders[2][MAX_N + 123];
int f[2][MAX_N + 123];
void add(const int& d, int x, const int& value) {
  while (x < MAX_N) {
    f[d][x] += value;
    x |= x + 1;
  }
}
int getSum(const int& d, int x) {
  int res = 0;
  while (x > 0) {
    res += f[d][x];
    x = (x & (x + 1)) - 1;
  }
  return res;
}
int main() {
  ios_base::sync_with_stdio(false);
  int mx[2];
  int n, k, q;
  cin >> n >> k >> mx[1] >> mx[0] >> q;
  for (int i = 1; i <= q; i++) {
    int t;
    cin >> t;
    if (t == 1) {
      int day, amount;
      cin >> day >> amount;
      for (int j = 0; j < 2; j++) {
        int newVal = min(orders[j][day] + amount, mx[j]);
        add(j, day, newVal - orders[j][day]);
        orders[j][day] = newVal;
      }
    } else {
      int l, r;
      cin >> l;
      r = l + k - 1;
      int ans = getSum(1, n) - getSum(1, r);
      ans += getSum(0, l - 1);
      cout << ans << '\n';
    }
  }
  return 0;
}
