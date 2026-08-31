#include <bits/stdc++.h>
using namespace std;
constexpr long long maxN = 2e5 + 43;
long long n;
vector<pair<long long, long long>> point;
vector<long long> val, cnt, cval;
long long LSOne(long long k) { return (k & (-k)); }
void update(vector<long long>& f, long long pos, long long val) {
  for (; pos <= n; pos += LSOne(pos)) f[pos] += val;
}
long long rsq(vector<long long>& f, long long pos) {
  long long sum = 0;
  for (; pos; pos -= LSOne(pos)) sum += f[pos];
  return sum;
}
bool Comp(const pair<long long, long long>& a,
          const pair<long long, long long>& b) {
  return a.first < b.first;
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin >> n;
  point.resize(n + 1);
  val.resize(n + 1);
  cnt.resize(n + 1);
  cval.resize(n + 1);
  for (long long i = 1; i <= n; ++i) {
    cin >> point[i].first;
  }
  for (long long i = 1; i <= n; ++i) {
    cin >> point[i].second;
    val[i] = point[i].second;
  }
  sort(point.begin() + 1, point.begin() + n + 1);
  sort(val.begin() + 1, val.begin() + n + 1);
  long long ans = 0;
  for (long long i = 1; i <= n; ++i) {
    long long pos =
        lower_bound(val.begin() + 1, val.begin() + n + 1, point[i].second) -
        val.begin();
    ans += rsq(cnt, pos) * point[i].first - rsq(cval, pos);
    update(cnt, pos, 1);
    update(cval, pos, point[i].first);
  }
  cout << ans;
  return 0;
}
