#include <bits/stdc++.h>
using std::cerr;
using std::endl;
const int N = 3005;
int n, dep[N], stk[N], top, on[N];
int circle_size;
double ans;
std::vector<int> G[N];
bool find_circle(int x, int fa) {
  dep[x] = dep[fa] + 1;
  stk[++top] = x;
  for (int y : G[x]) {
    if (y == fa) continue;
    if (!dep[y]) {
      if (find_circle(y, x)) return 1;
    } else {
      circle_size = dep[x] - dep[y] + 1;
      for (int z = 0; y != z; --top) {
        z = stk[top];
        on[z] = 1;
      }
      return 1;
    }
  }
  return 0;
}
int vis[N], st;
void dfs(int x, int a, int b) {
  vis[x] = 1;
  if (x != st) {
    double tmp = 0;
    if (b == 0) {
      tmp = 1.0 / (a + 1);
    } else {
      int na = a + 2, nb = b - 1, nc = circle_size - 2 - nb;
      tmp = 1.0 / (na + nb) + 1.0 / (na + nc) - 1.0 / (na + nb + nc);
    }
    ans += tmp;
  }
  for (int y : G[x]) {
    if (vis[y]) continue;
    int na = a, nb = b;
    if (on[x] && on[y])
      ++nb;
    else
      ++na;
    dfs(y, na, nb);
  }
}
int main() {
  std::cin >> n;
  for (int i = 1; i <= n; ++i) {
    int x, y;
    std::cin >> x >> y;
    ++x, ++y;
    G[x].push_back(y);
    G[y].push_back(x);
  }
  find_circle(1, 0);
  for (int i = 1; i <= n; ++i) {
    memset(vis, 0, sizeof(vis));
    st = i;
    dfs(i, 0, 0);
  }
  ans += n;
  printf("%.12lf\n", ans);
  return 0;
}
