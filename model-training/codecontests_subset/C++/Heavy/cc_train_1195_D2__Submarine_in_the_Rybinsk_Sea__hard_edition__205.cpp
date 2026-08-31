#include <bits/stdc++.h>
using namespace std;
const long long N = 100005, NN = 998244353;
long long n, i, ii, a[N], l = 0, r = 0, m, s = 0, ss = 0, biao;
int main() {
  scanf("%lld", &n);
  for (i = 0; i < n; i++) scanf("%d", &a[i]);
  sort(a, a + n);
  for (ii = 1; a[n - 1]; ii = ii * 100 % NN) {
    biao = 0;
    l = r;
    for (i = r; i < n; i++) {
      ss += a[i] % 10;
      a[i] /= 10;
      if (a[i] == 0) {
        biao = 1;
        r = i + 1;
      }
    }
    s = (s + ss * ii * 11 % NN * (n - l)) % NN;
    ss = 0;
    if (biao) {
      for (i = r; i < n; i++) ss += a[i];
      s = (s + ss % NN * (ii * 200 % NN) * (r - l)) % NN;
      ss = 0;
    }
  }
  printf("%lld\n", s);
}
