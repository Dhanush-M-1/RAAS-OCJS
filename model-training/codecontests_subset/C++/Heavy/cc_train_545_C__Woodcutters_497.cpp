#include <bits/stdc++.h>
using namespace std;
long long int pw(long long int b, long long int p) {
  if (!p) return 1;
  long long int sq = pw(b, p / 2);
  sq *= sq;
  if (p % 2) sq *= b;
  return sq;
}
long long int gcd(long long int a, long long int b) {
  return (b == 0 ? a : gcd(b, a % b));
}
long long int lcm(long long int a, long long int b) {
  return ((a * b) / gcd(a, b));
}
bool cmp(double a, double b) { return abs(a - b) < 1e-9; }
bool isint(double a) { return cmp(a, round(a)); }
const double PI = acos(-1);
long long int OO = 1e18 + 8;
int oo = 1e9 + 9;
int dx[6] = {1, -1, 0, 0, 0, 0}, dy[6] = {0, 0, 1, -1, 0, 0},
    dz[6] = {0, 0, 0, 0, 1, -1};
vector<pair<long long int, long long int>> trees;
long long int dp[100005][4];
long long int n, t, h;
long long int maximum(long long int idx = 0, long long int type = 3,
                      long long int maxiX = -OO) {
  if (idx == n) return 0;
  long long int &ret = dp[idx][type];
  if (~ret) return ret;
  ret = 0;
  ret = maximum(idx + 1, 0, trees[idx].first);
  if (trees[idx].first - trees[idx].second > maxiX)
    ret = max(ret, maximum(idx + 1, 1, trees[idx].first) + 1);
  if (idx == n - 1 ||
      trees[idx].first + trees[idx].second < trees[idx + 1].first)
    ret =
        max(ret, maximum(idx + 1, 2, trees[idx].first + trees[idx].second) + 1);
  return ret;
}
int main() {
  std::ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  ;
  cin >> n;
  memset(dp, -1, sizeof dp);
  for (int i = 0; i < n; i++) cin >> t >> h, trees.push_back({t, h});
  cout << maximum() << '\n';
  return 0;
}
