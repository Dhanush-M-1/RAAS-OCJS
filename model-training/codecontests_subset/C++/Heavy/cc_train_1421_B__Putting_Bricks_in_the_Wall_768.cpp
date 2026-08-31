#include <bits/stdc++.h>
using namespace std;
const int M = INT_MAX;
const int N = INT_MIN;
using namespace std;
int main() {
  int t = 0;
  cin >> t;
  while (t--) {
    int n, c = 0;
    cin >> n;
    char d[n + 1][n + 1];
    vector<pair<int, int>> vect;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        cin >> d[i][j];
      }
    }
    if (d[1][2] == d[2][1] && d[2][1] == '0') {
      if (d[n - 1][n] == d[n][n - 1] && d[n][n - 1] == d[1][2]) {
        vect.push_back({n - 1, n});
        vect.push_back({n, n - 1});
      } else if (d[n - 1][n] == d[n][n - 1] && d[n][n - 1] != d[1][2])
        c = c;
      else if (d[n - 1][n] != '0') {
        vect.push_back({n, n - 1});
      } else if (d[n][n - 1] != '0') {
        vect.push_back({n - 1, n});
      }
    } else if (d[1][2] == d[2][1] && d[2][1] == '1') {
      if (d[n - 1][n] == d[n][n - 1] && d[n][n - 1] == d[1][2]) {
        vect.push_back({n - 1, n});
        vect.push_back({n, n - 1});
      } else if (d[n - 1][n] == d[n][n - 1] && d[n][n - 1] != d[1][2])
        c = c;
      else if (d[n - 1][n] != '0') {
        vect.push_back({n - 1, n});
      } else if (d[n][n - 1] != '0') {
        vect.push_back({n, n - 1});
      }
    } else if (d[1][2] != d[2][1]) {
      if (d[n - 1][n] == d[n][n - 1] && d[n][n - 1] == '0') {
        if (d[1][2] == '1')
          vect.push_back({2, 1});
        else
          vect.push_back({1, 2});
      } else if (d[n - 1][n] == d[n][n - 1] && d[n][n - 1] == '1') {
        if (d[1][2] == '0')
          vect.push_back({2, 1});
        else
          vect.push_back({1, 2});
      } else if (d[n - 1][n] != d[n][n - 1]) {
        if (d[1][2] == '0') {
          vect.push_back({2, 1});
          if (d[n][n - 1] == '1')
            vect.push_back({n - 1, n});
          else
            vect.push_back({n, n - 1});
        } else {
          vect.push_back({1, 2});
          if (d[n][n - 1] == '1')
            vect.push_back({n - 1, n});
          else
            vect.push_back({n, n - 1});
        }
      }
    }
    cout << vect.size() << endl;
    for (auto x : vect) {
      cout << x.first << " " << x.second << endl;
    }
  }
  return 0;
}
