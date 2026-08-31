#include <bits/stdc++.h>
using namespace std;
int n, k;
vector<int> child[1000001];
int dep[1000001];
int mnc[1000001];
void dfs(int x) {
  mnc[x] = 9 * n;
  if (child[x].empty()) mnc[x] = dep[x];
  for (int i : child[x]) {
    dep[i] = dep[x] + 1;
    dfs(i);
    mnc[x] = min(mnc[x], mnc[i]);
  }
}
int dp1[1000001];
int dp2[1000001];
void dfs2(int x) {
  if (child[x].empty()) {
    dp1[x] = 1;
    dp2[x] = 1;
  } else {
    int sum = 0, mx = 0;
    for (int i : child[x]) {
      dfs2(i);
      sum += dp1[i];
      mx = max(mx, dp2[i] - dp1[i]);
    }
    dp1[x] = mnc[x] - k < dep[x] ? sum : 0;
    dp2[x] = sum + mx;
  }
}
int main() {
  scanf("%d%d", &n, &k);
  for (int i = 2; i <= n; ++i) {
    int p;
    scanf("%d", &p);
    child[p].push_back(i);
  }
  dfs(1);
  dfs2(1);
  printf("%d\n", dp2[1]);
  return 0;
}
