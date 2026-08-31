#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline void read(T &x) {
  x = 0;
  char c = getchar();
  bool flag = false;
  while (!isdigit(c)) {
    if (c == '-') flag = true;
    c = getchar();
  }
  while (isdigit(c)) {
    x = (x << 1) + (x << 3) + (c ^ 48);
    c = getchar();
  }
  if (flag) x = -x;
}
int n, m, k;
bool flag;
int dx[6] = {1, -1, 0, 0, 0, 0}, dy[6] = {0, 0, 1, -1, 0, 0},
    dz[6] = {0, 0, 0, 0, 1, -1}, c[400010];
vector<int> ve[400010];
void add(int x, int y, int z, int v, int t);
void del(int x, int y, int z);
bool check(int x, int y, int z) {
  return x >= 1 && x <= n && y >= 1 && y <= m && z >= 1 && z <= k;
}
void add(int x, int y, int z, int v, int t) {
  if (!check(x, y, z)) {
    if (v) flag = true;
    return;
  }
  int p = (((x - 1) * m + y - 1) * k + z);
  if (!v) {
    if (c[p] > 0) del(x, y, z);
    c[p] = 0, add(x + dx[t], y + dy[t], z + dz[t], v, t);
    return;
  }
  if (c[p]) {
    if (c[p] == v || c[p] == -1)
      c[p] = v, ve[p].push_back(t);
    else
      del(x, y, z), c[p] = 0, add(x + dx[t], y + dy[t], z + dz[t], v, t);
  } else
    add(x + dx[t], y + dy[t], z + dz[t], v, t);
}
void del(int x, int y, int z) {
  int p = (((x - 1) * m + y - 1) * k + z);
  while (!ve[p].empty()) {
    int t = ve[p].back(), v = c[p];
    ve[p].pop_back(), add(x + dx[t], y + dy[t], z + dz[t], v, t);
  }
}
int main() {
  read(n), read(m), read(k), memset(c, -1, sizeof(c));
  for (int i = 1; i <= m; ++i)
    for (int j = 1, v; j <= k; ++j) read(v), add(1, i, j, v, 0);
  for (int i = 1; i <= m; ++i)
    for (int j = 1, v; j <= k; ++j) read(v), add(n, i, j, v, 1);
  for (int i = 1; i <= n; ++i)
    for (int j = 1, v; j <= k; ++j) read(v), add(i, 1, j, v, 2);
  for (int i = 1; i <= n; ++i)
    for (int j = 1, v; j <= k; ++j) read(v), add(i, m, j, v, 3);
  for (int i = 1; i <= n; ++i)
    for (int j = 1, v; j <= m; ++j) read(v), add(i, j, 1, v, 4);
  for (int i = 1; i <= n; ++i)
    for (int j = 1, v; j <= m; ++j) read(v), add(i, j, k, v, 5);
  if (flag) {
    puts("-1");
    return 0;
  }
  for (int i = 1; i <= n; ++i)
    for (int j = 1; j <= m; ++j)
      for (int l = 1; l <= k; ++l)
        printf("%d%c", max(c[(((i - 1) * m + j - 1) * k + l)], 0),
               " \n"[l == k]);
  return 0;
}
