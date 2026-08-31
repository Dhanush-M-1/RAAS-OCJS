#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c;
  cin >> n >> a >> b >> c;
  n *= 2;
  long long ans = 0;
  for (int i = 0; i <= c; ++i) {
    int temp = n - 4 * i;
    if (temp < 0) break;
    if (a == 0 && temp % 2) {
      if (temp % 2 == 0) {
        if (b * 2 + a >= temp) ++ans;
      }
    } else {
      int d = min(temp / 2, b);
      int e = max(temp - a + 1 >> 1, 0);
      if (d >= e) ans += d - e + 1;
    }
  }
  cout << ans << endl;
  return 0;
}
