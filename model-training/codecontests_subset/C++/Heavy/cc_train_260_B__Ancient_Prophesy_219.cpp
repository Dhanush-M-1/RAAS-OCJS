#include <bits/stdc++.h>
using namespace std;
const long long N = 1e5 + 10;
const long long mod = 1e9 + 7;
const long long inf = -1e18;
const long long INF = 1e18;
long long d[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
string s, ans;
map<string, int> us;
long long mx;
int main() {
  cin >> s;
  for (int i = 0; i < s.size(); i++) {
    if (i + 9 < s.size()) {
      if (s[i + 2] == s[i + 5] && s[i + 5] == '-') {
        if (isdigit(s[i]) && isdigit(s[i + 1]) && isdigit(s[i + 3]) &&
            isdigit(s[i + 4]) && isdigit(s[i + 6]) && isdigit(s[i + 7]) &&
            isdigit(s[i + 8]) && isdigit(s[i + 9])) {
          int day = (s[i] - '0') * 10 + (s[i + 1] - '0');
          int mounth = (s[i + 3] - '0') * 10 + (s[i + 4] - '0');
          int year = (s[i + 6] - '0') * 1000 + (s[i + 7] - '0') * 100 +
                     (s[i + 8] - '0') * 10 + (s[i + 9] - '0');
          if (year >= 2013 && year <= 2015) {
            if (mounth >= 1 && mounth <= 12) {
              if (day >= 1 && day <= d[mounth]) {
                string str = "";
                for (int j = i; j <= i + 9; j++) {
                  str += s[j];
                }
                us[str]++;
                if (us[str] > mx) {
                  mx = us[str];
                  ans = str;
                }
              }
            }
          }
        }
      }
    }
  }
  cout << ans;
  return 0;
}
