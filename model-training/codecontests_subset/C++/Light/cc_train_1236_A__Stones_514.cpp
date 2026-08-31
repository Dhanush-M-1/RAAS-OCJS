#include <bits/stdc++.h>
using namespace std;
void fastio() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
}
void input() {}
int dp[101][101][101];
int f(int a, int b, int c) {
  if (dp[a][b][c] != -1) return dp[a][b][c];
  int& ans = dp[a][b][c];
  ans = 0;
  if (a >= 1 && b >= 2) ans = max(ans, 3 + f(a - 1, b - 2, c));
  if (b >= 1 && c >= 2) ans = max(ans, 3 + f(a, b - 1, c - 2));
  return ans;
}
int main() {
  fastio();
  input();
  int a, b, c, i, j, t;
  cin >> t;
  while (t--) {
    memset(dp, -1, sizeof dp);
    cin >> a >> b >> c;
    cout << f(a, b, c) << "\n";
  }
  return 0;
}
