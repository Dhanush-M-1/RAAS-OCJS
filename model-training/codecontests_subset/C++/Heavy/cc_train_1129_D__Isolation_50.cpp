#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 100000;
const int SZ = 320;
const long long MOD = 998244353;
int N, K;
int prv[MAX_N + 1];
int arr[MAX_N + 1];
int pidx[MAX_N + 1];
int num[MAX_N + 1];
long long dp[MAX_N + 1];
long long dp2[SZ + 1][MAX_N + 1];
long long D;
int add[SZ + 1];
void Update(int x, int y, int z) {
  for (int i = 0; i < SZ; i++) {
    int s = i * SZ, e = min(N, (i + 1) * SZ - 1);
    if (s > e) return;
    if (x <= s && e <= y) {
      if (z == 1) {
        add[i]++;
        if (K + 1 - add[i] >= 0 && K + 1 - add[i] <= N) {
          D = (D - dp2[i][K + 1 - add[i]] + MOD) % MOD;
        }
      } else {
        add[i]--;
        if (K - add[i] >= 0 && K - add[i] <= N) {
          D = (D + dp2[i][K - add[i]]) % MOD;
        }
      }
    } else if (x > e || y < s)
      continue;
    else {
      for (int j = s; j <= e; j++) {
        dp2[i][num[j]] = 0LL;
        num[j] += add[i];
      }
      add[i] = 0LL;
      for (int j = max(s, x); j <= min(e, y); j++) {
        num[j] += z;
        if (z == 1) {
          if (num[j] == K + 1) {
            D = (D - dp[j] + MOD) % MOD;
          }
        } else {
          if (num[j] == K) {
            D = (D + dp[j]) % MOD;
          }
        }
      }
      for (int j = s; j <= e; j++) {
        dp2[i][num[j]] = (dp2[i][num[j]] + dp[j]) % MOD;
      }
    }
  }
}
void Add(int x) {
  int g = x / SZ;
  int s = g * SZ;
  for (int i = s; i < x; i++) {
    dp2[g][num[i]] = 0LL;
    num[i] += add[g];
  }
  add[g] = 0;
  for (int i = s; i <= x; i++) {
    dp2[g][num[i]] = (dp2[g][num[i]] + dp[i]) % MOD;
  }
  D = (D + dp[x]) % MOD;
}
int main() {
  scanf("%d%d", &N, &K);
  for (int i = 1; i <= N; i++) {
    scanf("%d", &arr[i]);
    prv[i] = pidx[arr[i]];
    pidx[arr[i]] = i;
  }
  dp[0] = 1;
  D = 1LL;
  for (int i = 1; i <= N; i++) {
    Update(prv[i], i - 1, 1);
    if (prv[i] != 0) {
      Update(prv[prv[i]], prv[i] - 1, -1);
    }
    dp[i] = D;
    Add(i);
  }
  cout << dp[N];
  return 0;
}
