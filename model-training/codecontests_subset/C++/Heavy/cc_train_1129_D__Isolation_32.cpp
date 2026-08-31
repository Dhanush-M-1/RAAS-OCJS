#include <bits/stdc++.h>
using namespace std;
const int mod = 998244353;
const int b = 325;
int dp[100005];
int a[100005], cnt[100005];
int s[100005], e[100005];
vector<int> v[100005];
struct bucket {
  int val[2 * b + 5];
  int sum = 0;
  void rebuild(int s, int e) {
    for (int i = 0; i <= 2 * b; i++) val[i] = 0;
    sum = 0;
    for (int i = e; i >= s; i--) {
      sum += cnt[i];
      val[b + sum] = (val[b + sum] + dp[i - 1]) % mod;
    }
    for (int i = 1; i <= 2 * b; i++) val[i] = (val[i] + val[i - 1]) % mod;
  }
} bucket[b + 5];
int main() {
  int n, k, a;
  scanf("%d%d", &n, &k);
  for (int i = 1; i <= n; i++) {
    int bi = i / b;
    e[bi] = i;
    if (s[bi] == 0) s[bi] = i;
  }
  dp[0] = 1;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a);
    if (v[a].size() >= 1) {
      cnt[v[a][v[a].size() - 1]] = -1;
      int idx = (v[a][v[a].size() - 1]) / b;
      bucket[idx].rebuild(s[idx], e[idx]);
      if (v[a].size() >= 2) {
        cnt[v[a][v[a].size() - 2]] = 0;
        int idx = (v[a][v[a].size() - 2]) / b;
        bucket[idx].rebuild(s[idx], e[idx]);
      }
    }
    v[a].push_back(i);
    cnt[i] = 1;
    int idx = i / b;
    bucket[idx].rebuild(s[idx], e[idx]);
    int l = 1, r = i;
    int bl = l / b, br = r / b;
    if (bl == br) {
      int sum = 0;
      for (int j = r; j >= l; j--) {
        sum += cnt[j];
        if (sum <= k) dp[i] = (dp[i] + dp[j - 1]) % mod;
      }
    } else {
      int sum = 0;
      for (int j = r; j >= s[br]; j--) {
        sum += cnt[j];
        if (sum <= k) dp[i] = (dp[i] + dp[j - 1]) % mod;
      }
      for (int j = br - 1; j >= bl + 1; j--) {
        int d = min(2 * b, k - sum + b);
        if (d >= 0) dp[i] = (dp[i] + bucket[j].val[d]) % mod;
        sum += bucket[j].sum;
      }
      for (int j = e[bl]; j >= l; j--) {
        sum += cnt[j];
        if (sum <= k) dp[i] = (dp[i] + dp[j - 1]) % mod;
      }
    }
  }
  printf("%d\n", dp[n]);
}
