#include <bits/stdc++.h>
using namespace std;
void ga(int N, int *A) {
  for (int i(0); i < N; i++) scanf("%d", A + i);
}
int N, A[(1000006)], g, l, G[(1000006)], L[(1000006)], P[(1000006)], a, W;
long long S, X;
int main(void) {
  scanf("%d", &N), ga(N, A + 1);
  for (int k(1); k < N + 1; k++)
    if (A[k] > k)
      ++g, S += a = A[k] - k, --G[a], ++L[a], P[N - k] += 2 * A[k] - 1 - N,
                ++G[N - k], --L[N - k];
    else
      ++l, S += k - A[k], a = N - k + A[k], --G[a], ++L[a],
                          P[N - k] += 2 * A[k] - 1 - N, ++G[N - k], --L[N - k];
  X = S;
  for (int k(0); k < N; k++) {
    l += L[k], g += G[k], S += P[k] + l - g + 1;
    if (S < X) X = S, W = k + 1;
  }
  printf("%lld %d\n", X, W);
  return 0;
}
