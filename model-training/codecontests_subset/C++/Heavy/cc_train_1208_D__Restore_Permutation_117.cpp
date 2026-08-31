#include <bits/stdc++.h>
using namespace std;
using pii = pair<long long, int>;
const int maxn = 2e5 + 5;
int n;
long long a[maxn], s[maxn], t[maxn << 2];
void build(int l, int r, int rt) {
  if (l == r) {
    t[rt] = l;
    return;
  }
  int m = l + r >> 1;
  build(l, m, rt << 1);
  build(m + 1, r, rt << 1 | 1);
  t[rt] = t[rt << 1] + t[rt << 1 | 1];
}
void update(int pos, int l, int r, int rt) {
  if (l > pos || r < pos) return;
  if (l == r) {
    t[rt] = 0;
    return;
  }
  int m = l + r >> 1;
  update(pos, l, m, rt << 1);
  update(pos, m + 1, r, rt << 1 | 1);
  t[rt] = t[rt << 1] + t[rt << 1 | 1];
}
int query(long long q, int l, int r, int rt) {
  if (l == r) return l;
  int m = l + r >> 1;
  if (t[rt << 1] > q)
    return query(q, l, m, rt << 1);
  else
    return query(q - t[rt << 1], m + 1, r, rt << 1 | 1);
}
void pri(int l, int r, int rt) {
  if (l == r) {
    printf("%lld  ", t[rt]);
    return;
  }
  int m = l + r >> 1;
  pri(l, m, rt << 1);
  pri(m + 1, r, rt << 1 | 1);
}
int main() {
  scanf("%d", &n);
  build(1, n, 1);
  for (int i = 1; i <= n; i++) scanf("%lld", s + i);
  for (int i = n; i > 0; i--) {
    a[i] = query(s[i], 1, n, 1);
    update(a[i], 1, n, 1);
  }
  for (int i = 1; i <= n; i++) printf("%lld ", a[i]);
}
