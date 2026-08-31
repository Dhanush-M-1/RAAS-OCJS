#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
const int N = 100000 + 10;
int u[N << 1], v[N << 1], nt[N << 1], ft[N];
int n, m, cnt;
int vis[N << 1];
void add(int a, int b) {
  u[cnt] = a;
  v[cnt] = b;
  nt[cnt] = ft[a];
  ft[a] = cnt++;
}
int dfs(int x, int f) {
  queue<int> vec;
  for (int i = ft[x]; i != -1; i = nt[i]) {
    int nx = v[i];
    if (vis[i] || nx == f) continue;
    vis[i] = vis[i ^ 1] = 1;
    int r = dfs(nx, x);
    if (r) {
      printf("%d %d %d\n", x, nx, r);
    } else {
      vec.push(nx);
    }
  }
  while (vec.size() >= 2) {
    int a = vec.front();
    vec.pop();
    int b = vec.front();
    vec.pop();
    printf("%d %d %d\n", a, x, b);
  }
  if (!vec.empty()) {
    int a = vec.front();
    vec.pop();
    return a;
  }
  return 0;
}
int main() {
  while (scanf("%d%d", &n, &m) != EOF) {
    cnt = 0;
    memset(ft, -1, sizeof ft);
    memset(vis, 0, sizeof vis);
    int a, b;
    for (int i = 0; i < m; i++) {
      scanf("%d%d", &a, &b);
      add(a, b);
      add(b, a);
    }
    if (m & 1) {
      puts("No solution");
      continue;
    }
    dfs(1, -1);
  }
  return 0;
}
