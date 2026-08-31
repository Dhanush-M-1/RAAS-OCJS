#include <bits/stdc++.h>
using namespace std;
const int dayinmonth[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int num(string s) {
  int res = 0;
  for (int i = 0, _a = (int(s.size())); i < _a; ++i)
    if (s[i] < '0' || s[i] > '9')
      return -1;
    else
      res = res * 10 + s[i] - '0';
  return res;
}
bool correct(string s) {
  if (s[2] != '-' || s[5] != '-') return 0;
  int day = num(s.substr(0, 2));
  int month = num(s.substr(3, 2));
  int year = num(s.substr(6, 4));
  if (day == -1 || month == -1 || year == -1 || year < 2013 || year > 2015 ||
      month < 1 || month > 12 || day < 1 || day > dayinmonth[month])
    return 0;
  return 1;
}
map<string, int> mm;
char s[100007];
int n;
int main() {
  scanf("%s", s + 1);
  n = strlen(s + 1);
  string st;
  for (int i = 1, _c = n - 9; i <= _c; i++) {
    st = string(s + i, s + i + 10);
    if (correct(st)) mm[st]++;
  }
  string res;
  int best = 0;
  for (map<string, int>::iterator it = mm.begin(); it != mm.end(); it++)
    if (best < it->second) {
      best = it->second;
      res = it->first;
    }
  cout << res << endl;
  return 0;
}
