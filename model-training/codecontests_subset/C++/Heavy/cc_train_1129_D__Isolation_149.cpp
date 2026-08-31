#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2")
using namespace std;
using ll = long long;
int a[101001];
int b[101010];
int dp[101010];
int p1[101010];
int p2[101010];
ll ans = 0;
int n, k;
void add(int* __restrict a, int* __restrict dp, int n) {
  for (int i = 0; i < n; ++i) {
    a[i]++;
    ans -= a[i] == 0 ? dp[i] : 0;
  }
}
void sub(int* __restrict a, int* __restrict dp, int n) {
  for (int i = 0; i < n; ++i) {
    ans += a[i] == 0 ? dp[i] : 0;
    a[i]--;
  }
}
int main() {
  cin >> n >> k;
  for (int i = 0; i < n; ++i) {
    b[i] = -k - 1;
    cin >> a[i];
    --a[i];
    p1[i] = p2[i] = -1;
  }
  dp[0] = 1;
  ans = 1;
  for (int i = 0; i < n; ++i) {
    int x = a[i];
    sub(b + p2[x] + 1, dp + p2[x] + 1, p1[x] - p2[x]);
    add(b + p1[x] + 1, dp + p1[x] + 1, i - p1[x]);
    ans %= 998244353;
    if (ans < 0) ans += 998244353;
    dp[i + 1] = (int)ans;
    ans *= 2;
    p2[x] = p1[x];
    p1[x] = i;
  }
  cout << ans / 2 << endl;
  return 0;
}
