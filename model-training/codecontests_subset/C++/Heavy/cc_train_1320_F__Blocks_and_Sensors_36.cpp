#include <bits/stdc++.h>
int read() {
  static int c, x;
  while ((c = getchar()) < 48) {
  }
  x = c & 15;
  while ((c = getchar()) >= 48) x = x * 10 + (c & 15);
  return x;
}
const int dx[6] = {1, -1, 0, 0, 0, 0};
const int dy[6] = {0, 0, 1, -1, 0, 0};
const int dz[6] = {0, 0, 0, 0, 1, -1};
bool fail;
int n, m, k;
int a[200010], b[200010];
void dfs(const int d, const int x, const int y, const int z, const int c) {
  if (!x || !y || !z || x > n || y > m || z > k) {
    if (c) fail = true;
    return;
  }
  const int now = ((x - 1) * m + (y - 1)) * k + z;
  if (c) {
    if (a[now] == -1 || a[now] == c) {
      a[now] = c;
      b[now] |= 1 << d;
      return;
    }
    if (a[now] == 0) {
      dfs(d, x + dx[d], y + dy[d], z + dz[d], c);
      return;
    }
  }
  if (a[now] > 0) {
    for (int i = 0; i != 6; ++i) {
      if (b[now] & (1 << i)) {
        b[now] ^= 1 << i;
        dfs(i, x + dx[i], y + dy[i], z + dz[i], a[now]);
        if (fail) return;
      }
    }
  }
  a[now] = 0;
  dfs(d, x + dx[d], y + dy[d], z + dz[d], c);
}
int main() {
  n = read();
  m = read();
  k = read();
  const int N = n * m * k;
  for (int i = 1; i <= N; ++i) {
    a[i] = -1;
  }
  for (int i = 1; i <= m; ++i) {
    for (int j = 1; j <= k; ++j) {
      if (!fail) dfs(0, 1, i, j, read());
    }
  }
  for (int i = 1; i <= m; ++i) {
    for (int j = 1; j <= k; ++j) {
      if (!fail) dfs(1, n, i, j, read());
    }
  }
  for (int i = 1; i <= n; ++i) {
    for (int j = 1; j <= k; ++j) {
      if (!fail) dfs(2, i, 1, j, read());
    }
  }
  for (int i = 1; i <= n; ++i) {
    for (int j = 1; j <= k; ++j) {
      if (!fail) dfs(3, i, m, j, read());
    }
  }
  for (int i = 1; i <= n; ++i) {
    for (int j = 1; j <= m; ++j) {
      if (!fail) dfs(4, i, j, 1, read());
    }
  }
  for (int i = 1; i <= n; ++i) {
    for (int j = 1; j <= m; ++j) {
      if (!fail) dfs(5, i, j, k, read());
    }
  }
  if (fail) {
    puts("-1");
    return 0;
  }
  for (int i = 1; i <= N; ++i) {
    printf("%d ", (a[i] > 0) ? a[i] : 0);
  }
  return 0;
}
