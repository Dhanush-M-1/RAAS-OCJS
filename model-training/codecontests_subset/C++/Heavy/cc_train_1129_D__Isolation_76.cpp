#include <bits/stdc++.h>
#pragma GCC optimize("O2")
using namespace std;
const long long MXN = 1e5 + 10;
const long long SQR = 400;
const long long MXB = MXN / SQR + 10;
const long long MXM = SQR * 2 + 10;
const long long Mod = 998244353;
inline void mkay(long long& x) {
  if (x >= Mod) x -= Mod;
}
long long n, k;
long long A[MXN], dt[MXN], dp[MXN];
long long my[MXN], sigma[MXB][MXM];
deque<long long> Pos[MXN];
void Build(long long t) {
  long long s = max(t * SQR, 1ll), e = min(n, (t + 1) * SQR - 1);
  my[e] = dt[e];
  for (int i = e - 1; i >= s; i--) my[i] = my[i + 1] + dt[i];
  memset(sigma[t], 0, sizeof sigma[t]);
  for (int i = s; i <= e; i++) {
    sigma[t][my[i] + SQR] += dp[i - 1];
    mkay(sigma[t][my[i] + SQR]);
  }
  for (int i = 1; i < MXM; i++) {
    sigma[t][i] += sigma[t][i - 1];
    mkay(sigma[t][i]);
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> k;
  for (int i = 1; i <= n; i++) cin >> A[i];
  dp[0] = 1;
  for (int i = 1; i <= n; i++) {
    if (Pos[A[i]].size() == 2) {
      dt[Pos[A[i]][0]] = 0;
      if (Pos[A[i]][0] / SQR < i / SQR) Build(Pos[A[i]][0] / SQR);
      Pos[A[i]].pop_front();
    }
    Pos[A[i]].push_back(i);
    if (Pos[A[i]].size() == 2) {
      dt[Pos[A[i]][0]] = -1;
      if (Pos[A[i]][0] / SQR < i / SQR) Build(Pos[A[i]][0] / SQR);
    }
    dt[i] = 1;
    long long now = 0;
    for (int j = i; j / SQR == i / SQR; j--) {
      now += dt[j];
      if (now <= k) dp[i] += dp[j - 1], mkay(dp[i]);
    }
    for (int t = (i / SQR) - 1; t >= 0; t--) {
      long long s = max(t * SQR, 1ll), e = min(n, (t + 1) * SQR - 1);
      long long exp = k - now + SQR;
      if (0 <= exp) {
        dp[i] += sigma[t][min(MXM - 1, k - now + SQR)];
        mkay(dp[i]);
      }
      now += my[s];
    }
    if (i % SQR == SQR - 1) Build(i / SQR);
  }
  cout << dp[n] << '\n';
  return 0;
}
