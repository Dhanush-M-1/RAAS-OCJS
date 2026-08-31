#include <bits/stdc++.h>
using namespace std;
int ans = 0;
int main() {
  int n, a, b, c, i, j, s;
  cin >> n >> a >> b >> c;
  for (i = 0; i <= c; i++) {
    s = i * 2;
    if (s > n) break;
    for (j = 0; j <= b; j++) {
      if (s + j > n) break;
      if ((n - s - j) * 2 <= a) ans++;
    }
  }
  cout << ans;
  return 0;
}
