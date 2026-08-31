#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 1;
long long t = 1, n;
pair<long long, long long> ar[N];
long long dp[N];
long long recur(long long i, long long j) {
  if (i >= n) {
    return 0;
  }
  if (dp[i] != -1) {
    return dp[i];
  }
  long long count = LLONG_MIN;
  if (ar[i].first - ar[i].second > j) {
    count = max(count, 1 + recur(i + 1, ar[i].first));
  }
  if (i + 1 < n && ar[i].first + ar[i].second < ar[i + 1].first) {
    count = max(count, 1 + recur(i + 1, ar[i].first + ar[i].second));
  } else if (i == n - 1) {
    count = max(count, 1 + recur(i + 1, ar[i].first + ar[i].second));
  }
  count = max(count, recur(i + 1, ar[i].first));
  return dp[i] = count;
}
void solve() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> ar[i].first >> ar[i].second;
  }
  memset(dp, -1, sizeof dp);
  cout << recur(0, LLONG_MIN) << "\n";
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  while (t--) {
    solve();
  }
  return 0;
}
