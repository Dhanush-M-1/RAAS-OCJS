#include <bits/stdc++.h>
const int MAXN = 105;
int n;
int dp[MAXN][MAXN * MAXN];
using namespace std;
struct Record {
  int a, b;
} rec[MAXN];
bool cmp(const Record& x, const Record& y) {
  if (x.b != y.b)
    return x.b > y.b;
  else
    return x.a > y.a;
}
int main() {
  while (~scanf("%d", &n)) {
    int sum = 0;
    for (int i = 1; i <= n; i++) {
      scanf("%d", &rec[i].a);
      sum += rec[i].a;
    }
    for (int i = 1; i <= n; i++) scanf("%d", &rec[i].b);
    sort(rec + 1, rec + n + 1, cmp);
    int k;
    for (int i = 1, j = 0; i <= n; i++) {
      j += rec[i].b;
      if (j >= sum) {
        k = i;
        break;
      }
    }
    memset(dp, 0x80, sizeof dp);
    dp[0][0] = 0;
    for (int i = 1; i <= n; i++)
      for (int j = k; j > 0; j--)
        for (int l = 10000; l >= rec[i].b; l--)
          dp[j][l] = max(dp[j][l], dp[j - 1][l - rec[i].b] + rec[i].a);
    int temp = 0;
    for (int i = sum; i <= 100 * k; i++) temp = max(temp, dp[k][i]);
    printf("%d %d\n", k, sum - temp);
  }
  return 0;
}
