#include <bits/stdc++.h>
using namespace std;
int n, a, b, c, ans = 0;
int main() {
  cin >> n >> a >> b >> c;
  int nb = b;
  b += a / 2;
  for (int i = 0; i <= b; i++) {
    if (i > n) break;
    for (int j = 0; j <= c; j++) {
      if (j * 2 + i > n) break;
      if (j * 2 + i == n) {
        for (int k = 0; k * 2 <= a && k <= i; k++)
          if (i - k <= nb) ans++;
      }
    }
  }
  cout << ans << '\n';
  return 0;
}
