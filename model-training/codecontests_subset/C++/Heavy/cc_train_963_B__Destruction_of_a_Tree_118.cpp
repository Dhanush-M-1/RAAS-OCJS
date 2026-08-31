#include <bits/stdc++.h>
using namespace std;
vector<int> g[200100];
int sz[200100], root;
bool vist[200100];
void delSubtree(int u) {
  vist[u] = true;
  printf("%d\n", u);
  for (auto v : g[u])
    if (!vist[v]) delSubtree(v);
}
void DFS(int u, int p) {
  int degree = 0;
  for (auto v : g[u]) {
    if (v == p) continue;
    DFS(v, u);
    if (!vist[v]) degree++;
  }
  if (u != root) degree++;
  if (!(degree & 1)) delSubtree(u);
}
int main() {
  int n, u;
  scanf("%d", &n);
  for (int v = 1; v <= n; v++) {
    scanf("%d", &u);
    if (u)
      g[u].push_back(v);
    else
      root = v;
  }
  if (n & 1)
    printf("YES\n"), DFS(root, 0);
  else
    printf("NO");
  return 0;
}
