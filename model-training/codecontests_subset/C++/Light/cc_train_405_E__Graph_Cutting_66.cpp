#include <bits/stdc++.h>
using namespace std;
vector<pair<int, int> > adjlist[100005];
int num[100005];
bool visited[100005];
int n, m, u, v, d;
int dfs(int u) {
  int c1 = -1, c2 = 0;
  for (int i = 0; i < adjlist[u].size(); i++) {
    pair<int, int> next = adjlist[u][i];
    if (visited[next.second]) continue;
    visited[next.second] = 1;
    int res = dfs(next.first);
    if (res > -1) {
      printf("%d %d %d\n", res + 1, next.first + 1, u + 1);
    } else {
      if (c2 == 0) {
        c1 = next.first;
        c2 = 1;
      } else {
        printf("%d %d %d\n", next.first + 1, u + 1, c1 + 1);
        c2 = 0;
      }
    }
  }
  if (c2 == 0) return -1;
  return c1;
}
int main() {
  scanf("%d %d", &n, &m);
  for (int i = 0; i < n; i++) visited[i] = false;
  for (int i = 0; i < m; i++) {
    int u, v;
    scanf("%d %d", &u, &v);
    u--;
    v--;
    adjlist[u].push_back(pair<int, int>(v, i));
    adjlist[v].push_back(pair<int, int>(u, i));
  }
  if (m % 2) {
    printf("No solution\n");
    return 0;
  }
  dfs(0);
}
