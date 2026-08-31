#include <bits/stdc++.h>
using namespace std;
long long _abs(long long x) { return (x > 0 ? x : -x); }
const int N = 2e5 + 5;
int n, k, cost, damage;
vector<long long> d[N][4];
long long dp[N][12];
bool comp(long long a, long long b) { return a > b; }
long long solve(int i, int nc) {
  if (i == n) return 0;
  long long& r = dp[i][nc];
  if (r != -1) return r;
  long long best[4];
  for (int cost = 1; cost <= 3; cost++)
    best[cost] = (d[i][cost].size()) ? d[i][cost][0] : 0ll;
  long long o9 = 1 + (nc == 9), o8 = 1 + (nc >= 8), o7 = 1 + (nc >= 7);
  r = max(r,
          o9 * max({best[1], best[2], best[3]}) + solve(i + 1, (nc + 1) % 10));
  if (best[1] && best[2])
    r = max(r, o8 * max(best[1], best[2]) + min(best[1], best[2]) +
                   solve(i + 1, (nc + 2) % 10));
  if (d[i][1].size() >= 2)
    r = max(r, o8 * d[i][1][0] + d[i][1][1] + solve(i + 1, (nc + 2) % 10));
  if (d[i][1].size() >= 3)
    r = max(r, o7 * d[i][1][0] + d[i][1][1] + d[i][1][2] +
                   solve(i + 1, (nc + 3) % 10));
  r = max(r, solve(i + 1, nc));
  return r;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  memset(dp, -1, sizeof dp);
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> k;
    while (k--) {
      cin >> cost >> damage;
      d[i][cost].push_back(damage);
    }
    sort(d[i][1].begin(), d[i][1].end(), comp);
    sort(d[i][2].begin(), d[i][2].end(), comp);
    sort(d[i][3].begin(), d[i][3].end(), comp);
  }
  cout << solve(0, 0) << endl;
}
