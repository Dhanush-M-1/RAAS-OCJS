#include <bits/stdc++.h>
using namespace std;
const int N = 110;
int n, f[N][N * N], s[N], sa;
struct bottle {
  int a, b;
} q[N];
inline bool cmp(bottle a, bottle b) { return a.b > b.b; }
inline void upd(int &x, int y) { (y < x) && (x = y); }
int main() {
  scanf("%d", &n);
  int sum = 0;
  for (int i = 1; i <= n; ++i) scanf("%d", &q[i].a), sum += q[i].a;
  for (int i = 1; i <= n; ++i) scanf("%d", &q[i].b);
  sort(q + 1, q + n + 1, cmp);
  for (int i = 1; i <= n; ++i) s[i] = s[i - 1] + q[i].b;
  int mx = 0;
  sa = sum;
  for (int i = 1; i <= n; ++i) {
    sum -= q[i].b;
    if (sum <= 0) {
      mx = i;
      break;
    }
  }
  memset(f, 0x3f, sizeof(f));
  f[0][0] = 0;
  for (int i = 1; i <= n; ++i) {
    for (int j = i; j >= 0; --j) {
      for (int k = s[i]; k >= 0; --k) {
        f[j][k] += q[i].a;
        if (k >= q[i].b && j >= 1) upd(f[j][k], f[j - 1][k - q[i].b]);
      }
    }
  }
  int ans = 0x3f3f3f3f;
  for (int k = sa; k <= s[n]; ++k) ans = min(ans, f[mx][k]);
  printf("%d %d\n", mx, ans);
  return 0;
}
