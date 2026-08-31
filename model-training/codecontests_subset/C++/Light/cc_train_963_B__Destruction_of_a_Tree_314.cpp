#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5, INF = 1e9 + 7;
int rd() {
  char ch = getchar();
  int ret = 0;
  while (ch < '0' || ch > '9') ch = getchar();
  while (ch >= '0' && ch <= '9') ret = ret * 10 + ch - '0', ch = getchar();
  return ret;
}
int n, lat[N];
struct Edge {
  int v, nxt;
} e[N << 1];
int hd[N], cnt;
void addedge(int u, int v) {
  e[++cnt] = (Edge){v, hd[u]};
  hd[u] = cnt;
}
void dfs(int u, int fat = 0) {
  int sum = (fat != 0);
  for (int i = hd[u]; i; i = e[i].nxt)
    if (e[i].v != fat) dfs(e[i].v, u), sum += lat[e[i].v];
  lat[u] = sum & 1;
}
void print(int u, int fat = 0) {
  for (int i = hd[u]; i; i = e[i].nxt)
    if (e[i].v != fat && !lat[e[i].v]) print(e[i].v, u);
  printf("%d\n", u);
  for (int i = hd[u]; i; i = e[i].nxt)
    if (e[i].v != fat && lat[e[i].v]) print(e[i].v, u);
}
int main() {
  int n = rd();
  for (int i = 1; i <= n; i++) {
    int p = rd();
    if (p) addedge(i, p), addedge(p, i);
  }
  dfs(1);
  if (!lat[1]) {
    puts("YES");
    print(1, 0);
    puts("");
  } else
    puts("NO");
  return 0;
}
