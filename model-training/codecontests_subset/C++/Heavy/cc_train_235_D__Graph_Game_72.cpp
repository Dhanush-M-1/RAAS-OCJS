#include <bits/stdc++.h>
using namespace std;
const int M = 3005;
vector<int> eg[M];
int n;
int fa[M], cnt[M], sz[M];
int getfa(int x) {
  if (fa[x] == x) return x;
  return fa[x] = getfa(fa[x]);
}
double ans;
int pl[M], psz;
int mark[M], TIM;
void dfs_jih_pre(int x) {
  pl[psz++] = x;
  mark[x] = TIM;
  for (int i = 0, up = eg[x].size(); i < up; i++)
    if (mark[eg[x][i]] != TIM) dfs_jih_pre(eg[x][i]);
}
vector<int> ps;
void dfs_huan(int x) {
  ps.push_back(x);
  mark[x] = TIM;
  for (int i = 0, up = eg[x].size(); i < up; i++)
    if (mark[eg[x][i]] != TIM) dfs_huan(eg[x][i]);
}
vector<int> son[M];
int now;
void dfs_jih(int x, int f, int d) {
  pl[psz++] = x;
  son[now].push_back(d);
  for (int i = 0, up = eg[x].size(); i < up; i++)
    if (eg[x][i] != f && mark[eg[x][i]] != TIM) dfs_jih(eg[x][i], x, d + 1);
}
void dfs_jih_tre_calc(int x, int f, int d) {
  if (d != 1) ans += 1.0 / d;
  for (int i = 0, up = eg[x].size(); i < up; i++)
    if (eg[x][i] != f && (mark[eg[x][i]] != TIM || eg[x][i] == now))
      dfs_jih_tre_calc(eg[x][i], x, d + 1);
}
void calc_jih(int x) {
  TIM++;
  psz = 0;
  dfs_jih_pre(x);
  static int deg[M], q[M], L, R;
  L = R = 0;
  for (int w = 0; w < psz; w++)
    for (int x = pl[w], i = 0, up = eg[x].size(); i < up; i++) deg[eg[x][i]]++;
  for (int w = 0; w < psz; w++)
    if (deg[pl[w]] == 1) q[R++] = pl[w];
  TIM++;
  while (L < R) {
    static int x;
    x = q[L++];
    mark[x] = TIM;
    for (int i = 0, up = eg[x].size(); i < up; i++)
      if (deg[eg[x][i]]-- == 2) q[R++] = eg[x][i];
  }
  ps.clear();
  for (int w = 0; w < psz; w++)
    if (mark[pl[w]] != TIM) {
      dfs_huan(pl[w]);
      break;
    }
  TIM++;
  for (int i = 0, up = ps.size(); i < up; i++) mark[ps[i]] = TIM;
  for (int i = 0, up = ps.size(); i < up; i++) {
    now = ps[i];
    psz = 0;
    dfs_jih(now, now, 1);
    for (int j = 0; j < psz; j++) dfs_jih_tre_calc(pl[j], pl[j], 1);
  }
  for (int i = 0, up = ps.size(); i < up; i++)
    for (int j = i + 1; j < up; j++) {
      int a = ps[i], b = ps[j], c = j - i - 1, d = up - c - 2;
      for (int l = 0, upa = son[a].size(); l < upa; l++)
        for (int p = 0, upb = son[b].size(); p < upb; p++)
          ans += 2.0 * (1.0 / (son[a][l] + son[b][p] + c) +
                        1.0 / (son[a][l] + son[b][p] + d) -
                        1.0 / (son[a][l] + son[b][p] + c + d));
    }
}
void dfs_tre_pre(int x, int f) {
  pl[psz++] = x;
  for (int i = 0, up = eg[x].size(); i < up; i++)
    if (eg[x][i] != f) dfs_tre_pre(eg[x][i], x);
}
void dfs_tre_calc(int x, int f, int d) {
  if (d != 1) ans += 1.0 / d;
  for (int i = 0, up = eg[x].size(); i < up; i++)
    if (eg[x][i] != f) dfs_tre_calc(eg[x][i], x, d + 1);
}
void calc_tre(int x) {
  psz = 0;
  dfs_tre_pre(x, x);
  for (int i = 0; i < psz; i++) dfs_tre_calc(pl[i], pl[i], 1);
}
int main() {
  scanf("%d", &n);
  ans = n;
  for (int i = 1; i <= n; i++) fa[i] = i, sz[i] = 1;
  for (int i = 1, x, y, faa, fab; i <= n; i++) {
    scanf("%d %d", &x, &y);
    x++, y++;
    eg[x].push_back(y);
    eg[y].push_back(x);
    faa = getfa(x);
    fab = getfa(y);
    if (faa != fab) {
      fa[faa] = fab;
      cnt[fab] += cnt[faa] + 1;
      sz[fab] += sz[faa];
    } else
      cnt[faa]++;
  }
  for (int i = 1; i <= n; i++)
    if (getfa(i) == i) {
      if (cnt[i] == sz[i])
        calc_jih(i);
      else
        calc_tre(i);
    }
  printf("%.15f\n", ans);
  return 0;
}
