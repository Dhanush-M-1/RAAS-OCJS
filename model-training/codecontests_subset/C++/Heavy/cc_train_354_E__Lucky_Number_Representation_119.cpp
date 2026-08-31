#include <bits/stdc++.h>
using namespace std;
int a[30];
bool dp[30][10];
int c4[30][10], c7[30][10];
long long ten[20];
long long ans[10];
void func(void) {
  int i, j, k, p, q;
  for ((i) = 0; (i) < (int)(30); (i)++)
    for ((j) = 0; (j) < (int)(10); (j)++) dp[i][j] = false;
  dp[20][0] = true;
  for (i = 19; i >= 0; i--)
    for ((j) = 0; (j) < (int)(5); (j)++) {
      for ((p) = 0; (p) < (int)(7); (p)++)
        for ((q) = 0; (q) < (int)(7 - p); (q)++) {
          if ((4 * p + 7 * q + j) % 10 == a[i]) {
            int carry = (4 * p + 7 * q + j) / 10;
            if (dp[i + 1][carry]) {
              c4[i][j] = p;
              c7[i][j] = q;
              dp[i][j] = true;
            }
          }
        }
    }
  if (!dp[0][0]) {
    printf("-1\n");
    return;
  }
  for ((i) = 0; (i) < (int)(6); (i)++) ans[i] = 0;
  i = 0;
  j = 0;
  while (i <= 18) {
    p = c4[i][j];
    q = c7[i][j];
    for ((k) = 0; (k) < (int)(p); (k)++) ans[k] += ten[i] * 4;
    for ((k) = 0; (k) < (int)(q); (k)++) ans[p + k] += ten[i] * 7;
    j = (4 * p + 7 * q + j) / 10;
    i++;
  }
  for ((i) = 0; (i) < (int)(6); (i)++) {
    printf("%I64d", ans[i]);
    if (i == 5)
      printf("\n");
    else
      printf(" ");
  }
}
int main(void) {
  int Q, i, j;
  long long N;
  ten[0] = 1;
  for (i = 1; i <= 18; i++) ten[i] = ten[i - 1] * 10;
  cin >> Q;
  for ((i) = 0; (i) < (int)(Q); (i)++) {
    cin >> N;
    for ((j) = 0; (j) < (int)(20); (j)++) {
      a[j] = (int)(N % 10);
      N /= 10;
    }
    func();
  }
  return 0;
}
