#include <bits/stdc++.h>
using namespace std;
string str;
int dp[20][10][4];
string toString(long long n) {
  stringstream ss;
  ss << n;
  return ss.str();
}
long long toNum(string str) {
  stringstream ss(str);
  long long ans;
  ss >> ans;
  return ans;
}
void solve(int i, int j, int previ, int prevj, int count4, int count7) {
  if (dp[i][j][0] != -1) return;
  dp[i][j][0] = previ;
  dp[i][j][1] = prevj;
  dp[i][j][2] = count4;
  dp[i][j][3] = count7;
  if (i >= str.size()) return;
  int digit = (str[i] - '0');
  for (int k = 0; k <= 6; k++) {
    for (int l = 0; l <= 6; l++) {
      if (l + k > 6) continue;
      int last = (4 * k + 7 * l + j) % 10;
      int rem = (4 * k + 7 * l + j) / 10;
      if (last == digit) solve(i + 1, rem, i, j, count4 + k, count7 + l);
    }
  }
}
int main() {
  int t;
  cin >> t;
  while (t--) {
    memset(dp, -1, sizeof dp);
    long long num;
    cin >> num;
    str = toString(num);
    reverse(str.begin(), str.end());
    solve(0, 0, -1, -1, 0, 0);
    vector<string> ans(6);
    int i = str.size(), j = 0;
    if (dp[i][j][0] == -1) {
      cout << -1 << endl;
    } else {
      while (i != 0) {
        int previ = dp[i][j][0], prevj = dp[i][j][1];
        int count4 = dp[i][j][2] - dp[previ][prevj][2];
        int count7 = dp[i][j][3] - dp[previ][prevj][3];
        int index = 0;
        for (int k = 0; k < count4; k++) ans[index++].push_back('4');
        for (int k = 0; k < count7; k++) ans[index++].push_back('7');
        for (int k = 0; k < 6 - count4 - count7; k++)
          ans[index++].push_back('0');
        i = previ;
        j = prevj;
      }
      long long sum = 0;
      for (int i = 0; i < 6; i++) {
        cout << toNum(ans[i]) << " ";
        sum += toNum(ans[i]);
      }
      cout << endl;
    }
  }
  return 0;
}
