#include <bits/stdc++.h>
using namespace std;
double ans;
int d[3005], lp[3005], bl[3005], vst[3005], lc[3005][3005], dep[3005], cnt,
    fa[3005], pos[3005];
vector<int> son[3005];
queue<int> q;
void dfs(int now) {
  vst[lp[pos[now] = ++cnt] = now] = 2;
  for (int T, i = 0; i < son[now].size(); ++i)
    if (!vst[T = son[now][i]]) dfs(T);
}
void Dfs(int cc, int now, int fat) {
  bl[now] = cc;
  dep[now] = dep[fat] + 1;
  fa[now] = fat;
  for (int T, i = 0; i < son[now].size(); ++i)
    if ((T = son[now][i]) != fat && vst[T] == 1) Dfs(cc, T, now);
}
int solve(int x, int y) {
  if (lc[x][y]) return lc[x][y];
  if (dep[x] > dep[y])
    lc[x][y] = solve(fa[x], y);
  else
    lc[x][y] = solve(fa[y], x);
  return lc[x][y];
}
int n, i, x, y, T, j, Pos, f1, f2;
int main() {
  for (cin >> n, i = 1; i <= n; ++i)
    cin >> x >> y, son[++x].push_back(++y), son[y].push_back(x), ++d[x], ++d[y];
  for (i = 1; i <= n; lc[i][i] = i, ++i)
    if (d[i] == 1) q.push(i);
  while (q.size()) {
    x = q.front();
    q.pop();
    vst[x] = 1;
    for (i = 0; i < son[x].size(); ++i)
      if (!vst[T = son[x][i]] && (--d[T]) == 1) q.push(T);
  }
  for (i = 1; i <= n; ++i)
    if (!vst[i]) {
      dfs(i);
      break;
    }
  for (i = 1; i <= cnt; ++i) Dfs(i, lp[i], 0);
  for (i = 2; i <= n; ++i) {
    for (j = 1; j < i; ++j) {
      if (bl[i] == bl[j]) {
        Pos = dep[i] + dep[j] - (dep[solve(i, j)] << 1) + 1;
        ans += 2.0 / Pos;
      } else {
        Pos = dep[i] + dep[j];
        f1 = abs(bl[i] - bl[j]) - 1;
        f2 = cnt - f1 - 2;
        ans += 2.0 / (Pos + f1) + 2.0 / (Pos + f2) - 2.0 / (Pos + f1 + f2);
      }
    }
    ++ans;
  }
  printf("%.10lf", ans + 1);
}
