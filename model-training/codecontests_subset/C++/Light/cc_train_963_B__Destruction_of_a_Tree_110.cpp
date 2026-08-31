#include <bits/stdc++.h>
using namespace std;
const int maxn = 200005;
int u[maxn], par[maxn];
bool vis[maxn];
vector<int> rode[maxn];
stack<int> P;
queue<int> Q;
void dfs(int v, int pre) {
  P.push(v);
  par[v] = pre;
  for (int i = 0; i < rode[v].size(); i++) {
    if (rode[v][i] == pre) continue;
    dfs(rode[v][i], v);
  }
}
void dfs2(int x) {
  Q.push(x);
  vis[x] = 1;
  for (int i = 0; i < rode[x].size(); i++) {
    int to = rode[x][i];
    u[to]--;
    if (to == par[x] || vis[to]) continue;
    if (u[to] % 2 == 0) dfs2(to);
  }
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int x;
    scanf("%d", &x);
    if (x) {
      rode[i].push_back(x), rode[x].push_back(i);
      u[i]++, u[x]++;
    }
  }
  dfs(1, 0);
  while (!P.empty()) {
    int x = P.top();
    P.pop();
    if (u[x] % 2 == 0) dfs2(x);
  }
  if (Q.size() == n) {
    printf("YES\n");
    while (!Q.empty()) {
      printf("%d\n", Q.front());
      Q.pop();
    }
  } else
    printf("NO\n");
  return 0;
}
