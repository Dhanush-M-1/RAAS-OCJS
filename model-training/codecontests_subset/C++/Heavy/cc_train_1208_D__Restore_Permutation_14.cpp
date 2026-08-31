#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10;
const int maxm = 4e6 + 10;
const long long mod = 1e9 + 7;
const int inf = 0x3ffffff;
const double eps = 1e-5;
long long n, s[maxn];
long long a[maxn], ans[maxn << 2], tag[maxn << 2], m;
long long res[maxn];
inline void push_up(long long p) { ans[p] = ans[p << 1] + ans[p << 1 | 1]; }
inline void f(long long p, long long l, long long r, long long k) {
  tag[p] += k;
  ans[p] += (r - l + 1) * k;
}
void build(long long l, long long r, long long p) {
  if (l == r) {
    ans[p] = a[l];
    return;
  }
  long long mid = (l + r) >> 1;
  build(l, mid, p << 1);
  build(mid + 1, r, p << 1 | 1);
  push_up(p);
}
inline void push_down(long long p, long long l, long long r) {
  long long mid = (l + r) >> 1;
  f(p << 1, l, mid, tag[p]);
  f(p << 1 | 1, mid + 1, r, tag[p]);
  tag[p] = 0;
}
inline void update(long long nl, long long nr, long long l, long long r,
                   long long p, long long k) {
  if (nl <= l && r <= nr) {
    ans[p] += k * (r - l + 1);
    tag[p] += k;
    return;
  }
  push_down(p, l, r);
  long long mid = (l + r) >> 1;
  if (nl <= mid) update(nl, nr, l, mid, p << 1, k);
  if (nr > mid) update(nl, nr, mid + 1, r, p << 1 | 1, k);
  push_up(p);
}
long long query(long long q_x, long long q_y, long long l, long long r,
                long long p) {
  long long res = 0;
  if (q_x <= l && q_y >= r) return ans[p];
  long long mid = (l + r) >> 1;
  push_down(p, l, r);
  if (q_x <= mid) res += query(q_x, q_y, l, mid, p << 1);
  if (q_y > mid) res += query(q_x, q_y, mid + 1, r, p << 1 | 1);
  return res;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> s[i];
    a[i] = i;
  }
  build(1, n, 1);
  for (int i = n; i >= 1; i--) {
    int l = 1, r = n;
    while (l < r) {
      int mid = (l + r) >> 1;
      if (query(1, mid, 1, n, 1) > s[i])
        r = mid;
      else
        l = mid + 1;
    }
    update(l, l, 1, n, 1, -l);
    res[i] = l;
  }
  for (int i = 1; i <= n; i++) cout << res[i] << " ";
  return ~~(0 - 0);
}
