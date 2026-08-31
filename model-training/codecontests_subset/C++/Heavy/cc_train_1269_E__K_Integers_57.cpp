#include <bits/stdc++.h>
using namespace std;
int s[200005], sum[200005], ara[200005], p[200005], seg[4 * 200005];
void add(int x, int n) {
  while (x <= n) {
    sum[x]++;
    x += (x & -x);
  }
  return;
}
int query(int x) {
  int ret = 0;
  while (x) {
    ret += sum[x];
    x -= (x & -x);
  }
  return ret;
}
void update(int n, int s, int e, int indx) {
  if (s == indx && e == indx) {
    seg[n]++;
    return;
  }
  if (s > indx || e < indx) return;
  int mid = (s + e) / 2;
  update(n * 2, s, mid, indx);
  update(n * 2 + 1, mid + 1, e, indx);
  seg[n] = seg[n * 2] + seg[n * 2 + 1];
  return;
}
int query(int n, int s, int e, int k) {
  if (s == e && k == 1) return s;
  int mid = (s + e) / 2;
  if (seg[n * 2] < k)
    return query(n * 2 + 1, mid + 1, e, k - seg[n * 2]);
  else
    return query(n * 2, s, mid, k);
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &ara[i]), p[ara[i]] = i;
  for (int i = 1; i <= n; i++) s[i] = query(n) - query(p[i]), add(p[i], n);
  printf("0");
  long long res = 0;
  memset(sum, 0, sizeof sum);
  add(p[1], n);
  update(1, 1, n, p[1]);
  int mn = p[1], mx = p[1];
  for (int i = 2; i <= n; i++) {
    res += s[i];
    update(1, 1, n, p[i]);
    add(p[i], n);
    if (p[i] < mn || p[i] > mx)
      mn = min(mn, p[i]), mx = max(mx, p[i]);
    else {
      int x1 = query(p[i] - 1);
      int x2 = query(n) - x1 - 1;
      res -= min(x1, x2);
    }
    int l = p[i], r = query(1, 1, n, (i + 1) / 2);
    if (!(i & 1) && p[i] <= r) r = query(1, 1, n, (i + 2) / 2);
    if (l > r) swap(l, r);
    if (l < r) res += (r - l + 1) - (query(r) - query(l - 1));
    printf(" %lld", res);
  }
  puts("");
  return 0;
}
