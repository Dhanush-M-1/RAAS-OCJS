#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 9;
int n, tr[N], de[N], cnt, ans[N], eid, p[N];
struct edge {
  int v, nxt;
} e[N << 1];
bool vis[N];
void add(int u, int v) {
  eid++, de[v]++;
  e[eid].v = v, e[eid].nxt = p[u], p[u] = eid;
}
void out(int u, int fa) {
  ans[++cnt] = u;
  int ccnt = cnt;
  vis[u] = true;
  for (int i = p[u]; i; i = e[i].nxt) {
    int v = e[i].v;
    if (v != fa && !vis[v]) out(v, u);
  }
}
void dfs(int u, int fa) {
  int child = 0;
  for (int i = p[u]; i; i = e[i].nxt) {
    int v = e[i].v;
    if (v != fa) dfs(v, u), child += (!vis[v]);
  }
  if (de[u] % 2 == 0 && !vis[u]) out(u, fa), de[fa]--;
}
int main() {
  scanf("%d", &n);
  int now, x;
  for (int i = (1); i <= (n); i++) {
    scanf("%d", &x);
    if (x == 0)
      now = i;
    else
      add(i, x), add(x, i);
  }
  dfs(now, 0);
  if (cnt != n)
    printf("NO");
  else {
    printf("YES\n");
    for (int i = (1); i <= (n); i++) printf("%d\n", ans[i]);
  }
  return 0;
}
