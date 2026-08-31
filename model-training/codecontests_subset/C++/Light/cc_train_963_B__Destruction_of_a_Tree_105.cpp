#include <bits/stdc++.h>
using namespace std;
vector<vector<int>> vt;
vector<int> dap;
int degree[200010];
int visited[200010];
int n;
void solve(int here) {
  visited[here] = 1;
  dap.push_back(here);
  for (int i = 0; i < vt[here].size(); i++) {
    int next = vt[here][i];
    if (!visited[next]) solve(next);
  }
}
void dfs(int here, int par) {
  for (int i = 0; i < vt[here].size(); i++) {
    dfs(vt[here][i], here);
  }
  if (degree[here] % 2 == 0) {
    degree[par]--;
    solve(here);
  }
}
int main() {
  scanf("%d", &n);
  vt.resize(n + 1);
  int ch = 0;
  for (int i = 1; i <= n; i++) {
    int q;
    scanf("%d", &q);
    if (q == 0) {
      ch = i;
      continue;
    }
    vt[q].push_back(i);
    degree[q]++;
    degree[i]++;
  }
  if (n % 2 == 0) {
    puts("NO");
  } else {
    puts("YES");
    dfs(ch, 0);
    for (int i = 0; i < dap.size(); i++) printf("%d\n", dap[i]);
  }
}
