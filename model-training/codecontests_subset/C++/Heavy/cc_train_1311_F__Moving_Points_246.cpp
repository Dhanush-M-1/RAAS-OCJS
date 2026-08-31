#include <bits/stdc++.h>
using namespace std;
const long long maxn = 1e6 + 100, mod = 1e9 + 7, inf = 1e16 + 7;
pair<long long, long long> a[maxn];
long long get(long long l, long long r) {
  if (r - l == 1) return 0;
  long long m = (r + l) / 2;
  long long ans = 0;
  ans += get(l, m);
  ans += get(m, r);
  long long ptr = m;
  vector<long long> pref(r - m + 2, 0);
  for (long long i = r - 1; i >= m; --i) {
    pref[i - m] = pref[i + 1 - m] + a[i].first;
  }
  vector<pair<long long, long long> > tmp;
  for (long long i = l; i < m; ++i) {
    while (ptr < r && a[i].second > a[ptr].second) {
      tmp.push_back(a[ptr]);
      ptr++;
    }
    tmp.push_back(a[i]);
    ans += pref[ptr - m];
    ans -= (r - ptr) * a[i].first;
  }
  while (ptr < r) tmp.push_back(a[ptr]), ptr++;
  for (long long i = l; i < r; ++i) {
    a[i] = tmp[i - l];
  }
  return ans;
}
void solve() {
  long long n;
  cin >> n;
  for (long long i = 0; i < n; ++i) {
    cin >> a[i].first;
  }
  for (long long i = 0; i < n; ++i) {
    cin >> a[i].second;
  }
  sort(a, a + n);
  cout << get(0, n);
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  srand(10);
  cout << fixed << setprecision(2);
  long long t = 1;
  while (t--) {
    solve();
    cout << endl;
  }
}
