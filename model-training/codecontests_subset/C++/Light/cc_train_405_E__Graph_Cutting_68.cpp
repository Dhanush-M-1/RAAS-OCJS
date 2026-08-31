#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e5 + 100;
vector<int> V[MAXN];
int N, M;
int pass[MAXN], instack[MAXN];
vector<int> atdep[MAXN], extra[MAXN];
void dfs(int u, int parr, int dep) {
  pass[u] = true;
  instack[u] = true;
  atdep[dep].push_back(u);
  for (int i = 0; i < V[u].size(); i++) {
    if (instack[V[u][i]]) extra[u].push_back(V[u][i]);
    if (V[u][i] != parr && !pass[V[u][i]]) dfs(V[u][i], u, dep + 1);
  }
  instack[u] = false;
}
int main() {
  scanf("%d %d", &N, &M);
  if (M % 2 == 1) {
    printf("No solution\n");
    return 0;
  }
  for (int i = 1; i <= M; i++) {
    int a, b;
    scanf("%d %d", &a, &b);
    V[a].push_back(b);
    V[b].push_back(a);
  }
  dfs(1, -1, 0);
  for (int dep = N - 1; dep >= 0; dep--) {
    for (int i = 0; i < atdep[dep].size(); i++) {
      while (extra[atdep[dep][i]].size() >= 2) {
        int x = extra[atdep[dep][i]].back();
        extra[atdep[dep][i]].pop_back();
        int y = extra[atdep[dep][i]].back();
        extra[atdep[dep][i]].pop_back();
        printf("%d %d %d\n", x, atdep[dep][i], y);
      }
      if (!extra[atdep[dep][i]].empty()) {
        int x = extra[atdep[dep][i]].back();
        extra[atdep[dep][i]].pop_back();
        extra[x].push_back(atdep[dep][i]);
      }
    }
  }
  return 0;
}
