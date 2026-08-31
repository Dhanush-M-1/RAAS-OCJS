#include <bits/stdc++.h>
using namespace std;
int n, i = 0, p = 1, m = 0;
int s[107];
void read() {
  s[0] = 1;
  while (1) {
    char a, b;
    scanf(" %c %c", &a, &b);
    if (b == '+') s[++i] = 1, p++;
    if (b == '-') s[++i] = -1, m++;
    if (b == '=') break;
  }
  scanf("%d", &n);
}
void solve() {
  if (p - n * m <= n && n <= n * p - m) {
    puts("Possible");
    int sum = 0;
    for (int j = 1; j <= i; j++) {
      s[j - 1] == 1 ? p-- : m--;
      for (int l = 1; l <= n; l++) {
        int v = l * s[j - 1];
        if (sum + v + p - n * m <= n && n <= sum + v + n * p - m) {
          printf("%d %c ", s[j - 1] * v, s[j] == 1 ? '+' : '-');
          sum += v;
          break;
        }
      }
    }
    printf("%d = %d", max(n - sum, sum - n), n);
  } else
    puts("Impossible");
}
int main() {
  read();
  solve();
  return 0;
}
