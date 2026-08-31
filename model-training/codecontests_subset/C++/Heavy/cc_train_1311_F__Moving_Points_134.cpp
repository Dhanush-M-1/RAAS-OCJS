#include <bits/stdc++.h>
using namespace std;
vector<pair<long long, long long> > v;
vector<long long> v1;
long long a[200005], b[200005], c[200005], d[200005], n, m;
map<long long, long long> mp;
long long get(long long f[], long long pos) {
  long long res = 0;
  for (; pos >= 0; pos = (pos & (pos + 1)) - 1) res += f[pos];
  return res;
}
void upd(long long f[], long long pos, long long val) {
  for (; pos < m; pos |= pos + 1) f[pos] += val;
}
int main() {
  long long i;
  cin >> n;
  for (i = 0; i < n; i++) cin >> a[i];
  for (i = 0; i < n; i++) cin >> b[i];
  for (i = 0; i < n; i++) {
    v.push_back({a[i], b[i]});
    if (!mp[b[i]]) v1.push_back(b[i]);
    mp[b[i]] = 1;
  }
  sort(v.begin(), v.end());
  sort(v1.begin(), v1.end());
  m = v1.size();
  long long s = 0;
  for (auto x : v) {
    long long y = lower_bound(v1.begin(), v1.end(), x.second) - v1.begin();
    s += get(c, y) * x.first - get(d, y);
    upd(c, y, 1);
    upd(d, y, x.first);
  }
  cout << s;
  return 0;
}
