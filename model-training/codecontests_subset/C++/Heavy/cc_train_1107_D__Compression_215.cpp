#include <bits/stdc++.h>
using namespace std;
map<char, string> hex_to_bin = {
    {'0', "0000"}, {'1', "0001"}, {'2', "0010"}, {'3', "0011"},
    {'4', "0100"}, {'5', "0101"}, {'6', "0110"}, {'7', "0111"},
    {'8', "1000"}, {'9', "1001"}, {'A', "1010"}, {'B', "1011"},
    {'C', "1100"}, {'D', "1101"}, {'E', "1110"}, {'F', "1111"},
};
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n;
  string inp;
  cin >> n;
  vector<vector<int>> mat(n);
  for (int i = 0; i < n; i++) {
    cin >> inp;
    for (int j = 0; j < inp.size(); j++) {
      string s = hex_to_bin[inp[j]];
      for (int k = 0; k < 4; k++)
        if (s[k] == '1')
          mat[i].push_back(1);
        else
          mat[i].push_back(0);
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      int val = mat[i][j];
      if (i - 1 >= 0) val += mat[i - 1][j];
      if (j - 1 >= 0) val += mat[i][j - 1];
      if (i - 1 >= 0 && j - 1 >= 0) val -= mat[i - 1][j - 1];
      mat[i][j] = val;
    }
  }
  int ans = 1;
  for (int i = 2; i <= n; i++) {
    if (n % i != 0) continue;
    bool flag = true;
    for (int j = i - 1; j < n; j += i) {
      for (int k = i - 1; k < n; k += i) {
        if (mat[j][k] % (i * i) != 0) flag = false;
      }
    }
    if (flag) ans = i;
  }
  cout << ans << endl;
  return 0;
}
