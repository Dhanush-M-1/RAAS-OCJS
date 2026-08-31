#include <bits/stdc++.h>
using namespace std;
int n;
struct edge {
  int v;
  int next;
  edge() {}
  edge(int v, int next) : v(v), next(next) {}
} e[6004];
int ind[3004];
bool vzt[3004];
int stk[3004];
int top, newedge;
int circle_len;
bool oncircle[3004];
int d[3];
int path_on_circle;
double ans;
void addedge(int u, int v) {
  e[++newedge] = edge(v, ind[u]);
  ind[u] = newedge;
}
void findcircle(int u, int fa) {
  vzt[u] = true;
  stk[++top] = u;
  for (int i = ind[u]; i; i = e[i].next) {
    if (circle_len) return;
    int v = e[i].v;
    if (v == fa) continue;
    if (vzt[v]) {
      while (stk[top + 1] != v) {
        oncircle[stk[top--]] = true;
        circle_len++;
      }
    } else
      findcircle(v, u);
  }
  if (top > 0) top--;
}
void dfs(int u, int flag) {
  if (flag == 0 && oncircle[u]) flag = 1;
  if (flag == 1 && !oncircle[u]) flag = 2;
  d[flag]++;
  vzt[u] = true;
  if (flag == 0 || d[1] == 1)
    ans += 1.0 / (d[0] + d[1] + d[2]);
  else
    ans += 1.0 / (d[0] + d[1] + d[2]) +
           1.0 / (d[0] + circle_len + 2 - d[1] + d[2]) -
           1.0 / (d[0] + circle_len + d[2]);
  for (int i = ind[u]; i; i = e[i].next) {
    int v = e[i].v;
    if (!vzt[v]) dfs(v, flag);
  }
  d[flag]--;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int u, v;
    scanf("%d%d", &u, &v);
    u++, v++;
    addedge(u, v);
    addedge(v, u);
  }
  findcircle(1, -1);
  for (int i = 1; i <= n; i++) {
    memset(vzt, 0, sizeof(vzt));
    memset(d, 0, sizeof(d));
    dfs(i, 0);
  }
  printf("%lf", ans);
}
