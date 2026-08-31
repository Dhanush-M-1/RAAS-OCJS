#include <bits/stdc++.h>
using rmain = int;
using namespace std;
long long n;
vector<pair<long long, long long>> points;
vector<long long> v, cnt, xs;
long long LSOne(long long k) { return (k & (-k)); }
void update(vector<long long>& f, long long pos, long long val) {
  for (; pos <= n; pos += LSOne(pos)) f[pos] += val;
}
long long rsq(vector<long long>& f, long long pos) {
  long long sum = 0;
  for (; pos; pos -= LSOne(pos)) sum += f[pos];
  return sum;
}
rmain main() {
  ios_base::sync_with_stdio(false);
  cin >> n;
  points.resize(n + 1);
  v.resize(n + 1);
  cnt.resize(n + 1);
  xs.resize(n + 1);
  for (long long i = 1; i <= n; ++i) cin >> points[i].first;
  for (long long i = 1; i <= n; ++i) {
    cin >> points[i].second;
    v[i] = points[i].second;
  }
  sort(points.begin() + 1, points.begin() + n + 1);
  sort(v.begin() + 1, v.begin() + n + 1);
  long long ans = 0;
  for (long long i = 1; i <= n; ++i) {
    long long pos =
        lower_bound(v.begin() + 1, v.begin() + n + 1, points[i].second) -
        v.begin();
    ans += rsq(cnt, pos) * points[i].first - rsq(xs, pos);
    update(cnt, pos, 1);
    update(xs, pos, points[i].first);
  }
  cout << ans;
}
