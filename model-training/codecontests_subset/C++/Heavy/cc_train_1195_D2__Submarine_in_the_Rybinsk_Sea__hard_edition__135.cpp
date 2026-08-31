#include <bits/stdc++.h>
using namespace std;
long long MOD = 998244353;
long long get_length(long long n) {
  if (n == 0) return 0;
  return get_length(n / 10) + 1;
}
long long N;
long long get_ze0(long long n, long long cnt) {
  if (cnt <= 0) return n;
  if (n / 10 == 0) return n * 10;
  return (get_ze0(n / 10, cnt - 1) * 100 + n % 10 * 10) % MOD;
}
long long get_ze1(long long n, long long cnt) {
  if (cnt <= 0) return n;
  if (n / 10 == 0) return n;
  return (get_ze1(n / 10, cnt - 1) * 100 + n % 10) % MOD;
}
long long cnt_legth[11];
long long zero_added[111111][2][11];
long long legth[111111];
int main(void) {
  scanf("%lld", &N);
  for (long long i = 1; i <= N; ++i) {
    scanf("%lld", &zero_added[i][1][0]);
    legth[i] = get_length(zero_added[i][1][0]);
    cnt_legth[legth[i]]++;
    for (long long j = 1; j < 11; ++j) {
      zero_added[i][0][j] = get_ze0(zero_added[i][1][0], j);
      zero_added[i][1][j] = get_ze1(zero_added[i][1][0], j);
    }
  }
  long long res = 0;
  for (long long i = 1; i <= N; ++i) {
    for (long long l = 1; l < 11; ++l) {
      res += cnt_legth[l] * ((zero_added[i][0][l] + zero_added[i][1][l]) % MOD);
      res %= MOD;
    }
  }
  printf("%lld\n", res);
  return 0;
}
