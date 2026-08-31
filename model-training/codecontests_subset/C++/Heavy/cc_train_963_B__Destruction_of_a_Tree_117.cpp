#include <bits/stdc++.h>
using namespace std;
vector<int> edge[200000 + 5];
vector<int> sol;
bool dp[200000 + 5];
bool dfs(int idx, int p = -1) {
  vector<int> D, ND;
  for (auto x : edge[idx])
    if (x != p) {
      if (dfs(x, idx))
        ND.push_back(x);
      else
        D.push_back(x);
    }
  if (ND.empty() && D.empty()) return dp[idx] = true;
  if (ND.size() & 1) return dp[idx] = false;
  return dp[idx] = true;
}
void backT(int idx, int p = -1) {
  for (auto x : edge[idx])
    if (x != p) {
      if (!dp[x]) {
        backT(x, idx);
      }
    }
  sol.push_back(idx);
  for (auto x : edge[idx])
    if (x != p) {
      if (dp[x]) {
        backT(x, idx);
      }
    }
}
int main() {
  int i, n, p;
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    scanf("%d", &p);
    if (p) {
      edge[p].push_back(i);
      edge[i].push_back(p);
    }
  }
  if (dfs(1)) {
    puts("YES");
    backT(1);
    for (auto x : sol) printf("%d\n", x);
  } else
    puts("NO");
  return 0;
}
