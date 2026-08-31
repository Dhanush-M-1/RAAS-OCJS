#include <bits/stdc++.h>
using namespace std;
char mp[205][205];
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        cin >> mp[i][j];
      }
    }
    queue<pair<int, int>> q;
    if (mp[2][1] == mp[1][2]) {
      if (mp[n - 1][n] == mp[2][1]) q.push({n - 1, n});
      if (mp[n][n - 1] == mp[2][1]) q.push({n, n - 1});
      cout << q.size() << endl;
      while (!q.empty()) {
        cout << q.front().first << " " << q.front().second << endl;
        q.pop();
      }
    } else if (mp[n - 1][n] == mp[n][n - 1]) {
      if (mp[n - 1][n] == mp[2][1]) q.push({2, 1});
      if (mp[n - 1][n] == mp[1][2]) q.push({1, 2});
      cout << q.size() << endl;
      while (!q.empty()) {
        cout << q.front().first << " " << q.front().second << endl;
        q.pop();
      }
    } else {
      if (mp[1][2] == '0') q.push({1, 2});
      if (mp[2][1] == '0') q.push({2, 1});
      if (mp[n][n - 1] == '1') q.push({n, n - 1});
      if (mp[n - 1][n] == '1') q.push({n - 1, n});
      cout << q.size() << endl;
      while (!q.empty()) {
        cout << q.front().first << " " << q.front().second << endl;
        q.pop();
      }
    }
  }
}
