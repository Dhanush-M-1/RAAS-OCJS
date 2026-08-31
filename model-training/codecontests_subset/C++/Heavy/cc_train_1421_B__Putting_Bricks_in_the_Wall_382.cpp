#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 100001;
const int MAX_D = 17;
const long long MOD = 1000000007;
const int INF32 = 0x3f3f3f3f;
const long long INF = 1e18;
void solve() {
  int n;
  cin >> n;
  char grid[n][n];
  for (int i = (0); i < (n); i++)
    for (int j = (0); j < (n); j++) cin >> grid[i][j];
  int a = grid[1][0] + grid[0][1] - 2 * '0',
      b = grid[n - 1][n - 2] + grid[n - 2][n - 1] - 2 * '0';
  if (a == 2) {
    cout << b << endl;
    if (grid[n - 1][n - 2] == '1') cout << n << ' ' << n - 1 << endl;
    if (grid[n - 2][n - 1] == '1') cout << n - 1 << ' ' << n << endl;
  }
  if (!a) {
    cout << 2 - b << endl;
    if (grid[n - 1][n - 2] == '0') cout << n << ' ' << n - 1 << endl;
    if (grid[n - 2][n - 1] == '0') cout << n - 1 << ' ' << n << endl;
  }
  if (a == 1) {
    if (b == 1) {
      cout << 2 << endl;
      if (grid[0][1] == '0') cout << "1 2\n";
      if (grid[1][0] == '0') cout << "2 1\n";
      if (grid[n - 1][n - 2] == '1') cout << n << ' ' << n - 1 << endl;
      if (grid[n - 2][n - 1] == '1') cout << n - 1 << ' ' << n << endl;
    }
    if (b == 2) {
      cout << 1 << endl;
      if (grid[0][1] == '1') cout << "1 2\n";
      if (grid[1][0] == '1') cout << "2 1\n";
    }
    if (!b) {
      cout << 1 << endl;
      if (grid[0][1] == '0') cout << "1 2\n";
      if (grid[1][0] == '0') cout << "2 1\n";
    }
  }
  return;
}
int main(int argc, const char* argv[]) {
  int t;
  cin >> t;
  while (t--) {
    solve();
  }
  return 0;
}
