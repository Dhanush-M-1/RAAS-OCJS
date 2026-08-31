#include <bits/stdc++.h>
using namespace std;
vector<int> E[200005];
int deg[200005];
bool dele[200005];
int n;
void del(int u) {
  deg[u] = 0;
  dele[u] = 1;
  printf("%d\n", u);
  for (int i = 0; i < E[u].size(); i++) {
    if (deg[E[u][i]] != 0) deg[E[u][i]]--;
  }
  return;
}
void destroy(int fa, int u) {
  del(u);
  for (int i = 0; i < E[u].size(); i++) {
    if (E[u][i] != fa && dele[E[u][i]] == 0) {
      destroy(u, E[u][i]);
    }
  }
  return;
}
void dfs(int fa, int u) {
  for (int i = 0; i < E[u].size(); i++) {
    if (E[u][i] != fa) {
      dfs(u, E[u][i]);
    }
  }
  if (deg[u] % 2 == 0 && dele[u] == 0) {
    destroy(fa, u);
  }
  return;
}
int main() {
  scanf("%d", &n);
  if (n % 2 == 0) {
    printf("NO\n");
    return 0;
  }
  printf("YES\n");
  for (int i = 1; i <= n; i++) {
    int g;
    scanf("%d", &g);
    if (g) {
      E[g].push_back(i);
      E[i].push_back(g);
      deg[g]++;
      deg[i]++;
    }
  }
  dfs(0, 1);
  return 0;
}
