#include <bits/stdc++.h>
using namespace std;
const long long mx = 105;
const long long mod = 1000000007;
const long long maxn = 1e17;
vector<long long> v1;
vector<long long> v2;
long long get(long long x, long long vt) {
  long long i, j, k;
  long long res = 0;
  for (i = x; i > 0; i -= (i & -i)) {
    if (vt == 1) {
      res += v1[i];
    } else {
      res += v2[i];
    }
  }
  return res;
}
void upd(long long x, long long vt, long long val) {
  long long i, j, k;
  long long si = (vt == 1 ? (int)v1.size() : (int)v2.size());
  for (i = x; i < si; i += (i & -i)) {
    if (vt == 1) {
      v1[i] += val;
    } else {
      v2[i] += val;
    }
  }
}
void solve() {
  long long n, i, j, k;
  cin >> n;
  long long x[n + 1], v[n + 1];
  vector<pair<long long, long long>> v4;
  for (i = 1; i <= n; i++) {
    cin >> x[i];
  }
  for (i = 1; i <= n; i++) {
    cin >> v[i];
  }
  for (i = 1; i <= n; i++) {
    v4.push_back({x[i], v[i]});
  }
  sort(v4.begin(), v4.end());
  for (i = 1; i <= n; i++) {
    x[i] = v4[i - 1].first;
    v[i] = v4[i - 1].second;
  }
  vector<long long> disx;
  for (i = 1; i <= n; i++) {
    disx.push_back(v[i]);
  }
  sort(disx.begin(), disx.end());
  disx.resize(unique(disx.begin(), disx.end()) - disx.begin());
  v1.resize(disx.size() + 1);
  v2.resize(disx.size() + 1);
  long long res = 0;
  for (i = 1; i <= n; i++) {
    long long pos = lower_bound(disx.begin(), disx.end(), v[i]) - disx.begin();
    res += get(pos + 1, 1) * x[i] - get(pos + 1, 2);
    upd(pos + 1, 1, 1);
    upd(pos + 1, 2, x[i]);
  }
  cout << res << "\n";
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  long long t = 1;
  while (t--) {
    solve();
  }
}
