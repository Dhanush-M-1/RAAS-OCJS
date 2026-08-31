#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const long long INFL = 0x3f3f3f3f3f3f3f3fLL;
const double eps = 1e-8;
const double PI = acos(-1.0);
const int maxn = 1111;
vector<int> G[maxn];
int in[maxn], dp[maxn];
bool dp2[maxn];
int main() {
  memset(in, 0, sizeof(in));
  memset(dp, 0, sizeof(dp));
  int n, k;
  scanf("%d%d", &n, &k);
  for (int i = 1; i <= n; i++) {
    int x;
    scanf("%d", &x);
    if (x) {
      G[x].push_back(i);
      in[i]++;
    }
  }
  queue<int> Q;
  for (int i = 1; i <= n; i++) {
    if (in[i] == 0) {
      Q.push(i);
      dp[i] = 1;
    }
  }
  vector<int> arr;
  while (!Q.empty()) {
    int u = Q.front();
    Q.pop();
    for (int i = 0; i < (G[u].size()); i++) {
      int v = G[u][i];
      dp[v] = dp[u] + 1;
      in[v]--;
      if (in[v] == 0) {
        Q.push(v);
      }
    }
    if (G[u].size() == 0) {
      arr.push_back(dp[u]);
    }
  }
  int tmp = k;
  while (G[tmp].size() != 0) {
    tmp = G[tmp][0];
  }
  for (int i = 0; i < (arr.size()); i++)
    if (arr[i] == dp[tmp]) {
      arr.erase(arr.begin() + i);
      break;
    }
  memset(dp2, 0, sizeof(dp2));
  dp2[0] = 1;
  for (int i = 0; i < arr.size(); i++) {
    for (int j = maxn - 1; j >= arr[i]; j--) {
      dp2[j] = dp2[j] | dp2[j - arr[i]];
    }
  }
  vector<int> ans;
  for (int i = 0; i < maxn; i++) {
    if (dp2[i]) ans.push_back(i + dp[k]);
  }
  for (int i = 0; i < (ans.size()); i++) printf("%d\n", ans[i]);
  return 0;
}
