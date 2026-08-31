#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 7;
const int MOD = 1e9 + 7;
template <class T>
bool umin(T& a, T b) {
  if (a > b) {
    a = b;
    return 1;
  }
  return 0;
}
template <class T>
bool umax(T& a, T b) {
  if (a < b) {
    a = b;
    return 1;
  }
  return 0;
}
template <class T>
bool umod(T& a) {
  while (a < 0) a += MOD;
  a %= MOD;
  return 1;
}
int n, cn, a[N], b[N], c[N];
long long T[N << 2], S[N << 2], ans;
map<int, int> mk;
pair<int, int> p[N];
void upd(int x, int val, int l, int r, int v) {
  S[v]++, T[v] += val;
  if (l == r) return;
  if (x <= ((l + r) >> 1))
    upd(x, val, l, ((l + r) >> 1), v << 1);
  else
    upd(x, val, ((l + r) >> 1) + 1, r, v << 1 | 1);
}
long long getT(int x, int y, int l, int r, int v) {
  if (y < l || r < x) return 0LL;
  if (x <= l && r <= y) return T[v];
  return getT(x, y, l, ((l + r) >> 1), v << 1) +
         getT(x, y, ((l + r) >> 1) + 1, r, v << 1 | 1);
}
long long getS(int x, int y, int l, int r, int v) {
  if (y < l || r < x) return 0LL;
  if (x <= l && r <= y) return S[v];
  return getS(x, y, l, ((l + r) >> 1), v << 1) +
         getS(x, y, ((l + r) >> 1) + 1, r, v << 1 | 1);
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", a + i);
  for (int i = 1; i <= n; i++) scanf("%d", b + i), mk[b[i]] = 1;
  for (__typeof(mk.begin()) i = (mk.begin()); i != (mk.end()); i++)
    i->second = ++cn;
  for (int i = 1; i <= n; i++) {
    c[i] = mk[b[i]];
    p[i] = {a[i], i};
  }
  sort(p + 1, p + n + 1);
  for (int i = 1; i <= n; i++) {
    long long s, t;
    ans += (1LL * (s = getS(1, c[p[i].second], 1, cn, 1)) * p[i].first) -
           (t = getT(1, c[p[i].second], 1, cn, 1));
    upd(c[p[i].second], p[i].first, 1, cn, 1);
  }
  printf("%lld\n", ans);
  return 0;
}
