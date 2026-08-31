#include <bits/stdc++.h>
struct BIT {
  int n;
  long long a[200005];
  int lowbit(int x) { return x & -x; }
  void build(int size) { n = size; }
  void update(int x, int val) {
    for (; x <= n; x += lowbit(x)) a[x] += val;
  }
  long long query(int x) {
    long long ret = 0;
    for (; x; x -= lowbit(x)) ret += a[x];
    return ret;
  }
};
BIT b;
long long s[200005];
int a[200005];
int main() {
  int n;
  scanf("%d", &n);
  b.build(n);
  for (int i = 1; i <= n; ++i) scanf("%lld", &s[i]);
  for (int i = 1; i <= n; ++i) b.update(i, i);
  for (int i = n; i; --i) {
    int left = 1, right = n;
    while (left < right) {
      int mid = (left + right + 1) >> 1;
      if (b.query(mid - 1) <= s[i])
        left = mid;
      else
        right = mid - 1;
    }
    a[i] = left;
    b.update(a[i], -a[i]);
  }
  for (int i = 1; i <= n; ++i) printf("%d ", a[i]);
  return 0;
}
