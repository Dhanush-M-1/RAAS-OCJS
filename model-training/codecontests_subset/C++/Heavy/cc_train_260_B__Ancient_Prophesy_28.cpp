#include <bits/stdc++.h>
using namespace std;
vector<int> day, month, year;
map<pair<int, pair<int, int> >, int> mp;
int main() {
  string s;
  cin >> s;
  int da[] = {-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  for (int i = 0; i < s.length(); i++) {
    if (s[i] == '-') {
      if (i < 2) continue;
      if (s.length() - i <= 7) continue;
      if (s[i + 3] != '-') continue;
      if (s[i - 2] == '-' || s[i - 1] == '-' || s[i + 1] == '-' ||
          s[i + 2] == '-' || s[i + 4] == '-' || s[i + 5] == '-' ||
          s[i + 6] == '-' || s[i + 7] == '-')
        continue;
      int d = 10 * (s[i - 2] - '0') + (s[i - 1] - '0');
      int m = 10 * (s[i + 1] - '0') + (s[i + 2] - '0');
      int y = 1000 * (s[i + 4] - '0') + 100 * (s[i + 5] - '0') +
              10 * (s[i + 6] - '0') + (s[i + 7] - '0');
      day.push_back(d);
      month.push_back(m);
      year.push_back(y);
    }
  }
  for (int i = 0; i < day.size(); i++) {
    if (month[i] >= 1 && month[i] <= 12 && da[month[i]] >= day[i] &&
        day[i] > 0 && year[i] > 2012 && year[i] < 2016)
      mp[make_pair(day[i], make_pair(month[i], year[i]))]++;
  }
  map<pair<int, pair<int, int> >, int>::iterator it;
  int ans = 0;
  int d, m, y;
  for (it = mp.begin(); it != mp.end(); ++it) {
    if ((*it).second > ans) {
      d = (*it).first.first;
      m = (*it).first.second.first;
      y = (*it).first.second.second;
      ans = (*it).second;
    }
  }
  if (d < 10) cout << "0";
  cout << d << "-";
  if (m < 10) cout << "0";
  cout << m << "-";
  cout << y;
  return 0;
}
