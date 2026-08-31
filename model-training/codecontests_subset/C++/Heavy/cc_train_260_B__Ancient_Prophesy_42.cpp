#include <bits/stdc++.h>
using namespace std;
int ji[4][15][35];
int mon[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
inline bool judge(int day, int month, int year) {
  if ((year >= 2013 && year <= 2015) == 0) return false;
  if ((month >= 1 && month <= 12) == 0) return false;
  if ((day > 0 && day <= mon[month]) == 0) return false;
  return true;
}
inline void solve(string s) {
  int i = 0, day, month, year;
  day = month = year = 0;
  while (s[i] != '-' && i != s.size()) {
    day = day * 10 + s[i] - '0';
    i++;
  }
  if (i != 2) return;
  i++;
  while (s[i] != '-' && i != s.size()) {
    month = month * 10 + s[i] - '0';
    i++;
  }
  if (i != 5) return;
  i++;
  while (s[i] != '-' && i != s.size()) {
    year = year * 10 + s[i] - '0';
    i++;
  }
  if (i != 10) return;
  if (!judge(day, month, year)) return;
  ji[year - 2013][month][day]++;
}
string s;
int main() {
  getline(cin, s);
  for (int i = 0; i < s.size() - 9; i++) {
    string t = s.substr(i, 10);
    solve(t);
  }
  int day, month, year, pnt = 0;
  day = month = year = 0;
  for (int i = 0; i < 4; i++) {
    for (int j = 0; j < 15; j++) {
      for (int k = 0; k < 35; k++) {
        if (pnt < ji[i][j][k]) {
          year = i + 2013;
          month = j;
          day = k;
          pnt = ji[i][j][k];
        }
      }
    }
  }
  if (day < 10) cout << 0;
  printf("%d-", day);
  if (month < 10) cout << 0;
  printf("%d-%d\n", month, year);
  return 0;
}
