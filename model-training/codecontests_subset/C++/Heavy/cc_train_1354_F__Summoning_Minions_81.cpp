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
  while (T--) {
    int N, K;
    cin >> N >> K;
    vector<pair<pll, int>> v;
    for (int i = 0; i < N; i++) {
      ll a, b;
      cin >> a >> b;
      v.emplace_back(pll(b, a), i);
    }
    sort(v.begin(), v.end());
    vector<vector<pli>> dp(N + 1, vector<pli>(K + 1, pli(-INF, -1)));
    dp[0][0] = pli(0, -1);
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < K + 1; j++) {
        auto [p, k] = dp[i][j];
        if (p == -INF) continue;
        ll np = p + v[i].first.first * (K - 1);
        chmax(dp[i + 1][j], pli(np, k));
        np = p + v[i].first.first * j + v[i].first.second;
        if (j + 1 <= K) chmax(dp[i + 1][j + 1], pli(np, i));
      }
    }
    vector<bool> used(N, false);
    int ni = N, nj = K;
    while (true) {
      ni = dp[ni][nj].second;
      if (ni == -1) break;
      used[ni] = true;
      nj--;
    }
    vector<int> rem;
    for (int i = 0; i < N; i++)
      if (used[i]) rem.emplace_back(i);
    cout << 2 * N - K << '\n';
    for (int i = 0; i < K - 1; i++) cout << v[rem[i]].second + 1 << ' ';
    for (int i = 0; i < N; i++) {
      if (!used[i]) cout << v[i].second + 1 << ' ' << -v[i].second - 1 << ' ';
    }
    cout << v[rem.back()].second + 1 << '\n';
  }
}
