#include <bits/stdc++.h>
using namespace std;
template <class T1, class T2>
ostream &operator<<(ostream &os, pair<T1, T2> const &v) {
  return os << '(' << v.first << ", " << v.second << ')';
}
double const pi = acos(-1);
int n;
bool a[5210][5210];
int sum[5210][5210];
string s;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  for (int i = 1; i <= n; ++i) {
    cin >> s;
    for (int j = 0; j < n / 4; ++j) {
      string tmp = string("") + s[j];
      int mask = stoi(tmp, 0, 16);
      for (int k = 3; k >= 0; --k) a[i][j * 4 + 4 - k] = (mask & (1 << k));
    }
  }
  for (int i = 1; i <= n; ++i) {
    for (int j = 1; j <= n; ++j) {
      sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + a[i][j];
    }
  }
  for (int x = n; x >= 1; --x)
    if (n % x == 0) {
      bool ok = 1;
      for (int i = x; i <= n && ok; i += x) {
        for (int j = x; j <= n && ok; j += x) {
          int val =
              sum[i][j] - sum[i - x][j] - sum[i][j - x] + sum[i - x][j - x];
          if (val != 0 && val != x * x) ok = 0;
        }
      }
      if (ok) {
        cout << x << '\n';
        return 0;
      }
    }
  cerr << 0.001 * clock() << '\n';
  return 0;
}
