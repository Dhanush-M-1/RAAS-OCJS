#include <bits/stdc++.h>
using namespace std;
long long a, b, N;
long long T1[4 * 200010], T2[4 * 200010];
void update(long long v, long long tl, long long tr, long long pos,
            long long val) {
  if (tl == tr) {
    T1[v] = min(a, T1[v] + val);
    T2[v] = min(b, T2[v] + val);
  } else {
    long long tm = (tl + tr) / 2;
    if (pos <= tm)
      update(v * 2, tl, tm, pos, val);
    else
      update(v * 2 + 1, tm + 1, tr, pos, val);
    T1[v] = T1[v * 2] + T1[v * 2 + 1];
    T2[v] = T2[v * 2] + T2[v * 2 + 1];
  }
}
long long query1(long long v, long long tl, long long tr, long long l,
                 long long r) {
  if (l > r) return 0;
  if (tl == l && tr == r)
    return T1[v];
  else {
    long long tm = (tl + tr) / 2;
    return query1(v * 2, tl, tm, l, min(r, tm)) +
           query1(v * 2 + 1, tm + 1, tr, max(tm + 1, l), r);
  }
}
long long query2(long long v, long long tl, long long tr, long long l,
                 long long r) {
  if (l > r) return 0;
  if (tl == l && tr == r)
    return T2[v];
  else {
    long long tm = (tl + tr) / 2;
    return query2(v * 2, tl, tm, l, min(r, tm)) +
           query2(v * 2 + 1, tm + 1, tr, max(tm + 1, l), r);
  }
}
int main() {
  long long k, q;
  cin >> N >> k >> a >> b >> q;
  for (int i = 1; i <= q; i++) {
    long long pi, t, di, ai;
    cin >> t;
    if (t == 1) {
      cin >> di >> ai;
      update(1, 1, N, di, ai);
    } else {
      cin >> pi;
      cout << query2(1, 1, N, 1, pi - 1) + query1(1, 1, N, pi + k, N) << endl;
    }
  }
  return 0;
}
