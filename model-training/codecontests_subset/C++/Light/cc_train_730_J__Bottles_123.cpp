#include <bits/stdc++.h>
using namespace std;
int n, sum = 0, f[30005], maxl, g[30005][105];
struct node {
  int a, b;
} t[105];
bool cmp(node x, node y) { return x.a > y.b; }
int main() {
  memset(f, 0x3f, sizeof(f));
  cin >> n;
  f[0] = 0;
  for (int i = 1; i <= n; i++) cin >> t[i].a, sum += t[i].a;
  for (int i = 1; i <= n; i++) cin >> t[i].b;
  for (int i = 1; i <= n; i++) {
    for (int j = sum; j >= 0; j--) {
      if (j >= t[i].b)
        f[j] = min(f[j], f[j - t[i].b] + 1);
      else
        f[j] = min(f[j], 1);
    }
  }
  cout << f[sum] << " ";
  memset(g, -0x3f, sizeof(g));
  g[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    for (int j = sum + 10005; j >= t[i].b; j--) {
      for (int k = f[sum]; k >= 1; k--) {
        g[j][k] = max(g[j][k], g[j - t[i].b][k - 1] + t[i].a);
        if (j >= sum && k == f[sum]) maxl = max(maxl, g[j][k]);
      }
    }
  }
  cout << sum - maxl << endl;
}
