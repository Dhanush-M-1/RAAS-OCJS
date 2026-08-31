#include <bits/stdc++.h>
using namespace std;
int main() {
  cin.tie(0);
  cout.tie(0);
  ios_base::sync_with_stdio(0);
  int q = 0, w = 0, e = 0;
  string p = "";
  string s;
  cin >> s;
  vector<pair<int, string>> a;
  vector<int> b = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  a.push_back(make_pair(-1000000, "kek"));
  for (int i = 0; i < s.length(); i++) {
    if (s[i] != '-' && i + 9 < s.length() && s[i + 1] != '-' &&
        s[i + 2] == '-' && s[i + 3] != '-' && s[i + 4] != '-' &&
        s[i + 5] == '-' && s[i + 6] != '-' && s[i + 7] != '-' &&
        s[i + 8] != '-' && s[i + 9] != '-') {
      p = "";
      p.push_back(s[i]);
      p.push_back(s[i + 1]);
      p.push_back(s[i + 2]);
      p.push_back(s[i + 3]);
      p.push_back(s[i + 4]);
      p.push_back(s[i + 5]);
      p.push_back(s[i + 6]);
      p.push_back(s[i + 7]);
      p.push_back(s[i + 8]);
      p.push_back(s[i + 9]);
      for (int j = 0; j < a.size(); j++) {
        if (a[j].second != p && j == a.size() - 1) {
          a.push_back(make_pair(1, p));
          if (((int(p[0]) - '0') * 10 + int(p[1]) - '0') == 0 ||
              ((int(p[3]) - '0') * 10 + int(p[4]) - '0') == 0 ||
              ((int(p[8]) - '0') * 10 + int(p[9]) - '0') > 16 ||
              ((int(p[8]) - '0') * 10 + int(p[9]) - '0') <= 12 ||
              ((int(p[3]) - '0') * 10 + int(p[4]) - '0') > 12 ||
              b[((int(p[3]) - '0') * 10 + int(p[4]) - '0') - 1] <
                  ((int(p[0]) - '0') * 10 + int(p[1]) - '0'))
            a[a.size() - 1].first = -1100000;
          break;
        } else if (a[j].second == p) {
          a[j].first++;
        }
      }
    }
  }
  sort(a.begin(), a.end());
  cout << a[a.size() - 1].second;
  return 0;
}
