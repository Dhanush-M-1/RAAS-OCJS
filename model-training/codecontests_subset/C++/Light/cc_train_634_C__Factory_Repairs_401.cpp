#include <bits/stdc++.h>
using namespace std;
const int MAXN = 2 * 1e5 + 1;
int N, maxA, maxB, K, Q, A[MAXN];
int BIT1[MAXN], BIT2[MAXN];
void BIT_U(int ii, int val) {
  for (int i = ii + 1; i <= N; i += i & -i) BIT1[i] -= min(A[ii], maxB);
  for (int i = N - ii; i <= N; i += i & -i) BIT2[i] -= min(A[ii], maxA);
  A[ii] += val;
  for (int i = ii + 1; i <= N; i += i & -i) BIT1[i] += min(A[ii], maxB);
  for (int i = N - ii; i <= N; i += i & -i) BIT2[i] += min(A[ii], maxA);
}
int BIT_Q(int ii) {
  int ret = 0;
  for (int i = ii; i; i -= i & -i) ret += BIT1[i];
  for (int i = N - ii - K; i; i -= i & -i) ret += BIT2[i];
  return ret;
}
int main() {
  scanf("%d", &N), scanf("%d", &K);
  scanf("%d", &maxA), scanf("%d", &maxB);
  scanf("%d", &Q);
  memset(A, 0, sizeof(A));
  memset(BIT1, 0, sizeof(BIT1));
  memset(BIT2, 0, sizeof(BIT2));
  for (int q = 0; q < (int)Q; q++) {
    int t;
    scanf("%d", &t);
    if (t == 1) {
      int d, a;
      scanf("%d", &d), scanf("%d", &a);
      BIT_U(d - 1, a);
    } else {
      int p;
      scanf("%d", &p);
      printf("%d\n", BIT_Q(p - 1));
    }
  }
}
