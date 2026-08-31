#include <bits/stdc++.h>
using namespace std;
using namespace std;
int d[40000 + 20];
int main() {
  int i, j, k, t, m, n;
  int a, b, c;
  cin >> n >> a >> b >> c;
  for (i = 0; i <= a; i++) {
    for (j = 0; j <= b; j++) {
      if (i + 2 * j > 2 * n)
        continue;
      else
        d[i + 2 * j]++;
    }
  }
  int ans = 0;
  for (i = 0; i <= c; i++) {
    int rest = 2 * n - 4 * i;
    if (rest >= 0) ans += d[rest];
  }
  cout << ans << endl;
}
