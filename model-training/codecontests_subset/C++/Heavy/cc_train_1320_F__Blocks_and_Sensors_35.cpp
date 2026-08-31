#include <bits/stdc++.h>
using namespace std;
constexpr int maxn = 3e5 + 100;
int read() {
  int x = 0;
  char c = getchar();
  while (!isdigit(c)) c = getchar();
  while (isdigit(c)) x = x * 10 + c - '0', c = getchar();
  return x;
}
int n, m, k, gg, ans[maxn], obs[maxn];
int encode(const int x, const int y, const int z) {
  return ((x - 1) * m + (y - 1)) * k + z;
}
const int dx[] = {1, -1, 0, 0, 0, 0}, dy[] = {0, 0, 1, -1, 0, 0},
          dz[] = {0, 0, 0, 0, 1, -1};
void dfs(const int x, const int y, const int z, const int d, const int c) {
  if (!x || !y || !z || x > n || y > m || z > k) {
    if (c) gg = true;
    return;
  }
  const int now = encode(x, y, z);
  if (c) {
    if (ans[now] == -1 || ans[now] == c) {
      ans[now] = c;
      obs[now] |= (1 << d);
      return;
    }
    if (ans[now] == 0) {
      dfs(x + dx[d], y + dy[d], z + dz[d], d, c);
      return;
    }
  }
  if (ans[now] > 0) {
    for (int i = 0; i < 6; i++)
      if ((obs[now] >> i) & 1) {
        obs[now] ^= (1 << i);
        dfs(x + dx[i], y + dy[i], z + dz[i], i, ans[now]);
        if (gg) return;
      }
  }
  ans[now] = 0;
  dfs(x + dx[d], y + dy[d], z + dz[d], d, c);
}
int main() {
  n = read(), m = read(), k = read();
  const int N = n * m * k;
  for (int i = 1; i <= N; i++) ans[i] = -1;
  for (int i = 1; i <= m; i++)
    for (int j = 1; j <= k; j++) {
      dfs(1, i, j, 0, read());
      if (gg) return puts("-1"), 0;
    }
  for (int i = 1; i <= m; i++)
    for (int j = 1; j <= k; j++) {
      dfs(n, i, j, 1, read());
      if (gg) return puts("-1"), 0;
    }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= k; j++) {
      dfs(i, 1, j, 2, read());
      if (gg) return puts("-1"), 0;
    }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= k; j++) {
      dfs(i, m, j, 3, read());
      if (gg) return puts("-1"), 0;
    }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= m; j++) {
      dfs(i, j, 1, 4, read());
      if (gg) return puts("-1"), 0;
    }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= m; j++) {
      dfs(i, j, k, 5, read());
      if (gg) return puts("-1"), 0;
    }
  for (int i = 1; i <= N; i++) printf("%d ", ans[i] == -1 ? 0 : ans[i]);
  puts("");
  return 0;
}
