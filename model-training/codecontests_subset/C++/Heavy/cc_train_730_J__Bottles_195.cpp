#include <bits/stdc++.h>
using namespace std;
struct bot {
  int a, b;
} a[110];
int n, f[10100][105], suma, sumb, kk;
bool cmp(bot a, bot b) { return a.b > b.b; }
int main() {
  memset(f, -0x3f, sizeof(f));
  f[0][0] = 0;
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &a[i].a);
    suma += a[i].a;
  }
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &a[i].b);
  }
  sort(a + 1, a + n + 1, cmp);
  while (sumb < suma) {
    sumb += a[++kk].b;
  }
  printf("%d ", kk);
  for (int i = 1; i <= n; ++i) {
    for (int j = sumb; j >= a[i].b; --j) {
      for (int k = 1; k <= kk; ++k) {
        f[j][k] = max(f[j][k], f[j - a[i].b][k - 1] + a[i].a);
      }
    }
  }
  int ans = 0;
  for (int i = suma; i <= sumb; ++i) {
    ans = max(ans, f[i][kk]);
  }
  printf("%d", suma - ans);
  return 0;
}
