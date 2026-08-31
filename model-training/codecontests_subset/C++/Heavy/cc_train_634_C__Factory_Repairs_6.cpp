#include <bits/stdc++.h>
using namespace std;
template <typename Arg1>
void __f(const char* name, Arg1&& arg1) {
  cerr << name << " : " << arg1 << endl;
}
template <typename Arg1, typename... Args>
void __f(const char* names, Arg1&& arg1, Args&&... args) {
  const char* comma = strchr(names + 1, ',');
  cerr.write(names, comma - names) << " : " << arg1 << " | ";
  __f(comma + 1, args...);
}
long long int seg1[1000005];
long long int seg2[1000005];
long long int updt(int k, int l, int r, int q, long long int* seg,
                   long long int v, long long int lim) {
  if (l == r) return (seg[k] = min(lim, seg[k] + v));
  int m = (l + r) / 2;
  if (q > m)
    seg[k] = updt((k << 1) + 1, m + 1, r, q, seg, v, lim) + seg[(k << 1)];
  else
    seg[k] = updt((k << 1), l, m, q, seg, v, lim) + seg[(k << 1) + 1];
  return seg[k];
}
long long int qry(int k, int l, int r, int qb, int qe, long long int* seg) {
  if (qe < qb) return 0;
  int m = (l + r) / 2;
  if (qb > r || qe < l) return 0;
  if (qb <= l && qe >= r)
    return seg[k];
  else
    return (qry((2 * k), l, m, qb, qe, seg) +
            qry((2 * k) + 1, m + 1, r, qb, qe, seg));
}
int main() {
  long long int n, k, a, b, q;
  scanf("%lld", &n);
  scanf("%lld", &k);
  scanf("%lld", &a);
  scanf("%lld", &b);
  scanf("%lld", &q);
  long long int t, x, y;
  while (q--) {
    scanf("%lld", &t);
    t--;
    if (!t) {
      scanf("%lld", &x);
      scanf("%lld", &y);
      updt(1, 1, n, x, seg1, y, b);
      updt(1, 1, n, x, seg2, y, a);
    } else {
      scanf("%lld", &x);
      long long int ans = 0;
      ans += qry(1, 1, n, 1, x - 1, seg1);
      ans += qry(1, 1, n, x + k, n, seg2);
      printf("%lld\n", ans);
    }
  }
  return 0;
}
