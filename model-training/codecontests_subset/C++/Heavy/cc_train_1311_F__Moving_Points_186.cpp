#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 7;
pair<int, int> p[N];
long long cnt[N << 2], val[N << 2];
void update(int a, int b, int l, int r, int rt, int v) {
  if (a <= l && b >= r) {
    val[rt] += v, cnt[rt]++;
    return;
  }
  int mid = l + r >> 1;
  if (a <= mid) update(a, b, l, mid, rt << 1, v);
  if (b > mid) update(a, b, mid + 1, r, rt << 1 | 1, v);
  cnt[rt] = cnt[rt << 1] + cnt[rt << 1 | 1];
  val[rt] = val[rt << 1] + val[rt << 1 | 1];
}
pair<long long, long long> query(int a, int b, int l, int r, int rt) {
  if (a <= l && b >= r) {
    return {val[rt], cnt[rt]};
  }
  int mid = l + r >> 1;
  pair<long long, long long> ans = {0, 0}, t = {0, 0}, t2 = {0, 0};
  if (a <= mid) t = query(a, b, l, mid, rt << 1);
  if (b > mid) t2 = query(a, b, mid + 1, r, rt << 1 | 1);
  ans.first = t.first + t2.first;
  ans.second = t.second + t2.second;
  return ans;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  int n;
  cin >> n;
  for (int i = 0; i < n; ++i) cin >> p[i].first;
  for (int i = 0; i < n; ++i) cin >> p[i].second;
  sort(p, p + n);
  vector<int> a(n);
  for (int i = 0; i < n; ++i) a[i] = p[i].second;
  sort(a.begin(), a.end());
  a.resize(unique(a.begin(), a.end()) - a.begin());
  for (int i = 0; i < n; ++i) {
    p[i].second = lower_bound(a.begin(), a.end(), p[i].second) - a.begin() + 1;
  }
  long long ans = 0;
  for (int i = n - 1; ~i; --i) {
    update(p[i].second, p[i].second, 1, 200000, 1, p[i].first);
    auto t = query(p[i].second, 200000, 1, 200000, 1);
    ans += t.first - t.second * p[i].first;
  }
  cout << ans << '\n';
  return 0;
}
