#include <bits/stdc++.h>
using namespace std;
const int N = 3003;
int n, L, top, cir[N], stk[N], cnt[N], bel[N], dep[N], fa[N];
double ans;
vector<int> nxt[N];
void dfs(int u, int lst) {
  dep[u] = dep[lst] + 1, fa[u] = lst;
  for (auto v : nxt[u])
    if (v != lst) {
      if (!dep[v])
        dfs(v, u);
      else if (dep[v] < dep[u]) {
        int now = u;
        cir[++L] = now;
        do {
          now = fa[now], cir[++L] = now;
        } while (now != v);
      }
    }
}
void get(int u) {
  stk[++top] = u;
  for (auto v : nxt[u])
    if (!bel[v]) bel[v] = bel[u], get(v);
}
void DFS(int u, int lst) {
  dep[u] = dep[lst] + 1;
  for (auto v : nxt[u])
    if (bel[v] == bel[u] && v != lst) DFS(v, u);
}
int main() {
  cin >> n;
  for (int i = 1; i <= n; ++i) {
    int p, q;
    cin >> p >> q;
    ++p, ++q;
    nxt[p].push_back(q);
    nxt[q].push_back(p);
  }
  dfs(1, 0);
  for (int i = 1; i <= L; ++i) bel[cir[i]] = i;
  for (int i = 1; i <= L; ++i) {
    top = 0;
    get(cir[i]);
    for (int j = 1; j <= top; ++j) {
      DFS(stk[j], 0);
      for (int k = 1; k <= top; ++k) ++cnt[dep[stk[k]]];
    }
    DFS(cir[i], 0);
  }
  for (int i = 1; i <= n; ++i) ans += 1 / (double)i * cnt[i];
  for (int i = 1; i <= n; ++i)
    for (int j = 1; j <= n; ++j)
      if (bel[i] != bel[j]) {
        int x = abs(bel[i] - bel[j]) - 1, y = L - 2 - x;
        ans += 1 / (double)(dep[i] + dep[j] + x) +
               1 / (double)(dep[i] + dep[j] + y) -
               1 / (double)(dep[i] + dep[j] + x + y);
      }
  printf("%.10lf", ans);
  return 0;
}
