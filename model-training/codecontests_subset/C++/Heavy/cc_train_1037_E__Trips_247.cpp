#include <bits/stdc++.h>
struct pnt {
  int hd;
  int ind;
  bool ded;
} p[1000000];
struct ent {
  int twd;
  int lst;
} e[1000000];
int cnt;
int n, m, k;
int lft;
int ans[1000000];
int u[1000000], v[1000000];
void ade(int f, int t) {
  cnt++;
  e[cnt].twd = t;
  e[cnt].lst = p[f].hd;
  p[f].hd = cnt;
  p[f].ind++;
  return;
}
void Delete(int x) {
  if (p[x].ded) return;
  p[x].ded = true;
  lft--;
  for (int i = p[x].hd; i; i = e[i].lst) {
    int to = e[i].twd;
    p[to].ind--;
    if (p[to].ind < k) Delete(to);
  }
  return;
}
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1; i <= m; i++) {
    scanf("%d%d", &u[i], &v[i]);
    ade(u[i], v[i]);
    ade(v[i], u[i]);
  }
  lft = n;
  for (int i = 1; i <= n; i++) {
    if (p[i].ind < k) {
      Delete(i);
    }
  }
  for (int i = m; i; i--) {
    ans[i] = lft;
    p[u[i]].hd = e[p[u[i]].hd].lst;
    p[v[i]].hd = e[p[v[i]].hd].lst;
    if (!p[v[i]].ded) p[u[i]].ind--;
    if (!p[u[i]].ded) p[v[i]].ind--;
    if (p[v[i]].ind < k) Delete(v[i]);
    if (p[u[i]].ind < k) Delete(u[i]);
  }
  for (int i = 1; i <= m; i++) printf("%d\n", ans[i]);
  return 0;
}
