#include <bits/stdc++.h>
using namespace std;
struct pii {
  int first, second, id;
};
const int N = 76, INF = (int)1e9;
int n, k;
pii p[N];
int dp[N][N], tk[N][N];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  int T;
  cin >> T;
  while (T--) {
    cin >> n >> k;
    for (int i = 1; i < (n + 1); ++i)
      cin >> p[i].first >> p[i].second, p[i].id = i;
    sort(p + 1, p + n + 1,
         [](const pii &p1, const pii &p2) { return p1.second < p2.second; });
    for (int i = 0; i < (n + 1); ++i) fill(dp[i], dp[i] + n + 1, -INF);
    dp[0][0] = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= k; j++) {
        if (j >= 1) {
          int take_dp = dp[i - 1][j - 1] + (j - 1) * p[i].second + p[i].first;
          if (take_dp > dp[i][j]) {
            dp[i][j] = take_dp;
            tk[i][j] = 1;
          }
        }
        int not_dp = dp[i - 1][j] + (k - 1) * p[i].second;
        if (not_dp > dp[i][j]) {
          dp[i][j] = not_dp;
          tk[i][j] = 0;
        }
      }
    }
    vector<int> take, not_take;
    int cur = k;
    for (int i = n; i >= 1; i--) {
      (tk[i][cur] ? take : not_take).push_back(p[i].id);
      cur -= tk[i][cur];
    }
    reverse(begin(take), end(take));
    cout << take.size() + not_take.size() * 2 << '\n';
    for (int i = 0; i < k - 1; i++) cout << take[i] << " ";
    for (auto x : not_take) cout << x << " " << -x << " ";
    cout << take[k - 1] << '\n';
  }
}
