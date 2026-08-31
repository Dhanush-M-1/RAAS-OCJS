#include <bits/stdc++.h>
using namespace std;
int edge[100000 + 10], first[100000 + 10], nxt[100000 + 10 << 1];
bool v[100000 + 10];
int mark[100000 + 10], vv[100000 + 10 << 1];
void dfs(int n, int fa) {
  v[n] = 1;
  for (int e = first[n]; e; e = nxt[e])
    if (vv[e] != fa && !v[vv[e]]) dfs(vv[e], n);
  int top = 0;
  for (int e = first[n]; e; e = nxt[e])
    if (vv[e] != fa && mark[vv[e]] != 1) edge[top++] = vv[e];
  if (top & 1)
    edge[top++] = fa, mark[n] = 1;
  else
    mark[n] = 2;
  for (int i = 0; i < top; i += 2) {
    printf("%d %d %d\n", edge[i], n, edge[i + 1]);
    if (mark[edge[i]] == 2) mark[edge[i]] = 1;
    if (mark[edge[i + 1]] == 2) mark[edge[i + 1]] = 1;
  }
}
int main(void) {
  int e = 1;
  int n, m;
  scanf("%d %d", &n, &m);
  for (int i = 0; i < m; i++) {
    int u, v;
    scanf("%d%d", &u, &v);
    nxt[e] = first[u], vv[e] = v;
    first[u] = e++;
    nxt[e] = first[v], vv[e] = u;
    first[v] = e++;
  }
  if (m & 1)
    printf("No solution\n");
  else
    dfs(1, 0);
  return 0;
}
