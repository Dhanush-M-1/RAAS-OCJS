#include <bits/stdc++.h>
using namespace std;
int months[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
tuple<int, int, string> dates(0, 0, "fine");
map<tuple<int, int, string>, int> mp;
int day, month;
string year;
bool check_month(char a, char b) {
  if (a == '-' || b == '-') return false;
  month = (int)a - (int)'0';
  int y = (int)b - (int)'0';
  month *= 10;
  month += y;
  if (month >= 1 && month <= 12) return true;
  return false;
}
bool is_day(char a, char b) {
  if (a == '-' || b == '-') return false;
  if (a == '0' && b == '0') return false;
  day = (int)a - (int)'0';
  day *= 10;
  day += (int)b - (int)'0';
  return (day <= months[month - 1]);
}
bool check_year(string nyear) {
  year = nyear;
  return (nyear == "2013" || nyear == "2014" || nyear == "2015");
}
void add_tomap() {
  tuple<int, int, string> news(day, month, year);
  mp[news]++;
  if (mp[news] > mp[dates]) dates = news;
}
int main() {
  string s;
  cin >> s;
  for (int i = 2; i < s.length() - 5; i++) {
    if (s[i] == '-' && s[i + 3] == '-' && check_month(s[i + 1], s[i + 2]) &&
        is_day(s[i - 2], s[i - 1]) && check_year(s.substr(i + 4, 4))) {
      add_tomap();
    }
  }
  (get<0>(dates) < 10) ? cout << 0 << get<0>(dates) : cout << get<0>(dates);
  cout << "-";
  (get<1>(dates) < 10) ? cout << 0 << get<1>(dates) : cout << get<1>(dates);
  cout << "-";
  cout << get<2>(dates);
}
