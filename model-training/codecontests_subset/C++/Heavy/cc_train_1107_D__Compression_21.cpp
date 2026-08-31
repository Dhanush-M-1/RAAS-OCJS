#include <bits/stdc++.h>
using namespace std;
int cc[5205][5205];
int check(int n, int t) {
  int ok = 1;
  for (int i = t; i <= n; i += t)
    for (int j = t; j <= n; j += t) {
      int val = cc[i][j] - cc[i - t][j] - cc[i][j - t] + cc[i - t][j - t];
      if (!(val == 0 || val == t * t)) {
        ok = 0;
        break;
      }
    }
  return ok;
}
int main() {
  int n;
  cin >> n;
  string s;
  for (int i = 0; i < n; ++i) {
    cin >> s;
    for (int j = 0; j < s.size(); ++j) {
      int d = (isalpha(s[j]) ? s[j] - 'A' + 10 : s[j] - '0');
      for (int k = 3; k >= 0; --k) {
        cc[i + 1][(j * 4 + k) + 1] = (d & 1);
        d >>= 1;
      }
    }
  }
  for (int i = 0; i <= n; ++i) cc[0][i] = cc[i][0] = 0;
  for (int i = 1; i <= n; ++i)
    for (int j = 1; j <= n; ++j)
      cc[i][j] = cc[i - 1][j] + cc[i][j - 1] - cc[i - 1][j - 1] + cc[i][j];
  vector<int> can;
  for (int i = 1; i <= n; ++i)
    if (n % i == 0) can.push_back(i);
  int res = 1;
  for (int i = can.size() - 1; i > 0; --i) {
    int ok = check(n, can[i]);
    if (ok) {
      res = can[i];
      break;
    }
  }
  cout << res << endl;
  return 0;
}
