#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9 + 7;
const int mod = 1e9 + 7;
long long int powmod(long long int a, long long int b) {
  long long int res = 1;
  a %= mod;
  assert(b >= 0);
  for (; b; b >>= 1) {
    if (b & 1) res = res * a % mod;
    a = a * a % mod;
  }
  return res;
}
int nxt() {
  int x;
  scanf("%d", &x);
  return x;
}
void max_self(long long int &a, long long int b) { a = max(a, b); }
int main() {
  int n = nxt();
  vector<long long int> dp(10);
  for (int i = 0; i < 10; i++) dp[i] = LLONG_MIN;
  dp[0] = 0;
  for (int i = 0; i < n; i++) {
    vector<long long int> tmp = dp;
    int k = nxt();
    vector<int> a[3];
    long long int best = 0;
    for (int _ = 0; _ < k; _++) {
      int c = nxt(), d = nxt();
      c--;
      a[c].push_back(d);
      max_self(best, d);
    }
    for (int j = 0; j < 3; j++)
      sort((a[j]).begin(), (a[j]).end(), greater<int>());
    for (int j = 0; j < 10; j++) {
      max_self(tmp[(j + 1) % 10], dp[j] + best * (j == 9 ? 2 : 1));
    }
    if (a[0].size() >= 2) {
      long long int tt = 1LL * a[0][0] + a[0][1];
      long long int t2 = a[0][0];
      for (int j = 0; j < 10; j++) {
        max_self(tmp[(j + 2) % 10], dp[j] + tt + (j >= 8 ? t2 : 0));
      }
    }
    if (a[0].size() && a[1].size()) {
      long long int tt = 1LL * a[0][0] + a[1][0];
      long long int t2 = max(a[0][0], a[1][0]);
      for (int j = 0; j < 10; j++) {
        max_self(tmp[(j + 2) % 10], dp[j] + tt + (j >= 8 ? t2 : 0));
      }
    }
    if (a[0].size() >= 3) {
      long long int tt = 1LL * a[0][0] + a[0][1] + a[0][2];
      long long int t2 = a[0][0];
      for (int j = 0; j < 10; j++) {
        max_self(tmp[(j + 3) % 10], dp[j] + tt + (j >= 7 ? t2 : 0));
      }
    }
    dp = tmp;
  }
  printf("%lld\n", *max_element((dp).begin(), (dp).end()));
  return 0;
}
