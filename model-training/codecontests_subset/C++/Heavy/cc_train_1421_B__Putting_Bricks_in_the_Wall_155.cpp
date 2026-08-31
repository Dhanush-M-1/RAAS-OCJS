#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    char ch[n][n];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++) cin >> ch[i][j];
    int co = 0;
    pair<int, int> p[2];
    if (ch[0][1] == ch[1][0]) {
      char val;
      if (ch[0][1] == '0')
        val = '1';
      else
        val = '0';
      if (ch[n - 1][n - 2] != val) {
        p[co].first = n - 1;
        p[co].second = n - 2;
        co++;
      }
      if (ch[n - 2][n - 1] != val) {
        p[co].first = n - 2;
        p[co].second = n - 1;
        co++;
      }
    } else if (ch[n - 1][n - 2] == ch[n - 2][n - 1]) {
      char val;
      if (ch[n - 1][n - 2] == '0')
        val = '1';
      else
        val = '0';
      if (ch[0][1] != val) {
        p[co].first = 0;
        p[co].second = 1;
        co++;
      }
      if (ch[1][0] != val) {
        p[co].first = 1;
        p[co].second = 0;
        co++;
      }
    } else {
      if (ch[0][1] == '0') {
        p[co].first = 0;
        p[co].second = 1;
        co++;
      }
      if (ch[1][0] == '0') {
        p[co].first = 1;
        p[co].second = 0;
        co++;
      }
      if (ch[n - 1][n - 2] == '1') {
        p[co].first = n - 1;
        p[co].second = n - 2;
        co++;
      }
      if (ch[n - 2][n - 1] == '1') {
        p[co].first = n - 2;
        p[co].second = n - 1;
        co++;
      }
    }
    cout << co << "\n";
    for (int i = 0; i < co; i++) {
      cout << p[i].first + 1 << " " << p[i].second + 1 << "\n";
    }
  }
  return 0;
}
