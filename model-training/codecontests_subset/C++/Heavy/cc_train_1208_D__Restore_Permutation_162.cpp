#include <bits/stdc++.h>
using namespace std;
int t, n;
long long s[200005];
long long T[200005 << 2];
void build(int u, int l, int r) {
  T[u] = 0;
  if (l == r) {
    T[u] = l;
    return;
  }
  build((u << 1), l, ((l + r) >> 1));
  build((u << 1 | 1), ((l + r) >> 1) + 1, r);
  T[u] = T[(u << 1)] + T[(u << 1 | 1)];
}
int query(int u, int l, int r, long long S) {
  if (l == r) return l;
  if (T[(u << 1)] > S)
    return query((u << 1), l, ((l + r) >> 1), S);
  else
    return query((u << 1 | 1), ((l + r) >> 1) + 1, r, S - T[(u << 1)]);
}
void change(int u, int l, int r, int p) {
  if (l == r) {
    T[u] = 0;
    return;
  }
  if (p <= ((l + r) >> 1))
    change((u << 1), l, ((l + r) >> 1), p);
  else
    change((u << 1 | 1), ((l + r) >> 1) + 1, r, p);
  T[u] = T[(u << 1)] + T[(u << 1 | 1)];
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%lld", &s[i]);
  }
  build(1, 1, n);
  vector<int> ans(n + 1);
  for (int i = n; i >= 1; i--) {
    ans[i] = query(1, 1, n, s[i]);
    change(1, 1, n, ans[i]);
  }
  for (int i = 1; i <= n; i++) {
    printf("%d ", ans[i]);
  }
  puts("");
  return 0;
}
