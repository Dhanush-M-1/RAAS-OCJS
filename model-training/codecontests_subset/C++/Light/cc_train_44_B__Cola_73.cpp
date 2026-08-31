#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c, k, t;
  int ans = 0, i, j;
  cin >> n >> a >> b >> c;
  for (i = 0; i <= a; i += 2) {
    for (j = 0; j <= b; j++) {
      t = n - i / 2 - j;
      if (t == 0) {
        ans++;
      } else {
        if (t % 2 == 0) {
          k = t / 2;
          if ((k <= c) && (k > 0)) {
            ans++;
          }
        }
      }
    }
  }
  cout << ans;
  return 0;
}
