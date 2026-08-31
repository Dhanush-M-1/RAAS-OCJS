#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c, ans = 0, i, j, k;
  cin >> n >> a >> b >> c;
  for (i = 0; i <= n * 2 && i <= a; i += 2) {
    for (j = 0; j <= n - i / 2 && j <= b; j++) {
      k = n - i / 2 - j;
      if (k & 1) continue;
      if (k / 2 > c) continue;
      ans++;
    }
  }
  cout << ans << endl;
}
