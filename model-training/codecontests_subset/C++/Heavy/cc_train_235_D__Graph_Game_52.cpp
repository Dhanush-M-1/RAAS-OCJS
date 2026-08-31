#include <bits/stdc++.h>
using namespace std;
int n;
double p[3010][3010];
vector<int> v[3010], cycle;
bool vis[3010], oncycle[3010];
int stk[3010], top = 0, dep[3010];
void dfs1(int np, int fath) {
  if (!cycle.empty()) return;
  vis[np] = 1;
  stk[++top] = np;
  for (int &x : v[np]) {
    if (x == fath) continue;
    if (vis[x] && !cycle.size()) {
      int p = top;
      while (stk[p] != x) {
        cycle.push_back(stk[p]);
        p--;
      }
      cycle.push_back(x);
    } else
      dfs1(x, np);
  }
  top--;
}
void dfs2(int np, int fath, int st, int dis) {
  p[st][np] = 1.0 / dis;
  for (int &x : v[np]) {
    if (x == fath) continue;
    if (oncycle[np] && oncycle[x]) continue;
    dfs2(x, np, st, dis + 1);
  }
}
vector<int> subt[3010];
void dfs3(int np, int fath, int st) {
  dep[np] = dep[fath] + 1;
  subt[st].push_back(np);
  for (int &x : v[np]) {
    if (x == fath) continue;
    if (oncycle[np] && oncycle[x]) continue;
    dfs3(x, np, st);
  }
}
int main() {
  scanf("%d", &n);
  for (int i = 1, ti, tj; i <= n; i++) {
    scanf("%d%d", &ti, &tj);
    ti++;
    tj++;
    v[ti].push_back(tj);
    v[tj].push_back(ti);
  }
  dfs1(1, 0);
  for (auto &x : cycle) oncycle[x] = 1;
  for (int i = 1; i <= n; i++) dfs2(i, 0, i, 1);
  for (auto &x : cycle) dfs3(x, 0, x);
  int ps = cycle.size();
  for (int i = 0; i < ps; i++) {
    for (int j = 0; j < ps; j++) {
      if (i != j) {
        int l1 = (i > j) ? (i - j - 1) : (j - i - 1);
        int l2 = ps - 2 - l1;
        for (int &x : subt[cycle[i]]) {
          for (int &y : subt[cycle[j]]) {
            int l3 = dep[x] + dep[y];
            p[x][y] = 1.0 / (l1 + l3) + 1.0 / (l2 + l3) - 1.0 / (l1 + l2 + l3);
          }
        }
      }
    }
  }
  double ans = 0;
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++) ans += p[i][j];
  printf("%.10lf\n", ans);
  return 0;
}
