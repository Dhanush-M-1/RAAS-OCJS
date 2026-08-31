#include <bits/stdc++.h>
#pragma GCC optimize("Ofast,unroll-loops")
using namespace std;
const int N = 102;
const int oo = 1e9;
const int Mod = 1e9 + 7;
int dp[2][N][N * N];
int a[N], b[N];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  for (int i = (int)(0); i < (int)(2); ++i)
    for (int j = (int)(0); j < (int)(102); ++j)
      for (int k = (int)(0); k < (int)(10002); ++k) dp[i][j][k] = -oo;
  dp[0][0][0] = 0;
  int n;
  cin >> n;
  vector<int> caps;
  int vtot = 0, ctot = 0;
  for (int i = (int)(1); i < (int)(n + 1); ++i) cin >> a[i], vtot += a[i];
  for (int i = (int)(1); i < (int)(n + 1); ++i)
    cin >> b[i], caps.push_back(b[i]), ctot += b[i];
  sort(caps.begin(), caps.end(), greater<int>());
  int k = 0, acc = 0;
  while (acc < vtot) acc += caps[k++];
  for (int i = 1; i <= n; ++i) {
    int idx = i % 2;
    for (int j = 0; j <= k; ++j) {
      for (int c = 0; c <= ctot; ++c) {
        if (j >= 1 and c - b[i] >= 0)
          dp[idx][j][c] =
              max(dp[idx][j][c], dp[idx ^ 1][j - 1][c - b[i]] + a[i]);
        dp[idx][j][c] = max(dp[idx][j][c], dp[idx ^ 1][j][c]);
      }
    }
  }
  int idx = n % 2;
  int high = 0;
  for (int c = vtot; c <= ctot; ++c) {
    int soda = dp[idx][k][c];
    high = max(soda, high);
  }
  cout << k << " " << vtot - high << '\n';
  return 0;
}
