#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 100;
long long BIT[2][N];
inline long long getPrefix(int i, int z) {
  ++i;
  long long ret = 0;
  while (i) ret += BIT[z][i], i -= i & -i;
  return ret;
}
inline void add(int i, long long v, int z) {
  ++i;
  while (i < N) BIT[z][i] += v, i += i & -i;
}
inline long long getRange(int l, int r, int z) {
  return getPrefix(r, z) - getPrefix(l - 1, z);
}
long long arr[N], brr[N], a, b, n, k, q;
int main() {
  cin >> n >> k >> a >> b >> q;
  for (int C = 0; C < q; ++C) {
    long long type;
    scanf("%lld", &type);
    if (type == 1) {
      long long d, c;
      scanf("%lld", &d), scanf("%lld", &c);
      add(d, min(c, a - arr[d]), 0);
      arr[d] = min(a, arr[d] + c);
      add(d, min(c, b - brr[d]), 1);
      brr[d] = min(b, brr[d] + c);
    }
    if (type == 2) {
      long long p;
      scanf("%lld", &p);
      printf("%lld\n", getRange(1, p - 1, 1) + getRange(p + k, n, 0));
    }
  }
}
