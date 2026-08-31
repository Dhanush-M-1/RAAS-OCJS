#include <bits/stdc++.h>
using namespace std;
const int MAXN = 100100;
int bio[MAXN];
vector<int> E[MAXN];
int dfs(int x, int dad) {
  bio[x] = 1;
  int unused = -1;
  for (int to : E[x]) {
    if (to == dad) continue;
    if (bio[to] == 0) {
      int t = dfs(to, x);
      if (t != -1)
        printf("%d %d %d\n", t + 1, to + 1, x + 1);
      else if (unused != -1) {
        printf("%d %d %d\n", unused + 1, x + 1, to + 1);
        unused = -1;
      } else
        unused = to;
    } else if (bio[to] == 1) {
      if (unused != -1) {
        printf("%d %d %d\n", unused + 1, x + 1, to + 1);
        unused = -1;
      } else
        unused = to;
    }
  }
  bio[x] = 2;
  return unused;
}
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  for (int i = 0; i < m; ++i) {
    int a, b;
    scanf("%d%d", &a, &b);
    --a;
    --b;
    E[a].push_back(b);
    E[b].push_back(a);
  }
  if (m & 1) return printf("No solution\n"), 0;
  dfs(0, -1);
  return 0;
}
