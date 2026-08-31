#include <bits/stdc++.h>
using namespace std;
const long long mod = 998244353;
const int maxn = 105;
struct node {
  int a, b;
} NODE[maxn];
int B[maxn], dp[maxn][maxn * maxn];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  int sum = 0;
  for (int i = 1; i <= n; i++) cin >> NODE[i].a, sum += NODE[i].a;
  for (int i = 1; i <= n; i++) cin >> NODE[i].b, B[i] = NODE[i].b;
  sort(B + 1, B + n + 1);
  int Max = 0, idx = n, Msum = 0;
  int sum1 = sum;
  while (sum1 > 0) Max += 1, sum1 -= B[idx], Msum += B[idx], idx--;
  memset(dp, -1, sizeof(dp));
  dp[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    for (int j = min(i, Max); j >= 1; j--) {
      for (int k = Msum; k >= NODE[i].b; k--) {
        if (dp[j - 1][k - NODE[i].b] == -1) continue;
        dp[j][k] = max(dp[j - 1][k - NODE[i].b] + NODE[i].a, dp[j][k]);
      }
    }
  }
  int res = 0;
  for (int i = sum; i <= Msum; i++) res = max(res, dp[Max][i]);
  cout << Max << " " << sum - res << endl;
  return 0;
}
