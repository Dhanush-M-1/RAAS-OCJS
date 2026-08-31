#include <bits/stdc++.h>
using namespace std;
vector<pair<long long, long long>> t[2 * 200004];
vector<long long> tpre[2 * 200004];
long long ans = 0;
int cntlo = 0, cnthi = 0;
void build(int n) {
  for (int i = n - 1; i > 0; i--)
    merge(t[i << 1].begin(), t[i << 1].end(), t[i << 1 | 1].begin(),
          t[i << 1 | 1].end(), back_inserter(t[i]));
}
void buildpre(int n) {
  for (int i = 1, up = 2 * n; i < up; i++) {
    int sz = (int)t[i].size() + 1;
    tpre[i].resize(sz);
    for (int j = sz - 2; j >= 0; j--) {
      tpre[i][j] = tpre[i][j + 1] + t[i][j].second;
    }
  }
}
void queryhi(int n, int l, int r, long long v) {
  l += n;
  r += n;
  while (l < r) {
    if (l & 1) {
      int dist = lower_bound(t[l].begin(), t[l].end(),
                             pair<long long, long long>(v, 1ll * INT_MIN)) -
                 t[l].begin();
      if (dist > (int)t[l].size()) dist = (int)t[l].size();
      cnthi += (t[l].size() - dist);
      ans += tpre[l][dist];
      l++;
    }
    if (r & 1) {
      int dist = lower_bound(t[r - 1].begin(), t[r - 1].end(),
                             pair<long long, long long>(v, 1ll * INT_MIN)) -
                 t[r - 1].begin();
      if (dist > (int)t[r - 1].size()) dist = (int)t[r - 1].size();
      cnthi += (t[r - 1].size() - dist);
      ans += tpre[r - 1][dist];
      r--;
    }
    l >>= 1;
    r >>= 1;
  }
}
void querylo(int n, int l, int r, long long v) {
  l += n;
  r += n;
  while (l < r) {
    if (l & 1) {
      int dist = upper_bound(t[l].begin(), t[l].end(),
                             pair<long long, long long>(v, 1ll * INT_MAX)) -
                 t[l].begin();
      if (dist > (int)t[l].size()) dist = (int)t[l].size();
      cntlo += dist;
      ans -= (tpre[l][0] - tpre[l][dist]);
      l++;
    }
    if (r & 1) {
      int dist = upper_bound(t[r - 1].begin(), t[r - 1].end(),
                             pair<long long, long long>(v, 1ll * INT_MAX)) -
                 t[r - 1].begin();
      if (dist > (int)t[r - 1].size()) dist = (int)t[r - 1].size();
      cntlo += dist;
      ans -= (tpre[r - 1][0] - tpre[r - 1][dist]);
      r--;
    }
    l >>= 1;
    r >>= 1;
  }
}
int v[200004];
long long x[200004];
pair<long long, long long> xv[200004];
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) scanf("%lld", &x[i]);
  for (int i = 0; i < n; i++) scanf("%d", &v[i]);
  for (int i = 0; i < n; i++)
    xv[i] = pair<long long, long long>(x[i], 1ll * v[i]);
  sort(xv, xv + n);
  for (int i = n, up = n << 1; i < up; i++)
    t[i] = vector<pair<long long, long long>>(
        {pair<long long, long long>(xv[i - n].second, xv[i - n].first)});
  build(n);
  buildpre(n);
  long long res = 0;
  for (int i = 0; i < n; i++) {
    ans = 0;
    cntlo = cnthi = 0;
    queryhi(n, i + 1, n, xv[i].second);
    querylo(n, 0, i, xv[i].second);
    res += ans;
    res += (1ll * (cntlo - cnthi) * xv[i].first);
  }
  cout << res / 2;
  return 0;
}
