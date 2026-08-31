#include <bits/stdc++.h>
using namespace std;
template <typename T>
void chkmax(T &a, const T &b) {
  a = a > b ? a : b;
}
template <typename T>
void chkmin(T &a, const T &b) {
  a = a < b ? a : b;
}
const int MAXN = 300005;
const int dx[6] = {1, -1, 0, 0, 0, 0};
const int dy[6] = {0, 0, 1, -1, 0, 0};
const int dz[6] = {0, 0, 0, 0, 1, -1};
int clr[MAXN], n, m, K;
vector<int> opt[MAXN];
int get_id(int x, int y, int z) { return (x - 1) * m * K + (y - 1) * K + z; }
void update(int d, int c, int x, int y, int z) {
  if (x < 1 || x > n || y < 1 || y > m || z < 1 || z > K) {
    if (c == 0) return;
    puts("-1");
    exit(0);
  }
  int id = get_id(x, y, z);
  auto go_next = [&]() { update(d, c, x + dx[d], y + dy[d], z + dz[d]); };
  if (clr[id] == 0) {
    go_next();
  } else if (clr[id] < 0) {
    clr[id] = c;
    if (c == 0)
      go_next();
    else
      opt[id].push_back(d);
  } else if (clr[id] != c) {
    int cc = clr[id];
    clr[id] = 0;
    for (int o : opt[id]) update(o, cc, x + dx[o], y + dy[o], z + dz[o]);
    go_next();
  } else
    opt[id].push_back(d);
}
int main() {
  memset(clr, -1, sizeof(clr));
  scanf("%d%d%d", &n, &m, &K);
  for (int i = 1; i <= m; i++)
    for (int j = 1; j <= K; j++) {
      int x;
      scanf("%d", &x);
      update(0, x, 1, i, j);
    }
  for (int i = 1; i <= m; i++)
    for (int j = 1; j <= K; j++) {
      int x;
      scanf("%d", &x);
      update(1, x, n, i, j);
    }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= K; j++) {
      int x;
      scanf("%d", &x);
      update(2, x, i, 1, j);
    }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= K; j++) {
      int x;
      scanf("%d", &x);
      update(3, x, i, m, j);
    }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= m; j++) {
      int x;
      scanf("%d", &x);
      update(4, x, i, j, 1);
    }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= m; j++) {
      int x;
      scanf("%d", &x);
      update(5, x, i, j, K);
    }
  for (int i = 1; i <= n; i++, puts(""))
    for (int j = 1; j <= m; j++, puts(""))
      for (int k = 1; k <= K; k++) {
        int f = clr[get_id(i, j, k)];
        printf("%d ", f < 0 ? 0 : f);
      }
  return 0;
}
