#include <bits/stdc++.h>
using namespace std;
long long n, m, k, l, r, i, j, a[1000001], d[10000001], ans[1000001];
bool tt[1000001];
vector<pair<long long, long long> > v;
string s;
void build(long long h, long long l, long long r) {
  if (l == r) {
    d[h] = 0;
    return;
  }
  long long w = (l + r) / 2;
  build(h * 2, l, w);
  build(h * 2 + 1, w + 1, r);
}
void update(long long h, long long l, long long r, long long x) {
  if (l == r) {
    d[h] = 1;
    return;
  }
  long long w = (l + r) / 2;
  if (x <= w)
    update(h * 2, l, w, x);
  else
    update(h * 2 + 1, w + 1, r, x);
  d[h] = d[h * 2] + d[h * 2 + 1];
}
long long get(long long h, long long l, long long r, long long x) {
  if (l == r) return a[l];
  long long w = (l + r) / 2;
  if (x <= d[h * 2])
    return get(h * 2, l, w, x);
  else
    return get(h * 2 + 1, w + 1, r, x - d[h * 2]);
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    v.push_back(make_pair(a[i], n - i));
  }
  build(1, 1, n);
  sort(v.begin(), v.end());
  reverse(v.begin(), v.end());
  for (int i = 0; i < n; i++) v[i].second = n - v[i].second;
  vector<pair<pair<long long, long long>, long long> > z;
  cin >> m;
  for (int i = 1; i <= m; i++) {
    long long x, y;
    cin >> x >> y;
    z.push_back(make_pair(make_pair(x, y), i));
  }
  sort(z.begin(), z.end());
  long long l = -1;
  for (int i = 0; i < z.size(); i++) {
    while (z[i].first.first - 1 > l) {
      l++;
      update(1, 1, n, v[l].second);
    }
    ans[z[i].second] = get(1, 1, n, z[i].first.second);
  }
  for (int i = 1; i <= m; i++) cout << ans[i] << "\n";
  return 0;
}
