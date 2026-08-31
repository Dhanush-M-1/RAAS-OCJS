#include <iostream>

const int MOD = 1e9 + 7;
const int MX = 2e5 + 55;
int memo[MX + 1];
int d[10];

int main() {
  std::ios_base::sync_with_stdio(0); std::cin.tie(0);
  int t = 1; scanf("%d", &t);

  d[0] = 1;

  for (int i = 1; i <= MX; i++) {
    int tmp[10] = { 0 };

    for (int j = 0; j <= 9; j++) {
      if (j == 9) {
        tmp[1] = (tmp[1] + d[j]) % MOD;
        tmp[0] = (tmp[0] + d[j]) % MOD;
      } else {
        tmp[j + 1] = d[j];
      }
    }

    for (int j = 0; j <= 9; j++) {
      d[j] = tmp[j];
      memo[i] = (memo[i] + d[j]) % MOD;
    }
  }

  while (t--) {
    int n, m; scanf("%d%d", &n, &m);
    int ans = 0;

    while (n) {
      ans = (ans + memo[m + n % 10]) % MOD;
      n /= 10;
    }

    printf("%d\n", ans);
  }
}