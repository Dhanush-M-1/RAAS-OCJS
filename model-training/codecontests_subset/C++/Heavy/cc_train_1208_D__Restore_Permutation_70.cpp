#include <bits/stdc++.h>
using namespace std;
long long t[200025 * 4], lz[200025 * 4], n, a[200025];
void build(int l, int r, int i) {
  t[i] = 1ll * l * (l - 1) / 2;
  if (l == r) return;
  build(l, (l + r) / 2, i * 2 + 1);
  build((l + r) / 2 + 1, r, i * 2 + 2);
  t[i] = max(t[i * 2 + 1], t[i * 2 + 2]);
}
void down(int i) {
  lz[i * 2 + 1] += lz[i];
  lz[i * 2 + 2] += lz[i];
  t[i * 2 + 1] += lz[i];
  t[i * 2 + 2] += lz[i];
  lz[i] = 0;
}
void updata(int L, int R, long long v, int l, int r, int i) {
  if (L <= l && R >= r) {
    t[i] += v;
    lz[i] += v;
    return;
  }
  if (lz[i]) down(i);
  if (L <= (l + r) / 2) updata(L, R, v, l, (l + r) / 2, i * 2 + 1);
  if (R > (l + r) / 2) updata(L, R, v, (l + r) / 2 + 1, r, i * 2 + 2);
  t[i] = max(t[i * 2 + 1], t[i * 2 + 2]);
}
int query(long long v, int l, int r, int i) {
  if (l == r) return l;
  if (lz[i]) down(i);
  if (t[i * 2 + 1] >= v) return query(v, l, (l + r) / 2, i * 2 + 1);
  return query(v, (l + r) / 2 + 1, r, i * 2 + 2);
}
int main() {
  cin >> n;
  for (int i = (1); i <= (n); i++) scanf("%lld", &a[i]);
  build(1, n, 0);
  for (int i = (n); i >= (1); i--) {
    a[i] = query(a[i], 1, n, 0);
    if (a[i] < n) updata(a[i] + 1, n, -a[i], 1, n, 0);
    updata(a[i], a[i], -1e12, 1, n, 0);
  }
  for (int i = (1); i <= (n); i++) printf("%lld%c", a[i], i == n ? '\n' : ' ');
  return 0;
}
