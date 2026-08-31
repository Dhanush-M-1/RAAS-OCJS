#include <bits/stdc++.h>
using namespace std;
const double pi = acos(-1);
const int N = 2e5 + 5, mod = 998244353, M = 1e7 + 7;
const long long MAX = 5e18;
int n;
pair<int, int> a[N];
long long ans;
struct BIT {
  long long s[N][2], sum[2];
  void init() {
    memset(s, 0, sizeof s);
    sum[0] = sum[1] = 0;
  }
  void add(int x, int v) {
    while (x < N) {
      s[x][0] += v;
      s[x][1]++;
      x += x & -x;
    }
    sum[0] += v;
    sum[1]++;
  }
  pair<long long, long long> lSum(int x) {
    pair<long long, long long> c = {0, 0};
    while (x) {
      c.first += s[x][0];
      c.second += s[x][1];
      x -= x & -x;
    }
    return c;
  }
  pair<long long, long long> rSum(int x) {
    pair<long long, long long> ret = lSum(x - 1);
    ret.first = sum[0] - ret.first;
    ret.second = sum[1] - ret.second;
    return ret;
  }
} p, nz;
void compress() {
  map<int, int> mp[2];
  set<int> s[2];
  for (int i = 0; i < n; i++) {
    if (a[i].second > 0)
      s[0].insert(a[i].second);
    else
      s[1].insert(-a[i].second);
  }
  for (int i = 0; i < 2; i++) {
    int c = 1;
    for (int j : s[i]) mp[i][j] = c++;
  }
  for (int i = 0; i < n; i++) {
    if (a[i].second > 0)
      a[i].second = mp[0][a[i].second];
    else
      a[i].second = -mp[1][-a[i].second];
  }
}
void add(pair<int, int> x) {
  pair<long long, long long> s;
  if (x.second > 0) {
    s = p.rSum(x.second);
    ans += s.first - s.second * x.first;
    p.add(x.second, x.first);
  } else {
    x.second *= -1;
    s = p.rSum(1);
    ans += s.first - s.second * x.first;
    s = nz.lSum(x.second);
    ans += s.first - s.second * x.first;
    nz.add(x.second, x.first);
  }
}
int main() {
  p.init();
  nz.init();
  scanf("%d", &n);
  for (int i = 0; i < n; i++) scanf("%d", &a[i].first);
  for (int i = 0; i < n; i++) scanf("%d", &a[i].second);
  sort(a, a + n);
  compress();
  for (int i = n - 1; i >= 0; i--) add(a[i]);
  cout << ans;
  return 0;
}
