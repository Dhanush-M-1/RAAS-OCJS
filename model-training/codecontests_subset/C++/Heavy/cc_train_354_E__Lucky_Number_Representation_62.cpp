#include <bits/stdc++.h>
using namespace std;
string s;
int memo[19][5][6];
vector<vector<vector<int>>> sums;
void dp(int pos, int res) {
  if (pos == s.size() && res) {
    memo[pos][res][0] = -2;
    return;
  }
  if (pos == s.size() && !res) {
    return;
  }
  if (memo[pos][res][0] != -1) return;
  int flag = 0;
  int r = (s[pos] - '0') - res;
  if (pos == s.size() - 1 && r < 0) {
    memo[pos][res][0] = -2;
    return;
  }
  if (r < 0) {
    r += 10;
    flag = 1;
  }
  int j;
  for (j = 0; j < sums[r].size(); ++j) {
    dp(pos + 1, flag + (sums[r][j][6]) / 10);
    if (memo[pos + 1][flag + (sums[r][j][6]) / 10][0] != -2) {
      break;
    }
  }
  if (j == sums[r].size())
    for (int i = 0; i < 6; ++i) memo[pos][res][i] = -2;
  else {
    for (int i = 0; i < 6; ++i) memo[pos][res][i] = sums[r][j][i];
  }
}
void print() {
  string ans[6] = {"", "", "", "", "", ""};
  int pos = 0, res = 0;
  while (1) {
    if (pos >= s.size() || memo[pos][res][0] == -1 || memo[pos][res][0] == -2)
      break;
    for (int i = 0; i < 6; ++i) {
      ans[i] += (char)(memo[pos][res][i] + '0');
    }
    int flag = 0;
    int r = (s[pos] - '0') - res;
    if (r < 0) {
      r += 10;
      flag = 1;
    }
    int j;
    for (j = 0; j < sums[r].size(); ++j) {
      if (memo[pos + 1][flag + (sums[r][j][6]) / 10][0] != -2) {
        pos++;
        res = flag + (sums[r][j][6]) / 10;
        break;
      }
    }
    if (j == sums[r].size()) break;
  }
  for (int k = 0; k < 6; ++k) {
    reverse(ans[k].begin(), ans[k].end());
    int z = 0;
    for (int i = 0; i < ans[k].size(); ++i) {
      if (ans[k][i] == '0' && !z) continue;
      z = 1;
      cout << ans[k][i];
    }
    if (!z) cout << "0";
    cout << " ";
  }
  cout << "\n";
}
int main() {
  int T;
  cin >> T;
  sums.resize(10);
  int lucky[3] = {0, 4, 7};
  int a, b, c, d, e, f;
  for (int i = 0; i < 3; ++i) {
    for (int j = i; j < 3; ++j) {
      for (int k = j; k < 3; ++k) {
        for (int l = k; l < 3; ++l) {
          for (int m = l; m < 3; ++m) {
            for (int n = m; n < 3; ++n) {
              int sum = lucky[i] + lucky[j] + lucky[k] + lucky[l] + lucky[m] +
                        lucky[n];
              vector<int> vec = {lucky[i], lucky[j], lucky[k], lucky[l],
                                 lucky[m], lucky[n], sum};
              sums[sum % 10].push_back(vec);
            }
          }
        }
      }
    }
  }
  while (T--) {
    memset(memo, -1, sizeof(memo));
    cin >> s;
    reverse(s.begin(), s.end());
    dp(0, 0);
    if (memo[0][0][0] == -2)
      cout << "-1\n";
    else
      print();
  }
}
