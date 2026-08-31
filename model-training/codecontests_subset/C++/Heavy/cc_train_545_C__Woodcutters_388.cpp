#include <bits/stdc++.h>
using namespace std;
const long long int inf = 1e9 + 100;
const long long int maxn = 1e5 + 100;
vector<pair<long long int, long long int> > v;
long long int n;
long long int dp[maxn];
long long int ans(long long int x, long long int T) {
  if (x == n - 1) return 1;
  if (x > (n - 1)) return 0;
  if (x == 0) {
    return (ans(x + 1, v[x].first) + 1);
  }
  if (v[x].first - v[x].second > T) return (ans(x + 1, v[x].first) + 1);
  if (dp[x]) {
    return dp[x];
  }
  long long int P = ans(x + 1, v[x].first);
  if (v[x].first + v[x].second < v[x + 1].first) {
    long long int Q = (ans(x + 1, v[x].first + v[x].second) + 1);
    dp[x] = max(P, Q);
    return max(P, Q);
  } else {
    dp[x] = P;
    return P;
  }
}
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    long long int x, h;
    cin >> x >> h;
    v.push_back(make_pair(x, h));
  }
  cout << ans(0, -10000);
  return 0;
}
