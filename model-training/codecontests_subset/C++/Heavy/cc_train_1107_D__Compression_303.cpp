#include <bits/stdc++.h>
using namespace std;
string s[5205];
int n;
int a[5205][5205];
vector<int> ve;
void check(int x) {
  int j = 0;
  for (; j < n; j++) {
    if (s[j] != s[j / x * x]) break;
  }
  if (j == n) ve.push_back(x);
}
int main() {
  std::ios::sync_with_stdio(false);
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> s[i];
    for (int j = 0; j < n; j++) {
      a[i][j + 1] =
          (s[i][j / 4] <= '9')
              ? (((int(s[i][j / 4] - '0')) >> (3 - j + j / 4 * 4)) & 1)
              : (((int(s[i][j / 4] - 'a' + 10)) >> (3 - j + j / 4 * 4)) & 1);
    }
    for (int j = 1; j <= n; j++) {
      a[i][j] = a[i][j - 1] + a[i][j];
    }
  }
  for (int i = sqrt(n); i > 1; i--) {
    if (n % i) continue;
    check(i);
    check(n / i);
  }
  check(n);
  sort(ve.begin(), ve.end());
  bool f = 0;
  for (int i = ve.size() - 1; i >= 0; i--) {
    int t = ve[i];
    f = 1;
    for (int i = 0; i < n; i += t) {
      for (int j = 0; j <= n - t; j += t) {
        if (a[i][j + t] - a[i][j] != t && a[i][j + t] - a[i][j] != 0) {
          f = 0;
          break;
        }
      }
      if (!f) break;
    }
    if (f) {
      cout << t << endl;
      break;
    }
  }
  if (!f) cout << 1 << endl;
}
