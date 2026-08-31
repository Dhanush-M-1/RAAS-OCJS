#include <bits/stdc++.h>
using namespace std;
template <typename T>
void __read(T &a) {
  cin >> a;
}
template <typename T, typename... Args>
void __read(T &a, Args &...args) {
  cin >> a;
  __read(args...);
}
constexpr long long M7 = 1000000007ll;
constexpr long long M9 = 1000000009ll;
constexpr long long MFFT = 998244353ll;
template <class T>
void outv(T &a) {
  for (auto &x : a) cout << x << ' ';
}
static mt19937 rnd(static_cast<unsigned>(
    chrono::steady_clock::now().time_since_epoch().count()));
auto __fast_io__ = (ios_base::sync_with_stdio(false), cin.tie(nullptr));
int32_t main() {
  int t;
  __read(t);
  while (t--) {
    int n, k;
    __read(n, k);
    vector<pair<int, int>> a(n);
    for (auto &[l, r] : a) {
      cin >> l >> r;
    }
    vector<int> ind(n);
    iota((ind).begin(), (ind).end(), 0);
    sort((ind).begin(), (ind).end(),
         [&](int i, int j) { return a[i].second < a[j].second; });
    vector<vector<int>> dp(n + 1, vector<int>(k + 1, -1));
    vector<vector<int>> pr(n + 1, vector<int>(k + 1, -1));
    dp[0][0] = 0;
    for (int i = 0; i < n; ++i) {
      auto &[l, r] = a[ind[i]];
      for (int j = 0; j <= k; ++j) {
        if (dp[i][j] == -1) {
          continue;
        }
        if (j + 1 <= k) {
          if (dp[i + 1][j + 1] < dp[i][j] + l + r * j) {
            dp[i + 1][j + 1] = dp[i][j] + l + r * j;
            pr[i + 1][j + 1] = j;
          }
        }
        if (dp[i + 1][j] < dp[i][j] + r * (k - 1)) {
          dp[i + 1][j] = dp[i][j] + r * (k - 1);
          pr[i + 1][j] = j;
        }
      }
    }
    vector<int> g, b;
    int j = k;
    for (int i = n - 1; i >= 0; --i) {
      if (pr[i + 1][j] == j) {
        b.push_back(ind[i]);
      } else {
        g.push_back(ind[i]);
      }
      j = pr[i + 1][j];
    }
    reverse((g).begin(), (g).end());
    reverse((b).begin(), (b).end());
    cout << b.size() * 2 + g.size() << '\n';
    for (int i = 0; i + 1 < g.size(); ++i) {
      cout << g[i] + 1 << ' ';
    }
    for (auto &i : b) {
      cout << i + 1 << ' ' << -(i + 1) << ' ';
    }
    cout << g.back() + 1 << '\n';
  }
  return 0;
}
