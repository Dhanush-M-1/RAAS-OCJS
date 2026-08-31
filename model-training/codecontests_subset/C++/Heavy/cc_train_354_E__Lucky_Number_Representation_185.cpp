#include <bits/stdc++.h>
using namespace std;
template <typename T, typename U>
inline void smin(T &a, U b) {
  if (a > b) a = b;
}
template <typename T, typename U>
inline void smax(T &a, U b) {
  if (a < b) a = b;
}
int d[22];
int dp[22][5];
pair<pair<int, int>, int> pre[22][5];
int cnt[22][2];
int main() {
  int t;
  long long n;
  for (scanf("%d", &t); t--;) {
    scanf("%I64d", &n);
    int m = 0;
    while (n) {
      d[m++] = n % 10;
      n /= 10;
    }
    memset(dp, 0, sizeof(dp));
    dp[m][0] = 1;
    for (int i = m; i--;) {
      for (int j = 0; j < 5; j++) {
        for (int a = 0; a <= 6; a++) {
          for (int b = 0; b <= 6 - a; b++) {
            int val = a * 4 + b * 7;
            if ((val + j) % 10 != d[i]) continue;
            if (dp[i + 1][(val + j) / 10]) {
              dp[i][j] = 1;
              pre[i][j] = pair<pair<int, int>, int>(pair<int, int>(a, b),
                                                    (val + j) / 10);
              break;
            }
          }
          if (dp[i][j]) break;
        }
      }
    }
    if (!dp[0][0])
      puts("-1");
    else {
      for (int i = 0, up = 0; i < m; i++) {
        cnt[i][0] = pre[i][up].first.first;
        cnt[i][1] = pre[i][up].first.second;
        up = pre[i][up].second;
      }
      for (int i = 0; i < 6; i++) {
        long long val = 0;
        for (int i = m; i--;) {
          val *= 10;
          if (cnt[i][0] > cnt[i][1])
            val += 4, cnt[i][0]--;
          else if (cnt[i][1])
            val += 7, cnt[i][1]--;
        }
        printf("%I64d ", val);
      }
      puts("");
    }
  }
  return 0;
}
