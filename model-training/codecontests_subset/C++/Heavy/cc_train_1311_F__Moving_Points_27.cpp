#include <bits/stdc++.h>
using namespace std;
const long long N = 1000010;
const long long mod = 998244353;
const long long inf = 1e9;
const long double eps = 1e-16;
const long double pi = acos(-1);
inline long long rd() {
  long long p = 0;
  long long f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f *= -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    p = p * 10 + ch - '0';
    ch = getchar();
  }
  return p * f;
}
struct node {
  long long x, v;
} a[N];
vector<long long> v;
bool cmp(const node &x, const node &y) { return x.x < y.x; }
long long tr[2][N], n;
void add(long long id, long long x, long long c) {
  while (x <= n) {
    tr[id][x] += c;
    x += ((x) & (-(x)));
  }
}
long long qry(long long id, long long x) {
  long long s = 0;
  while (x >= 1) {
    s += tr[id][x];
    x -= ((x) & (-(x)));
  }
  return s;
}
signed main() {
  n = rd();
  for (long long i = (1); i <= (n); i++) a[i].x = rd();
  for (long long i = (1); i <= (n); i++) a[i].v = rd(), v.push_back(a[i].v);
  sort(a + 1, a + n + 1, cmp);
  sort(v.begin(), v.end());
  v.erase(unique(v.begin(), v.end()), v.end());
  for (long long i = (1); i <= (n); i++)
    a[i].v = lower_bound(v.begin(), v.end(), a[i].v) - v.begin() + 1;
  long long ans = 0;
  for (long long i = (1); i <= (n); i++) {
    ans += qry(0, a[i].v) * a[i].x - qry(1, a[i].v);
    add(0, a[i].v, 1);
    add(1, a[i].v, a[i].x);
  }
  return printf("%lld\n", ans), 0;
}
