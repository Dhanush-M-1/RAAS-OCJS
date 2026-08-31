#include <bits/stdc++.h>
using namespace std;
const int maxN = 2e5 + 5;
vector<int> G[maxN];
vector<int> ans;
bool vis[maxN];
int n, root;
int nextInt() {
  int res = 0;
  char ch = getchar();
  for (; !isdigit(ch); ch = getchar())
    ;
  for (; isdigit(ch); ch = getchar()) {
    res = res * 10 + ch - 48;
  }
  return res;
}
void getAns(int u) {
  if (vis[u]) return;
  vis[u] = true;
  ans.push_back(u);
  for (auto v : G[u]) {
    getAns(v);
  }
}
int dfs(int u) {
  int res = u != root;
  for (auto v : G[u]) {
    res += dfs(v);
  }
  if (res & 1) return 1;
  getAns(u);
  return 0;
}
int main() {
  n = nextInt();
  for (int v = 1; v <= n; v++) {
    int u = nextInt();
    if (u == 0) root = v;
    G[u].push_back(v);
  }
  if (dfs(root))
    puts("NO");
  else {
    puts("YES");
    for (auto p : ans) {
      printf("%d\n", p);
    }
  }
  return 0;
}
