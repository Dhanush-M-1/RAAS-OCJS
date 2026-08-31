#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC optimize("no-stack-protector")
#pragma GCC optimize("unroll-loops")
#pragma GCC target("sse,sse2,sse3,ssse3,popcnt,abm,mmx,tune=native")
#pragma GCC optimize("fast-math")
using namespace std;
long long MOD = 998244353;
long long ans[100007];
int a[100007], b[100007], t[100007];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, k;
  cin >> n >> k;
  ans[0] = 1;
  long long sum = 0;
  for (int i = 0; i < n; i++) {
    int u;
    cin >> u;
    u--;
    sum += ans[i];
    if (a[u] == 0) {
      for (int j = i; j >= 0; j--) {
        t[j]++;
        if (t[j] == k + 1) sum -= ans[j];
      }
    } else if (b[u] == 0) {
      for (int j = a[u] - 1; j >= 0; j--) {
        t[j]--;
        if (t[j] == k) sum += ans[j];
      }
      for (int j = i; j >= a[u]; j--) {
        t[j]++;
        if (t[j] == k + 1) sum -= ans[j];
      }
      b[u] = a[u];
    } else {
      for (int j = a[u] - 1; j >= b[u]; j--) {
        t[j]--;
        if (t[j] == k) sum += ans[j];
      }
      for (int j = i; j >= a[u]; j--) {
        t[j]++;
        if (t[j] == k + 1) sum -= ans[j];
      }
      b[u] = a[u];
    }
    a[u] = i + 1;
    ans[i + 1] = sum % MOD;
    if (ans[i + 1] < 0) ans[i + 1] += MOD;
  }
  cout << ans[n];
}
