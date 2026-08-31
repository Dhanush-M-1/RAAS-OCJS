#include <bits/stdc++.h>
using namespace std;
const int N = 3005;
int q[N];
int fa[N], dep[N];
int n, co[N], dis[N];
vector<int> e[N];
double ans;
void dfs(int x) {
  for (auto i : e[x])
    if (i != fa[x]) {
      if (!dep[i]) {
        fa[i] = x;
        dep[i] = dep[x] + 1;
        dfs(i);
      } else if (dep[i] < dep[x]) {
        for (int y = x;; y = fa[y]) {
          q[++*q] = y;
          if (y == i) break;
        }
      }
    }
}
void find(int x) {
  for (auto i : e[x])
    if (!co[i]) {
      co[i] = co[x];
      dep[i] = dep[x] + 1;
      find(i);
    }
}
void SSSP(int x) {
  for (int i = (int)(1); i <= (int)(n); i++) dis[i] = -1;
  int h = 0, t = 1;
  q[1] = x;
  dis[x] = 0;
  while (h != t) {
    int x = q[++h];
    for (auto i : e[x])
      if (dis[i] == -1 && co[i] == co[x]) {
        dis[i] = dis[x] + 1;
        q[++t] = i;
      }
  }
}
int main() {
  scanf("%d", &n);
  for (int i = (int)(1); i <= (int)(n); i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    e[++x].push_back(++y);
    e[y].push_back(x);
  }
  dfs(1);
  for (int i = (int)(1); i <= (int)(*q); i++) co[q[i]] = i, dep[q[i]] = 0;
  for (int i = (int)(1); i <= (int)(*q); i++) find(q[i]);
  for (int i = (int)(1); i <= (int)(n); i++) {
    SSSP(i);
    for (int j = (int)(i + 1); j <= (int)(n); j++)
      if (co[i] == co[j])
        ans += 2.0 / (dis[j] + 1);
      else {
        int d1 = dep[i] + dep[j];
        int d2 = (co[i] + (*q) - co[j]) % (*q);
        int d3 = *q - d2;
        ans += 2.0 / (d1 + d2 + 1);
        ans += 2.0 / (d1 + d3 + 1);
        ans -= 2.0 / (d1 + (*q));
      }
  }
  printf("%.10lf\n", ans + n);
}
