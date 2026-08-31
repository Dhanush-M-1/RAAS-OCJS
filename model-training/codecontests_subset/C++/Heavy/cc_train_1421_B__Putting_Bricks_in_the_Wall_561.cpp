#include <bits/stdc++.h>
using namespace std;
int main() {
  long long a;
  cin >> a;
  for (long long i = 0; i < a; i++) {
    long long b;
    cin >> b;
    string s[b + 1];
    for (long long j = 0; j < b; j++) {
      cin >> s[j];
    }
    vector<pair<long long, long long>> ans;
    if (s[0][1] == s[1][0]) {
      if (s[b - 1][b - 2] == s[0][1]) {
        ans.push_back({b - 1, b - 2});
      }
      if (s[b - 2][b - 1] == s[0][1]) {
        ans.push_back({b - 2, b - 1});
      }
    } else {
      if (s[b - 1][b - 2] == s[b - 2][b - 1]) {
        if (s[0][1] == s[b - 1][b - 2]) {
          ans.push_back({0, 1});
        }
        if (s[b - 2][b - 1] == s[1][0]) {
          ans.push_back({1, 0});
        }
      } else {
        if (s[0][1] == '1') {
          ans.push_back({0, 1});
        } else {
          ans.push_back({1, 0});
        }
        if (s[b - 1][b - 2] == '0') {
          ans.push_back({b - 1, b - 2});
        } else {
          ans.push_back({b - 2, b - 1});
        }
      }
    }
    cout << ans.size() << "\n";
    for (long long j = 0; j < ans.size(); j++) {
      cout << ans[j].first + 1 << " " << ans[j].second + 1 << "\n";
    }
  }
}
