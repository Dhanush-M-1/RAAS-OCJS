#include <bits/stdc++.h>
using namespace std;
int64_t m[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  map<string, int64_t> date;
  string s;
  cin >> s;
  s = "00" + s;
  int64_t n = s.length();
  for (int64_t i = 0; i < n - 8; ++i) {
    string a = s.substr(i, 9);
    if (count((a).begin(), (a).end(), '-') == 2 and a[2] == '-' and
        a[4] == '-') {
      int64_t day = stoi(a.substr(0, 2));
      int64_t month = stoi(a.substr(3, 1));
      int64_t year = stoi(a.substr(5, 4));
      if (month >= 1 and month <= 12 and day >= 1 and day <= m[month - 1] and
          year >= 2013 and year <= 2015) {
        string real;
        real += a[0], real += a[1], real += '-', real += '0', real += a[3],
            real += '-', real += a.substr(5, 4);
        date[real]++;
        cout << a << '\n';
      }
    }
  }
  for (int64_t i = 0; i < n - 9; ++i) {
    string a = s.substr(i, 10);
    if (count((a).begin(), (a).end(), '-') == 2 and a[2] == '-' and
        a[5] == '-') {
      int64_t day = stoi(a.substr(0, 2));
      int64_t month = stoi(a.substr(3, 2));
      int64_t year = stoi(a.substr(6, 4));
      if (month >= 1 and month <= 12 and day >= 1 and day <= m[month - 1] and
          year >= 2013 and year <= 2015) {
        string real;
        real += a.substr(0, 2), real += '-', real += a.substr(3, 2),
            real += '-', real += a.substr(6, 4);
        date[real]++;
      }
    }
  }
  int64_t best = 0;
  string val;
  for (auto& x : date) {
    if (x.second >= best) {
      best = x.second;
      val = x.first;
    }
  }
  cout << val;
}
