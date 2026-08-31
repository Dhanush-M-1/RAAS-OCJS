#include <bits/stdc++.h>
using namespace std;
const int N = 109;
int n, suma, K, sumb, f[10086][N], ans = 0;
struct node {
  int a, b;
} c[N];
bool cmp(const node& a, const node& b) { return a.b > b.b; }
int main() {
  scanf("%d", &n);
  for (register int i = 1; i <= n; i++) scanf("%d", &c[i].a), suma += c[i].a;
  for (register int i = 1; i <= n; i++) scanf("%d", &c[i].b);
  sort(c + 1, c + n + 1, cmp);
  while (sumb < suma) sumb += c[++K].b;
  printf("%d ", K);
  memset(f, 128, sizeof(f));
  f[0][0] = 0;
  for (register int i = 1; i <= n; i++)
    for (register int j = sumb; j >= c[i].b; j--)
      for (register int k = 1; k <= K; k++)
        f[j][k] = max(f[j][k], f[j - c[i].b][k - 1] + c[i].a);
  for (register int j = suma; j <= sumb; j++) ans = max(ans, f[j][K]);
  printf("%d", suma - ans);
  return 0;
}
