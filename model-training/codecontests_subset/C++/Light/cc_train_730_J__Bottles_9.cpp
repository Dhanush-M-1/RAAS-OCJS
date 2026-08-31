#include <bits/stdc++.h>
using namespace std;
const int maxn = 105;
int n, sum1, sum2;
int dp[maxn][maxn * maxn];
struct node {
  int a, b;
  bool operator<(const node& i) const { return i.b < b; }
} p[maxn];
void Inite() {
  memset(dp, -1, sizeof(dp));
  dp[0][0] = 0;
}
void Solve() {
  int tem = 0, q = 1;
  for (int i = 1; i <= n; i++) {
    tem += p[i].b;
    q = i;
    if (tem >= sum1) break;
  }
  for (int i = 1; i <= n; i++)
    for (int j = q; j >= 1; j--)
      for (int k = sum2; k >= p[i].b; k--)
        if (~dp[j - 1][k - p[i].b])
          dp[j][k] = max(dp[j][k], dp[j - 1][k - p[i].b] + p[i].a);
  int ans = 0;
  for (int i = sum1; i <= sum2; i++) ans = max(ans, dp[q][i]);
  cout << q << " " << sum1 - ans << endl;
}
int main() {
  cin >> n;
  Inite();
  sum1 = sum2 = 0;
  for (int i = 1; i <= n; i++) {
    cin >> p[i].a;
    sum1 += p[i].a;
  }
  for (int i = 1; i <= n; i++) {
    cin >> p[i].b;
    sum2 += p[i].b;
  }
  sort(p + 1, p + n + 1);
  Solve();
}
