#include <bits/stdc++.h>
using namespace std;
struct data {
  long long x, v, pos;
} p[200005];
struct seg {
  long long val, cnt;
} f[1000005];
long n;
bool cmp(data a, data b) {
  if (a.v == b.v)
    return a.x < b.x;
  else
    return a.v < b.v;
}
bool cmp2(data a, data b) { return a.x < b.x; }
void update(long id, long l, long r, long u, long long k) {
  if (l > u || r < u) return;
  if (l == r) {
    f[id].val = k;
    f[id].cnt = 1;
    return;
  }
  long mid = (l + r) >> 1;
  update(id * 2, l, mid, u, k);
  update(id * 2 + 1, mid + 1, r, u, k);
  f[id].val = f[id * 2].val + f[id * 2 + 1].val;
  f[id].cnt = f[id * 2].cnt + f[id * 2 + 1].cnt;
}
seg get(long id, long l, long r, long u, long v) {
  if (l > v || r < u) return {0, 0};
  if (l >= u && r <= v) return f[id];
  long mid = (l + r) >> 1;
  seg res, res1, res2;
  res1 = get(id * 2, l, mid, u, v);
  res2 = get(id * 2 + 1, mid + 1, r, u, v);
  res.val = res1.val + res2.val;
  res.cnt = res1.cnt + res2.cnt;
  return res;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (long i = 1; i <= n; i++) cin >> p[i].x;
  for (long i = 1; i <= n; i++) cin >> p[i].v;
  sort(p + 1, p + n + 1, cmp);
  for (long i = 1; i <= n; i++) p[i].pos = i;
  sort(p + 1, p + n + 1, cmp2);
  long long res = 0;
  for (long i = 1; i <= n; i++) {
    seg tmp = get(1, 1, n, 1, p[i].pos - 1);
    res += p[i].x * tmp.cnt - tmp.val;
    update(1, 1, n, p[i].pos, p[i].x);
  }
  cout << res;
  return 0;
}
