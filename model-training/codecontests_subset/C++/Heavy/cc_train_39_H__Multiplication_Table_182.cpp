#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const double eps = 1e-8;
const long long MOD = 1000000007;
const long long MAX = 11;
long long a[MAX][MAX];
int ts(int n, int m) {
  int i = 1;
  int r[3];
  while (n) {
    r[i++] = n % m;
    n /= m;
  }
  i--;
  int re = 0;
  while (i) {
    re *= 10;
    re += r[i];
    i--;
  }
  return re;
}
int main() {
  int i, j, k;
  int T, n, m;
  for (i = 0; i < MAX; i++) {
    for (j = 0; j < MAX; j++) a[i][j] = 0;
  }
  scanf("%d", &n);
  for (i = 1; i < n; i++) {
    for (j = 1; j < n; j++) {
      printf("%d", ts(i * j, n));
      if (j != n - 1) {
        printf(" ");
      } else {
        printf("\n");
      }
    }
  }
  return 0;
}
