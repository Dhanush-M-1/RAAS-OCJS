#include <bits/stdc++.h>
using namespace std;
struct road {
  int x, next;
} r[3005 * 2];
int N, M;
double ans;
int fa[3005], flag;
int st[3005], w, vis[3005], pr[3005];
int deep[3005], lca[3005][3005], rt[3005];
int loop[3005], num[3005], cnt;
int stk[3005], top;
int find(int x) {
  if (fa[x] == x) return x;
  return fa[x] = find(fa[x]);
}
void add(int x, int y) {
  r[++w].x = y, r[w].next = st[x];
  st[x] = w;
}
void Find_loop(int x, int fr) {
  int i, j, tmp;
  stk[++top] = x, vis[x] = 1;
  for (i = st[x]; i; i = r[i].next) {
    tmp = r[i].x;
    if (tmp == fr) continue;
    if (vis[tmp])
      if (!num[tmp]) {
        for (j = top; j && stk[j + 1] != tmp; j--)
          loop[++cnt] = stk[j], num[stk[j]] = cnt;
      } else
        ;
    else
      Find_loop(tmp, x);
  }
  top--;
}
void Dfs(int x, int fr) {
  int i, tmp;
  deep[x] = deep[fr] + 1, pr[x] = fr;
  for (i = st[x]; i; i = r[i].next) {
    tmp = r[i].x;
    if (tmp == fr || num[tmp]) continue;
    Dfs(tmp, x);
  }
  rt[x] = flag;
  for (i = 1; i <= N; i++)
    if (rt[i] == rt[x])
      lca[i][x] = lca[x][i] = ((find(i) == x) ? x : pr[find(i)]);
  for (i = st[x]; i; i = r[i].next) {
    tmp = r[i].x;
    if (tmp == fr || num[tmp]) continue;
    fa[find(tmp)] = x;
  }
}
int main() {
  int i, j;
  int fr, to;
  double tmp, tt, all;
  scanf("%d", &N);
  for (i = 1; i <= N; i++) {
    fa[i] = i;
    scanf("%d %d", &fr, &to);
    fr++, to++;
    add(fr, to), add(to, fr);
  }
  Find_loop(1, 0);
  for (i = 1; i <= cnt; i++) flag = loop[i], Dfs(loop[i], 0);
  for (i = 1; i <= N; i++)
    for (j = 1; j <= N; j++) {
      if (rt[i] == rt[j])
        ans += 1.0 / (deep[i] + deep[j] - deep[lca[i][j]] * 2 + 1);
      else {
        fr = num[rt[i]], to = num[rt[j]];
        tmp = deep[i] + deep[j];
        tt = abs(fr - to) + 1;
        all = tmp + cnt - 2;
        ans += 1;
        ans -= (tmp - 1) / (double)all;
        ans -= ((tt - 2) / all) * ((tmp + cnt - tt - 1) / (tmp + cnt - tt));
        ans -= ((cnt - tt) / all) * ((tmp + tt - 3) / (tmp + tt - 2));
      }
    }
  printf("%.10lf\n", ans);
  return 0;
}
