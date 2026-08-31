#include <bits/stdc++.h>
using namespace std;
long long q, dp[200005][15], a[555555][5], b[555555], k, l, m, n, o, p;
map<long long, long long> mp;
vector<long long> v[555555];
const long long mod = 1e9 + 7;
long long mem(long long i, long long md) {
  if (i == n + 1) return 0;
  long long &r = dp[i][md];
  if (r != -1) return r;
  long long s = min(3LL, (long long)v[i].size());
  r = mem(i + 1, md);
  long long sum = 0, u = 0;
  for (long long j = 0; j < s; j++) {
    sum += v[i][j];
    if (md + j + 1 >= 10) u = max(u, v[i][0]);
    r = max(r, mem(i + 1, (md + j + 1) % 10) + sum + u);
  }
  if (a[i][2]) {
    long long sum = 0, u = 0;
    if (md + 1 == 10) u = a[i][2];
    sum += a[i][2];
    r = max(r, mem(i + 1, (md + 1) % 10) + sum + u);
    if (s) {
      if (md + 2 >= 10) u = max(a[i][2], v[i][0]);
      sum += v[i][0];
      r = max(r, mem(i + 1, (md + 2) % 10) + sum + u);
    }
  }
  if (a[i][3]) {
    long long sum = 0, u = 0;
    if (md + 1 == 10) u = a[i][3];
    sum += a[i][3];
    r = max(r, mem(i + 1, (md + 1) % 10) + sum + u);
  }
  return r;
}
void solve() {
  memset(dp, -1, sizeof dp);
  cin >> n;
  for (long long i = 1; i <= n; i++) {
    cin >> b[i];
    for (long long j = 0; j < b[i]; j++) {
      cin >> o >> p;
      if (o > 1)
        a[i][o] = max(a[i][o], p);
      else
        v[i].push_back(p);
    }
    sort(v[i].begin(), v[i].end(), greater<long long>());
  }
  cout << mem(1, 0) << endl;
}
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  q = 1;
  while (q--) {
    solve();
  }
}
