#include <bits/stdc++.h>
using namespace std;
long long int num4[10][10], num7[10][10];
long long int p[10];
long long int ok, n4[20], n7[20];
long long int n;
void pre() {
  memset(p, 0, sizeof(p));
  for (int i = 0; i <= 6; i++) {
    for (int k = 0; k + i <= 6; k++) {
      int mod = (i * 4 + k * 7) % 10;
      num4[mod][++p[mod]] = i;
      num7[mod][p[mod]] = k;
    }
  }
}
void output() {
  long long int x[10];
  memset(x, 0, sizeof(x));
  long long int w = 1;
  for (int i = 1; i <= 18; i++) {
    int no = 1;
    for (int k = 1; k <= n4[i]; k++) x[k] += 4 * w;
    for (int k = n4[i] + 1; k <= n4[i] + n7[i]; k++) x[k] += 7 * w;
    w *= 10;
  }
  printf("%I64d %I64d %I64d %I64d %I64d %I64d\n", x[1], x[2], x[3], x[4], x[5],
         x[6]);
}
void dp(long long int w) {
  if (n == 0) {
    ok = 1;
    output();
    return;
  } else if (n > 0) {
    long long int tmp = n;
    if (!ok) {
      long long int x = (n % 10);
      for (int i = 1; i <= p[x]; i++) {
        if (n - (4 * num4[x][i] + 7 * num7[x][i]) >= 0 && !ok) {
          n = (n - (4 * num4[x][i] + 7 * num7[x][i])) / 10;
          n4[w] = num4[x][i];
          n7[w] = num7[x][i];
          dp(w + 1);
          n = tmp;
          n4[w] = 0;
          n7[w] = 0;
        }
      }
    }
  }
}
int main() {
  pre();
  int time;
  scanf("%d", &time);
  while (time--) {
    scanf("%I64d", &n);
    memset(n4, 0, sizeof(n4));
    memset(n7, 0, sizeof(n7));
    ok = 0;
    dp(1);
    if (!ok) cout << -1 << endl;
  }
  return 0;
}
