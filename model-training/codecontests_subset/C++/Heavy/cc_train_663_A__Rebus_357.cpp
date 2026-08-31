#include <bits/stdc++.h>
using namespace std;
int n, queCnt, addCnt, subCnt;
vector<int> sign, res[2];
string s;
int main() {
  getline(cin, s);
  n = 0;
  addCnt = 1;
  subCnt = 0;
  sign.push_back(1);
  for (int i = 0; i < s.length(); ++i) {
    if (s[i] == '?') queCnt++;
    if (s[i] == '-') subCnt++, sign.push_back(0);
    if (s[i] == '+') addCnt++, sign.push_back(1);
    if (s[i] >= '0' && s[i] <= '9') n = 10 * n + (s[i] - '0');
  }
  for (int i = subCnt; i <= n * subCnt; ++i) {
    int rem = n + i;
    if (rem >= addCnt && rem <= n * addCnt) {
      int x = rem, y = i;
      cout << "Possible" << endl;
      for (int j = 0; j < addCnt; ++j)
        if (j == addCnt - 1)
          res[0].push_back(x);
        else
          res[0].push_back(1), x--;
      if (addCnt >= 2) {
        while (res[0][addCnt - 1] > n) {
          int z = addCnt - 1;
          while (res[0][addCnt - 1] - z <= 0) z--;
          res[0][addCnt - 1] -= z;
          for (int j = 0; j <= z - 1; ++j) res[0][j]++;
        }
      }
      for (int j = 0; j < subCnt; ++j)
        if (j == subCnt - 1)
          res[1].push_back(y);
        else
          res[1].push_back(1), y--;
      if (subCnt >= 2) {
        while (res[1][subCnt - 1] > n) {
          int z = subCnt - 1;
          while (res[1][subCnt - 1] - z <= 0) z--;
          res[1][subCnt - 1] -= z;
          for (int j = 0; j <= z - 1; ++j) res[1][j]++;
        }
      }
      x = 0, y = 0;
      for (int j = 0; j < sign.size(); ++j) {
        if (j != 0) cout << (sign[j] == 0 ? " - " : " + ");
        if (sign[j] == 0)
          cout << res[1][x], x++;
        else
          cout << res[0][y], y++;
      }
      cout << " = " << n << endl;
      exit(0);
    }
  }
  cout << "Impossible" << endl;
  return 0;
}
