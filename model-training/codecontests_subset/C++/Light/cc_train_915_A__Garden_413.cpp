#include <bits/stdc++.h>
using namespace std;
long long int mod_expo(long long int MOD, long long int a, long long int b) {
  long long int ans = 1;
  while (b) {
    if (b % 2) {
      ans *= a;
      ans %= MOD;
    }
    b /= 2;
    a *= a;
    a %= MOD;
  }
  return ans % MOD;
}
void display(vector<int> v1) {
  for (int i = 0; i < v1.size(); i++) {
    cout << v1[i] << " ";
  }
  cout << endl;
}
int dx[8] = {0, 1, 0, -1, 1, 1, -1, -1};
int dy[8] = {1, 0, -1, 0, 1, -1, 1, -1};
using namespace std;
int n, k;
int dp[500][500];
vector<int> v1;
int solve(int idx, int left) {
  if (idx == n) {
    if (left == 0) {
      return 0;
    }
    return (int)1e6;
  }
  if (left < 0) {
    return (int)(1e6 + 100);
  }
  if (dp[idx][left] != -1) {
    return dp[idx][left];
  }
  cout << idx << " " << left << endl;
  int ans = (int)1e6;
  for (int i = 0; i <= 200; i += 1) {
    ans = min(ans, i + solve(idx + 1, left - (i * v1[idx])));
  }
  return dp[idx][left] = ans;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  memset(dp, -1, sizeof(dp));
  cin >> n >> k;
  int ans = (int)1e6 + 1000;
  for (int i = 0; i < n; i += 1) {
    int x;
    cin >> x;
    if (k % x == 0) {
      ans = min(ans, k / x);
    }
  }
  cout << ans << endl;
  return 0;
}
