#include <bits/stdc++.h>
using namespace std;
struct custom_hash {
  static uint64_t splitmix64(uint64_t x) {
    x += 0x9e3779b97f4a7c15;
    x = (x ^ (x >> 30)) * 0xbf58476d1ce4e5b9;
    x = (x ^ (x >> 27)) * 0x94d049bb133111eb;
    return x ^ (x >> 31);
  }
  size_t operator()(uint64_t x) const {
    static const uint64_t FIXED_RANDOM =
        chrono::steady_clock::now().time_since_epoch().count();
    return splitmix64(x + FIXED_RANDOM);
  }
};
const int inf = INT_MAX;
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
void solve() {
  int n;
  cin >> n;
  vector<pair<int, int>> arr(n);
  for (int i = 0; i < (n); i++) {
    cin >> arr[i].first >> arr[i].second;
  }
  if (n == 1) {
    cout << 1 << endl;
    return;
  }
  vector<vector<int>> dp(n, vector<int>(2, 0));
  dp[0] = vector<int>{1, 1};
  int mid = arr[0].first;
  int right = arr[0].first;
  for (int i = (1); i <= (n - 2); i++) {
    dp[i][0] = dp[i][1] = max(dp[i - 1][0], dp[i - 1][1]);
    int xi = arr[i].first, hi = arr[i].second;
    if (xi - hi > mid) dp[i][0] = max(dp[i][0], dp[i - 1][0] + 1);
    if (xi - hi > right) dp[i][0] = max(dp[i][0], dp[i][1] + 1);
    if (xi + hi < arr[i + 1].first) dp[i][1]++;
    mid = arr[i].first;
    right = arr[i].first + arr[i].second;
  }
  int ans = max(dp[n - 2][0], dp[n - 2][1]);
  cout << ans + 1 << endl;
}
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  srand(chrono::high_resolution_clock::now().time_since_epoch().count());
  int t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
