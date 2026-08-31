#include <bits/stdc++.h>
using namespace std;
long long a, b;
const int N = 200005;
int n;
long long ta[2 * N];
long long tb[2 * N];
void modify(int p, long long value) {
  int p2 = p;
  for (p += n, ta[p] = min(a, ta[p] + value); p > 1; p >>= 1)
    ta[p >> 1] = ta[p] + ta[p ^ 1];
  p = p2;
  for (p += n, tb[p] = min(b, tb[p] + value); p > 1; p >>= 1)
    tb[p >> 1] = tb[p] + tb[p ^ 1];
}
long long querya(int l, int r) {
  long long res = 0;
  for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
    if (l & 1) res += ta[l++];
    if (r & 1) res += ta[--r];
  }
  return res;
}
long long queryb(int l, int r) {
  long long res = 0;
  for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
    if (l & 1) res += tb[l++];
    if (r & 1) res += tb[--r];
  }
  return res;
}
int main() {
  int k, q;
  scanf("%d%d%lld%lld%d", &n, &k, &a, &b, &q);
  while (q--) {
    int tt;
    scanf("%d", &tt);
    if (tt == 1) {
      long long ai;
      int di;
      scanf("%d%lld", &di, &ai);
      di--;
      modify(di, ai);
    } else {
      int pi;
      scanf("%d", &pi);
      pi--;
      long long ans = queryb(0, pi) + querya(pi + k, n);
      printf("%lld\n", ans);
    }
  }
}
