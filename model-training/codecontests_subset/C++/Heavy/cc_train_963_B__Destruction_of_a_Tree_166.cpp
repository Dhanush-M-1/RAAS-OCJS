#include <bits/stdc++.h>
using namespace std;
const int maxn = int(2e5) + 5;
int dp[maxn][2], memoi[maxn][2];
vector<int> graph[maxn];
void dfs(int node) {
  for (auto it : graph[node]) dfs(it);
  for (int p = 0; p < 2; p++) {
    int cnt0 = 0, cnt1 = 0, cnt01 = 0;
    for (auto it : graph[node]) {
      if (dp[it][0] && dp[it][1])
        cnt01++;
      else if (dp[it][0])
        cnt0++;
      else if (dp[it][1])
        cnt1++;
      else {
        dp[node][p] = 0;
        continue;
      }
    }
    for (int i = 0; i <= cnt01; i++) {
      int v = int(graph[node].size()) + 1 - (!p) - cnt1 - i;
      if (v % 2 == 0) dp[node][p] = 1, memoi[node][p] = i;
    }
  }
}
void dfs2(int node, int p) {
  vector<int> cnt0, cnt1, cnt01;
  for (auto it : graph[node]) {
    if (dp[it][0] && dp[it][1])
      cnt01.push_back(it);
    else if (dp[it][0])
      cnt0.push_back(it);
    else if (dp[it][1])
      cnt1.push_back(it);
  }
  for (auto it : cnt1) dfs2(it, 1);
  for (int i = 0; i < memoi[node][p]; i++) dfs2(cnt01[i], 1);
  printf("%d\n", node + 1);
  for (auto it : cnt0) dfs2(it, 0);
}
int main(void) {
  int n, p, root = -1;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d", &p);
    p--;
    if (p == -1)
      root = i;
    else
      graph[p].push_back(i);
  }
  dfs(root);
  if (dp[root][0]) {
    printf("YES\n");
    dfs2(root, 0);
  } else
    printf("NO\n");
}
