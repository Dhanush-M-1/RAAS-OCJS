#include <bits/stdc++.h>
using namespace std;
pair<long long, long long> a[200005];
long long sum[1000005], cnt[1000005];
long long querysum(long long pos) {
  long long ret = 0;
  for (; pos >= 0; pos = (pos & (pos + 1)) - 1) {
    ret += sum[pos];
  }
  return ret;
}
long long querycnt(long long pos) {
  long long ret = 0;
  for (; pos >= 0; pos = (pos & (pos + 1)) - 1) {
    ret += cnt[pos];
  }
  return ret;
}
void updatesum(long long pos, long long val) {
  for (; pos < 1000000; pos |= pos + 1) {
    sum[pos] += val;
  }
}
void updatecnt(long long pos, long long val) {
  for (; pos < 1000000; pos |= pos + 1) {
    cnt[pos] += val;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long n;
  cin >> n;
  for (long long i = 1; i <= n; i++) cin >> a[i].first;
  for (long long i = 1; i <= n; i++) cin >> a[i].second;
  vector<long long> v;
  for (long long i = 1; i <= n; i++) {
    v.push_back(a[i].second);
  }
  sort(v.begin(), v.end());
  map<long long, long long> num;
  for (long long i = 0; i < v.size(); i++) {
    num[v[i]] = i;
  }
  for (long long i = 1; i <= n; i++) {
    a[i].second = num[a[i].second];
  }
  sort(a + 1, a + n + 1);
  memset(sum, 0, sizeof(sum));
  memset(cnt, 0, sizeof(cnt));
  long long ans = 0;
  for (long long i = 1; i <= n; i++) {
    ans += a[i].first * querycnt(a[i].second) - querysum(a[i].second);
    updatesum(a[i].second, a[i].first);
    updatecnt(a[i].second, 1);
  }
  cout << ans << endl;
  return 0;
}
