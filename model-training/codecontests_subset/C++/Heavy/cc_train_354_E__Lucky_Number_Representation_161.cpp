#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e9 + 7;
const int INF = 2e9;
const double PI = acos(-1.0);
const int MAX = 1e5 + 5;
int T;
long long N;
int A[50][6];
int C[6];
int dig[19];
bool vis[19][50];
int dp[19][50][6];
int res[19][6];
void get(int k) {
  if (k == 6) {
    int sum = 0;
    for (int i = 0; i < 6; i++) {
      sum += C[i];
    }
    if (A[sum][0] != -1) return;
    for (int i = 0; i < 6; i++) {
      A[sum][i] = C[i];
    }
    return;
  }
  C[k] = 0;
  get(k + 1);
  C[k] = 4;
  get(k + 1);
  C[k] = 7;
  get(k + 1);
}
bool getdp(int k, int a) {
  if (a >= 50) {
    return false;
  }
  if (k == -1) return (a == 0);
  if (vis[k][a]) {
    if (dp[k][a][0] == -1) return false;
    return true;
  }
  a += dig[k];
  vis[k][a] = true;
  for (int i = 0; i <= a; i++) {
    if (A[i][0] == -1) continue;
    for (int j = 0; j < 6; j++) {
      res[k][j] = A[i][j];
    }
    bool ok = getdp(k - 1, 10 * (a - i));
    if (ok) {
      return true;
    }
  }
  return false;
}
void solve() {
  memset(dp, -1, sizeof(dp));
  memset(vis, 0, sizeof(vis));
  for (int j = 0; j < 19; j++) {
    dig[j] = N % 10;
    N /= 10;
  }
  bool ok = getdp(18, 0);
  if (!ok) {
    cout << "-1\n";
    return;
  }
  for (int i = 0; i < 6; i++) {
    long long v = 0;
    for (int j = 18; j >= 0; j--) {
      v = v * 10 + res[j][i];
    }
    cout << v << " ";
  }
  cout << '\n';
}
int main() {
  memset(A, -1, sizeof(A));
  get(0);
  cin >> T;
  for (int i = 0; i < T; i++) {
    cin >> N;
    solve();
  }
}
