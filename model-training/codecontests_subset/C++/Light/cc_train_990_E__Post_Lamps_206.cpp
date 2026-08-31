#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 10;
const long long INFL = 0x3f3f3f3f3f3f3f3fLL;
int n, m, q, aSize;
int a[N], b[N];
int main() {
  scanf("%d%d%d", &n, &m, &q);
  int p = 0;
  aSize = 0;
  for (int i = 1; i <= m; ++i) {
    int v;
    scanf("%d", &v);
    for (int j = p; j <= v - 1; ++j) a[++aSize] = j;
    p = v + 1;
  }
  while (p <= n) a[++aSize] = p++;
  for (int i = 1; i <= q; ++i) scanf("%d", &b[i]);
  for (int i = q - 1; i >= 1; --i) b[i] = min(b[i], b[i + 1]);
  int maxDist = 0;
  for (int i = 2; i <= aSize; ++i) maxDist = max(maxDist, a[i] - a[i - 1]);
  if (a[1] != 0 || maxDist > q) {
    puts("-1");
    return 0;
  }
  long long ans = INFL;
  for (int i = maxDist; i <= q; ++i) {
    int d = 0;
    for (int j = 0; j < n;) {
      int p = upper_bound(a + 1, a + aSize + 1, j + i) - a - 1;
      j = a[p];
      ++d;
    }
    ans = min(ans, (long long)d * b[i]);
  }
  cout << ans;
  return 0;
}
