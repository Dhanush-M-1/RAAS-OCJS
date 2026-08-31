#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c, ans = 0;
  cin >> n >> a >> b >> c;
  for (int i = 0; i <= c; i++) {
    for (int j = 0; j <= min(n - i * 2, b); j++) {
      int k = (n - i * 2 - j) * 2;
      if (k > a) continue;
      ans++;
    }
  }
  return cout << ans << endl, 0;
}
