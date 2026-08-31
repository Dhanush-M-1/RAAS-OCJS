#include <bits/stdc++.h>
using namespace std;
long long i, j, k, l, n, m, an, K, tot;
const long long N = 22;
long long d[N], ans[N][N];
bool ff[N][6];
bool dfs(long long k, long long ss) {
  if (ss > 5) return false;
  if (ff[k][ss]) return false;
  ff[k][ss] = true;
  if (!k) {
    if (!ss) return true;
    return false;
  }
  ss = ss * 10 + d[k];
  for (long long i = 0; i <= 6; i++)
    for (long long now = 0; now < 1 << i; now++) {
      long long s = 0;
      for (long long j = 0; j < i; j++)
        if (now & (1 << j))
          s += 4;
        else
          s += 7;
      if (s > ss) continue;
      if (dfs(k - 1, ss - s)) {
        for (long long j = 0; j < i; j++)
          if (now & (1 << j))
            ans[j][k] = 4;
          else
            ans[j][k] = 7;
        return true;
      }
    }
  return false;
}
int main() {
  long long T;
  scanf("%I64d", &T);
  while (T) {
    T--;
    memset(ans, 0, sizeof(ans));
    memset(ff, 0, sizeof(ff));
    scanf("%I64d", &n);
    tot = 0;
    while (n) {
      d[++tot] = n % 10;
      n /= 10;
    }
    if (!dfs(tot, 0))
      printf("-1");
    else
      for (long long i = 0; i < 6; i++) {
        long long k = 0;
        for (long long j = tot; j; j--)
          if (ans[i][j] != 0) {
            k = j;
            break;
          }
        if (!k)
          printf("0");
        else
          for (long long j = k; j; j--) printf("%I64d", ans[i][j]);
        printf(" ");
      }
    printf("\n");
  }
  return 0;
}
