#include <bits/stdc++.h>
using namespace std;
const int N = 200005;
int n, b[N];
long long BIT[N], a[N];
int lowbit(int x) { return x & (-x); }
void Add(int x, int y) {
  while (x <= n) {
    BIT[x] += y;
    x += lowbit(x);
  }
}
long long Sum(int x) {
  long long ans = 0;
  while (x) {
    ans += BIT[x];
    x -= lowbit(x);
  }
  return ans;
}
int main() {
  scanf("%d", &n);
  for (register int i = 1; i <= n; i++) {
    scanf("%I64d", &a[i]);
  }
  for (register int i = 1; i <= n; i++) Add(i, i);
  for (register int i = n; i >= 1; i--) {
    int l = 1, r = n;
    while (l <= r) {
      int mid = l + r >> 1;
      long long w = Sum(mid - 1);
      if (w <= a[i])
        l = mid + 1;
      else
        r = mid - 1;
    }
    b[i] = r;
    Add(r, -r);
  }
  for (register int i = 1; i <= n; i++) printf("%d ", b[i]);
  return 0;
}
