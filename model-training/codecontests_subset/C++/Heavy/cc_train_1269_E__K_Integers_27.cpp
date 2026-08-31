#include <bits/stdc++.h>
using namespace std;
int T, n, m, p, k, a[200010], pos[200010], bit[200010], hd;
long long ans = 0;
int query(int a) {
  int tmp = 0;
  for (int i = a; i >= 1; i -= (i & -i)) tmp += bit[i];
  return tmp;
}
void add(int a, int x) {
  for (int i = a; i <= n; i += (i & -i)) bit[i] += x;
}
set<int> S;
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]), pos[a[i]] = i;
  S.insert(INT_MIN);
  S.insert(INT_MAX);
  hd = pos[1];
  for (int i = 1; i <= n; i++) {
    ans += query(n) - query(pos[i]);
    add(pos[i], 1);
    if (pos[i] < hd)
      ans += hd - pos[i] - 1 - query(hd - 1) + query(pos[i]),
          ans -= query(pos[i] - 1);
    if (pos[i] > hd)
      ans += pos[i] - hd - 1 - query(pos[i] - 1) + query(hd),
          ans -= query(n) - query(pos[i]);
    S.insert(pos[i]);
    set<int>::iterator now = S.find(hd), l = now, r;
    l--;
    if ((*l) > 0) {
      if (query(n) - query(*l) <= i / 2 && query((*l) - 1) <= i / 2)
        ans += (hd - (*l) - 1) * (query(n) - 2 * query(hd - 1)), hd = *l;
    }
    now = S.find(hd), r = now;
    r++;
    if ((*r) <= n) {
      if (query(n) - query(*r) <= i / 2 && query((*r) - 1) <= i / 2)
        ans += ((*r) - hd - 1) * (2 * query(hd) - query(n)), hd = *r;
    }
    printf("%lld ", ans);
  }
}
