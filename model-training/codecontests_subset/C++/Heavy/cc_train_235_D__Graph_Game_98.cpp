#include <bits/stdc++.h>
const int sz = 3010;
int vi[sz], low[sz], t;
int sta[sz], top = 0;
int con[sz], cir[sz];
std::vector<int> edge[sz], ed[sz];
void dfs(int x, int p) {
  vi[x] = low[x] = ++t;
  sta[top++] = x;
  for (int k = 0; k < edge[x].size(); k++) {
    int y = edge[x][k];
    if (!vi[y]) dfs(y, x);
    if (y != p) low[x] = std::min(low[x], low[y]);
  }
  if (vi[x] == low[x]) {
    int y;
    do {
      y = sta[--top];
      con[y] = x;
    } while (x != y);
  }
  return;
}
bool in[sz];
int fi[sz], d[sz], dd[sz], cd[sz], fa[sz];
void DFS(int x, int ff) {
  vi[x] = 1;
  fa[x] = ff;
  for (int k = 0; k < edge[x].size(); k++) {
    int y = edge[x][k];
    if (in[y] || vi[y]) continue;
    vi[y] = 1;
    d[y] = d[x] + 1;
    DFS(y, ff);
  }
  return;
}
void cir_dfs(int x) {
  vi[x] = 1;
  for (int k = 0; k < edge[x].size(); k++) {
    int y = edge[x][k];
    if ((!in[y]) || vi[y]) continue;
    cd[y] = cd[x] + 1;
    cir_dfs(y);
  }
  return;
}
double ans;
void find_dfs(int x) {
  vi[x] = 1;
  ans += 1 / (double)(dd[x] + 1);
  for (int k = 0; k < edge[x].size(); k++) {
    int y = edge[x][k];
    if (vi[y] || fa[x] != fa[y]) continue;
    dd[y] = dd[x] + 1;
    find_dfs(y);
  }
  return;
}
int main() {
  int n, k, a, b, num = 0, cir, i;
  scanf("%d", &n);
  for (k = 1; k <= n; k++) {
    scanf("%d%d", &a, &b);
    edge[a].push_back(b);
    edge[b].push_back(a);
  }
  dfs(0, 0);
  for (k = 0; k < n; k++) fi[con[k]]++;
  for (k = 0; k < n; k++) {
    if (fi[k] > 1) {
      cir = k;
      break;
    }
  }
  memset(vi, 0, sizeof(vi));
  for (k = 0; k < n; k++) {
    if (con[k] == cir) {
      in[k] = 1;
      num++;
    }
  }
  cir_dfs(cir);
  for (k = 0; k < n; k++) {
    if (con[k] == cir) {
      DFS(k, k);
    }
  }
  ans = 0;
  for (k = 0; k < n; k++) {
    memset(vi, 0, sizeof(vi));
    for (i = 0; i < n; i++) {
      if (fa[k] == fa[i]) continue;
      int c1, c2, d1, d2;
      d1 = d[k] + 1;
      d2 = d[i] + 1;
      c1 = abs(cd[fa[k]] - cd[fa[i]]) - 1;
      c2 = num - c1 - 2;
      int q = c1 + c2 + d1 + d2;
      ans += 1 / (double)q + (double)c1 / (double)q / (double)(q - c1) +
             (double)c2 / (double)q / (double)(q - c2);
    }
    dd[k] = 0;
    find_dfs(k);
  }
  printf("%.9f\n", ans);
}
