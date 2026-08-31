#include <bits/stdc++.h>
using namespace std;
const int MAXN = 220000;
int vis[MAXN], ans[MAXN];
struct Edge {
  int u, v, nxt;
} e[MAXN << 1];
int e_cnt;
int head[MAXN];
void Add(int u, int v) {
  int id = ++e_cnt;
  e[id].u = u;
  e[id].v = v;
  e[id].nxt = head[u];
  head[u] = id;
}
void DFS2(int u, int fa) {
  ans[++ans[0]] = u;
  vis[u] = true;
  for (int id = head[u]; ~id; id = e[id].nxt) {
    int v = e[id].v;
    if (v == fa) continue;
    if (!vis[v]) DFS2(v, u);
  }
}
void DFS1(int u, int fa) {
  int siz = (u != 1);
  for (int id = head[u]; ~id; id = e[id].nxt) {
    int v = e[id].v;
    if (v == fa) continue;
    DFS1(v, u);
    if (!vis[v]) siz++;
  }
  if (siz % 2 == 0) DFS2(u, fa);
}
int main() {
  memset(head, -1, sizeof(head));
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    int j;
    scanf("%d", &j);
    if (j) Add(j, i), Add(i, j);
  }
  DFS1(1, 0);
  if (ans[0] == n) {
    printf("YES\n");
    for (int i = 1; i <= ans[0]; ++i) printf("%d\n", ans[i]);
  } else
    printf("NO\n");
  return 0;
}
