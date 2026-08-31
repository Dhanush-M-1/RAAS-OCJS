#include <bits/stdc++.h>
using namespace std;
const int MAX = 1e5 + 10;
bool vis[MAX];
vector<int> g[MAX];
map<pair<int, int>, bool> M;
void DFS(int v, int par) {
  vis[v] = 1;
  int last = -1;
  for (int i = 0; i < (int)g[v].size(); i++) {
    int u = g[v][i];
    if (!vis[u]) DFS(u, v);
    if (M[make_pair(v, u)] == 1 && u != par) {
      if (last == -1)
        last = u;
      else {
        M[make_pair(v, u)] = M[make_pair(u, v)] = 0;
        M[make_pair(v, last)] = M[make_pair(last, v)] = 0;
        printf("%d %d %d\n", u, v, last);
        last = -1;
      }
    }
  }
  if (last != -1) {
    M[make_pair(v, par)] = M[make_pair(par, v)] = 0;
    M[make_pair(v, last)] = M[make_pair(last, v)] = 0;
    printf("%d %d %d\n", par, v, last);
  }
}
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  int sum = 0;
  while (m--) {
    int a, b;
    scanf("%d%d", &a, &b);
    sum++;
    g[a].push_back(b);
    g[b].push_back(a);
    M[make_pair(a, b)] = 1;
    M[make_pair(b, a)] = 1;
  }
  if (sum % 2 == 0) {
    DFS(1, -1);
  } else
    printf("No solution\n");
}
