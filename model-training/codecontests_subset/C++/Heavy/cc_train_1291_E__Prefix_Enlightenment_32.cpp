#include <bits/stdc++.h>
using namespace std;
const int maxn = 300005;
int n, k, fa[maxn], f[maxn][2], val[maxn], pos[maxn][2], ans;
char s[maxn];
int getfa(int x) {
  if (fa[x] == x) return x;
  int F = fa[x];
  fa[x] = getfa(F);
  val[x] ^= val[F];
  return fa[x];
}
void merge(int x, int y, int z) {
  getfa(x), getfa(y);
  z ^= (val[x] ^ val[y]);
  x = fa[x], y = fa[y];
  if (x == y) return;
  if (x > y) swap(x, y);
  if (!x)
    ans -= f[x][0];
  else
    ans -= min(f[x][0], f[x][1]);
  ans -= min(f[y][0], f[y][1]);
  f[x][0] += f[y][z];
  f[x][1] += f[y][z ^ 1];
  fa[y] = x, val[y] = z;
  if (!x)
    ans += f[x][0];
  else
    ans += min(f[x][0], f[x][1]);
}
int main() {
  scanf("%d%d", &n, &k);
  scanf("%s", s + 1);
  for (int i = 1, cnt; i <= k; i++) {
    scanf("%d", &cnt);
    for (int j = 1, x; j <= cnt; j++) {
      scanf("%d", &x);
      if (pos[x][0])
        pos[x][1] = i;
      else
        pos[x][0] = i;
    }
  }
  for (int i = 1; i <= k; i++) fa[i] = i, f[i][1] = 1;
  for (int i = 1; i <= n; i++) {
    if (!pos[i][0]) {
      printf("%d\n", ans);
      continue;
    }
    merge(pos[i][0], pos[i][1], (s[i] - '0') ^ 1);
    printf("%d\n", ans);
  }
  return 0;
}
