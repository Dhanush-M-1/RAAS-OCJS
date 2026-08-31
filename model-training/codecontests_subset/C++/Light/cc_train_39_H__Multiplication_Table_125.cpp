#include <bits/stdc++.h>
using namespace std;
int k;
string solve(int n) {
  string ans;
  bool ok = false;
  int d, p = pow(k, 8);
  while (p > 0) {
    d = n / p;
    n = n % p;
    if (!ok) {
      if (d != 0) {
        ok = true;
      }
    }
    if (ok) {
      ans += to_string(d);
    }
    p /= k;
  }
  return ans;
}
int main(void) {
  ios ::sync_with_stdio(0);
  cin.tie(0);
  cin >> k;
  for (int i = 1; i <= k - 1; ++i) {
    for (int j = 1; j <= k - 1; ++j) {
      cout << solve(i * j) << " ";
    }
    cout << "\n";
  }
  return 0;
}
