#include <bits/stdc++.h>
using namespace std;
const long long maxN = 1e18;
const long long minN = -1e18;
const int INF = 2e9;
const long long MOD = 1e9 + 7;
const long long MOD1 = 998244353;
const int baseHash = 331;
const int bigNumLength = 5000;
const long double PI = acos(-1);
const long long limit = 2e5 + 5;
const long long limit1 = 1e6 + 5;
const long long limit2 = 1e3 + 5;
pair<int, int> dir[] = {{0, 1}, {1, 0},  {0, -1}, {-1, 0},
                        {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
pair<int, int> NON = {-1, -1};
int t, n;
char c[250][250];
void solveProblem() {
  if (c[1][2] == c[2][1]) {
    if (c[n - 1][n] == c[n][n - 1]) {
      if (c[1][2] == c[n - 1][n]) {
        cout << 2 << '\n' << 1 << " " << 2 << '\n' << 2 << " " << 1 << '\n';
      }
      if (c[1][2] != c[n - 1][n]) {
        cout << 0 << '\n';
      }
    } else {
      if (c[1][2] == c[n - 1][n]) {
        cout << 1 << '\n' << n - 1 << " " << n << '\n';
      } else
        cout << 1 << '\n' << n << " " << n - 1 << '\n';
    }
  } else {
    if (c[n][n - 1] == c[n - 1][n]) {
      if (c[n][n - 1] == c[1][2]) {
        cout << 1 << '\n' << 1 << " " << 2 << '\n';
      } else {
        cout << 1 << '\n' << 2 << " " << 1 << '\n';
      }
    } else {
      if (c[1][2] == c[n][n - 1]) {
        cout << 2 << '\n'
             << 1 << " " << 2 << '\n'
             << " " << n - 1 << " " << n << '\n';
      } else {
        cout << 2 << '\n'
             << 1 << " " << 2 << '\n'
             << " " << n << " " << n - 1 << '\n';
      }
    }
  }
}
void fastInput() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
void readInput() {
  cin >> t;
  while (t--) {
    cin >> n;
    for (int i = (1); i <= (n); ++i) {
      for (int j = (1); j <= (n); ++j) {
        cin >> c[i][j];
      }
    }
    solveProblem();
  }
}
int main() {
  fastInput();
  readInput();
}
