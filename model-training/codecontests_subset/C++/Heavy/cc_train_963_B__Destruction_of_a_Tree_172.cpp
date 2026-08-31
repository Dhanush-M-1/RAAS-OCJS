#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 10;
vector<int> G[N];
int vis[N], rt = 0;
void print(int x) {
  vis[x] = 1;
  printf("%d\n", x);
  for (int i = 0; i < G[x].size(); i++) {
    int v = G[x][i];
    if (!vis[v]) print(v);
  }
}
void DFS(int u, int fa) {
  int d = 0;
  for (int i = 0; i < G[u].size(); i++) {
    int v = G[u][i];
    if (!vis[v]) DFS(v, u);
  }
  for (int i = 0; i < G[u].size(); i++) {
    int v = G[u][i];
    if (!vis[v]) d++;
  }
  if (fa) d++;
  if (d % 2 == 0) {
    printf("%d\n", u);
    vis[u] = 1;
    for (int i = 0; i < G[u].size(); i++) {
      int v = G[u][i];
      if (!vis[v]) print(v);
    }
  }
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int fa;
    scanf("%d", &fa);
    if (!fa)
      rt = i;
    else
      G[fa].push_back(i);
  }
  if ((n & 1) == 0)
    printf("NO\n");
  else {
    printf("YES\n");
    DFS(rt, 0);
  }
  return 0;
}
