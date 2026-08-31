#include <bits/stdc++.h>
using namespace std;
const int MOD = 1000000007;
const int INF = 2e9;
const long long INFLL = 1e18;
const int MAX_N = 1;
int T;
long long N, L, R;
int main() {
  scanf("%d", &T);
  while (T--) {
    scanf("%lld", &N);
    scanf("%lld%lld", &L, &R);
    long long n = 1;
    while (L <= R) {
      while (n != N && L > (N - n) * 2LL) {
        L -= (N - n) * 2LL;
        R -= (N - n) * 2LL;
        n++;
      }
      if (n == N) {
        printf("1");
        break;
      }
      if (L % 2 == 1) {
        printf("%lld ", n);
      } else {
        printf("%lld ", (L / 2) + n);
      }
      L++;
    }
    printf("\n");
  }
  return 0;
}
