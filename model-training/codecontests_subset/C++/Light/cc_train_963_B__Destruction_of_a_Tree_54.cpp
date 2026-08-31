#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 10;
vector<int> G[N];
stack<int> S;
int in[N];
int pre[N];
int fa[N];
int dfss;
void dfs(int u, int fas) {
  pre[u] = dfss++;
  fa[u] = fas;
  for (int i = 0; i < G[u].size(); i++) {
    int v = G[u][i];
    if (v == fas) continue;
    dfs(v, u);
  }
  if (in[u] % 2 == 1) S.push(u);
  if (in[u] % 2 == 0) {
    printf("%d\n", u);
    in[fa[u]]--;
    while (!S.empty()) {
      int s = S.top();
      if (pre[s] < pre[u]) break;
      S.pop();
      printf("%d\n", s);
      in[fa[s]]--;
    }
  }
}
int main() {
  int n;
  scanf("%d", &n);
  int x;
  dfss = 0;
  memset(in, 0, sizeof(in));
  for (int i = 1; i <= n; i++) {
    scanf("%d", &x);
    if (x == 0) continue;
    in[x]++;
    in[i]++;
    G[i].push_back(x);
    G[x].push_back(i);
  }
  if (n % 2 == 0) {
    puts("NO");
    return 0;
  }
  printf("YES\n");
  dfs(1, 0);
  return 0;
}
