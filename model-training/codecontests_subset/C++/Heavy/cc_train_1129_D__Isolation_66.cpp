#include <bits/stdc++.h>
#pragma GCC optimize("Ofast,no-stack-protector,unroll-loops,fast-math")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4.1,sse4.2,avx,popcnt,tune=native")
using namespace std;
const int MN = 100005, inf = 1000000005, mod = 998244353;
const long long INF = 1000000000000000005LL;
int t[MN], dp[MN], ile[MN], ost[MN], gdzie[MN];
int main() {
  int n, k;
  scanf("%d%d", &n, &k);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &t[i]);
    gdzie[i] = ost[t[i]];
    ost[t[i]] = i;
  }
  dp[0] = 1;
  long long res = 0LL;
  for (int i = 1; i <= n; ++i) {
    int a = gdzie[i], b = gdzie[gdzie[i]];
    for (int j = a; j < i; ++j) ++ile[j];
    for (int j = b; j < a; ++j) --ile[j];
    for (int j = 0; j < i; ++j) res += (ile[j] <= k) * dp[j];
    res %= mod;
    dp[i] = res;
    res = 0LL;
  }
  printf("%d", dp[n]);
}
