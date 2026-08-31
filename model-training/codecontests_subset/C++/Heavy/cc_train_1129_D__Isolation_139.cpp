#include <bits/stdc++.h>
using namespace std;
long long MOD = 998244353;
long long mpow(long long a, long long b) {
  if (b == 0) return 1;
  long long t1 = mpow(a, b / 2);
  t1 *= t1;
  t1 %= MOD;
  if (b % 2) t1 *= a;
  t1 %= MOD;
  return t1;
}
const long long N = 1e5 + 5;
const long long block = 320;
vector<long long> mcount(N, 0);
vector<long long> offset(block, 0);
vector<long long> mprev(N, 0), dp(N, 0);
vector<long long> recent(N, 0);
long long n, k;
long long ans;
vector<vector<long long> > sum(block, vector<long long>(N, 0));
void update(long long st, long long la, long long val) {
  if (st <= 0 || la <= 0) return;
  for (long long i = 0; i < block; i++) {
    long long stb = i * block + 1, lab = (i + 1) * block;
    if (stb > la || lab < st)
      continue;
    else if (stb >= st && la >= lab) {
      if (val == 1 && k - offset[i] >= 0)
        ans -= sum[i][k - offset[i]];
      else if (val == -1 && k + 1 - offset[i] >= 0)
        ans += sum[i][k + 1 - offset[i]];
      ans = (ans + MOD) % MOD;
      offset[i] += val;
    } else {
      for (long long j = stb; j < lab + 1; j++) {
        if (j < st || j > la) continue;
        if (val == 1 && offset[i] + mcount[j] == k) {
          ans -= dp[j - 1];
        } else if (val == -1 && offset[i] + mcount[j] == k + 1)
          ans += dp[j - 1];
        ans = (ans + MOD) % MOD;
        sum[i][mcount[j]] -= dp[j - 1] - MOD;
        sum[i][mcount[j]] %= MOD;
        mcount[j] += val;
        sum[i][mcount[j]] += dp[j - 1];
        sum[i][mcount[j]] %= MOD;
      }
    }
  }
}
void solve() {
  cin >> n >> k;
  dp[0] = 1;
  for (long long i = 1; i < n + 1; i++) {
    long long a;
    cin >> a;
    ans += dp[i - 1];
    ans %= MOD;
    sum[(i - 1) / block][0] += dp[i - 1];
    sum[(i - 1) / block][0] %= MOD;
    mprev[i] = recent[a];
    update(mprev[i] + 1, i, 1);
    update(mprev[mprev[i]] + 1, mprev[i], -1);
    recent[a] = i;
    dp[i] = ans;
  }
  cout << ans << "\n";
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long t = 1;
  for (long long i = 0; i < t; i++) {
    solve();
  }
  return 0;
}
