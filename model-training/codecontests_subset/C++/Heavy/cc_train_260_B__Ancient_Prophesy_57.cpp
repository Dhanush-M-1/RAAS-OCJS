#include <bits/stdc++.h>
using namespace std;
int Day[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int maxx = -1;
int main() {
  string s, ans;
  cin >> s;
  map<string, int> mp;
  for (int i = 0; i < (int)s.size() - 9; i++) {
    string t = s.substr(i, 10);
    int year =
        (t[9] - 48) + (t[8] - 48) * 10 + (t[7] - 48) * 100 + (t[6] - 48) * 1000;
    int month = (t[4] - 48) + (t[3] - 48) * 10;
    int day = (t[1] - 48) + (t[0] - 48) * 10;
    if (year > 2015 || year < 2013 || month > 12 || month < 1 ||
        day > Day[month] || day < 1 || count(t.begin(), t.end(), '-') != 2) {
      continue;
    }
    mp[t]++;
    if (mp[t] > maxx) {
      maxx = mp[t];
      ans = t;
    }
  }
  cout << ans << endl;
  return 0;
}
