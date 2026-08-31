#include <bits/stdc++.h>
using namespace std;
struct cww {
  cww() {
    ios::sync_with_stdio(false);
    cin.tie(0);
  }
} star;
const int MAX = 1000;
bool dp[111][2 * MAX];
int main() {
  vector<string> S;
  string s;
  while (cin >> s) {
    S.push_back(s);
  }
  int n = stoi(S.back());
  s.clear();
  for (string el : S) {
    if (el == "+" || el == "-") s += el;
  }
  int sz = s.size();
  dp[0][MAX] = true;
  for (int i = 0; i < sz; i++) {
    char op = s[i];
    for (int j = 0; j < 2 * MAX; j++)
      if (dp[i][j]) {
        for (int k = 1; k <= min(n, 100); k++) {
          int next = j;
          if (op == '+')
            next += k;
          else
            next -= k;
          if (0 <= next && next < 2 * MAX) dp[i + 1][next] = true;
        }
      }
  }
  for (int i = 0; i < 2 * MAX; i++)
    if (dp[sz][i]) {
      int value = i - MAX;
      int first = n - value;
      if (1 <= first && first <= n) {
        cout << "Possible" << endl;
        vector<int> ans;
        int now = i;
        for (int j = sz; j > 0; j--) {
          char op = s[j - 1];
          for (int k = 1; k <= min(n, 100); k++) {
            int prev = now;
            if (op == '+')
              prev -= k;
            else
              prev += k;
            if (0 <= prev && prev < 2 * MAX && dp[j - 1][prev]) {
              ans.push_back(k);
              now = prev;
              break;
            }
          }
        }
        ans.push_back(first);
        reverse(ans.begin(), ans.end());
        for (int i = 0; i < sz; i++) {
          cout << ans[i] << " " << s[i] << " ";
        }
        cout << ans[sz] << " = " << n << endl;
        return 0;
      }
    }
  cout << "Impossible" << endl;
  return 0;
}
