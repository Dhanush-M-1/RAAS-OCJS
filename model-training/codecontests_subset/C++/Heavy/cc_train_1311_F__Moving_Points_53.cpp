#include <bits/stdc++.h>
using namespace std;
const long long maxn = 200010;
const long long N = 200000;
long long n;
struct Node {
  long long v, x;
  bool operator<(const Node& b) const { return x < b.x; }
} p[maxn];
struct BIT {
  long long b[maxn];
  inline long long lowbit(long long x) { return x & (-x); }
  void update(long long x, long long v) {
    for (long long i = x; i <= N; i += lowbit(i)) b[i] += v;
  }
  long long query(long long x) {
    long long ans = 0;
    for (long long i = x; i > 0; i -= lowbit(i)) ans += b[i];
    return ans;
  }
} a, b;
long long tot[maxn], len[maxn];
long long c[maxn], l[maxn];
map<long long, long long> mm;
long long ans;
signed main() {
  cin >> n;
  for (long long i = 1; i <= n; i++) cin >> p[i].x;
  for (long long i = 1; i <= n; i++) cin >> p[i].v, mm[p[i].v]++;
  long long id = 0;
  for (map<long long, long long>::iterator it = mm.begin(); it != mm.end();
       it++)
    it->second = ++id;
  for (long long i = 1; i <= n; i++) p[i].v = mm[p[i].v];
  sort(p + 1, p + n + 1);
  for (long long i = 1; i <= n; i++) {
    ans += a.query(p[i].v) * p[i].x - b.query(p[i].v);
    a.update(p[i].v, 1);
    b.update(p[i].v, p[i].x);
  }
  cout << ans << endl;
  return 0;
}
