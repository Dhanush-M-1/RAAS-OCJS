#include <bits/stdc++.h>
using namespace std;
const int INF = 2e9 + 1;
long long int m = 1000000007;
string toString(char x) {
  string s(1, x);
  return s;
}
long long int pow1(long long int x, long long int y) {
  long long int temp;
  if (y == 0) return 1;
  temp = pow1(x, y / 2);
  if (y % 2 == 0)
    return (temp % m * temp % m) % m;
  else
    return ((x % m * temp % m) % m * temp % m) % m;
}
int main() {
  int n, k;
  cin >> n >> k;
  vector<int> times[4];
  vector<int> sums[4];
  for (int i = 0; i < n; ++i) {
    int t, a, b;
    cin >> t >> a >> b;
    times[a * 2 + b].push_back(t);
  }
  for (int i = 0; i < 4; ++i) {
    sort(times[i].begin(), times[i].end());
    sums[i].push_back(0);
    for (auto it : times[i]) {
      sums[i].push_back(sums[i].back() + it);
    }
  }
  int ans = INF;
  for (int cnt = 0; cnt < min(k + 1, int(sums[3].size())); ++cnt) {
    if (k - cnt < int(sums[1].size()) && k - cnt < int(sums[2].size())) {
      ans = min(ans, sums[3][cnt] + sums[1][k - cnt] + sums[2][k - cnt]);
    }
  }
  if (ans == INF) ans = -1;
  cout << ans << endl;
  return 0;
}
