#include <bits/stdc++.h>
using namespace std;
const double PI = acos(-1.0);
const double EPS = 1e-10;
inline int read() {
  static char ch;
  bool sgn = false;
  while (ch = getchar(), ch < '0' || ch > '9')
    if (ch == '-') sgn = true;
  int res = ch - 48;
  while (ch = getchar(), ch >= '0' && ch <= '9') res = res * 10 + ch - 48;
  return sgn ? -res : res;
}
const int N = 3e3 + 5;
double p[N][N], ans;
int dis[N][N][2], f[N], father[N], dep[N], a[N], b[N], now;
vector<int> E[N];
bool incircle[N], bo[N], passcircle[N][N];
void dfs(int x, int f, int d) {
  for (int i = E[x].size() - 1; i >= 0; i--) {
    int u = E[x][i];
    if (u == f || u == now) continue;
    if (dis[now][u][0] == 0) {
      dis[now][u][0] = d + 1;
      dfs(u, x, d + 1);
    } else {
      if (d + 1 < dis[now][u][0]) {
        dis[now][u][1] = dis[now][u][0];
        dis[now][u][0] = d + 1;
        dfs(u, x, d + 1);
      } else {
        if (dis[now][u][1] == 0) {
          dis[now][u][1] = d + 1;
          dfs(u, x, d + 1);
        } else {
          if (dis[now][u][1] > d + 1) {
            dis[now][u][1] = d + 1;
            dfs(u, x, d + 1);
          }
        }
      }
    }
  }
}
void Dfs(int x, int f) {
  dep[x] = dep[f] + 1;
  father[x] = f;
  for (int i = E[x].size() - 1; i >= 0; i--) {
    int u = E[x][i];
    if (u == f) continue;
    Dfs(u, x);
  }
}
void DFS(int x, int f, int cir) {
  bo[x] = 1;
  passcircle[now][x] = (cir >= 2 ? 1 : 0);
  for (int i = E[x].size() - 1; i >= 0; i--) {
    int u = E[x][i];
    if (u == f || bo[u]) continue;
    DFS(u, x, cir + incircle[u]);
  }
}
int find(int x) { return f[x] == x ? x : f[x] = find(f[x]); }
int main() {
  int n = read(), x, y;
  for (int i = 1; i <= n; i++) f[i] = i;
  for (int i = 1; i <= n; i++) {
    a[i] = read(), b[i] = read();
    a[i]++;
    b[i]++;
    int fa = find(a[i]), fb = find(b[i]);
    if (fa != fb) {
      E[a[i]].push_back(b[i]);
      E[b[i]].push_back(a[i]);
      f[fa] = fb;
    } else {
      x = a[i];
      y = b[i];
    }
  }
  Dfs(1, 0);
  E[x].push_back(y);
  E[y].push_back(x);
  incircle[x] = incircle[y] = 1;
  while (dep[x] > dep[y]) {
    x = father[x];
    incircle[x] = 1;
  }
  swap(x, y);
  while (dep[x] > dep[y]) {
    x = father[x];
    incircle[x] = 1;
  }
  while (x != y) {
    x = father[x];
    incircle[x] = 1;
    y = father[y];
    incircle[y] = 1;
  }
  for (now = 1; now <= n; now++) dfs(now, 0, 1);
  for (now = 1; now <= n; now++) {
    for (int i = 1; i <= n; i++) bo[i] = 0;
    DFS(now, 0, incircle[now]);
  }
  int num = 0;
  for (int i = 1; i <= n; i++) num += incircle[i];
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      if (i == j) {
        ans += 1;
        continue;
      }
      if (passcircle[i][j]) {
        ans += 1.0 / dis[i][j][0] + 1.0 / dis[i][j][1] -
               1.0 / ((dis[i][j][0] + dis[i][j][1] - num - 2) / 2 + num);
      } else {
        ans += 1.0 / dis[i][j][0];
      }
    }
  }
  printf("%.10f", ans);
}
