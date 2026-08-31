#include <bits/stdc++.h>
using namespace std;
void ga(int N, int *A) {
  for (int i(0); i < N; i++) scanf("%d", A + i);
}
struct FT {
  long long t[(1 << 19)], S;
  void clr(long long s) {
    (memset(t, 0, sizeof(t)));
    S = s;
  }
  void inc(long long i, long long d) {
    for (; i < S; i |= i + 1) t[i] += d;
  }
  long long sum(long long i) {
    long long s(0);
    while (~i) s += t[i], i &= i + 1, --i;
    return s;
  }
  long long gt(long long l, long long r) {
    if (l > S) return 0;
    if (l < 1) return 0;
    r = min(r, S);
    return sum(r) - sum(l - 1);
  }
} U, V;
int N, K, a, b, Q, u, v, h, B, E;
int main(void) {
  scanf("%d%d%d%d%d", &N, &K, &a, &b, &Q);
  U.clr(N + 5), V.clr(N + 5);
  for (int i(0); i < Q; i++) {
    scanf("%d%d", &h, &B);
    if (h == 1) {
      scanf("%d", &E);
      u = U.gt(B, B), v = V.gt(B, B);
      if (u + E >= b)
        U.inc(B, b - u);
      else
        U.inc(B, E);
      if (v + E >= a)
        V.inc(B, a - v);
      else
        V.inc(B, E);
    } else
      printf("%lld\n", U.gt(1, B - 1) + V.gt(B + K, N + 1));
  }
  return 0;
}
