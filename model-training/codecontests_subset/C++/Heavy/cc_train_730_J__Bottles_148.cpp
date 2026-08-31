#include <bits/stdc++.h>
using namespace std;
int N, K;
struct Bott {
  int a, b;
} p[105];
bool cmp(Bott x, Bott y) {
  if (x.b == y.b) return x.a < y.a;
  return x.b < y.b;
}
int s[105];
int f[2][105][20000 + 10];
int Ans = 0x3f3f3f3f;
int main() {
  scanf("%d", &N);
  for (int i = 1; i <= N; i++) scanf("%d", &p[i].a);
  for (int i = 1; i <= N; i++) scanf("%d", &p[i].b);
  sort(p + 1, p + 1 + N, cmp);
  for (int i = 1; i <= N; i++) {
    s[i] = s[i - 1] + p[i].a;
    p[i].b -= p[i].a;
  }
  for (int i = N, sum = 0; i >= 1; i--) {
    sum += p[i].b;
    if (sum >= s[i - 1]) {
      K = N - i + 1;
      break;
    }
  }
  memset(f, 0x3f, sizeof(f));
  f[0][0][10000] = 0;
  int S1 = 10000, S2 = 10000;
  for (int i = 1; i <= N; i++) {
    for (int j = 0; j <= i; j++)
      for (int k = S1; k <= S2; k++) {
        f[i & 1][j + 1][k + p[i].b] =
            min(f[i & 1][j + 1][k + p[i].b], f[(i - 1) & 1][j][k]);
        f[i & 1][j][k - p[i].a] =
            min(f[i & 1][j][k - p[i].a], f[(i - 1) & 1][j][k] + p[i].a);
        f[(i - 1) & 1][j][k] = 0x3f3f3f3f;
      }
    S1 -= p[i].a;
    S2 += p[i].b;
  }
  for (int i = 10000; i <= S2; i++) Ans = min(Ans, f[N & 1][K][i]);
  printf("%d %d", K, Ans);
  return 0;
}
