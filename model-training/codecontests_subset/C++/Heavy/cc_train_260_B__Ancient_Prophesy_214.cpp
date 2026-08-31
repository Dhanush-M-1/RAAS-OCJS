#include <bits/stdc++.h>
using namespace std;
bool correct(int day, int month) {
  if (day == 0 || month == 0) return false;
  if (month == 2 && day <= 28)
    return true;
  else if ((month == 4 || month == 6 || month == 9 || month == 11) && day <= 30)
    return true;
  else if (day <= 31 && (month == 1 || month == 3 || month == 5 || month == 7 ||
                         month == 8 || month == 10 || month == 12))
    return true;
  return false;
}
int main() {
  stringstream ss;
  vector<string> v;
  map<string, int> mp;
  string s, t, month, day, res;
  cin >> s;
  int x, y;
  for (int i = s.size() - 1; i >= 9; i--) {
    t.push_back(s[i - 3]);
    t.push_back(s[i - 2]);
    t.push_back(s[i - 1]);
    t.push_back(s[i]);
    if (t == "2013" || t == "2015" || t == "2014") {
      if (s[i - 4] == '-' && s[i - 7] == '-' && isdigit(s[i - 6]) &&
          isdigit(s[i - 5]) && isdigit(s[i - 9]) && isdigit(s[i - 8])) {
        month.push_back(s[i - 6]);
        month.push_back(s[i - 5]);
        day.push_back(s[i - 9]);
        day.push_back(s[i - 8]);
        ss << month;
        ss >> x;
        ss.clear();
        ss << day;
        ss >> y;
        ss.clear();
        if (correct(y, x)) {
          res = day + "-" + month + "-" + t;
          v.push_back(res);
          mp[res]++;
        }
        month = "";
        day = "";
      }
    }
    t = "";
  }
  res = v[0];
  for (int i = 1; i < v.size(); i++) {
    if (mp[v[i]] > mp[res]) res = v[i];
  }
  cout << res;
}
