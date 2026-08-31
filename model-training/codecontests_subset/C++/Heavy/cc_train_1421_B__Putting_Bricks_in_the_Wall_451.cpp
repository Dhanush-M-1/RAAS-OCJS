#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int tests;
  cin >> tests;
  while (tests--) {
    int n;
    cin >> n;
    vector<vector<char>> t(n);
    char c;
    for (auto& i : t) {
      for (int j = 0; j < n; ++j) {
        cin >> c;
        i.push_back(c);
      }
    }
    vector<pair<int, int>> ans;
    char right_s = t[0][1];
    char down_s = t[1][0];
    char left_f = t[n - 1][n - 2];
    char up_f = t[n - 2][n - 1];
    if (right_s == down_s) {
      if (right_s == '0')
        c = '1';
      else
        c = '0';
      if (left_f != c) ans.push_back(make_pair(n, n - 1));
      if (up_f != c) ans.push_back(make_pair(n - 1, n));
    } else if (left_f == up_f) {
      if (left_f == '0')
        c = '1';
      else
        c = '0';
      if (right_s != c) ans.push_back(make_pair(1, 2));
      if (down_s != c) ans.push_back(make_pair(2, 1));
    } else {
      c = right_s;
      ans.push_back(make_pair(1, 2));
      if (left_f != c) ans.push_back(make_pair(n, n - 1));
      if (up_f != c) ans.push_back(make_pair(n - 1, n));
    }
    cout << ans.size() << '\n';
    for (auto i : ans) {
      cout << i.first << ' ' << i.second << '\n';
    }
  }
  return 0;
}
