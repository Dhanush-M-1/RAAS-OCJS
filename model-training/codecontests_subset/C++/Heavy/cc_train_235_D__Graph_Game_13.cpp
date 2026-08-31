#include <bits/stdc++.h>
using namespace std;
struct Edge {
  int nxt, to;
} e[6005];
int hd[3005], e_cnt;
void add(int u, int v) {
  e[++e_cnt] = (Edge){hd[u], v};
  hd[u] = e_cnt;
}
int n, dia[3005], dia_cnt, rec[3005];
double ans;
bool vis[3005];
void dfs1(int u, int r, int dep) {
  vis[u] = true;
  rec[dep] = u;
  for (int i = hd[u]; i; i = e[i].nxt)
    if (e[i].to != r) {
      if (vis[e[i].to]) {
        for (int j = 1; j <= dep; j++)
          if (rec[j] == e[i].to) {
            while (j <= dep) {
              dia[++dia_cnt] = rec[j];
              j++;
            }
            break;
          }
        return;
      }
      dfs1(e[i].to, u, dep + 1);
      if (dia_cnt) return;
    }
}
void dfs2(int u, int r, int dep, vector<int> &vec) {
  vec.push_back(dep);
  for (int i = hd[u]; i; i = e[i].nxt)
    if (e[i].to != r && !vis[e[i].to]) {
      dfs2(e[i].to, u, dep + 1, vec);
    }
}
void dfs4(int u, int r, int dep, int exception) {
  ans += 1.0 / dep;
  for (int i = hd[u]; i; i = e[i].nxt)
    if (e[i].to != r && (!vis[e[i].to] || e[i].to == exception))
      dfs4(e[i].to, u, dep + 1, exception);
}
void dfs3(int u, int r, int exception) {
  dfs4(u, 0, 1, exception);
  for (int i = hd[u]; i; i = e[i].nxt)
    if (e[i].to != r && !vis[e[i].to]) dfs3(e[i].to, u, exception);
}
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    int a, b;
    cin >> a >> b;
    a++;
    b++;
    add(a, b);
    add(b, a);
  }
  dfs1(1, 0, 1);
  memset(vis, 0, sizeof vis);
  for (int i = 1; i <= dia_cnt; i++) vis[dia[i]] = true;
  for (int i = 1; i <= dia_cnt; i++)
    for (int j = i + 1; j <= dia_cnt; j++) {
      vector<int> v1, v2;
      dfs2(dia[i], 0, 0, v1);
      dfs2(dia[j], 0, 0, v2);
      int d1 = j - i, d2 = dia_cnt - d1;
      for (int x : v1)
        for (int y : v2) {
          ans += 1.0 / (x + y + d1 + 1) + 1.0 / (x + y + d2 + 1) -
                 1.0 / (x + y + dia_cnt);
        }
    }
  ans *= 2;
  for (int i = 1; i <= dia_cnt; i++) dfs3(dia[i], 0, dia[i]);
  printf("%.8lf\n", ans);
  return 0;
}
