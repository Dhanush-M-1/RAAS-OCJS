#include <bits/stdc++.h>
using namespace std;
pair<long long, long long> t[4 * 200009];
long long a[200009], lazy[4 * 200009], ans[200009];
void build(long long v, long long tl, long long tr) {
  if (tl == tr) {
    t[v] = {a[tl], tl};
  } else {
    long long tm = (tl + tr) / 2;
    build(v * 2, tl, tm);
    build(v * 2 + 1, tm + 1, tr);
    if (t[v * 2].first < t[v * 2 + 1].first ||
        (t[v * 2].first == t[v * 2 + 1].first &&
         t[v * 2].second > t[v * 2 + 1].second))
      t[v] = t[v * 2];
    else
      t[v] = t[v * 2 + 1];
  }
}
void push(long long v) {
  t[v * 2].first += lazy[v];
  lazy[v * 2] += lazy[v];
  t[v * 2 + 1].first += lazy[v];
  lazy[v * 2 + 1] += lazy[v];
  lazy[v] = 0;
}
void update(long long v, long long tl, long long tr, long long l, long long r,
            long long addend) {
  if (l > r) return;
  if (l == tl && tr == r) {
    t[v].first += addend;
    lazy[v] += addend;
  } else {
    push(v);
    long long tm = (tl + tr) / 2;
    update(v * 2, tl, tm, l, min(r, tm), addend);
    update(v * 2 + 1, tm + 1, tr, max(l, tm + 1), r, addend);
    if (t[v * 2].first < t[v * 2 + 1].first ||
        (t[v * 2].first == t[v * 2 + 1].first &&
         t[v * 2].second > t[v * 2 + 1].second))
      t[v] = t[v * 2];
    else
      t[v] = t[v * 2 + 1];
  }
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long n;
  cin >> n;
  long long i = 1;
  while (i <= n) cin >> a[i++];
  build(1, 1, n);
  i = 1;
  long long x;
  while (i <= n) {
    x = t[1].second;
    ans[x] = i;
    update(1, 1, n, x + 1, n, -i);
    update(1, 1, n, x, x, 1e13);
    i++;
  }
  i = 1;
  while (i <= n) {
    cout << ans[i] << " ";
    i++;
  }
}
