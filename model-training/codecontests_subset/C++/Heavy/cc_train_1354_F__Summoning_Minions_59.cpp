#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const long long INFLL = 1e18;
const int MOD = 1e9 + 7;
const int MAXN = 2e5 + 5;
tuple<int, int, int> minions[111];
bool picked[111];
long long dp[111][111];
int n, k;
vector<int> ans;
void mxze(long long &a, long long b) { a = max(a, b); }
long long solve(int i, int j) {
  if (i == n) return 0;
  if (dp[i][j] != -1) return dp[i][j];
  long long ret = 0;
  auto [b, a, id] = minions[i];
  if (j < k) mxze(ret, b * j + a + solve(i + 1, j + 1));
  if (n - i > k - j) mxze(ret, b * (k - 1) + solve(i + 1, j));
  return dp[i][j] = ret;
}
int main() {
  int t;
  scanf("%d", &t);
  while (t--) {
    memset(dp, -1, sizeof(dp));
    memset(picked, false, sizeof(picked));
    ans.clear();
    scanf("%d", &n), scanf("%d", &k);
    for (int i = 0; i < (int)n; i++) {
      int a, b;
      scanf("%d", &a), scanf("%d", &b);
      minions[i] = {b, a, i + 1};
    }
    sort(minions, minions + n);
    int i = 0, j = 0;
    while (i < n) {
      auto [b, a, id] = minions[i];
      if (j < k && solve(i, j) == b * j + a + solve(i + 1, j + 1)) {
        picked[id] = true;
        ans.push_back(id);
        i++, j++;
      } else
        i++;
    }
    int lst = ans.back();
    ans.pop_back();
    for (int i = 1; i < (int)n + 1; i++)
      if (!picked[i]) ans.push_back(i), ans.push_back(-i);
    ans.push_back(lst);
    printf("%zu\n", ans.size());
    for (auto id : ans) printf("%d ", id);
    printf("\n");
  }
  return 0;
}
