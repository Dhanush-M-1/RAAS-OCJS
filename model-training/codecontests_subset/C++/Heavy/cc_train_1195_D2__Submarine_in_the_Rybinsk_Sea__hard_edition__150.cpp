#include <bits/stdc++.h>
template <class T>
int gmax(T &a, T b) {
  if (b > a) {
    a = b;
    return 1;
  }
  return 0;
}
template <class T>
int gmin(T &a, T b) {
  if (b < a) {
    a = b;
    return 1;
  }
  return 0;
}
using namespace std;
const int MAXN = 1e5 + 5;
const int MOD = 998244353;
int a[MAXN];
int has[15];
int sum[15];
long long sum2[15];
long long ten[25];
long long Pow(long long x, long long y) {
  long long ans = 1;
  while (y) {
    if (y & 1) ans = 1ll * ans * x % MOD;
    x = 1ll * x * x % MOD;
    y >>= 1;
  }
  return ans;
}
long long getSum2(int x) {
  if (x <= 0)
    return 0;
  else
    return sum2[x];
}
int getSum(int x) {
  if (x <= 0)
    return 0;
  else
    return sum[x];
}
int main() {
  int n;
  ten[0] = 1;
  for (int i = 1; i < 25; ++i) {
    ten[i] = ten[i - 1] * 10 % MOD;
  }
  while (~scanf("%d", &n)) {
    memset(has, 0, sizeof(has));
    for (int i = 0; i < n; ++i) {
      scanf("%d", &a[i]);
    }
    for (int i = 0; i < n; ++i) {
      int tmp = a[i];
      int cnt = 0;
      while (tmp) {
        cnt++;
        tmp /= 10;
      }
      has[cnt]++;
    }
    sum[0] = 0;
    for (int i = 1; i < 15; ++i) {
      sum[i] = sum[i - 1] + has[i];
    }
    sum2[0] = 0;
    for (int i = 1; i < 15; ++i) {
      sum2[i] = (sum2[i - 1] + 1ll * has[i] * ten[i] % MOD) % MOD;
    }
    long long result = 0;
    for (int i = 0; i < n; ++i) {
      int tmp = a[i];
      int cnt = 1;
      while (tmp) {
        int tt = tmp % 10;
        result =
            (result + tt * getSum2(cnt - 2) % MOD * ten[cnt - 1] % MOD) % MOD;
        result = (result +
                  tt * (n - getSum(cnt - 2)) % MOD * ten[cnt * 2 - 2] % MOD) %
                 MOD;
        result =
            (result + tt * getSum2(cnt - 1) % MOD * ten[cnt - 1] % MOD) % MOD;
        result = (result +
                  tt * (n - getSum(cnt - 1)) % MOD * ten[cnt * 2 - 1] % MOD) %
                 MOD;
        tmp /= 10;
        cnt++;
      }
    }
    printf("%lld\n", result);
  }
  return 0;
}
