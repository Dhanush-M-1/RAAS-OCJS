#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
long long int ceil(long long int a, long long int b) {
  if ((a >= 0 && b >= 0) || (a < 0 && b < 0)) return (a / b) + ((a % b) != 0);
  return a / b;
}
long long int floor(long long int a, long long int b) {
  if ((a >= 0 && b >= 0) || (a < 0 && b < 0)) return a / b;
  return a / b - ((a % b) != 0);
}
void IO() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
}
void solve(vector<string>& grid, int n) {
  char a = grid[1][0];
  char b = grid[0][1];
  char x = grid[n - 1][n - 2];
  char y = grid[n - 2][n - 1];
  int num0 = 0;
  if (a == '0') num0++;
  if (b == '0') num0++;
  if (x == '0') num0++;
  if (y == '0') num0++;
  if (num0 == 0 || num0 == 4) {
    cout << 2 << "\n";
    cout << "2 1\n1 2\n";
  } else if (num0 == 1 || num0 == 3) {
    cout << 1 << "\n";
    if (a == b) {
      if (x == a) cout << n << " " << n - 1 << "\n";
      if (y == a) cout << n - 1 << " " << n << "\n";
    }
    if (x == y) {
      if (a == x) cout << "2 1\n";
      if (b == x) cout << "1 2\n";
    }
  } else {
    if (a == b) {
      cout << "0\n";
      return;
    }
    cout << 2 << "\n";
    if (a == '1') cout << "2 1\n";
    if (b == '1') cout << "1 2\n";
    if (x == '0') cout << n << " " << n - 1 << "\n";
    if (y == '0') cout << n - 1 << " " << n << "\n";
  }
}
int main() {
  IO();
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    vector<string> grid(n);
    for (int i = 0; i < n; i++) cin >> grid[i];
    solve(grid, n);
  }
}
