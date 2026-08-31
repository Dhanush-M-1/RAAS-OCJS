#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using pii = pair<int, int>;
using pil = pair<int, ll>;
using pli = pair<ll, int>;
using pll = pair<ll, ll>;
const int MOD = 1000000007;
const int inf = (1 << 30) - 1;
const ll INF = (1LL << 60) - 1;
template <typename T>
bool chmax(T &x, const T &y) {
  return (x < y) ? (x = y, true) : false;
};
template <typename T>
bool chmin(T &x, const T &y) {
  return (x > y) ? (x = y, true) : false;
};
struct io_setup {
  io_setup() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout << fixed << setprecision(15);
  }
} io_setup;
int main() {
  int T;
  cin >> T;
  vector<vector<int>> ok;
  vector<int> s;
  for (int i = 0; i < 8; i++) {
    for (int j = 0; j < i; j++) {
      vector<int> tmp;
      int now = 4;
      for (int k = 0; k < 8; k++) {
        if (k == i || k == j)
          now += 3, now %= 10;
        else
          tmp.emplace_back(now);
      }
      ok.emplace_back(tmp),
          s.emplace_back(accumulate(tmp.begin(), tmp.end(), 0));
    }
  }
  while (T--) {
    ll N;
    cin >> N;
    string S = to_string(N);
    reverse(S.begin(), S.end());
    int n = (int)S.size();
    vector<vector<bool>> dp(n + 1, vector<bool>(10, false));
    vector<vector<pii>> pre(n + 1, vector<pii>(10));
    dp[0][0] = true;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 10; j++) {
        if (dp[i][j] == false) continue;
        int x = S[i] - '0';
        for (int k = 0; k < (int)s.size(); k++) {
          int p = j + s[k];
          if (p % 10 == x) {
            dp[i + 1][p / 10] = true;
            pre[i + 1][p / 10] = pii(j, k);
          }
        }
      }
    }
    if (!dp[n][0]) {
      cout << "-1\n";
      continue;
    }
    int j = 0;
    vector<string> ans(6);
    for (int i = n; i >= 1; i--) {
      auto [nj, nk] = pre[i][j];
      for (int k = 0; k < 6; k++) {
        ans[k] += char('0' + ok[nk][k]);
      }
      j = nj;
    }
    for (int i = 0; i < 6; i++) {
      int j = 0;
      while (j < (int)ans[i].size() - 1 && ans[i][j] == '0') j++;
      cout << ans[i].substr(j) << (i == 5 ? '\n' : ' ');
    }
  }
}
