#include <bits/stdc++.h>
using namespace std;
void solve() {
  string s;
  cin >> s;
  reverse(s.begin(), s.end());
  while (s.size() < 20) {
    s += "0";
  }
  bool dp[21][1000] = {0};
  int lastx[21][1000] = {0};
  int last0[21][1000] = {0};
  int last4[21][1000] = {0};
  int last7[21][1000] = {0};
  dp[0][0] = 1;
  for (int i = 0; i < 20; i++) {
    for (int j = 0; j < 1000; j++) {
      if (!dp[i][j]) {
        continue;
      }
      for (int a = 0; a <= 6; a++) {
        for (int b = 0; a + b <= 6; b++) {
          int c = 6 - a - b;
          int x = j + b * 4 + c * 7;
          if (x / 10 < 1000 && x % 10 == s[i] - '0') {
            dp[i + 1][x / 10] = 1;
            lastx[i + 1][x / 10] = j;
            last0[i + 1][x / 10] = a;
            last4[i + 1][x / 10] = b;
            last7[i + 1][x / 10] = c;
          }
        }
      }
    }
  }
  if (dp[20][0]) {
    vector<string> ans(6);
    int n = 20, x = 0;
    while (n) {
      int j = 0;
      for (int i = j; i < j + last0[n][x]; i++) {
        ans[i] += '0';
      }
      j += last0[n][x];
      for (int i = j; i < j + last4[n][x]; i++) {
        ans[i] += '4';
      }
      j += last4[n][x];
      for (int i = j; i < j + last7[n][x]; i++) {
        ans[i] += '7';
      }
      x = lastx[n][x];
      n--;
    }
    for (string i : ans) {
      long long y = 0;
      for (char c : i) {
        y *= 10;
        y += c - '0';
      }
      cout << y << " ";
    }
    cout << "\n";
  } else {
    cout << -1 << "\n";
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  int t;
  cin >> t;
  while (t--) {
    solve();
  }
}
