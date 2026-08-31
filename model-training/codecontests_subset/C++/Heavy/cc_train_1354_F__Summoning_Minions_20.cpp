#include <bits/stdc++.h>
using namespace std;
template <typename A, typename B>
ostream& operator<<(ostream& os, const pair<A, B>& x) {
  return os << "(" << x.first << "," << x.second << ")";
}
int main() {
  int T;
  scanf("%d", &T);
  while (T--) {
    int n, k;
    scanf("%d%d", &n, &k);
    vector<pair<pair<int, int>, int>> M(n);
    long long offset = 0;
    for (int i = 0; i < n; ++i) {
      scanf("%d%d", &M[i].first.second, &M[i].first.first);
      offset += (k - 1) * M[i].first.second;
      M[i].second = i + 1;
    }
    sort(M.begin(), M.end());
    const long long INF = 1LL << 60;
    vector<vector<vector<pair<long long, int>>>> dp(
        n + 1,
        vector<vector<pair<long long, int>>>(
            k + 1, vector<pair<long long, int>>(2, make_pair(-INF, -1))));
    dp[0][0][0] = make_pair(0, 0);
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < k; ++j) {
        dp[i + 1][j][0] = max(dp[i + 1][j][0], make_pair(dp[i][j][0].first, 0));
        dp[i + 1][j][1] = max(dp[i + 1][j][0], make_pair(dp[i][j][1].first, 0));
        dp[i + 1][j][1] =
            max(dp[i + 1][j][1],
                make_pair(dp[i][j][0].first + M[i].first.second, 1));
        if (j + 1 < k) {
          for (int v = 0; v < 2; ++v) {
            dp[i + 1][j + 1][v] =
                max(dp[i + 1][j + 1][v],
                    make_pair(dp[i][j][v].first + M[i].first.second -
                                  (k - 1 - j) * M[i].first.first,
                              2));
          }
        }
      }
    }
    if (false)
      cerr << "dp[n][k - 1][1]"
           << "=" << dp[n][k - 1][1] << endl;
    int j = k - 1, c = 1;
    int las = -1;
    vector<int> pick;
    for (int i = n; i >= 1; --i) {
      int act = dp[i][j][c].second;
      assert(act != -1);
      if (act == 0) {
      } else if (act == 1) {
        assert(c == 1);
        las = i - 1;
        c = 0;
      } else {
        pick.push_back(i - 1);
        --j;
      }
    }
    assert(j == 0);
    assert(c == 0);
    reverse(pick.begin(), pick.end());
    assert(las != -1);
    vector<bool> used(n + 1);
    vector<int> ans;
    for (int x : pick) {
      ans.push_back(M[x].second);
      used[M[x].second] = true;
    }
    used[M[las].second] = true;
    for (int i = 1; i <= n; ++i) {
      if (used[i]) continue;
      ans.push_back(i);
      ans.push_back(-i);
    }
    ans.push_back(M[las].second);
    printf("%d\n", ans.size());
    for (int x : ans) printf("%d ", x);
    printf("\n");
  }
}
