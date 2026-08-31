#include <bits/stdc++.h>
using namespace std;
long long n;
pair<long long, long long> a[200001];
long long cnt[200001], sum[200001];
void update(long long x, long long val) {
  for (; x <= 200000; x += x & (-x)) {
    cnt[x]++;
    sum[x] += val;
  }
}
long long query(long long x, long long val) {
  long long ans = 0;
  for (; x > 0; x -= x & (-x)) ans += (cnt[x] * val - sum[x]);
  return ans;
}
int32_t main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (long long i = 1; i <= n; i++) cin >> a[i].first;
  vector<pair<long long, long long> > val;
  for (long long i = 1; i <= n; i++) cin >> a[i].second;
  sort(a + 1, a + 1 + n);
  for (long long i = 1; i <= n; i++)
    val.push_back(pair<long long, long long>(a[i].second, i));
  sort(val.begin(), val.end());
  long long pre = -1e9, top = 0;
  for (long long i = 0; i < val.size(); i++) {
    if (val[i].first != pre) {
      pre = val[i].first;
      top++;
    }
    a[val[i].second].second = top;
  }
  long long ans = 0;
  for (long long i = 1; i <= n; i++) {
    ans += query(a[i].second, a[i].first);
    update(a[i].second, a[i].first);
  }
  cout << ans;
}
