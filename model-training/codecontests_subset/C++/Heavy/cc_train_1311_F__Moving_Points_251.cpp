#include <bits/stdc++.h>
using namespace std;
const int Z = (int)1e3 + 228;
const int N = (int)2e5 + 228;
const int INF = (int)1e9 + 228;
const int MOD = (int)998244353;
const long long LLINF = (long long)1e18 + 228;
const long double eps = (long double)1e-6;
pair<long long, long long> t[4 * N];
void update(int v, int tl, int tr, int pos, int x) {
  if (tl == tr) {
    t[v].first += x;
    t[v].second++;
    return;
  }
  int mid = (tl + tr) / 2;
  if (pos <= mid)
    update(2 * v, tl, mid, pos, x);
  else
    update(2 * v + 1, mid + 1, tr, pos, x);
  t[v].first = t[2 * v].first + t[2 * v + 1].first;
  t[v].second = t[2 * v].second + t[2 * v + 1].second;
}
pair<long long, long long> get_sum(int v, int tl, int tr, int l, int r) {
  if (tl >= l && tr <= r) {
    return t[v];
  }
  if (tl > r || tr < l) {
    return {0, 0};
  }
  int mid = (tl + tr) / 2;
  pair<long long, long long> ql = get_sum(2 * v, tl, mid, l, r);
  pair<long long, long long> qr = get_sum(2 * v + 1, mid + 1, tr, l, r);
  return {ql.first + qr.first, ql.second + qr.second};
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  vector<pair<int, int> > a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i].first;
  }
  vector<int> v;
  for (int i = 0; i < n; i++) {
    cin >> a[i].second;
    v.push_back(a[i].second);
  }
  sort(v.begin(), v.end());
  v.erase(unique(v.begin(), v.end()), v.end());
  sort(a.begin(), a.end());
  long long ans = 0;
  for (int i = 0; i < n; i++) {
    int pos = lower_bound(v.begin(), v.end(), a[i].second) - v.begin();
    pair<long long, long long> p = get_sum(1, 0, v.size() - 1, 0, pos);
    ans += p.second * a[i].first - p.first;
    update(1, 0, v.size() - 1, pos, a[i].first);
  }
  cout << ans;
  return 0;
}
