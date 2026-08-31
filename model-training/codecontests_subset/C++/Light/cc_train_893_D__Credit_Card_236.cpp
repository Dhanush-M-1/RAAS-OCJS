#include <bits/stdc++.h>
using namespace std;
int s[101000], f[101000], g[101000], n, m;
int ans;
int main() {
  int i, j, k;
  scanf("%d%d", &n, &m);
  for (i = 1; i <= n; i++) scanf("%d", &s[i]);
  g[n] = m;
  for (i = n - 1; i; i--) g[i] = min(m, min(m, g[i + 1]) - s[i + 1]);
  for (i = 1; i <= n; i++) {
    f[i] = f[i - 1] + s[i];
    if (s[i] == 0) {
      if (f[i] < 0) {
        ans++;
        f[i] = max(0, g[i]);
      }
    }
    if (f[i] > g[i]) {
      puts("-1");
      return 0;
    }
  }
  cout << ans << endl;
  return 0;
}
