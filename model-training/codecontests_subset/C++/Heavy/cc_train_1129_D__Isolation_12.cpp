#include <bits/stdc++.h>
using namespace std;
const int MAXN = 2000 * 100 + 1;
const int Q = 100;
const int MOD = 998244353;
const int UNDEF = -10;
int a[MAXN];
int b[MAXN];
int pr[MAXN];
int prpr[MAXN];
int dp[MAXN];
int sum_dp[MAXN / Q + 10][2 * Q + 1];
int sum[MAXN / Q + 10];
int n, k;
void relax(int& x) {
  while (x >= MOD) x -= MOD;
  while (x < 0) x += MOD;
}
void up(int ind) {
  int l = ind * Q;
  int r = (ind + 1) * Q;
  for (int i = 0; i < 2 * Q + 1; i++) {
    sum_dp[ind][i] = 0;
  }
  int& sum = ::sum[ind] = 0;
  for (int i = r - 1; i >= l; i--) {
    if (b[i] != UNDEF) {
      sum_dp[ind][sum + Q] += dp[i];
      relax(sum_dp[ind][sum + Q]);
      sum += b[i];
    }
  }
  for (int i = 1; i < 2 * Q + 1; i++) {
    sum_dp[ind][i] += sum_dp[ind][i - 1];
    relax(sum_dp[ind][i]);
  }
}
int get(int ind, int cur_sum) {
  int up = max(-Q, min(Q, k - cur_sum));
  return sum_dp[ind][up + Q];
}
int main(int argc, const char* argv[]) {
  for (int i = 0; i < MAXN / Q + 10; i++) {
    sum[i] = 0;
  }
  for (int i = 0; i < MAXN; i++) {
    b[i] = UNDEF;
    pr[i] = -1;
    prpr[i] = -1;
  }
  cin >> n >> k;
  for (int i = 1; i <= n; i++) {
    scanf("%i", a + i);
    a[i]--;
  }
  dp[0] = 1;
  b[0] = 0;
  up(0);
  for (int i = 1; i <= n; i++) {
    if (prpr[a[i]] != -1) {
      b[prpr[a[i]]] = 0;
      up(prpr[a[i]] / Q);
    }
    if (pr[a[i]] != -1) {
      b[pr[a[i]]] = -1;
      up(pr[a[i]] / Q);
    }
    prpr[a[i]] = pr[a[i]];
    pr[a[i]] = i;
    int sum = 1;
    dp[i] = 0;
    for (int j = (i - 1) / Q; j >= 0; j--) {
      dp[i] += get(j, sum);
      relax(dp[i]);
      sum += ::sum[j];
    }
    b[i] = 1;
    up(i / Q);
  }
  cout << dp[n] << endl;
  return 0;
}
