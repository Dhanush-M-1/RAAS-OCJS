#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int T = 1;
  while (T--) {
    map<string, int> mp;
    string s;
    cin >> s;
    int n = int((s).size());
    for (int i = 0; i < n - 9; i++) {
      if (isdigit(s[i]) && s[i + 2] == '-' && s[i + 5] == '-') {
        string sub = s.substr(i, 10);
        char ch = '-';
        int c = count((sub).begin(), (sub).end(), ch);
        if (c != 2) {
          continue;
        }
        string D, M, Y;
        D = sub.substr(0, 2);
        M = sub.substr(3, 2);
        Y = sub.substr(6, 4);
        int d = stoi(D);
        int m = stoi(M);
        int y = stoi(Y);
        if (y >= 2013 && y <= 2015) {
          if (m >= 1 && m <= 12) {
            if (m == 2) {
              if (d >= 1 && d <= 28) {
                mp[sub]++;
              }
            } else if (m == 4 || m == 6 || m == 9 || m == 11) {
              if (d >= 1 && d <= 30) {
                mp[sub]++;
              }
            } else {
              if (d >= 1 && d <= 31) {
                mp[sub]++;
              }
            }
          }
        }
      }
    }
    int maxi = 0;
    string ans;
    for (auto x : mp) {
      if (x.second > maxi) {
        maxi = x.second;
        ans = x.first;
      }
    }
    cout << ans;
  }
  return 0;
}
