#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9 + 1e8;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0), cout.tie(0);
  int tcase;
  cin >> tcase;
  while (tcase--) {
    int n, k;
    cin >> n >> k;
    vector<int> a(n + 1), b(n + 1), id(n + 1);
    for (int i = 1; i <= n; i++) cin >> a[i] >> b[i], id[i] = i;
    sort(id.begin() + 1, id.begin() + n + 1,
         [&](int u, int v) { return b[u] < b[v]; });
    vector<vector<int>> dp(n + 1, vector<int>(k + 1, -INF)),
        prv(n + 1, vector<int>(k + 1, 0));
    dp[0][0] = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= k; j++) {
        dp[i][j] = dp[i - 1][j];
        if (j) {
          if (dp[i][j] < dp[i - 1][j - 1] + a[id[i]] - b[id[i]] * (k - j)) {
            dp[i][j] = dp[i - 1][j - 1] + a[id[i]] - b[id[i]] * (k - j);
            prv[i][j] = 1;
          }
        }
      }
    }
    vector<int> chk(n + 1, 0);
    int cur_i = n, cur_j = k;
    while (cur_i) {
      if (prv[cur_i][cur_j])
        chk[cur_i] = 1, cur_i--, cur_j--;
      else
        cur_i--;
    }
    vector<int> ans1, ans2;
    for (int i = 1; i <= n; i++)
      if (chk[i]) ans1.push_back(id[i]);
    for (int i = 1; i <= n; i++)
      if (!chk[i]) ans2.push_back(id[i]);
    vector<int> rlt;
    for (int i = 0; i < ans1.size() - 1; i++) rlt.push_back(ans1[i]);
    for (auto it : ans2) rlt.push_back(it), rlt.push_back(-it);
    rlt.push_back(ans1[ans1.size() - 1]);
    cout << rlt.size() << "\n";
    for (int i = 0; i < rlt.size(); i++)
      cout << rlt[i] << " \n"[i == rlt.size() - 1];
  }
  return 0;
}
