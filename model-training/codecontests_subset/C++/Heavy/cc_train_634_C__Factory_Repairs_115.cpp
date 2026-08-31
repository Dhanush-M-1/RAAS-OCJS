#include <bits/stdc++.h>
int N, K, A, B, Q, a[200001], TA[524288], TB[524288];
void P(int x) {
  int p = 1, l = 1, r = N;
  while (l < r) {
    int m = l + r >> 1;
    if (x <= m)
      r = m, p <<= 1;
    else
      l = m + 1, p = p << 1 | 1;
  }
  TA[p] = std::min(a[x], A);
  TB[p] = std::min(a[x], B);
  while (p > 1) {
    p >>= 1;
    TA[p] = TA[p << 1] + TA[p << 1 | 1];
    TB[p] = TB[p << 1] + TB[p << 1 | 1];
  }
}
int G(int *T, int p, int l, int r, int L, int R) {
  if (L <= l && r <= R) return T[p];
  int m = l + r >> 1;
  if (R <= m) return G(T, p << 1, l, m, L, R);
  if (L > m) return G(T, p << 1 | 1, m + 1, r, L, R);
  return G(T, p << 1, l, m, L, R) + G(T, p << 1 | 1, m + 1, r, L, R);
}
int main() {
  scanf("%d%d%d%d%d", &N, &K, &A, &B, &Q);
  while (Q--) {
    int ty, u, w;
    scanf("%d%d", &ty, &u);
    if (ty == 1) {
      scanf("%d", &w);
      a[u] += w;
      P(u);
    } else
      printf("%d\n", (u > 1 ? G(TB, 1, 1, N, 1, u - 1) : 0) +
                         (u > N - K ? 0 : G(TA, 1, 1, N, u + K, N)));
  }
  return 0;
}
