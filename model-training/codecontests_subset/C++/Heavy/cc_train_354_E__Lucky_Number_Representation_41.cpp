#include <bits/stdc++.h>
using namespace std;
int luck_number[105], tot;
int dp[10005][7];
bool is_luck(int x) {
  while (x) {
    int y = x % 10;
    x = x / 10;
    if (y > 0 && y < 4) return false;
    if (y > 4 && y < 7) return false;
    if (y > 7) return false;
  }
  return true;
}
void init() {
  tot = 0;
  for (int i = 0; i <= 10000; i++) {
    if (is_luck(i)) luck_number[tot++] = i;
  }
}
void pre10000() {
  for (int i = 0; i <= 10000; i++)
    for (int j = 0; j <= 6; j++) dp[i][j] = -1;
  for (int i = 0; i <= 6; i++) {
    dp[0][i] = 0;
  }
  for (int i = 1; i <= 6; i++) {
    for (int j = 0; j < tot; j++) {
      int x = luck_number[j];
      for (int k = x; k <= 10000; k++) {
        if (dp[k - x][i - 1] != -1) {
          dp[k][i] = x;
        }
      }
    }
  }
}
int main() {
  init();
  pre10000();
  int cas;
  scanf("%d", &cas);
  while (cas--) {
    long long N;
    cin >> N;
    if (N < 10000LL) {
      int n = (int)(N);
      if (dp[n][6] != -1) {
        for (int i = 6; i > 0; i--) {
          printf("%d ", dp[n][i]);
          n -= dp[n][i];
        }
        puts("");
      } else
        printf("-1\n");
    } else {
      int n1 = (int)(N % 4000LL);
      if (dp[n1][6] == -1) n1 += 4000, N -= 4000;
      long long res[7];
      for (int i = 6; i > 0; i--) {
        res[i] = (long long)(dp[n1][i]);
        n1 -= dp[n1][i];
      }
      long long n2 = N - n1;
      long long p = n2 / 4000LL, base = 1000LL;
      while (p) {
        int d = (int)(p % 10LL);
        if (d <= 6) {
          for (int i = 1; i <= d; i++) {
            res[i] += base * 4;
          }
        } else {
          for (int i = 1; i <= d - 7; i++) {
            res[i] += base * 4;
          }
          for (int i = 6; i >= 3; i--) {
            res[i] += base * 7;
          }
        }
        base *= 10LL;
        p /= 10LL;
      }
      for (int i = 1; i <= 6; i++) cout << res[i] << " ";
      puts("");
    }
  }
  return 0;
}
